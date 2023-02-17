package hospital_project.dto;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Med_orders {

               @Id
           	@GeneratedValue(strategy = GenerationType.IDENTITY)

               private int med_orders_id;
               private String doctor_name;

               @ManyToOne
               private Encounter encounter;

               public int getMed_orders_id() {

                               return med_orders_id;

               }

			public String getDoctor_name() {
				return doctor_name;
			}

			public void setDoctor_name(String doctor_name) {
				this.doctor_name = doctor_name;
			}

			public Encounter getEncounter() {
				return encounter;
			}

			public void setEncounter(Encounter encounter) {
				this.encounter = encounter;
			}

			public void setMed_orders_id(int med_orders_id) {
				this.med_orders_id = med_orders_id;
			}

			@Override
			public String toString() {
				return "Med_orders [med_orders_id=" + med_orders_id + ", doctor_name=" + doctor_name + ", encounter="
						+ encounter + "]";
			}

              

              



}
