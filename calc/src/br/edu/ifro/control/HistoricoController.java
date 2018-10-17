/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.modelo.historico;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 00669412295
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
    public void buscarSalvar(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT a FROM historico a");
        query.setParameter("nomeAluno", "%"+txtAluno.getText()+"%");
        
        List<historico> historico = query.getResultList();
        
        ObservableList oAlunos = FXCollections.observableArrayList(historico);
   
        tbAlunos.setItems(oAlunos);
    }
}
