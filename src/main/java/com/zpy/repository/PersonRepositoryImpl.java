package com.zpy.repository;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpy.entity.Person;

@Component("personRepository")
public class PersonRepositoryImpl implements PersonRepository {

	@Resource(name = "sessionFactory")
	private SessionFactory sf;
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Resource
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public String getName(String name) {
		System.out.println("--------" + name);
		return name;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int save(Person person) {
		try {
//			sf.openSession().save(person);
			sf.getCurrentSession().save(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Person getPersonById(Integer id) {
		Person person = sf.getCurrentSession().load(Person.class, id);
		return person;
	}

	@Override
	public boolean exists(String username) {
		try {
			List<?> list = hibernateTemplate.find("select count(1) from Person where username=?", username);
			if(null != list && list.size() > 0) {
				if(Integer.valueOf(String.valueOf(list.get(0))) > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Person getPersonByIdOfJpa(Integer id) {
		try {
			Person person = entityManagerFactory.createEntityManager().find(Person.class, id);
			return person;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
