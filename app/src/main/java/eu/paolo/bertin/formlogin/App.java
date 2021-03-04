/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package eu.paolo.bertin.formlogin;

import eu.paolo.bertin.formlogin.controller.LoginController;
import eu.paolo.bertin.formlogin.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class App extends Application {

    private static final Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        log.info("avviata App");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/scene.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        LoginController loginController = fxmlLoader.getController();

        Model model = new Model();
        loginController.setModel(model);

        scene.getStylesheets()
             .add("/styles/style.css");

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}