package com.multithreading;

public class Main2 {

	private static int val = 1;
	private static final Object lock = new Object();

	public static void main(String[] args) {

		Even even = new Even();
		Thread e = new Thread(even);

		Odd odd = new Odd();
		Thread o = new Thread(odd);

		
		e.start();
		o.start();
	}

	public static class Even implements Runnable {

		@Override
		public void run() {
			while(val<=10) {
				printEven();
			}
		}

		public void printEven() {
			synchronized (lock) {
				if (val % 2 == 0) {
					System.out.println("Even value: " + val);
					val += 1;
					lock.notify();
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static class Odd implements Runnable {

		@Override
		public void run() {
			while(val<=10) {
				printOdd();
			}
		}

		public void printOdd() {
			synchronized (lock) {
				if (val % 2 != 0) {
					System.out.println("Odd value: " + val);
					val += 1;
						lock.notify();
					}
				else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
