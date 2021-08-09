package weekend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestMethod {

	public static void main(String[] args) {

		String Customer_name;
		int age;
		String sql;

		String URL = "jdbc:mysql://localhost:3306";
		String USER = "root";
		String PASS = "root";
		Scanner s= new Scanner(System.in);

		// Open a connection
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
				Statement stmt = conn.createStatement();
				)
		{	
			//sql="CREATE SCHEMA `bank` ;";
			// stmt.executeUpdate(sql);
	//	sql="CREATE TABLE `bank`.`customer_details` (`customer_Id` INT NOT NULL AUTO_INCREMENT, `customer_name` VARCHAR(45) NOT NULL,`customer_age` VARCHAR(45) NOT NULL,PRIMARY KEY (`customer_Id`));";
			//stmt.executeUpdate(sql);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", USER, PASS);
			Statement st = con.createStatement();
			
			for(int i=1;i==1;)  {
				Scanner sa =new Scanner(System.in);
		System.out.println("      WELCOME TO BANK");
		System.out.println("''''''''''''''''''''''''''''''''''''");
		System.out.println("''''''''''''''''''''''''''''''''''''");
		System.out.println("1.Create Account");
		System.out.println("2.Show customer details");
		System.out.println("3.Account details");
		System.out.println("4.withdraw");
		System.out.println("5.Check balance");
		System.out.println("6.Exit");
		Bank b= new Bank();
		Scanner sc = new Scanner(System.in);
		int ch;
		System.out.println("Enter the choice:");
		ch=sc.nextInt();
		switch (ch) {


		case 1:System.out.println("Enter customer name:");
		Customer_name=sa.nextLine();
		System.out.println("Enter age:");
		age=sa.nextInt();
		if (age<18) {
			System.out.println("not eligible");
			i=1;
		}else {
			 sql="INSERT INTO customer_details(customer_name,customer_age) VALUES  "+"('"+Customer_name + "',"+age +")";
			st.executeUpdate(sql);
			System.out.println("account created");
			
		}
		
			break;
		case 2:
			Statement stm =con.createStatement();
			ResultSet rs =stm.executeQuery("SELECT * FROM bank.customer_details; ");
			while(rs.next())
			System.out.println(rs.getInt(1)+  "  "+rs.getNString(2)+ " " +rs.getInt(3));
			break;
		case 6:
			i=0;
			System.out.println("---------------------EXIT-----------------------");
			break;
			default:
				System.out.println("Enter valid choice.");
				break;
			
		
		
		}
		}

		} 
		
	

		catch (Exception e) {
			System.out.println(e);;
		}
		}

	}
