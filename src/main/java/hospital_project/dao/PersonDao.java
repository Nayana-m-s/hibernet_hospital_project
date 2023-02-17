package hospital_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory eMFEntityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return eMFEntityManagerFactory.createEntityManager();

	}

	public void savePerson(Person person) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		
		eManager.persist(person);
		eTransaction.commit();

	}

	public void updatePerson(int id,String name) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		Person person = eManager.find(Person.class, id);
		if(person!=null) {
		  person.setPerson_name(name);
		eTransaction.begin();
		eManager.merge(person);
		eTransaction.commit();
		}
		else
			System.out.println("person not found");
	}
	public void deletePerson(int id) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		Person person = eManager.find(Person.class, id);
		 if(person !=null) {
		eTransaction.begin();
		eManager.remove(person);
		eTransaction.commit();
		 }	
		 else
			 System.out.println("id not found");
	}
	public void getPersonById(int id) {
		EntityManager eManager = getEntityManager();
		Person person = eManager.find(Person.class, id);
		if(person!=null)
		System.out.println(person);
		else
			System.out.println("id not found");
		
	}
	public List<Person> getAllPerson() {
		EntityManager eManager = getEntityManager();
		Query query=eManager.createQuery("select p from Person p");
		List<Person> list1=query.getResultList();
		return list1;
		
		 
	}

}
