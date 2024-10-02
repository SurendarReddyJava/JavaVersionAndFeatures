package com.soori.java8.concurrent;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class ParallelSumTask extends RecursiveTask<Long> {
	private static final int THRESHOLD = 10000;
	private int[] array;
	private int start;
	private int end;

	public ParallelSumTask(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		if (end - start <= THRESHOLD) {
			long sum = 0;
			for (int i = start; i < end; i++) {
				sum += array[i];
			}
			return sum;
		} else {
			int mid = (start + end) / 2;
			ParallelSumTask leftTask = new ParallelSumTask(array, start, mid);
			ParallelSumTask rightTask = new ParallelSumTask(array, mid, end);
			leftTask.fork();
			long rightResult = rightTask.compute();
			long leftResult = leftTask.join();
			return leftResult + rightResult;
		}
	}
}

public class ParallelSum {
	public static void main(String[] args) {
		int[] array = new int[1000000];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

		ForkJoinPool pool = new ForkJoinPool();
		ParallelSumTask task = new ParallelSumTask(array, 0, array.length);

		long startTime = System.currentTimeMillis();
		long result = pool.invoke(task);
		long endTime = System.currentTimeMillis();

		System.out.println("Sum: " + result);
		System.out.println("Time taken with ForkJoin: " + (endTime - startTime) + " ms");

		System.out.println("------------------------");
		
		result = SequentialSum.sequentialSumTask();
		
	}
}

class SequentialSum {

	public static long sequentialSumTask() {
		int[] array = new int[1000000];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

		long startTime = System.currentTimeMillis();
		long sum = 0;
		for (int i : array) {
			sum += i;
		}
		long endTime = System.currentTimeMillis();

		System.out.println("SequentialSum: " + sum);
		System.out.println("Time taken without ForkJoin #SequentialSum: " + (endTime - startTime) + " ms");
		return sum;
	}
}
