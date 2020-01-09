package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.CacheService;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonalService;

@RestController
@RequestMapping("person")
public class PersonController {
	private final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	private PersonalService personalService;
	@Autowired
	private CacheService cacheService;
	
	@RequestMapping("data")
	public List<Person> getAllPerson(){
		LOGGER.info("getAllPerson 方法入参:无");
		List<Person> allPersonList = personalService.getAllPerson();
		LOGGER.info("getAllPerson 方法出参:{}", JSON.toJSONString(allPersonList));
		return allPersonList;
	}
	
	@RequestMapping("save")
	public String save() {
		LOGGER.info("save 入参：无");
		Person p = new Person();
		cacheService.save(p);
		return p.getId();
	}
	
	@RequestMapping("getPersonById")
	public String getPersonById(String id) {
		LOGGER.info("getPersonById 入参：无");
		Person p = new Person();
		p.setId(id);
		cacheService.getPersonById(p);
		return p.getId();
	}
	
	@RequestMapping("delete")
	public String delete(String id) {
		LOGGER.info("delete 入参：无");
		Person p = new Person();
		p.setId(id);
		cacheService.delete(p);
		return p.getId();
	}
}
