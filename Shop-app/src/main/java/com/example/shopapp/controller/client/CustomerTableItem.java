package com.example.shopapp.controller.client;
import com.example.shopapp.model.Customer;
import javafx.beans.property.SimpleStringProperty;

public class CustomerTableItem {
    private SimpleStringProperty fio;
    private SimpleStringProperty passport;
    private SimpleStringProperty phone;
    private SimpleStringProperty address;
    private Customer customer;
    public CustomerTableItem(Customer customer) {
        this.fio = new SimpleStringProperty(customer.getFio());
        this.passport = new SimpleStringProperty(customer.getPassport());
        this.address = new SimpleStringProperty(customer.getAddress());
        this.phone = new SimpleStringProperty(customer.getPhone());
        this.customer = customer;
    }
    public String getFio() {
        return fio.get();
    }
    public SimpleStringProperty fioProperty() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio.set(fio);
    }
    public String getPassport() {
        return passport.get();
    }
    public SimpleStringProperty passportProperty() {
        return passport;
    }
    public void setPassport(String passport) {
        this.passport.set(passport);
    }
    public String getPhone() {
        return phone.get();
    }
    public SimpleStringProperty phoneProperty() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    public String getAddress() {
        return address.get();
    }
    public SimpleStringProperty addressProperty() {
        return address;
    }
    public void setAddress(String address) {
        this.address.set(address);
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
