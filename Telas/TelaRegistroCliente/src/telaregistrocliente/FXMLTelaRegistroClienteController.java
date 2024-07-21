package telaregistrocliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXMLTelaRegistroCliente Controller class
 *
 * @author Matheus Teixeira Pires
 */
public class FXMLTelaRegistroClienteController implements Initializable {

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
    private TextField fieldCpf;
    @FXML
    private TextField fieldDataNascimento;
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
    
    public RegistroCliente buttonRegistrarClicked(){
        RegistroCliente gcCliente = new RegistroCliente();
        try{
            gcCliente.setNome(String.valueOf(fieldNome.getText()));
            gcCliente.setCpf(String.valueOf(fieldCpf.getText()));
            gcCliente.setDataNascimento(String.valueOf(fieldDataNascimento.getText()));
            gcCliente.setTelefone(String.valueOf(fieldTelefone.getText()));
            gcCliente.setEmail(String.valueOf(fieldEmail.getText()));
            gcCliente.setCep(String.valueOf(fieldCep.getText()));
            gcCliente.setEndereco(String.valueOf(fieldEndereco.getText()));
            gcCliente.setCidade(String.valueOf(fieldCidade.getText()));
            gcCliente.setEstado(String.valueOf(fieldEstado.getText()));
            labelMensagem.setText("Cliente Registrado Com Sucesso!");
        } catch (Exception e){
            labelMensagem.setText("Dados Inválidos! Tente Novamente.");
        }
        /* Teste
        System.out.println("Nome: " + gcCliente.getNome());
        System.out.println("CPF: " + gcCliente.getCpf());
        System.out.println("Data de Nascimento: " + gcCliente.getDataNascimento());
        System.out.println("Telefone: " + gcCliente.getTelefone());
        System.out.println("Email: " + gcCliente.getEmail());
        System.out.println("CEP: " + gcCliente.getCep());
        System.out.println("Endereco: " + gcCliente.getEndereco());
        System.out.println("Cidade: " + gcCliente.getCidade());
        System.out.println("Estado: " + gcCliente.getEstado());
        */
        return gcCliente;
    }
}
