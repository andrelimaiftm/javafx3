package br.edu.iftm.javafx3;

import br.edu.iftm.javafx3.model.classes.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Pessoa> comboBoxPessoas;

    private ObservableList<Pessoa> obslista;

    @FXML
    private Button btnTodos;

    @FXML
    public void onComboxPessoaAction(){
        Pessoa pessoa = comboBoxPessoas.getSelectionModel().getSelectedItem();
        System.out.println(pessoa);
    }

    @FXML
    public void onBtnTodosAction(){
        for(Pessoa pessoa : comboBoxPessoas.getItems()){
            System.out.println(pessoa);
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa(1, "Maria", "maria@gmail.com"));
        lista.add(new Pessoa(2, "Alex", "alex@gmail.com"));
        lista.add(new Pessoa(3, "Andre", "andre@gmail.com"));
        lista.add(new Pessoa(4, "Pedro", "pedro@gmail.com"));
        obslista = FXCollections.observableArrayList(lista);
        comboBoxPessoas.setItems(obslista);

        Callback<ListView<Pessoa>, ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() {
            @Override
            protected void updateItem(Pessoa item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        };

        comboBoxPessoas.setCellFactory(factory);
        comboBoxPessoas.setButtonCell(factory.call(null));

    }

}