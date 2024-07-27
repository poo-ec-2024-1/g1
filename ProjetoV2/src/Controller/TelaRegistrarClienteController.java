
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


public class TelaRegistrarClienteController  {

    @FXML
    private Button BotaoEntrar;
    @FXML
    private Button BotaoEntrar1;
    private Parent root;
    private Scene scena;
    private Stage stage;

    @FXML
    private void onClickVoltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scena = new Scene(root);
        stage.setScene(scena);
        stage.show();
    }
    
    

   
}
