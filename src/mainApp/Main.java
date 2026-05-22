package mainApp;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {

		try {

			Lost_items ls = new Lost_items();
			Police_portal pc = new Police_portal();
			Found_items fi = new Found_items();
			Scanner sc = new Scanner(System.in);
			int main_menu = 1;
			while (main_menu == 1) {

				System.out.println("Select options to do operations :");
				System.out.println("-------------------------------");
				System.out.println("Press 1 to Common Authority Login :");
				System.out.println("Press 2 to Founder Login");
				System.out.println("Press 3 to Lost_items :");

				int opt = sc.nextInt();
				sc.nextLine();
				
				// Police Portal
				if (opt == 1) {
					while (main_menu == 1) {
					System.out.println("Welcome to Common Authority Portal :");
					System.out.println("Press 1 to Login Account ");
					System.out.println("Press 2 to Create new Account ");
					System.out.println("Press 0 to Back");
					int acc = sc.nextInt();
					if (acc == 1) {
						System.out.print("Enter UserName : ");
						String uname = sc.next();
						System.out.print("\nEnter Password : ");
						String pass = sc.next();
						boolean loginstatus = pc.police_login(uname, pass);

						if (loginstatus) {
							System.out.println("\t\t\t\tWelcome  " + uname + "!!!");
							int opt1_1 = 1;
							while (opt1_1 != 0) {
								System.out.println("Select your operation : ");
								System.out.println("Press 1 to see all data :");
								System.out.println("Press 2 to delete hand-over data :");
								
								int opt1 = sc.nextInt();
								if (opt1 == 1) {
									pc.show();
								} else if (opt1 == 2) {
									System.out.println("! ! ! ..Make sure of id before delete data...");
									System.out.print("Enter delete data id : ");
									int id = sc.nextInt();
									pc.delete_data(id);
								}
								System.out.println("To continue Common Authority portal press 1 :");
								System.out.println("Go back press 0 : ");
								opt1_1 = sc.nextInt();
							}
						} else {
							System.out.println("Invalid User Login ");
							System.out.println("....Try again.....");
						}
					} else if (acc == 2) {
						System.out.print("Enter UserName : ");
						String uname = sc.next();
						System.out.print("\nEnter Password : ");
						String pass = sc.next();
						pc.police_signup(uname, pass);
						}else {break;}
				}
			}
				// Founder Portal
				else if (opt == 2) {
					System.out.println("Welcome to Founders Portal : (Login to continue)");
					System.out.print("Enter UserName : ");
					String uname = sc.next();
					System.out.print("\nEnter Password : ");
					String pass = sc.next();
					boolean loginstatus = fi.founder_login(uname, pass);
					if (loginstatus) {
						System.out.println("\t\t\t\tWelcome : " + uname + "!!!");
						System.out.println("Select your operation : ");
						System.out.println("Press 1 to Update New Data :");
						System.out.println("Press 2 to Update Status :");
						int opt2 = sc.nextInt();
						if (opt2 == 1) {
							System.out.println("Enter product type (without_space) :");
							String ptype = sc.next();

							System.out.println("Enter product name (without_space) :");
							String name = sc.next();
							sc.nextLine();
							System.out.println("Enter product description");
							String desc = sc.nextLine();

							System.out.println("Enter product found location");
							String loc = sc.nextLine();

							System.out.println("Enter product found date (YYYY-MM-DD)");
							String fdate = sc.nextLine();

							System.out.println("Enter your contact Number");
							long contact = sc.nextLong();

							fi.found_details(ptype, name, desc, loc, fdate, contact);

							System.out.println("Product details updated Successfully");
						} else if (opt2 == 2) {
							System.out.println("Enter product id to update status :");
							int id = sc.nextInt();
							fi.update_status(id);
							System.out.println("Status updated Successfully");
						} else {
							System.out.println("Invalid Option");
						}
					} else {
						System.out.println("Invalid User Login ");
						System.out.println("....Try again.....");
					}
				} else if (opt == 3) {
					System.out.println("Welcome to Lost_items Finder App");
					System.out.println("Product-type to search (without_space) \nEx : \n1. Phone \n2. Laptop ");
					System.out.println("Enter Your Product_type : ");
					String ptype = sc.next();
					ls.lost_details(ptype);
				} else {
					System.out.println("Invalid Option");
					System.out.println("Try Again");
				}
				System.out.println("To Go back to main menu press 1 : ");
				System.out.println("Press 0 to Exit App");
				main_menu = sc.nextInt();
			}
			System.out.println("........ThankYou........");
			sc.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
