package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.ServerProperties;
import com.example.demo.entity.Person;

@RestController
@RequestMapping("test")
public class TestController {
	
	private final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Value("${server.port}")
	private String port;
	
	@Autowired
	private ServerProperties serverProperties;
	private List<Person> personList = new ArrayList<Person>();
	
	@PostConstruct
	public void init() {
		Person p1 = new Person("xx", 11);
		Person p2 = new Person("yy", 22);
		Person p3 = new Person("zz", 33);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
	}
	
	@RequestMapping("index")
	public String index() {
		logger.info("index controller, port:{}, testport", serverProperties.getPort());
//		System.out.println("serverProperties->>" + JSON.toJSONString(serverProperties, true));
		System.out.println("personList is : " + JSON.toJSONString(personList, false));
//		return "index-" + port;
		return JSON.toJSONString(personList);
	}
	
}
