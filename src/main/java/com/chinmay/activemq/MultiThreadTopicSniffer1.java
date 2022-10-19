package com.chinmay.activemq;

class MultiThreadTopicSniffer1 extends Thread {
	
	TopicSniffer TopicSnifferOBJ=new TopicSniffer();
	public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " is running");
            
            TopicSnifferOBJ.callTopicSniffer();
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
	
}