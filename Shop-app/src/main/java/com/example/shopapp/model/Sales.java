package com.example.shopapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesId;

    @ManyToOne
    @JoinColumn(name = "kind_moto_id")
    private KindMoto kindMoto;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "price")
    private Integer price;

    @Column(name = "date")
    private LocalDate date;

    public KindMoto getKindMoto() {
        return kindMoto;
    }

    public void setKindMoto(KindMoto kindMoto) {
        this.kindMoto = kindMoto;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Salers{" +
                "id='" + salesId + "' " +
                "kind_moto='" + kindMoto + "' " +
                "customer='" + customer + "' " +
                "price='" + price + "' " +
                "date='" + date + "'";
    }
}
