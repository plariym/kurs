package com.example.shopapp.controller.kindmoto;

import com.example.shopapp.ShopMotoApp; 
import com.example.shopapp.model.KindMoto;
import com.example.shopapp.service.KindMotoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class KindMotoController {

    private List<KindMoto> kindMotos;

    @FXML
    private Button btnCustomers;

    @FXML
    private TableColumn<?, ?> vidColumn;

    @FXML
    private Button btnSales;
    @FXML
    private Button btnOff;

    @FXML
    private TableView<KindMotoTableItem> kindMotoTable;

    @FXML
    private Button btnKindMoto;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> powerColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;
    private ObservableList<KindMotoTableItem> motoObservable;

    @FXML
    void btnAddKindMoto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(ShopMotoApp.class.getResource("add-edit-kind-moto-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(ShopMotoApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("Добавить вид кредита");
            AddEditKindMotoDialog controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }
    }

    @FXML
    void btnDeleteKindMoto(ActionEvent event) {
        KindMotoTableItem currentItem = kindMotoTable.getSelectionModel().getSelectedItem();
        int currentItemId = kindMotoTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getName() + "\"?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                new KindMotoService().delete(currentItem.getKindMoto());
                kindMotoTable.getItems().remove(currentItemId);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }

    @FXML
    void btnEditKindMoto(ActionEvent event) {
        KindMotoTableItem currentItem = kindMotoTable.getSelectionModel().getSelectedItem();
        int currentItemId = kindMotoTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(ShopMotoApp.class.getResource("add-edit-kind-moto-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(ShopMotoApp.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать вид кредита");
                AddEditKindMotoDialog controller = loader.getController();
                controller.setEditDialogStage(dialogStage, currentItem.getKindMoto());
                dialogStage.showAndWait();
                updateList();
            } catch (IOException e) {
                System.out.println("Ошибка открытия окна: " + e.getMessage());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для редактирования");
            alert.showAndWait();
        }
    }
    @FXML
    void btnSales(ActionEvent event) {
        ShopMotoApp.primaryStage.setScene(ShopMotoApp.sales);
    }


    @FXML
    void btnOff(ActionEvent event) {
        ShopMotoApp.primaryStage.close();
    }

    @FXML
    void btnUpdateKindMoto(ActionEvent event) {
        updateList();
    }

    public void updateList() {
        try {
            kindMotos = new KindMotoService().findAll();
            motoObservable.clear();

            if (kindMotos != null) {
                for (KindMoto KindMoto : kindMotos) {
                    motoObservable.add(new KindMotoTableItem(KindMoto));
                }
            }
            kindMotoTable.refresh();

        } catch (Exception e) {
            System.err.println("Ошибка в updateList():");
            e.printStackTrace();
        }
    }

    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        vidColumn.setCellValueFactory(new PropertyValueFactory<>("class"));
        powerColumn.setCellValueFactory(new PropertyValueFactory<>("power"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        motoObservable = FXCollections.observableArrayList();
        kindMotoTable.setItems(motoObservable);
        updateList();
    }

    public void btnCustomers(ActionEvent actionEvent) {
        ShopMotoApp.primaryStage.setScene(ShopMotoApp.customers);
    }
}