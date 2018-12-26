package com.spring.boot.study;

import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.spring.boot.study.service.ProducerService;

public class Producer implements Runnable{

	private String name;
	private ProducerService service;	
	private LinkedList<Message> sharedQ;

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	public Producer(String name,ProducerService service,LinkedList<Message> sharedQ) {
		super();
		this.name=name;
		this.service = service;
		this.sharedQ = sharedQ;
	}

	@Override
	public void run() {
		Message msg;
		while(true){
			msg = service.createMsg();
			synchronized (sharedQ) {
				try{
					if(sharedQ.size()==250){
						logger.info("Q is Full, Producer {} is going to wait...",name);
						sharedQ.wait();
					}
					sharedQ.add(msg);
					sharedQ.notifyAll();
				}catch (Exception e) {
				}
			}
		}			
	}
}
