package com.pack1;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock2 
{
						public static void main(String[] args) 
						{
							
							ReentrantLock l=new ReentrantLock(true);
							l.lock();
							l.lock();
							
							System.out.println(l.getHoldCount());//2
							System.out.println(l.isLocked());//true
							System.out.println(l.isHeldByCurrentThread());//true
							System.out.println(l.getQueueLength());//0
							System.out.println(l.isFair());
						System.out.println(".......................................................");
							l.unlock();
							System.out.println(l.getHoldCount());//1
							System.out.println(l.isLocked());//true
							System.out.println(l.isHeldByCurrentThread());//true
							System.out.println(l.getQueueLength());//0
						System.out.println("..................................................");
						
						l.unlock();
						System.out.println(l.getHoldCount());//2
						System.out.println(l.isLocked());//true
						System.out.println(l.isHeldByCurrentThread());//true
						System.out.println(l.getQueueLength());//0
						}

}
