package com.lamda;

public class EvenAndOddMutli extends Thread{

	private static final Object lock = new Object();
	boolean isEven;
	private static int num = 1;
	public EvenAndOddMutli(boolean isEven) {
		this.isEven = isEven;
	}
	
	@Override
	public void run() {
		while(num<=10) {
			synchronized (lock) {
				if(!isEven) {
					System.out.println("Odd"+num);
					num++;
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("Even"+num);
					num++;
					lock.notify();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		
		
		Thread even = new Thread(new EvenAndOddMutli(true));
		Thread odd = new Thread(new EvenAndOddMutli(false));
		
		even.start();
		odd.start();
		
		synchronized (lock) {
			lock.notify();
		}
	}

}
