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
    private void Soma(ActionEvent event) {
           Double num1 = Double.parseDouble (txtNum1.getText()); 
           Double num2 = Double.parseDouble (txtNum2.getText()); 
                     Double result = num1 + num2;  
                     
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
    
}
