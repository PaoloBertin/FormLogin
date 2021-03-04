package eu.paolo.bertin.formlogin.controller;

import eu.paolo.bertin.formlogin.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private static final Logger log = Logger.getLogger(LoginController.class.getName());

    private static final int ATTEMPTS_MAX = 3;

    private static int attempts;

    private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnAccedi;

    @FXML
    private Button btnClear;

    @FXML
    private TextArea txtMessage;

    @FXML
    void login(ActionEvent event) {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        txtMessage.setText("");
        String message = model.verifyLogin(username, password);
        txtMessage.appendText(message);

        if ((username.length() > 0) && (!message.equals("credenziali valide"))) {
            attempts += 1;
            if ((ATTEMPTS_MAX - attempts) > 0) {
                txtMessage.appendText("\nAncora " + (ATTEMPTS_MAX - attempts) + " tentativi possibili\n");
                log.debug("numero tentativi effettuati = " + attempts);
            } else {
                btnAccedi.setDisable(true);
                attempts = ATTEMPTS_MAX;
                txtMessage.setText("Login non riuscito. Premere Clear");
            }
        }
    }

    @FXML
    void clear(ActionEvent event) {

        btnAccedi.setDisable(false);
        txtUsername.setText("");
        txtPassword.setText("");
        attempts = 0;
        txtMessage.setText("Sono possibili " + ATTEMPTS_MAX + " tentativi di login");
    }

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'scene.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'scene.fxml'.";
        assert btnAccedi != null : "fx:id=\"btnAccedi\" was not injected: check your FXML file 'scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'scene.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'scene.fxml'.";

        txtMessage.setText("Sono possibili " + ATTEMPTS_MAX + " tentativi di login");
    }

    public void setModel(Model model) {

        this.model = model;
    }

}
