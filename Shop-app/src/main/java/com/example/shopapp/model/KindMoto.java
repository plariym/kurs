package com.example.shopapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "kind_moto")
public class KindMoto {
    @Id
    @Column(name = "kind_moto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kindCreditId;
    @Column(name = "name")
    private String name;
    @Column(name = "class")
    private String vid;
    @Column(name = "Power(h/p)")
    private Integer power;
    @Column(name = "price")
    private Integer price;

    // Геттеры и сеттеры
    @Override
    public String toString() {
        return name;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        if (!vid.isEmpty()) {
            this.vid = vid;
        } else {
            throw new IllegalArgumentException("Класс не должно быть пустым");
        }
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(String powerText) {
        if (!powerText.)
        this.power = power;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer priceText) {
        if (!priceText.isEmpty() && priceText.matches("-?\\d+")){
            int price = Integer.parseInt(priceText);
            this.price = price;
        }else {
            throw new IllegalArgumentException("Цена должна быть целым числом!");
        }

    }

    public Integer getKindCreditId() {
        return kindCreditId;
    }

    public void setKindCreditId(Integer kindCreditId) {
        this.kindCreditId = kindCreditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Название не должно быть пустым");
        }
    }
}