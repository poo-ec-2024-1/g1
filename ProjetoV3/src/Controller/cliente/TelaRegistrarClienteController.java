
package Controller.cliente;

import Model.model.Cliente;
import Model.repository.ClienteRepository;
import Model.repository.Database;
import Util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

/**
 * TelaRegistrarCliente Controller Class
 */
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
    
    /**
     * Sai da tela de registrar cliente para a tela de login do cliente
     * @param event   event
     * @throws IOException  e 
     */
    @FXML
    public void onClickVoltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scena = new Scene(root);
        stage.setScene(scena);
        stage.show();
    }
    /**
     * Escaneia os dados escritos e, após uma verificação, salva o cliente no banco de dados
     * @param event  event
     */
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
                labelMensagem.setText("Dados inválidos! Tente novamente.");
            }
            else if(!verificarRegistro(cliente)){
            }
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
    /**
     * Verifica se os dados do cliente do parâmetro são válidos
     * @param cliente cliente a ser verificado
     * @return true se passar pela verificação, false do contrário
     */
    public boolean verificarRegistro(Cliente cliente){
            if(!Util.verificarCpf(cliente.getCpf())){
                labelMensagem.setText("CPF inválido ou já existente!"); return false;
            }
            else if(!Util.verificarEmail(cliente.getEmail())){
                labelMensagem.setText("Email já existente!"); return false;
            }
            else if(!Util.verificarTelefone(cliente.getTelefone())){
                labelMensagem.setText("Telefone inválido!"); return false;
            }
            else if(!Util.verificarCep(cliente.getCep())){
                labelMensagem.setText("CEP inválido!"); return false;
            }
            else if(!Util.verificarSenha(cliente.getSenha())){
                labelMensagem.setText("A senha precisa ter no mínimo 8 caractéres!"); return false;
            }
            return true;
    }
}
