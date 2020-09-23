package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department departmentObj = new Department(1, "Books");
        Seller seller = new Seller(21, "Raquel", "raquel@bolarida.com", new Date(), 3000.0, departmentObj);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.print(seller);
    }
}
