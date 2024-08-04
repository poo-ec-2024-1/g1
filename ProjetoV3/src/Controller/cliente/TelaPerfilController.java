
package Controller.cliente;

import Util.*;
import Model.model.Cliente;
import Model.repository.ClienteRepository;
import Model.repository.Database;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class TelaPerfilController implements Initializable{
    
    @FXML
    private Button buttonSalvar;
    @FXML
    private Label labelConfirmarSenha;
    @FXML
    private Label labelMensagem;
    @FXML
    private Label labelNovaSenha;
    @FXML
    private TextField tfCep;
    @FXML
    private TextField tfCidade;
    @FXML
    private PasswordField tfConfirmarSenha;
    @FXML
    private TextField tfCpf;
    @FXML
    private TextField tfDataNascimento;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfNome;
    @FXML
    private PasswordField tfNovaSenha;
    @FXML
    private PasswordField tfSenha;
    @FXML
    private TextField tfTelefone;
    @FXML
    private Label labelSenhaAtual;
    
    private Scene scene;
    private Parent root;
    private Stage stage;
    
    public static int idSelecionado = 0;
    
    public static Cliente cliente;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idSelecionado = TelaLoginClienteController.idSelecionado;
        Database database = Util.openDatabase("clientesDatabase");
        ClienteRepository clienteRP = new ClienteRepository(database);
        cliente = clienteRP.loadFromId(idSelecionado);
        atualizarCampos();
    }
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaMenuPrinc.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void atualizarCampos(){
        tfNome.setText(cliente.getNome());
        tfCpf.setText(cliente.getCpf());
        tfDataNascimento.setText(cliente.getDataNascimento());
        tfTelefone.setText(cliente.getTelefone());
        tfCep.setText(cliente.getCep());
        tfEstado.setText(cliente.getEstado());
        tfCidade.setText(cliente.getCidade());
        tfEmail.setText(cliente.getEmail());
    }

    public void onClickEditar(){
        isEdit(true);
    }
    
    public void isEdit(boolean x){
        tfNome.setEditable(x);
        tfCpf.setEditable(x);
        tfDataNascimento.setEditable(x);
        tfTelefone.setEditable(x);
        tfCep.setEditable(x);
        tfEstado.setEditable(x);
        tfCidade.setEditable(x);
        tfEmail.setEditable(x);
        tfSenha.setEditable(x);
        tfSenha.setVisible(x);
        tfNovaSenha.setVisible(x);
        tfConfirmarSenha.setVisible(x);
        
        labelSenhaAtual.setVisible(x);
        labelNovaSenha.setVisible(x);
        labelConfirmarSenha.setVisible(x);
        
        buttonSalvar.setDisable(!x);
        
        tfSenha.setText("");
        tfNovaSenha.setText("");
        tfConfirmarSenha.setText("");
    }
    
    public void salvarCliente(Cliente cliente){
        Database database = Util.openDatabase("clientesDatabase");
        ClienteRepository clienteRP = new ClienteRepository(database);
        clienteRP.update(cliente);
        database.close();
    }
    
    public void onClickSalvar(ActionEvent event){
        try{
            String nome = tfNome.getText();
            String cpf = tfCpf.getText();
            String dataNascimento = tfDataNascimento.getText();
            String email = tfEmail.getText();
            String cep = tfCep.getText();
            String cidade = tfCidade.getText();
            String telefone = tfTelefone.getText();
            String senhaAtual = tfSenha.getText();
            String estado = tfEstado.getText();
            String novaSenha = tfNovaSenha.getText();
            String senhaConfirmacao = tfConfirmarSenha.getText();
            
            Cliente novoCliente = new Cliente(nome, dataNascimento, email, telefone, estado, cpf, cep, cidade, senhaAtual);
            novoCliente.setId(idSelecionado);
            List<String> list = Util.listCliente(novoCliente);
            
            if(Util.existeVazio(list)){
                labelMensagem.setText("Dados inválidos! Tente novamente.");
            }
            else if(!cliente.getSenha().equals(senhaAtual)){
                labelMensagem.setText("Senha atual incorreta!");
            }
            else if(!Util.stringVazia(novaSenha) || !Util.stringVazia(senhaConfirmacao)){
                if(!novaSenha.equals(senhaConfirmacao)){
                    labelMensagem.setText("As senhas não conferem! Tente novamente.");
                }
                else{
                    novoCliente.setSenha(novaSenha);
                    salvarCliente(novoCliente);
                    cliente = novoCliente;
                    labelMensagem.setText("Dados salvos com sucesso!");
                    isEdit(false);
                }
            }
            else{
                salvarCliente(novoCliente);
                cliente = novoCliente;
                labelMensagem.setText("Dados salvos com sucesso!");
                isEdit(false);
            }
        } catch(Exception e){
            labelMensagem.setText("Não foi possivel realizar a edição!");
        }
    }
}