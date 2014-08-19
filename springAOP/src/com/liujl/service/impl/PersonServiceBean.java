package com.liujl.service.impl;

import org.springframework.stereotype.Service;

import com.liujl.service.PersonService;
@Service("personServiceBean")
public class PersonServiceBean implements PersonService {
	
	@Override
	public void save() {
		System.out.println("我是save()方法");
	}

}
