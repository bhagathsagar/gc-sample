package com.spring.boot.study.service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.boot.study.Message;

@Service
public class ConsumerSerive {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerSerive.class);
	public boolean service(Message msg){
		Objects.requireNonNull(msg);
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		} catch (InterruptedException e) {
		}		
		logger.info("Msg {} is consumed",msg);
		return true;
	}
	
}
