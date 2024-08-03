
package Controller;

import Model.Cliente;
import Model.ClienteRepository;
import Model.Database;
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
    private TextField tfDataNascimento;
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
    private void onClickVoltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scena = new Scene(root);
        stage.setScene(scena);
        stage.show();
    }
    
   
    
    public boolean verificarSenha(String senha, String senhaConfirmacao){
        boolean validador = false;
        if(senha.equals(senhaConfirmacao)){
            validador = true;
        }
        return validador;
    }
    
    public List<String> listCliente(Cliente cliente){
        List<String> list = new ArrayList<>();
        list.add(cliente.getNome());
        list.add(cliente.getCpf());
        list.add(cliente.getDataNascimento());
        list.add(cliente.getEmail());
        list.add(cliente.getCep());
        list.add(cliente.getCidade());
        list.add(cliente.getTelefone());
        list.add(cliente.getSenha());
        list.add(cliente.getEndereco());
        return list;
    }
            
    public boolean stringVazia(String s){
        boolean validador = false;
        if(s.trim().isEmpty()){
            validador = true;
        }
        return validador;
    }
    
    public boolean existeVazio(Cliente cliente){
        boolean validador = false;
        List<String> list = listCliente(cliente);
        for(String x : list){
            if(stringVazia(x)){
                validador = true;
                break;
            }
        }
        return validador;
    }
    
    public void onClickRegistrar(ActionEvent event){
        try{
            String nome = tfNome.getText();
            String cpf = tfCpf.getText();
            String dataNascimento = tfDataNascimento.getText();
            String email = tfEmail.getText();
            String cep = tfCep.getText();
            String cidade = tfCidade.getText();
            String telefone = tfTelefone.getText();
            String senha = tfSenha.getText();
            String endereco = tfEndereco.getText();
            String senhaConfirmacao = tfSenhaConfirmacao.getText();
            
            Cliente cliente = new Cliente(nome, dataNascimento, email, telefone, endereco, cpf, cep, cidade, senha);
            
            if(existeVazio(cliente)){
                labelMensagem.setText("Dados inválidos! Tente novamente.");
            }
            else if(!verificarSenha(senha, senhaConfirmacao)){
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
    
    
   
    
}