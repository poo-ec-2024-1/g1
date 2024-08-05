
package View;

import Model.model.Servico;
import Model.repository.Database;
import Model.repository.ServicoRepository;
import Util.Util;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TelaLoginCliente.fxml"));
            Scene scene = new Scene(root);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Car Wash");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
