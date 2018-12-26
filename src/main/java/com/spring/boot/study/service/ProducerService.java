package com.spring.boot.study.service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.boot.study.Message;

@Service
public class ProducerService {

	private static final AtomicInteger idGenerator = new AtomicInteger(0);
	private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

	public Message createMsg() {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		} catch (InterruptedException e) {
		}
		int id= idGenerator.incrementAndGet();
		Message result = new Message(id, "Random Msg >> " + id);
		logger.info("Msg {} is gnerated",result);
		return result;
	}
	
	
	
}
