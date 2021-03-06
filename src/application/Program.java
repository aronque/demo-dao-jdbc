package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===TESTE 1: SELLER BY ID ===");

        Seller seller = sellerDao.findById(3);

        System.out.print(seller);

        System.out.println("\n===TESTE 2: SELLER BY DEPARTMENT ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for(Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n===TESTE 3: SELLER FIND ALL ===");
        list = sellerDao.findAll();
        for(Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n===TESTE 4: INSERT SELLER ===");
        Seller newSeller = new Seller(null, "Jooj", "jooj@gmail.com", new Date(), 2040.00, dep);
        sellerDao.insert(newSeller);
        System.out.print(newSeller.getId());

        System.out.println("\n===TESTE 5: UPDATE SELLER ===");
        newSeller = sellerDao.findById(1);
        newSeller.setName("Vitor Aronque");
        sellerDao.update(newSeller);
        System.out.print("Update completed");

        System.out.println("\n===TESTE 6: DELETE SELLER ===");
        System.out.print("Enter id for delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.print("Deleted!");
    }
}
