package hospital_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project.dto.Branch;
import hospital_project.dto.Encounter;
import hospital_project.dto.Med_orders;

public class Med_OrdersDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory eMFEntityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return eMFEntityManagerFactory.createEntityManager();

	}

	public void saveMedOrders(Med_orders medorder, int  encounter_id) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		Encounter getEncounter = eManager.find(Encounter.class, encounter_id);
		 medorder.setEncounter(getEncounter);

		eTransaction.begin();

		eManager.persist(medorder);
		

		eTransaction.commit();
	}

	public void updateMedOrder(int med_orders_id, String doctor_name) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		Med_orders getMedOrder = eManager.find(Med_orders.class, med_orders_id);
		if(getMedOrder!=null) {
			getMedOrder.setDoctor_name(doctor_name);
		eTransaction.begin();

		eManager.merge(getMedOrder);

		eTransaction.commit();
		}
		else
			System.out.println("id not found");
	}
	
	public void deleteMedOrder(int med_orders_id) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		Med_orders getMedOrder = eManager.find(Med_orders.class, med_orders_id);
		if(getMedOrder!=null) {
		eTransaction.begin();

		eManager.remove(getMedOrder);

		eTransaction.commit();
		}
		else
			System.out.println("id not found");
	}
	
	public void getMedOrderById(int med_orders_id) {
		EntityManager eManager = getEntityManager();
		Med_orders getMedOrder = eManager.find(Med_orders.class, med_orders_id);
		System.out.println(getMedOrder);
	}
	public List<Med_orders> getAllMedorders(){
		EntityManager eManager = getEntityManager();
		Query query= eManager.createQuery("select m from Med_orders m");
		List<Med_orders> list=query.getResultList();
		  return list;
		
		
	}

}
