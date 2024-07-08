package telalogin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *  FXMLTelaLogin Controller Class
 * 
 * @author matheus teixeira pires
 */
public class FXMLTelaLoginController implements Initializable {
    
    @FXML
    private Label testeSenha;
    @FXML
    private Label testeUsuario;
    @FXML
    private Button buttonEntrar;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private PasswordField textfieldSenha;
    @FXML
    private TextField textfieldUsuario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private Usuario usuario = new Usuario("","");
    
    /**
     * Lê o usuário e a senha que estão digitados nos campos de texto, e os atribui ao objeto "usuario".
     */
    public void buttonEntrarClicked(){
        usuario.setUsuario(String.valueOf(textfieldUsuario.getText()));
        usuario.setSenha(String.valueOf(textfieldSenha.getText()));
        
        //Teste
        testeUsuario.setText(textfieldUsuario.getText());
        testeSenha.setText(textfieldSenha.getText());
    }
}
