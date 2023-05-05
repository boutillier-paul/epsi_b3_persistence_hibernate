package fr.epsi.b3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Configuration configuration = new Configuration().configure("./");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Product product = new Product("Product Name", 99.99);
        Client client = new Client("John", "Doe", "555-555-5555");
        Order order = new Order(product, client);

        session.persist(order);

        transaction.commit();
        session.close();

    }
}