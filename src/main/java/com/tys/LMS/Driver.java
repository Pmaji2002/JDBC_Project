package com.tys.LMS;

import java.util.List;
import java.util.Scanner;

import com.tyss.lms.dao.LaptopDao;
import com.tyss.lms.entity.Laptop;
import com.tyss.lms.utility.HelperClass;

public class Driver{
	static Scanner scanner = new Scanner(System.in);
	static LaptopDao laptopDao=new LaptopDao();
	public static void main(String[] args){
		boolean flag=true;
		while(flag){
			System.out.println("user enter 1 to create and add laptop to DataBase");
			System.out.println("user enter 2 to delete laptop from DateBase");
			System.out.println("user enter 3 to update laptop");
			System.out.println("user enter 4 to find all laptops in DataBase");
			System.out.println("user enter 5 to find laptop by id in DateBase");
			System.out.println("user enter 6 to exit");
			try{
				int choice=scanner.nextInt();
				switch(choice){
				case 1:
					Laptop laptop = HelperClass.createLaptop(scanner);
					Laptop laptop2 = laptopDao.addLaptop(laptop);
					if(laptop.equals(laptop2))
						System.out.println("laptop sucessfuly inserted");
					break;
				case 2:
					System.out.println("user enter id");
					int id=scanner.nextInt();
					if(laptopDao.deleteLaptop(id)) 
						System.out.println("laptop successfully deleted");
					break;
				case 3:
					System.out.println("user enter id");
					int id2=scanner.nextInt();
					Laptop laptop3=laptopDao.updateLaptop(id2, scanner);
					if (laptop3!=null)
						System.out.println("laptop succesfully updated");
					break;
				case 4:
					List<Laptop> laptops = laptopDao.findAllLaptops();
					if (laptops.size()==0)
						System.out.println("no laptop exists please add laptops first to perform crud operations");
					break;
				case 5:
					System.out.println("user enter id");
					int id3=scanner.nextInt();
					Laptop laptop4=  laptopDao.findById(id3);
					if (laptop4!=null)
						System.out.println(laptop4);
					break;
				case 6:
					flag =false;
					System.out.println("sucessfully exited");
					break;
				default:
					System.out.println("user please enter valid choice");	
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
