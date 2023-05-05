package fr.epsi.b3;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.epsi.b3.HibernateUtil;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Product product = new Product("Product Name", 99.99);
        Client client = new Client("John", "Doe", "555-555-5555");
        Order order = new Order(product, client);

        ProductDao productDao = new ProductDao();
        productDao.saveProduct(product);

        List <Product> products = productDao.getProducts();
        products.forEach(p -> System.out.println(p.getName()));
    }
}
