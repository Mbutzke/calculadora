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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
 * @author 02119149240
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXButton btnCadastrar;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private StackPane messageDialog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();

        // Busca utilizando HQL
        Query query = em.createQuery("SELECT u FROM Usuario as u where u.nomeUsuario = :usuario");
        query.setParameter("usuario", txtUsuario.getText());
        List<Usuario> u = query.getResultList();

        if (!u.isEmpty()) {

            Usuario usuario = u.get(0);

            //Query queryLogin = em.createQuery("SELECT u FROM Usuario as u WHERE u.nomeUsuario = :login");
            //queryLogin.setParameter("login", usuario.getText());
            //Usuario usuario = (Usuario) queryLogin.getSingleResult();
            if (txtSenha.getText().equals(usuario.getSenha())) {
                // usuario nao cadastrado
                //mensagemNaoCadastrado();
                Stage stage1 = (Stage) btnLogin.getScene().getWindow();
                //stage1.close();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/telaInicial.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 400);
                Stage stage = new Stage();
                //stage.resizableProperty().setValue(Boolean.FALSE);
                stage.setTitle("Menu Principal");
                stage.setScene(scene);
                stage.show();
            } else {

                mensagemSenhaErrada();
            }
        } else {

            mensagemSemUsuarioCadastrado();

        }
        em.close();
        emf.close();
    }

    @FXML
    private void cadastrar(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) btnCadastrar.getScene().getWindow();
        //stage1.close();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/cadastroUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Cadastrar usuário");
        stage.setScene(scene);
        stage.show();

    }

    private void next(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            txtSenha.requestFocus();
        }
    }

    private void mensagemNaoCadastrado() {
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Erro ao logar, usuário não cadastrado!"));
        JFXDialog dialog = new JFXDialog(messageDialog, content, JFXDialog.DialogTransition.CENTER);
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
        txtSenha.setText("");

    }

    private void mensagemSenhaErrada() {
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Erro ao logar, senha que foi digitada está errada!"));
        JFXDialog dialog = new JFXDialog(messageDialog, content, JFXDialog.DialogTransition.CENTER);
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
        txtSenha.setText("");

    }

    private void mensagemSemUsuarioCadastrado() {
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Usuário não cadastrado no sistema. Tente cadastrar um usuário ou inserir um usuário válido!"));
        JFXDialog dialog = new JFXDialog(messageDialog, content, JFXDialog.DialogTransition.CENTER);
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
        txtSenha.setText("");

    }
}
