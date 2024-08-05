
package Controller.cliente;

import Model.model.Cliente;
import Model.repository.ClienteRepository;
import Model.repository.Database;
import Util.Util;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class TelaRegistrarClienteController  {

    @FXML
    private Button BotaoEntrar;
    @FXML
    private Button BotaoRegistrar;
    @FXML
    private TextField tfCep;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfCpf;
    @FXML
    private DatePicker dateData;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfEndereco;
    @FXML
    private TextField tfNome;
    @FXML
    private PasswordField tfSenha;
    @FXML
    private PasswordField tfSenhaConfirmacao;
    @FXML
    private TextField tfTelefone;
    @FXML
    private Label labelMensagem;
    
    private Parent root;
    private Scene scena;
    private Stage stage;
    

    @FXML
    public void onClickVoltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scena = new Scene(root);
        stage.setScene(scena);
        stage.show();
    }

    public void onClickRegistrar(ActionEvent event){
        try{
            String nome = tfNome.getText();
            String cpf = tfCpf.getText();
            String dataNascimento = Util.formatData(String.valueOf(dateData.getValue()));
            String email = tfEmail.getText();
            String cep = tfCep.getText();
            String cidade = tfCidade.getText();
            String telefone = tfTelefone.getText();
            String senha = tfSenha.getText();
            String endereco = tfEndereco.getText();
            String senhaConfirmacao = tfSenhaConfirmacao.getText();
            Cliente cliente = new Cliente(nome, dataNascimento, email, telefone, endereco, cpf, cep, cidade, senha);
            
            if(Util.existeVazio(Util.listCliente(cliente))){
                labelMensagem.setText("Preencha todos os dados!");
            }
       //     Essa é a parte que verifica o registro do cliente. Deixei comentada para fins desenvolvedorísticos.
    //        else if(!verificarRegistro(cliente)){
    //        }
            else if(!Util.verificarIgualdade(senha, senhaConfirmacao)){
                labelMensagem.setText("As senhas não conferem! Tente novamente.");
            }
            else{
                Database database = new Database("clientesDatabase");
                database.getConnection();
                ClienteRepository clienteRP = new ClienteRepository(database);
                clienteRP.create(cliente);
                database.close();
                Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginCliente.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scena = new Scene(root);
                stage.setScene(scena);
                stage.show();
   
             
            }
        } catch(Exception e){
            labelMensagem.setText("Não foi posível realizar o cadastro. Tente novamente");
        }
    }
    
    public boolean verificarRegistro(Cliente cliente){
            if(Util.verificarCpf(cliente.getCpf())){
                labelMensagem.setText("CPF inválido ou já existente!"); return false;
            }
            else if(Util.verificarEmail(cliente.getEmail())){
                labelMensagem.setText("Email já está em uso!"); return false;
            }
            else if(Util.verificarTelefone(cliente.getTelefone())){
                labelMensagem.setText("Telefone inválido!"); return false;
            }
            else if(Util.verificarCep(cliente.getCep())){
                labelMensagem.setText("CEP inválido!"); return false;
            }
            else if(Util.verificarSenha(cliente.getSenha())){
                labelMensagem.setText("A senha precisa ter no mínimo 8 caractéres!"); return false;
            }
            return true;
    }
}
