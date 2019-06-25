package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("====Test 1: seller find by id====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n====Test 2: seller find by department====");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		for(Seller x: list) {
			System.out.println(x);
		}
		
		System.out.println("\n====Test 3: seller find all====");
		list = sellerDao.findAll();
		for(Seller x: list) {
			System.out.println(x);
		}
		
		System.out.println("\n====Test 4: seller insert====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(2, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted new id = " + newSeller.getId());
		
		System.out.println("\n====Test 5: seller update====");
		seller = sellerDao.findById(1);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n====Test 6: seller delete====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete comleted!");
		
		sc.close();
	}
}
