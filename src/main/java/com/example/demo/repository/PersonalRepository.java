package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Person;

public interface PersonalRepository extends CrudRepository<Person, Long>{

	//sql语句不能带有;
	@Query(value = "select * from person_test", nativeQuery = true)
//	@Query(value = "from Person")
	List<Person> getAllPerson();
	
	@Query(value = "select * from person_test t where t.age = ?1", nativeQuery = true)
	List<Person> getPersonByAge(int age);
	
	@Query("from Person where id = ?1")
	Person getPersonById(String id);
}
