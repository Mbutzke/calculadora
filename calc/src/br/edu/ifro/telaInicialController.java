/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import br.edu.ifro.modelo.historico;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 02119149240
 */
public class telaInicialController implements Initializable {
    
    @FXML
    private TextField txtNum1, txtNum2, txtResult;
    @FXML
    private Button btnSoma, btnSub, btnMult, btnDiv;
    @FXML
    private Label label;
    @FXML
    private Button btnClean;
    @FXML
    private String operador;
    
    @FXML
    private void Soma(ActionEvent event) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
            historico historico = new historico ();
            
         
        Double num1 = Double.parseDouble (txtNum1.getText()); 
           Double num2 = Double.parseDouble (txtNum2.getText()); 
                     Double result = num1 + num2;  
          txtResult.setText(result.toString());
                txtNum1.setText("");
                txtNum2.setText("");
             historico.setNum1(txtNum1.getText());
             historico.setNum2(txtNum2.getText());
             historico.setResult(txtResult.getText());
             historico.setOperador("+");
             
          em.getTransaction().begin();
          
          
          em.persist(historico);
          
          em.getTransaction().commit();
             
                
    }
    
     @FXML
    private void Sub(ActionEvent event) {
         EntityManagerFactory emf= Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
            historico historico = new historico ();
           Double num1 = Double.parseDouble (txtNum1.getText()); 
           Double num2 = Double.parseDouble (txtNum2.getText()); 
                     Double result = num1 - num2;  
                 txtResult.setText(result.toString());
                txtNum1.setText("");
                txtNum2.setText("");
                
             historico.setNum1(txtNum1.getText());
             historico.setNum2(txtNum2.getText());
             historico.setResult(txtResult.getText());
               historico.setOperador("-");
               
            em.getTransaction().begin();
          
          
          em.persist(historico);
          
          em.getTransaction().commit();
             
    }
    
     @FXML
    private void Mult(ActionEvent event) {
            EntityManagerFactory emf= Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
            historico historico = new historico ();
            
           Double num1 = Double.parseDouble (txtNum1.getText()); 
           Double num2 = Double.parseDouble (txtNum2.getText()); 
                     Double result = num1 * num2;  
                 txtResult.setText(result.toString());
                  txtNum1.setText("");
                  txtNum2.setText("");
                  
             historico.setNum1(txtNum1.getText());
             historico.setNum2(txtNum2.getText());
             historico.setResult(txtResult.getText());
               historico.setOperador("*");
               
          em.getTransaction().begin();
          
          
          em.persist(historico);
          
          em.getTransaction().commit();
             
    }
    
     @FXML
    private void Div(ActionEvent event) {
        
         EntityManagerFactory emf= Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
            historico historico = new historico ();
            
           Double num1 = Double.parseDouble (txtNum1.getText()); 
           Double num2 = Double.parseDouble (txtNum2.getText()); 
                     Double result = num1 / num2;  
                 txtResult.setText(result.toString());
                txtNum1.setText("");
                txtNum2.setText("");
                
             historico.setNum1(txtNum1.getText());
             historico.setNum2(txtNum2.getText());
             historico.setResult(txtResult.getText());
               historico.setOperador("/");
               
         em.getTransaction().begin();
          
          
          em.persist(historico);
          
          em.getTransaction().commit();
             
    }
     @FXML
    private void Clean(ActionEvent event) {
                 txtResult.setText("");
                
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrirHist(ActionEvent event) throws IOException{
                 try{
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Historico.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(),900,682);
                    Stage stage = new Stage();
                    stage.setTitle("History");
                    stage.setScene(scene);
                    stage.show();
                }
                catch(IOException e){

}
    }

    @FXML
    private void FecharTela(ActionEvent event) {
                System.exit(0);
    }
    
}
