package com.example.shopapp.controller.sales;

import com.example.shopapp.model.Sales;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class SalesTableItem {
    private SimpleObjectProperty kindMoto;
    private SimpleObjectProperty customer;
    private SimpleIntegerProperty price;
    private SimpleObjectProperty<LocalDate> date;
    private Sales sales;

    public SalesTableItem(Sales sales) {
        this.kindMoto = new SimpleObjectProperty<>(sales.getKindMoto());
        this.customer = new SimpleObjectProperty<>(sales.getCustomer());
        this.price = new SimpleIntegerProperty(sales.getPrice());
        this.date = new SimpleObjectProperty<>(sales.getDate());
        this.sales = sales;
    }


    public Object getKindMoto() {
        return kindMoto.get();
    }

    public SimpleObjectProperty kindMotoProperty() {
        return kindMoto;
    }

    public void setKindMoto(Object kindMoto) {
        this.kindMoto.set(kindMoto);
    }

    public Object getCustomer() {
        return customer.get();
    }

    public SimpleObjectProperty customerProperty() {
        return customer;
    }

    public void setCustomer(Object customer) {
        this.customer.set(customer);
    }

    public int getPrice() {
        return price.get();
    }

    public SimpleIntegerProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public Sales getSales() {
        return sales;
    }

    public void setSalers(Sales sales) {
        this.sales = sales;
    }
}
