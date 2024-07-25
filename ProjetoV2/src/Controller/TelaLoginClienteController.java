package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaLoginClienteController {
    private Stage stage;
    @FXML
    private Button BotaoEntrar;
    
    @FXML
    public void onClickEntrar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaMenuPrinc.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
