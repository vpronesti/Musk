package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.control.TestController;

@Component()
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private TestController testController;
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		testController.testCreation();
		
	}

}
