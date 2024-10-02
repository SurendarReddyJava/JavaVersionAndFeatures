package com.soori.java9.osprocess;

public class ProcessApiExample {
	public static void main(String[] args) {
		ProcessHandle currentProcess = ProcessHandle.current();
		System.out.println("PID: " + currentProcess.pid());
		
		ProcessHandle.Info info = currentProcess.info();
		info.command().ifPresent(cmd -> System.out.println("Command: " + cmd));
		info.startInstant().ifPresent(start -> System.out.println("Start time: " + start));
		info.totalCpuDuration().ifPresent(cpu -> System.out.println("CPU usage: " + cpu));
		
	}
}
