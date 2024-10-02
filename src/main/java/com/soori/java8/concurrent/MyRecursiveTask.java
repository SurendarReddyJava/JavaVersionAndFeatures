package com.soori.java8.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	private long workLoad = 0;

	public MyRecursiveTask(long workLoad) {
		this.workLoad = workLoad;
	}

	protected Long compute() {

		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

			long workload1 = this.workLoad / 2;
			long workload2 = this.workLoad - workload1;

			MyRecursiveTask subtask1 = new MyRecursiveTask(workload1);
			MyRecursiveTask subtask2 = new MyRecursiveTask(workload2);

			subtask1.fork();
			subtask2.fork();

			long result = 0;
			result += subtask1.join();
			result += subtask2.join();
			return result;

		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad +" ==>"+workLoad * 3);
			return workLoad * 3;
		}
	}
	
	public static void main(String[] args) {
		
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);
		long mergedResult = forkJoinPool.invoke(myRecursiveTask);
		System.out.println("mergedResult = " + mergedResult);    
	}
}