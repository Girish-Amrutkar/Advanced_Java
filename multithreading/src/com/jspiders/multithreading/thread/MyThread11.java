package com.jspiders.multithreading.thread;

public class MyThread11 extends Thread{

	@Override
	public void run() {
		
		String message = "Java is a Programming Language.";
				char[] charArray = message.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
