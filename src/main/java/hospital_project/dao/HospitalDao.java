package hospital_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project.dto.Hospital;

public class HospitalDao {

	public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
        return entityManagerFactory.createEntityManager();

	}

	public void saveHospital(Hospital hospital) {

		EntityManager entityManager = getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(hospital);

		entityTransaction.commit();

	}

	public void updateHospital(int id, String name) {

		EntityManager eManager = getEntityManager();

		EntityTransaction eTransaction = eManager.getTransaction();

		Hospital hospital = eManager.find(Hospital.class, id);

		if (hospital != null) {

			hospital.setHospital_name(name);

			eTransaction.begin();

			eManager.merge(hospital);

			eTransaction.commit();

		} else {

			System.out.println("Id is not found");

		}

	}

	public void deleteHospital(int id) {

		EntityManager eManager = getEntityManager();

		EntityTransaction eTransaction = eManager.getTransaction();

		Hospital hospital = eManager.find(Hospital.class, id);

		if (hospital != null) {

			eTransaction.begin();

			eManager.remove(hospital);

			eTransaction.commit();

		} else {

			System.out.println("Id is not found");

		}

	}

	public void getHospitalById(int id) {

		EntityManager eManager = getEntityManager();

		Hospital hospital = eManager.find(Hospital.class, id);

		if (hospital != null) {

			System.out.println(hospital);

		} else {

			System.out.println("Id is not found");

		}

	}

	public List<Hospital> getAllHospital() {

		EntityManager eManager = getEntityManager();

		Query query = eManager.createQuery("select h from Hospital h");

		List<Hospital> list1 = query.getResultList();

		return list1;

	}

}
