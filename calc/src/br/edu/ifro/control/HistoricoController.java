/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author 00080339271
 */
public class HistoricoController implements Initializable {

    @FXML
    private JFXTextField txtAluno;
    @FXML
    private JFXButton btnProcurar;
    @FXML
    private TableView<?> tbAlunos;
    @FXML
    private JFXButton btnEditar;
    @FXML
    private JFXButton btnDeletar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buscarSalvar(ActionEvent event) {
    }
    
}
