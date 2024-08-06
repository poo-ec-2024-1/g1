
package Controller.cliente;

import Util.*;
import Model.model.Cliente;
import Model.repository.ClienteRepository;
import Model.repository.Database;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * TelaPerfil Controller Class
 */
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
    private DatePicker dateData;
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
    public Database database;
    public ClienteRepository clienteRP;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idSelecionado = TelaLoginClienteController.idSelecionado;
        database = Util.openDatabase("clientesDatabase");
        clienteRP = new ClienteRepository(database);
        cliente = clienteRP.loadFromId(idSelecionado);
        atualizarCampos();
    }
    /**
     * Sai da tela de perfil do cliente para a tela de menu do cliente
     * @param event event
     * @throws IOException e
     */
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaMenuPrinc.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Atualiza os dados do cliente para os campos correspondentes
     */
    public void atualizarCampos(){
        tfNome.setText(cliente.getNome());
        tfCpf.setText(cliente.getCpf());
        dateData.setValue(Util.stringToDate(cliente.getDataNascimento(), "dd/MM/yyyy"));
        tfTelefone.setText(cliente.getTelefone());
        tfCep.setText(cliente.getCep());
        tfEstado.setText(cliente.getEstado());
        tfCidade.setText(cliente.getCidade());
        tfEmail.setText(cliente.getEmail());
    }
    /**
     * Habilita a edição das caixas de texto
     */
    public void onClickEditar(){
        isEdit(true);
    }
    /**
     * Habilita a edição das caixas de texto
     * @param x true para deixar editável, false para o contrário
     */
    public void isEdit(boolean x){
        tfNome.setEditable(x);
        tfCpf.setEditable(x);
        dateData.setMouseTransparent(!x);
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
    /**
     * Salva o cliente do parâmetro no lugar do cliente do banco de dados que possui o mesmo id
     * @param cliente novo cliente para fazer a substituição
     */
    public void salvarCliente(Cliente cliente){
        database = Util.openDatabase("clientesDatabase");
        clienteRP = new ClienteRepository(database);
        clienteRP.update(cliente);
        database.close();
    }
    /**
     * Escaneia o que foi escrito nas caixas de texto e após uma verificação, salva as alterações feitas no cliente referido
     * @param event event
     */
    public void onClickSalvar(ActionEvent event){
        try{
            String nome = tfNome.getText();
            String cpf = tfCpf.getText();
            String dataNascimento = Util.formatData(String.valueOf(dateData.getValue()));
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
            else if(!verificarRegistro(novoCliente)){
                
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
    /**
     * Verifica se os dados do cliente do parâmetro são válidos
     * @param cliente cliente a ser verificado
     * @return true se passar pela verificação, false do contrário
     */
    public boolean verificarRegistro(Cliente cliente){
            if(!Util.verificarCpf(cliente.getCpf())){
                Cliente clienteOld = clienteRP.loadFromId(cliente.getId());
                if(!clienteOld.getCpf().equals(cliente.getCpf())){
                    labelMensagem.setText("CPF inválido ou já existente!"); return false;
                }
            }
            if(!Util.verificarEmail(cliente.getEmail())){
                Cliente clienteOld = clienteRP.loadFromId(cliente.getId());
                if(!clienteOld.getEmail().equals(cliente.getEmail())){
                    labelMensagem.setText("Email já existente!"); return false;
                }
            }
            if(!Util.verificarTelefone(cliente.getTelefone())){
                labelMensagem.setText("Telefone inválido!"); return false;
            }
            if(!Util.verificarCep(cliente.getCep())){
                labelMensagem.setText("CEP inválido!"); return false;
            }
            if(!Util.verificarSenha(cliente.getSenha())){
                labelMensagem.setText("A senha precisa ter no mínimo 8 caractéres!"); return false;
            }
            return true;
    }
}