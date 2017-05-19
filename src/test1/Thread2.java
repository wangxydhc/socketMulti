package test1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread2 implements Runnable {	
	Lock lock;
	Thread2(Lock lock){
		this.lock=lock;		
	}
	public void run(){
		System.out.println(Thread.currentThread().getId()+" is run");
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for(int i=0;i<4;i++)
			{	
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getId()+" run "+i+"th time");
			}		
			lock.unlock();
	}
	public static void main(String[] args) throws InterruptedException {
		Lock lock=new ReentrantLock();
		Thread2 thread=new Thread2(lock);
		lock.lock();
		for(int i=0;i<5;i++){
			new Thread(thread).start();			
			}
		for(int i=0;i<5;i++){
			Thread.sleep(900);
			System.out.println("sleep");
		}
		lock.unlock();
		System.out.println("over");
		
	}
}
