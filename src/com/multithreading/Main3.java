package com.multithreading;

public class Main3 {
	public static void main(String[] args) {
		Object lock = new Object();
		Thread thread1 = new Thread(()->{
			synchronized (lock){
				for(int i = 0 ;i< 10 ;i++) {}
			}
		});
		Thread thread2 = new Thread(()->{
			for(int i = 0 ;i< 10 ;i++) {}
		});
		
		thread1.start();
		thread2.start();
		
	}
}
