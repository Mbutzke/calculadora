/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

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
    private void Soma(ActionEvent event) {
           Double num1 = Double.parseDouble (txtNum1.getText()); 
           Double num2 = Double.parseDouble (txtNum2.getText()); 
                     Double result = num1 + num2;  
          
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
            EntityManager em = emf.createEntityManager();
                telaInicialController numero1 = new telaInicialController();
                    numero1.setNum1(txtNum1.getText());
                    
                txtResult.setText(result.toString());
                txtNum1.setText("");
                txtNum2.setText("");
    }
    
     @FXML
    private void Sub(ActionEvent event) {
           Double num1 = Double.parseDouble (txtNum1.getText()); 
           Double num2 = Double.parseDouble (txtNum2.getText()); 
                     Double result = num1 - num2;  
                 txtResult.setText(result.toString());
                txtNum1.setText("");
                txtNum2.setText("");
    }
    
     @FXML
    private void Mult(ActionEvent event) {
           Double num1 = Double.parseDouble (txtNum1.getText()); 
           Double num2 = Double.parseDouble (txtNum2.getText()); 
                     Double result = num1 * num2;  
                 txtResult.setText(result.toString());
                  txtNum1.setText("");
                  txtNum2.setText("");
    }
    
     @FXML
    private void Div(ActionEvent event) {
           Double num1 = Double.parseDouble (txtNum1.getText()); 
           Double num2 = Double.parseDouble (txtNum2.getText()); 
                     Double result = num1 / num2;  
                 txtResult.setText(result.toString());
                txtNum1.setText("");
                txtNum2.setText("");
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
    private void abrirHist(ActionEvent event) {
                 try{
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("Histórico.fxml"));
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
