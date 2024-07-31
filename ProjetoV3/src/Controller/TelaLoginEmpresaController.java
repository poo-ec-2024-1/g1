
package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TelaLoginEmpresaController {

    private Stage stage;
    private Parent root;
    private Scene scene;
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickRegistrar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/TelaRegistroEmpresa.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
