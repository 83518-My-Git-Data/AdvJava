package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;



public class GetProductsByPriceAndCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in);
				) {
			// create dao instance
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter begin end price and catogory");
			dao.getProductsByCategoryAndPriceRange(sc.nextDouble(),
					sc.nextDouble(), 
					Category.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);//u -> System.out.println(u)
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}


	}

}
