package com.example.shopapp.controller.kindmoto;
import com.example.shopapp.service.KindMotoService;
import com.example.shopapp.model.KindMoto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
public class AddEditKindMotoDialog implements Initializable {
    @FXML
    private TextField vidField;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField powerField;
    @FXML
    private TextField nameField;
    @FXML
    private Button okButton;
    @FXML
    private TextField priceField;
    private Stage dialogStage;
    private KindMoto kindMoto;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    private void add() {
        try {
            KindMoto kindMoto = new KindMoto();
            kindMoto.setName(nameField.getText());
            kindMoto.setPrice(priceField.getText());
            kindMoto.setVid(vidField.getText());
            kindMoto.setPower(powerField.getText());
            KindMotoTableItem KindMotoTableItem = new KindMotoTableItem(kindMoto);
            new KindMotoService().save(kindMoto);
            dialogStage.close();
        }catch (IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
        }
    }
    void edit() {
        try {
            kindMoto.setName(nameField.getText());
            kindMoto.setPrice(priceField.getText());
            kindMoto.setVid(vidField.getText());
            kindMoto.setPower(powerField.getText());
            new KindMotoService().update(kindMoto);
            dialogStage.close();
        }catch (IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
        }
    }
    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }
    public void setEditDialogStage(Stage dialogStage, KindMoto kindMoto) {
        this.kindMoto = kindMoto;
        this.dialogStage = dialogStage;
        nameField.setText(kindMoto.getName());
        powerField.setText(String.valueOf(kindMoto.getPower()));
        vidField.setText(kindMoto.getVid());
        priceField.setText(String.valueOf(kindMoto.getPrice()));
        okButton.setOnAction((www) -> edit());
    }
}
