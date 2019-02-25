package com.pack1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock4 
{

				public static void main(String[] args) {
					
					Display4 d=new Display4();
					Thread t1=new Thread(new Hello4(d,"Dhoni"));
					Thread t2=new Thread(new Hello4(d,"Yuvraj"));
					
					
					t1.start();
					t2.start();
				}
}


class Hello4 implements Runnable
{
	Display4 d;
	String name;
	
	
			public Hello4(Display4 d, String name)
			{
		
				this.d = d;
				this.name = name;
			}


			public  void run()
			{
				
						try 
						{
							d.GET(name);
						} catch (InterruptedException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
			}
}

 class Display4
{
	 ReentrantLock l=new ReentrantLock();
	 TimeUnit tu=TimeUnit.SECONDS;
	public  void GET(String name) throws InterruptedException
	{
		l.tryLock(2000,tu);
		//l.lock();
		
				for(int i=0; i<10; i++)
				{
					System.out.print("Good morning:"+name);
					l.unlock();
					//Thread.sleep(150);
					//System.out.println(name);
				}
		//l.unlock();
		//l.unlock();
		//System.out.println();
	}
	
}

