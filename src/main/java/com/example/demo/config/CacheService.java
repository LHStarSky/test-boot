package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonalRepository;

@Service
public class CacheService {
	private final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);
	
	@Autowired PersonalRepository repository;
	
	@CachePut(value = "person", key = "#p.id")
	@Transactional
	public void save(Person p) {
		LOGGER.info("新增的缓存person， key为：{}", p.getId());
		repository.save(p);
	}
	
	@Cacheable(value = "person", key = "#p.id")
	public Person getPersonById(Person p) {
		LOGGER.info("数据缓存person， key为：{}", p.getId());
		return repository.getPersonById(p.getId());
	}
	
	@CacheEvict(value = "person", key = "#p.id")
	@Transactional
	public void delete(Person p) {
		LOGGER.info("删除缓存person， key为：{}", p.getId());
		repository.delete(p);
	}
}
