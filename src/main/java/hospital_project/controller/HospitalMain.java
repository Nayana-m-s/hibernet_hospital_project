package hospital_project.controller;

import java.util.Scanner;

import hospital_project.dao.AddressDao;
import hospital_project.dao.BranchDao;
import hospital_project.dao.EncounterDao;
import hospital_project.dao.HospitalDao;
import hospital_project.dao.Med_OrdersDao;
import hospital_project.dao.Med_itemsDao;
import hospital_project.dao.PersonDao;
import hospital_project.dto.Address;
import hospital_project.dto.Branch;
import hospital_project.dto.Encounter;
import hospital_project.dto.Hospital;
import hospital_project.dto.Med_items;
import hospital_project.dto.Med_orders;
import hospital_project.dto.Person;

public class HospitalMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean repeat = true;
		do {
			System.out.println("1.Hospital details \n 2.Branch \n 3. address \n 4.Encounter\n 5.Person \n 6. MedOrders\n 7.MedItems \n 8.Exit");
			System.out.println("enter your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				boolean repeat1 = true;
				do {
					System.out.println(
							"1.save hospital \n 2.update hospital\n 3.delete hospital\n 4.get hospital by id\n 5.get All hospital\n 6.Exit");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {

						System.out.println("enter hospital name: ");
						String hospital_name = scanner.next();
						System.out.println("enter gst: ");
						String gst = scanner.next();

						Hospital hospital = new Hospital();
						hospital.setHospital_name(hospital_name);

						hospital.setGst(gst);

						HospitalDao hospitaldao = new HospitalDao();
						
						hospitaldao.saveHospital(hospital);
						System.out.println("saved successfully");

					}
						break;// end case1
					case 2: {
						System.out.println("enter hospital id: ");
						int hospital_id = scanner.nextInt();
						System.out.println("enter the hospital name u wanto update: ");
						String hospital_name = scanner.next();

						HospitalDao hospitaldao = new HospitalDao();
						hospitaldao.updateHospital(hospital_id, hospital_name);
						System.out.println("updated successfully");

					}
						break;// end case2
					case 3: {
						System.out.println("enter hospital id: ");
						int hospital_id = scanner.nextInt();
						HospitalDao hospitaldao = new HospitalDao();
						hospitaldao.deleteHospital(hospital_id);
						System.out.println("deleted");

					}
						break; // end case3
					case 4: {
						System.out.println("enter hospital id: ");
						int hospital_id = scanner.nextInt();
						HospitalDao hospitaldao = new HospitalDao();
						hospitaldao.getHospitalById(hospital_id);
					}
						break; // end case4
					case 5: {
						HospitalDao hospitaldao = new HospitalDao();
						System.out.println(hospitaldao.getAllHospital());
					}
						break; // end case5
					case 6: {
						repeat1 = false;
					}
						break; // end case6

					}// end switch
				} while (repeat1);

			}
				break; // end case1
			case 2: {
				Branch branch = new Branch();
				BranchDao dao = new BranchDao();
				boolean repeat1 = true;
				do {
					System.out.println(
							"1.save Branch \n 2.update branch \n 3.delete branch\n 4.get branch by id\n 5.get All branch\n 6.Exit");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {

						System.out.println("Enter the Branch name");

						String name = scanner.next();

						System.out.println("Enter the Branch Contact number");

						long phoneno = scanner.nextLong();

						System.out.println("Enter the Hospital Id to add Branch ");

						int h_id = scanner.nextInt();

						branch.setBranch_name(name);

						branch.setPhoneno(98745);

						dao.saveBranch(h_id, branch);

						System.out.println("Branch Saved");

					}
						break;

					case 2: {

						System.out.println("enter the Branch Id to be update ");

						int b_id = scanner.nextInt();

						System.out.println("Enter the Branch name to be updated ");

						String b_name = scanner.next();

						dao.updateBranch(b_id, b_name);

						System.out.println("Branch name Updated");

					}
						break;

					case 3: {

						System.out.println("enter the Branch Id to be delete ");

						int b_id = scanner.nextInt();

						dao.deleteBranch(b_id);

						System.out.println("Branch Deleted");

					}
						break;

					case 4: {

						System.out.println("enter the Branch Id to be fetch ");

						int b_id = scanner.nextInt();

						dao.getBranchById(b_id);

					}
						break;

					case 5: {

						System.out.println(dao.getAllBranches());

					}
						break;

					case 6: {

						repeat1 = false;

					}
						break;
					}// end switch

				} while (repeat1); // end do while
			}
				break; // end case2
			case 3: {
				boolean repeat1 = true;
				do {
					System.out.println(
							"1.save address \n 2.update address \n 3.delete address\n 4.get address by id\n 5.get All address\n 6.Exit");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {

						System.out.println("enter address: ");
						String address = scanner.next();
						System.out.println("enter branch id:");
						int branch_id = scanner.nextInt();
						Address addres = new Address();
						addres.setAddress(address);

						AddressDao addressdao = new AddressDao();
						addressdao.saveAddress(branch_id, addres);

						System.out.println("saved");

					}
						break; // end case1
					case 2: {
						System.out.println("enter addres id:");
						int address_id = scanner.nextInt();
						System.out.println("enter address: ");
						String address = scanner.next();
						AddressDao addressdao = new AddressDao();
						addressdao.updateAddress(address_id, address);
						System.out.println("updated");

					}
						break; // case 2
					case 3: {
						System.out.println("enter addres id:");
						int address_id = scanner.nextInt();
						AddressDao addressdao = new AddressDao();
						addressdao.deleteAddress(address_id);

					}
						break;// end case3
					case 4: {
						System.out.println("enter addres id:");
						int address_id = scanner.nextInt();
						AddressDao addressdao = new AddressDao();
						addressdao.getAddressById(address_id);
					}
						break; // end case4
					case 5: {
						AddressDao addressdao = new AddressDao();
						System.out.println(addressdao.getAllAddress());

					}
						break; // end case 5
					case 6: {
						repeat1 = false;
					}
						break;

					}

				} while (repeat1);

			}
				break; // end case3
			case 4: {
				Encounter encounter = new Encounter();
				EncounterDao encounterDao = new EncounterDao();
				boolean repeat1 = true;
				do {
					System.out.println(
							"1.save encounter \n 2.update encounter \n 3.delete encounter\n 4.get encounter by id\n 5.get All encounter\n 6.Exit");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {

						System.out.println("enter reason: ");
						String reason = scanner.next();
						System.out.println("enter branch id ");
						int branch_id = scanner.nextInt();
						System.out.println("enter person id: ");
						int person_id = scanner.nextInt();
						encounter.setReason(reason);
						encounterDao.saveEncounter(person_id, branch_id, encounter);
						System.out.println("saved");

					}
						break; // end case1
					case 2: {
						System.out.println("enter encounter id: ");
						int encounter_id = scanner.nextInt();
						System.out.println("enter reason  ");
						String reason= scanner.next();
						encounterDao.updateEncounter(encounter_id,reason);

					}
						break; // end case2
					case 3: {
						System.out.println("enter encounter id: ");
						int encounter_id = scanner.nextInt();
						encounterDao.deleteEncounter(encounter_id);
						System.out.println("deleted");
					}
						break; // end case3
					case 4: {
						System.out.println("enter encounter id: ");
						int encounter_id = scanner.nextInt();
						encounterDao.getEncounterById(encounter_id);

					}
						break; // end case4
					case 5: {
						System.out.println(encounterDao.getAllEncounters());
					}
						break; // end case5
					case 6: {
						repeat1 = false;
					}
						break; // end case6
					}

				} while (repeat1);

			}
				break;// end case4

			case 5: {

				Person person = new Person();
				PersonDao dao = new PersonDao();

				boolean repeat1 = true;
				do {
					System.out.println(
							"1.save person \n 2.update person \n 3.delete person\n 4.get person by id\n 5.get All person\n 6.Exit");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {

						System.out.println("Enter the Person name");

						String name = scanner.next();

						System.out.println("Enter the Person address");

						String address = scanner.next();

						System.out.println("Enter the Person contact number");

						Long contact = scanner.nextLong();
						 person.setPerson_name(name);
						 person.setPerson_contact_number(contact);
						 person.setPerson_address(address);

						dao.savePerson(person);

						System.out.println("Person Saved");

					}
						break;

					case 2: {

						System.out.println("enter the Person Id to be update ");

						int p_id = scanner.nextInt();

						System.out.println("Enter the Person name to be updated ");

						String p_name = scanner.next();

						dao.updatePerson(p_id, p_name);

						System.out.println("Person name Updated");

					}
						break;

					case 3: {

						System.out.println("enter the Person Id to be delete ");

						int p_id = scanner.nextInt();

						dao.deletePerson(p_id);

						System.out.println("Person Deleted");

					}
						break;

					case 4: {

						System.out.println("enter the Person Id to be fetch ");

						int p_id = scanner.nextInt();

						dao.getPersonById(p_id);

					}
						break;

					case 5: {
						System.out.println(dao.getAllPerson());
					}
						break;

					case 6: {
						repeat1 = false;
					}
						break;
					}
					break;// end case5

				} while (repeat1);

			}
			case 6: {
				boolean repeat1 = true;
				do {
					Med_orders med_Orders = new Med_orders();
					Med_OrdersDao dao = new Med_OrdersDao();
					System.out.println("Select Your Choice ");
					System.out.println(
							" 1 . To insert Med_Orders  \n 2 . To update Med_Orders \n 3 . To delete Med_Orders \n 4 . To fetch Med_Orders by Id \n 5 . To get All Med_Orders \n 6 . To Exit");
					int choice1 = scanner.nextInt();
					// start 6
					switch (choice1) {
					case 1: {
						System.out.println("enter the doctor name:");
						String name = scanner.next();
						System.out.println("enter the encounter id");
						int encounter_id = scanner.nextInt();

						med_Orders.setDoctor_name(name);
						dao.saveMedOrders(med_Orders, encounter_id);
						System.out.println("saved");

					}
						break;

					case 2: {
						System.out.println("enter med order id: ");
						int medorder_id = scanner.nextInt();
						System.out.println("enter the doctor name:");
						String name = scanner.next();
						dao.updateMedOrder(medorder_id, name);
						System.out.println("updated");
					}
						break;

					case 3: {
						System.out.println("enter med order id: ");
						int medorder_id = scanner.nextInt();
						dao.deleteMedOrder(medorder_id);
						System.out.println("deleted");

					}
						break;

					case 4: {
						System.out.println("enter med order id: ");
						int medorder_id = scanner.nextInt();
						dao.getMedOrderById(medorder_id);

					}
						break;

					case 5: {
						System.out.println(dao.getAllMedorders());
					}
						break;

					case 6: {
						repeat1 = false;
					}
						break;

					}// end 6

				} while (repeat1);

			}
				break; // end case6
			case 7: {
				Med_items med_Items = new Med_items();

				Med_itemsDao dao = new Med_itemsDao();

				boolean repeat1 = true;

				do {

					System.out.println("Select Your Choice ");

					System.out.println(

							" 1 . To insert Med_Items  \n 2 . To update Med_Items \n 3 . To delete Med_Items \n 4 . To fetch Med_Items by Id \n 5 . To get All Med_Items \n 6 . To Exit");

					int choice1 = scanner.nextInt();

					// start 7

					switch (choice1) {

					case 1: {

						System.out.println("Enter the med_item name");

						String name = scanner.next();

						System.out.println("Enter the med_item price");

						double price = scanner.nextDouble();

						System.out.println("Enter the med_Oders id");

						int med_orders_id = scanner.nextInt();

						med_Items.setMed_item_name(name);

						med_Items.setMed_item_price(price);

						dao.saveMedItems(med_Items, med_orders_id);

						System.out.println("Med_Items Saved");

					}
						break;

					case 2: {

						System.out.println("enter the med_item Id to be update ");

						int m_id = scanner.nextInt();

						System.out.println("Enter the med_item name to be updated ");

						String m_name = scanner.next();

						dao.updateMedItems(m_id, m_name);

						System.out.println("med_item name Updated");

					}
						break;

					case 3: {

						System.out.println("enter the med_item Id to be delete ");

						int m_id = scanner.nextInt();

						dao.deleteMedItems(m_id);

						System.out.println("med_item Deleted");

					}
						break;

					case 4: {

						System.out.println("enter the med_item Id to be fetch ");

						int p_id = scanner.nextInt();

						dao.getMedItemsById(p_id);

					}
						break;

					case 5: {

						System.out.println(dao.getALlMedItems());

					}
						break;

					case 6: {

						repeat1 = false;

					}
						break;

					}// end 7

				} while (repeat1);

			}
				break;// end case 7
			case 8: {
				repeat = false;
				System.out.println("Thank you!!");
			}
				break; // end case 8
			default:
				System.out.println("invalid choice");
			}// end of switch

		} while (repeat); // end of 1st dowhile

	}

}
