package com.soori.java8.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.soori.java8.concurrent.database.EmployeeDatabase;
import com.soori.java8.concurrent.dto.Employee;

public class EmployeeReminderService {

	public CompletableFuture<Void> sendReminderToEmployee() {
//below will guarantee that , new thread created , Customer threads
		Executor executor = Executors.newFixedThreadPool(5);
		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("fetchEmployee : " + Thread.currentThread().getName());
			return EmployeeDatabase.fetchEmployees();
		}, executor).thenApplyAsync((employees) -> {
			System.out.println("filter new joiner employee  : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner()))
					.collect(Collectors.toList());
		}, executor).thenApplyAsync((employees) -> {
			System.out.println("filter training not complete employee  : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getLearningPending()))
					.collect(Collectors.toList());
		}, executor).thenApplyAsync((employees) -> {
			System.out.println("get emails  : " + Thread.currentThread().getName());
			return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
		}, executor).thenAcceptAsync((emails) -> {
			System.out.println("send email  : " + Thread.currentThread().getName());
			emails.forEach(EmployeeReminderService::sendEmail);
		}, executor);
		return voidCompletableFuture;
	}

	public CompletableFuture<Void> sendReminderToEmployeeOld() {

// threads created from Common/Global thread pool --> ForkJoinPool.commonPool-worker-1

		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("fetchEmployee : " + Thread.currentThread().getName());
			return EmployeeDatabase.fetchEmployees();
		}).thenApplyAsync((employees) -> {
			System.out.println("filter new joiner employee  : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner()))
					.collect(Collectors.toList());
		}).thenApplyAsync((employees) -> {
			System.out.println("filter training not complete employee  : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getLearningPending()))
					.collect(Collectors.toList());
		}).thenApplyAsync((employees) -> {
			System.out.println("get emails  : " + Thread.currentThread().getName());
			return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
		}).thenAcceptAsync((emails) -> {
			System.out.println("send email  : " + Thread.currentThread().getName());
			emails.forEach(EmployeeReminderService::sendEmail);
		});
		return voidCompletableFuture;
	}

	public CompletableFuture<Void> sendReminderToEmployeeCombine() {
		Executor executor = Executors.newFixedThreadPool(5);

		CompletableFuture<List<Employee>> fetchEmployeesFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("fetchEmployee : " + Thread.currentThread().getName());
			return EmployeeDatabase.fetchEmployees();
		}, executor);

		CompletableFuture<List<Employee>> filterNewJoinersFuture = fetchEmployeesFuture.thenApplyAsync((employees) -> {
			System.out.println("filter new joiner employee  : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner()))
					.collect(Collectors.toList());
		}, executor);

		CompletableFuture<List<Employee>> filterTrainingPendingFuture = fetchEmployeesFuture
				.thenApplyAsync((employees) -> {
					System.out.println("filter training not complete employee  : " + Thread.currentThread().getName());
					return employees.stream().filter(employee -> "TRUE".equals(employee.getLearningPending()))
							.collect(Collectors.toList());
				}, executor);

		CompletableFuture<List<String>> getEmailsFuture = filterNewJoinersFuture
				.thenCombineAsync(filterTrainingPendingFuture, (newJoiners, trainingPending) -> {
					System.out.println(
							"combine new joiners and training pending employees : " + Thread.currentThread().getName());
					List<Employee> combinedList = new ArrayList<>(newJoiners);
					combinedList.retainAll(trainingPending);
					return combinedList.stream().map(Employee::getEmail).collect(Collectors.toList());
				}, executor);

		CompletableFuture<Void> sendEmailsFuture = getEmailsFuture.thenAcceptAsync((emails) -> {
			System.out.println("send email  : " + Thread.currentThread().getName());
			emails.forEach(EmployeeReminderService::sendEmail);
		}, executor);

		return sendEmailsFuture;
	}

	public static void sendEmail(String email) {
		System.out.println("sending training reminder email to : " + email);
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		EmployeeReminderService service = new EmployeeReminderService();
		service.sendReminderToEmployee().get();
//		service.sendReminderToEmployeeOld().get();
	}
}
