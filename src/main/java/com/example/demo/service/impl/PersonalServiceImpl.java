package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonalRepository;
import com.example.demo.service.PersonalService;

@Service
public class PersonalServiceImpl implements PersonalService{
	@Autowired
	private PersonalRepository personalRepository;

	@Override
	@Transactional
	public List<Person> getAllPerson() {
		System.out.println(JSON.toJSONString(personalRepository.getPersonByAge(10)));
//		Person p = new Person();
//		personalRepository.save(p);
		return personalRepository.getAllPerson();
	}
	
	
}
