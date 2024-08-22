package com.multithreading;

public class EvenOddMulti {
	static int val = 1;
	static String lock = "Niraj";

	public static void main(String[] args) {
		Even e = new Even();
		Thread t1 = new Thread(e);

		Odd o = new Odd();
		Thread t2 = new Thread(o);

		t1.start();
		t2.start();
	}

	static class Even implements Runnable {

		@Override
		public synchronized void run() {
			while (val <= 10) {
				printEven();
			}
		}

		private void printEven() {
			synchronized (lock.intern()) {
				if(val%2==0) {
					System.out.println("Even val : "+val++);
					lock.notify();
				}else {
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

	static class Odd implements Runnable {

		@Override
		public synchronized void run() {
			while (val <= 10) {
				try {
					printOdd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		private void printOdd() throws InterruptedException {
			synchronized (lock.intern()) {
				if(val%2!=0) {
					System.out.println("Odd val : "+val++);
					lock.notifyAll();
				}else {
					lock.wait();
				}
			}
		}

	}
}
