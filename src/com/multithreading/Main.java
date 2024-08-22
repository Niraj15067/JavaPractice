package com.multithreading;

public class Main {

	private static int val = 1;

	public static void main(String[] args) {

		Even even = new Even();
		Thread e = new Thread(even);

		Odd odd = new Odd();
		Thread o = new Thread(odd);

		o.start();
		e.start();
	}

	public static class Even implements Runnable {

		@Override
		public void run() {
			while (val <= 10) {
				printEven();
			}
		}

		public synchronized void printEven() {
			if (val % 2 == 0) {
				System.out.println("Even value: " + val);
				val += 1;
				notifyAll();
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static class Odd implements Runnable {

		@Override
		public void run() {
			while (val <= 10) {
				printOdd();
			}
		}

		public synchronized void printOdd() {
			if (val % 2 != 0) {
				System.out.println("Even value: " + val);
				val += 1;
				notifyAll();
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
