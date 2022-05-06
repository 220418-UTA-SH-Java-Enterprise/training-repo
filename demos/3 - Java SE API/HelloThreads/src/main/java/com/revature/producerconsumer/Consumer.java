package com.revature.producerconsumer;

public class Consumer implements Runnable{
	public Holder data;
	int max;
	
	public Consumer(Holder data, int max) {
		super();
		this.data = data;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i=0; i< max; i++) {
			int currentVal = this.data.getVal();
			
			System.out.println("Consumer got: " + currentVal);
		}
		
	}
}
