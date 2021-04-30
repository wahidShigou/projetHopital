package cours.controller;

import cours.java.model.Service;
import cours.java.model.Specialite;
import cours.utils.Fabrique;
import cours.utils.Utils;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ServiceController implements Initializable {

    @FXML
    private TableView<Service> serviceTable;

    @FXML
    private TableColumn<Service, Long> colID;

    @FXML
    private TableColumn<Service, String> colLibelle;

    @FXML
    private TextField serviceTfd;

    @FXML
    private Button saveBtn;

    @FXML
    public void saveHandler(ActionEvent event) {
        if(serviceTfd.getText().trim().isEmpty()){
            Utils.showMessage("Cours RMI","Gestion des servioce","Libellé service obligatoire !");
            return;
        }
        Service s = new Service();
        s.setLibelle(serviceTfd.getText().trim());
        try {
            Fabrique.getiService().add(s);
            Utils.showMessage("Cours RMI","Gestion des servioce","Service sauvegardé !");
        }
        catch(Exception e){
            Utils.showMessage("Cours RMI","Gestion des servioce","Erreur : "+e.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colID.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        colLibelle.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>
                (cellData.getValue().getLibelle()));
        try {
            serviceTable.setItems(FXCollections.
                    observableArrayList(Fabrique.getiService().findAll()));
        }
        catch(Exception e){
            Utils.showMessage("Cours RMI","Gestion des servioce","Erreur : "+e.getMessage());
        }

    }
}