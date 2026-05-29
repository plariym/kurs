package com.example.shopapp.model;


import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "fio")
    private String fio;

    @Column(name = "passport")
    private String passport;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;


    // Геттеры и сеттеры
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        if (!fio.isEmpty()) this.fio = fio;
        else throw new IllegalArgumentException("ФИО не должно быть пустым!");
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        if (!passport.isEmpty()) this.passport = passport;
        else throw new IllegalArgumentException("Паспорт не должен быть пуcтым!");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (!phone.isEmpty() && phone.length() <= 20) this.phone = phone;
        else throw new IllegalArgumentException("Телефон не может быть пустым или одержать более 20 символов!");
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!address.isEmpty()) this.address = address;
        else throw new IllegalArgumentException("Адрес не может быть пустым!");
    }

    @Override
    public String toString(){
        return fio;
    }
}
