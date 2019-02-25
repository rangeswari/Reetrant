package com.pack1;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock3 
{

				public static void main(String[] args) {
					
					Display d=new Display();
					Thread t1=new Thread(new Hello(d,"Dhoni"));
					Thread t2=new Thread(new Hello1(d,"Yuvraj"));
					//Thread t2=new Thread(new Hello1(new Display(),"Yuvraj"));
					
					t1.start();
					t2.start();
				}
}


class Hello implements Runnable
{
	Display d;
	String name;
	
	
			public Hello(Display d, String name)
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
class Hello1 implements Runnable
{
	Display d;
	String name;
	
	
			public Hello1(Display d, String name)
			{
		
				this.d = d;
				this.name = name;
			}


			public  void run()
			{
				
						try {
							d.get(name);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
			}
}
 class Display
{
	public  void GET(String name) throws InterruptedException
	{
		synchronized(this)
		{
				for(int i=0; i<10; i++)
				{
					System.out.println("Good morning:");
					Thread.sleep(2000);
					System.out.println(name);
				}
		}
		System.out.println();
	}
	public synchronized void get(String name) throws InterruptedException
	{
		for(int i=0; i<10;i++)
		{
			System.out.println("good night:"+name);
			Thread.sleep(2000);
		}
	}
}

