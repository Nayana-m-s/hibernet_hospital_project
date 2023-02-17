package hospital_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hospital_project.dto.Med_items;
import hospital_project.dto.Med_orders;

public class Med_itemsDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory eMFEntityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return eMFEntityManagerFactory.createEntityManager();

	}

	public void saveMedItems(Med_items items, int  med_orders_id) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		Med_orders getMedOrders = eManager.find(Med_orders.class, med_orders_id);
		  items.setMedorders(getMedOrders);
		eTransaction.begin();

		eManager.persist(items);
		

		eTransaction.commit();
	}

	public void updateMedItems(int  med_item_id, String med_item_name) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		Med_items getMedItems = eManager.find(Med_items.class, med_item_id);
		if (getMedItems != null) {
			getMedItems.setMed_item_name(med_item_name);
			eTransaction.begin();

			eManager.merge(getMedItems);

			eTransaction.commit();

		}
		else
			System.out.println("id not found");

	

}
	
	public void deleteMedItems(int med_item_id ) {
		EntityManager eManager = getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		Med_items getMedItems = eManager.find(Med_items.class, med_item_id);
		if (getMedItems != null) {
			
			eTransaction.begin();

			eManager.remove(getMedItems);

			eTransaction.commit();

		}
		else
			System.out.println("id not found");
		
	}
	
	public void getMedItemsById(int med_item_id ) {
		EntityManager eManager = getEntityManager();
		Med_items getMedItems = eManager.find(Med_items.class, med_item_id);
		System.out.println(getMedItems);
		 
	}
	public List<Med_items> getALlMedItems(){
		EntityManager eManager = getEntityManager();
		Query query=eManager.createQuery("select m from Med_items m");
		List<Med_items> list=query.getResultList();
		return list;
	}
	
}
