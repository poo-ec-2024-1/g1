/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ContatoViewController  {

    @FXML
    private Button btnOneStar;
    @FXML
    private Button btnTwoStar;
    @FXML
    private Button btnTreeStar;
    @FXML
    private Button btnFourStar;
    @FXML
    private Button btnFiveStar;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField tfDescricao;
    @FXML
    private Button BotaoVoltar;
    @FXML
    private Button BotaoEnviar;

    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaMenuPrinc.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
