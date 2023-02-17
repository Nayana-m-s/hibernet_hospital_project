package hospital_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project.dto.Address;
import hospital_project.dto.Branch;

public class AddressDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory eMFEntityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return eMFEntityManagerFactory.createEntityManager();

	}

	public void saveAddress(int b_id, Address address) {

		EntityManager entityManager = getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class, b_id);

		address.setBranches(branch);

		entityTransaction.begin();

		entityManager.persist(address);

		entityTransaction.commit();

	}

	public void updateAddress(int a_id, String a_address) {

		EntityManager eManager = getEntityManager();

		EntityTransaction eTransaction = eManager.getTransaction();

		Address address = eManager.find(Address.class, a_id);

		if (address != null) {

			address.setAddress(a_address);

			eTransaction.begin();

			eManager.merge(address);

			eTransaction.commit();

		} else {

			System.out.println("Id is not found");

		}

	}

	public void deleteAddress(int a_id) {

		EntityManager eManager = getEntityManager();

		EntityTransaction eTransaction = eManager.getTransaction();

		Address address = eManager.find(Address.class, a_id);

		if (address != null) {

			eTransaction.begin();

			eManager.remove(address);

			eTransaction.commit();

		} else {

			System.out.println("Id is not found");

		}

	}

	public void getAddressById(int a_id) {

		EntityManager eManager = getEntityManager();

		Address address = eManager.find(Address.class, a_id);

		if (address != null) {

			System.out.println(address);

		} else {

			System.out.println("Id is not found");

		}

	}

	public List<Address> getAllAddress() {

		EntityManager eManager =getEntityManager();

		Query query = eManager.createQuery("select h from Address h");

		List<Address> list1 = query.getResultList();

		return list1;

	}

}