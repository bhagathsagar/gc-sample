package com.spring.boot.study;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.study.service.ConsumerSerive;
import com.spring.boot.study.service.ProducerService;

@SpringBootApplication(scanBasePackages={"com.spring.boot"})
public class GcSampleApplication implements CommandLineRunner{

	public static final Logger logger = LoggerFactory.getLogger(GcSampleApplication.class);

	@Autowired
	ProducerService producer;	
	@Autowired
	ConsumerSerive consumer;
	
	public static void main(String[] args) {		
		SpringApplication.run(GcSampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LinkedList<Message> sharedQ = new LinkedList<>();
		
		ExecutorService ex = Executors.newFixedThreadPool(4);
		Producer pro1 = new Producer("Prod-001",producer,sharedQ);
		Producer pro2 = new Producer("Prod-002",producer,sharedQ);
		Producer pro3 = new Producer("Prod-003",producer,sharedQ);
		Consumer con1 = new Consumer("Cons-001",consumer,sharedQ);
		
		ex.execute(con1);
		ex.execute(pro1);
		ex.execute(pro2);
		//ex.execute(pro3);

	}

	

	
}

