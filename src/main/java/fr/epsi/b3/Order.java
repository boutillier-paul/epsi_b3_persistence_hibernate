package fr.epsi.b3;


import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


@Entity
public class Order {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Generated( GenerationTime.INSERT )
    @ColumnDefault( "CURRENT_TIMESTAMP" )
    private Date date;
    @OneToOne
    @JoinColumn(name="Product_fk")
    private Product product;
    @ManyToOne
    @JoinColumn(name="Client_fk")
    private Client client;

    public Order(Product product, Client client) {
        this.product = product;
        this.client = client;
    }

    public Order() {}

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Product getProduct() {
        return product;
    }

    public Client getClient() {
        return client;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}