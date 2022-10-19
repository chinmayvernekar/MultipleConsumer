package com.chinmay.activemq;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;




public class TopicSniffer {
	//public static void main(String[] args) throws URISyntaxException, Exception {
	
	public void callTopicSniffer() throws URISyntaxException, Exception
	{
		
		Connection connection = null;
		try {
			// Producer
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:tcp://192.168.1.65:61616");
		//	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(args[0]);
			
			connection = connectionFactory.createConnection();
			
			connection.setClientID(Thread.currentThread().getName());
			
			System.out.println("Thread.currentThread().getName:"+Thread.currentThread().getName());
			
			
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic("srk.topic.journey");
			//Topic topic = session.createTopic(args[1]);
			TextMessage msg ;

			// Publish
			/*String payload = "Important Task";
			TextMessage msg = session.createTextMessage(payload);
			MessageProducer publisher = session.createProducer(topic);
			System.out.println("Sending text '" + payload + "'");
			publisher.send(msg, javax.jms.DeliveryMode.PERSISTENT, javax.jms.Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE);*/

			// Consumer1 subscribes to customerTopic
		//	MessageConsumer consumer1 = session.createDurableSubscriber(topic,"BAR", "", false);		
			//MessageConsumer consumer1 = session.createDurableSubscriber(topic, args[1], "", false);		

			
	        // Getting the queue 'VALLYSOFTQ'   javax.jms.Destination destination = session.createTopic(topic);

	        // MessageConsumer is used for receiving (consuming) messages
			//connection.setClientID(Thread.currentThread().getName());
	        MessageConsumer consumer = session.createConsumer(topic);

	        
		
			connection.start();
			
			int n=0;
			int cnt=1;
			while(n!=1)
			{
				
				System.out.println("Am sniffing ::: ->");
			msg = (TextMessage) consumer.receive();
			System.out.println("Consumer received " + msg.getText());
			
			    
			  
			
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("current message Count:"+cnt);
			System.out.println("\r\n\r\n*********Next Message*************");
			
			cnt=cnt+1;
			  //  cnt=cnt+1;
			
			}
			
			
		
			session.close();
		} catch (Exception ex)
		{
		System.out.println(ex.toString());
		}
			finally {
		
			if (connection != null) {
				connection.close();
			}
		
		}
	}
}
