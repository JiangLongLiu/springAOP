package com.liujl.service.impl;

import org.springframework.stereotype.Service;

import com.liujl.service.PersonService;
@Service("personServiceBean")
public class PersonServiceBean implements PersonService {
	
	@Override
	public void save(String name) {
//		throw new RuntimeException("我爱例外");
		System.out.println("我是save()方法");
	}

	@Override
	public String getPersonName(Integer id) {
		
		return "xxx";
	}

}
