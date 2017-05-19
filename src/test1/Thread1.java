package test1;

public class Thread1 implements Runnable {
	Integer lock;
	Thread1(Integer i)
	{
		lock=i;
	}
	public void run(){
		
		synchronized(lock){
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getId()+" is run");
			for(int i=0;i<4;i++)
			{
				System.out.println(Thread.currentThread().getId()+" run "+i+"th time");
			}
		}
	}
	public static void main(String[] args) {
		Integer l=new Integer(3);
		Thread1 f=new Thread1(l);
		for(int i=0;i<5;i++)
			new Thread(f).start();			
		synchronized(l){
			System.out.println("main");
			l.notifyAll();
		}
	}
}
