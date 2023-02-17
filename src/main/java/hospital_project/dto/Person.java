package hospital_project.dto;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

@Entity
@Cacheable
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	private int person_id;

	private String person_name;

	private String person_address;

	private long person_contact_number;

	
	public int getPerson_id() {

		return person_id;

	}

	public void setPerson_id(int person_id) {

		this.person_id = person_id;

	}

	public String getPerson_name() {

		return person_name;

	}

	public void setPerson_name(String person_name) {

		this.person_name = person_name;

	}

	public String getPerson_address() {

		return person_address;

	}

	public void setPerson_address(String person_address) {

		this.person_address = person_address;

	}

	public long getPerson_contact_number() {

		return person_contact_number;

	}

	public void setPerson_contact_number(long person_contact_number) {

		this.person_contact_number = person_contact_number;

	}


	@Override

	public String toString() {

		return "Person [person_id=" + person_id + ", person_name=" + person_name + ", person_address=" + person_address

				+ ", person_contact_number=" + person_contact_number +   "]";
	}
}
