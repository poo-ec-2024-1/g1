
package Controller.empresa;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


public class RegistrarServicoController {
    
    
    private Stage stage;
    private Parent root;
    private Scene scene;
    
    
    @FXML
    private PasswordField tfNome;
    @FXML
    private PasswordField tfValor;
    @FXML
    private PasswordField tfDescricao;
    @FXML
    private Button BotaoVoltar;
    @FXML
    private Button BotaoSalvar;

    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/EmpresaMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
      
    
}
