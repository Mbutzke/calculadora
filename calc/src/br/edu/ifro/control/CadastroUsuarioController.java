/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import br.edu.ifro.modelo.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 00669412295
 */
public class CadastroUsuarioController implements Initializable {

    @FXML
    private JFXButton btnCriarConta;
    @FXML
    private JFXPasswordField senha;
    @FXML
    private JFXPasswordField repetirSenha;
    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private StackPane dialogMessagen;
    @FXML
    private JFXButton btnFechar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }       
    @FXML
    private void fecharPrograma(ActionEvent event) {
        Stage stage = (Stage) btnFechar.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void verificacoes(){
        if(senha.getText().equals(repetirSenha.getText())){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT u FROM Usuario as u where u.nomeUsuario = :usuario");
            query.setParameter("usuario", txtUsuario.getText());
            List<Usuario> u = query.getResultList();
            
            if(!u.isEmpty()){
                mensagemUsuarioExistente();
            }
            else{
                    Usuario user1 = new Usuario();
                    user1.setNomeUsuario(txtUsuario.getText());
                    user1.setSenha(senha.getText());

                    em.getTransaction().begin();
                    em.persist(user1);
                    em.getTransaction().commit();
        
                    mensagemConclusão();
            }
        }
        else{
                mensagemConflitodeSenhas();
        }
    }
    
       private void mensagemConclusão(){
    
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Usuário cadastrado com sucesso!"));
        JFXDialog dialog = new JFXDialog(dialogMessagen, content, JFXDialog.DialogTransition.CENTER);
        JFXButton button = new JFXButton("Fechar");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        
        content.setActions(button);
        dialog.show();
        
        txtUsuario.setText("");
        senha.setText("");
        repetirSenha.setText("");
      
        
 }
       
       private void mensagemUsuarioExistente(){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Usuário já existente!"));
        JFXDialog dialog = new JFXDialog(dialogMessagen, content, JFXDialog.DialogTransition.CENTER);
        JFXButton button = new JFXButton("Fechar");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        
        content.setActions(button);
        dialog.show();
        
        txtUsuario.setText("");
        senha.setText("");
        repetirSenha.setText("");
      
        
 } 
     private void mensagemConflitodeSenhas(){
         JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Senhas digitadas não conferem!"));
        JFXDialog dialog = new JFXDialog(dialogMessagen, content, JFXDialog.DialogTransition.CENTER);
        JFXButton button = new JFXButton("Fechar");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        
        content.setActions(button);
        dialog.show();
        
        txtUsuario.setText("");
     
     }   
     
                    private void enter(KeyEvent event) throws IOException{
        if (event.getCode() == KeyCode.ENTER) {
            verificacoes();
        }
    }
}
