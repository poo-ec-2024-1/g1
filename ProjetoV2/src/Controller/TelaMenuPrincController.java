
package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TelaMenuPrincController{

    @FXML
    private Button BotaoEntrar1;
    @FXML
    private Button BotaoEntrar2;
    @FXML
    private Button BotaoEntrar3;
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private ImageView Logout;
    @FXML
    private Button BotaoEntrar11;
    @FXML
    private Button BotaoPerfil;
    @FXML
    private Button BotaoLogout;
    

    @FXML
    public void onClickLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void onClickPerfil(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaPerfil.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickEntrar(ActionEvent event) {
    }
    

}


