package com.spring.boot.study;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.boot.study.service.ConsumerSerive;

public class Consumer implements Runnable{
	
	private String name;
	private ConsumerSerive service;	
	private LinkedList<Message> sharedQ;
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	public Consumer(String name,ConsumerSerive service,LinkedList<Message> sharedQ) {
		super();
		this.name = name;
		this.service = service;
		this.sharedQ = sharedQ;
	}

	@Override
	public void run() {
		while(true){
			Message msg=null;
			try{
				synchronized (sharedQ) {
					if(sharedQ.isEmpty()){
						logger.info("Q is Empty, Consumer {} is going to wait...",name);
						sharedQ.wait();							
					}
					msg=sharedQ.remove();
					sharedQ.notifyAll();
				}					
				service.service(msg);
			}catch(Exception e){					
			}
		}
	}
}