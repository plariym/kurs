package com.example.shopapp.controller.kindmoto;
import com.example.shopapp.model.KindMoto;
import javafx.beans.property.SimpleStringProperty;

public class KindMotoTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty vid;
    private SimpleStringProperty power;
    private SimpleStringProperty price;
    private KindMoto kindMoto;

    public KindMotoTableItem(KindMoto KindMoto){
        this.name = new SimpleStringProperty(KindMoto.getName());
        this.vid = new SimpleStringProperty(KindMoto.getVid());
        this.power = new SimpleStringProperty(KindMoto.getPower().toString());
        this.price = new SimpleStringProperty(KindMoto.getPrice().toString());
        this.kindMoto = KindMoto;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getVid() {
        return vid.get();
    }

    public SimpleStringProperty vidProperty() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid.set(vid);
    }

    public String getPower() {
        return power.get();
    }

    public SimpleStringProperty powerProperty() {
        return power;
    }

    public void setPower(String power) {
        this.power.set(power);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public KindMoto getKindMoto() {
        return kindMoto;
    }

    public void setKindMoto(KindMoto kindMoto) {
        this.kindMoto = kindMoto;
    }


}
