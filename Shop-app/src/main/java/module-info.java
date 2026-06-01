module com.example.shopapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.desktop;
    requires org.hibernate.validator;
    requires org.postgresql.jdbc;
    requires jakarta.validation;
    opens com.example.shopapp to javafx.fxml;
    opens com.example.shopapp.model to org.hibernate.orm.core, javafx.base;
    exports com.example.shopapp;
    exports com.example.shopapp.controller;
    opens com.example.shopapp.controller to javafx.fxml;
    opens com.example.shopapp.util to org.hibernate.orm.core;
    exports com.example.shopapp.controller.client;
    opens com.example.shopapp.controller.client to javafx.fxml;
    exports com.example.shopapp.controller.kindmoto;
    opens  com.example.shopapp.controller.kindmoto to javafx.fxml;
}