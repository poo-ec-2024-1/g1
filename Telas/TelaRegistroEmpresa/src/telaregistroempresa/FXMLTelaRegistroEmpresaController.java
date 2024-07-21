package telaregistroempresa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXMLTelaRegistroEmpresa Controller class
 *
 * @author Matheus Teixeira Pires
 */
public class FXMLTelaRegistroEmpresaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button buttonRegistrar;
    @FXML
    private TextField fieldCep;
    @FXML
    private TextField fieldCidade;
    @FXML
    private TextField fieldCnpj;
    @FXML
    private TextField fieldEmail;
    @FXML
    private TextField fieldEndereco;
    @FXML
    private TextField fieldEstado;
    @FXML
    private TextField fieldNome;
    @FXML
    private TextField fieldTelefone;
    @FXML
    private Label labelMensagem;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public RegistroEmpresa buttonRegistrarClicked(){
        RegistroEmpresa rgEmp = new RegistroEmpresa();
        try{
            rgEmp.setNome(String.valueOf(fieldNome.getText()));
            rgEmp.setCnpj(String.valueOf(fieldCnpj.getText()));
            rgEmp.setTelefone(String.valueOf(fieldTelefone.getText()));
            rgEmp.setEmail(String.valueOf(fieldEmail.getText()));
            rgEmp.setCep(String.valueOf(fieldCep.getText()));
            rgEmp.setEndereco(String.valueOf(fieldEndereco.getText()));
            rgEmp.setCidade(String.valueOf(fieldCidade.getText()));
            rgEmp.setEstado(String.valueOf(fieldEstado.getText()));
            labelMensagem.setText("Empresa Registrada Com Sucesso!");
        } catch (Exception e){
            labelMensagem.setText("Dados Inválidos! Tente Novamente.");
        }
        /* Teste
        System.out.println("Nome: " + rgEmp.getNome());
        System.out.println("CNPJ: " + rgEmp.getCnpj());
        System.out.println("Telefone: " + rgEmp.getTelefone());
        System.out.println("Email: " + rgEmp.getEmail());
        System.out.println("CEP: " + rgEmp.getCep());
        System.out.println("Endereco: " + rgEmp.getEndereco());
        System.out.println("Cidade: " + rgEmp.getCidade());
        System.out.println("Estado: " + rgEmp.getEstado());
        */
        return rgEmp;
    }
}
