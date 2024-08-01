
package Controller;


import Model.repository.EmpresaRepository;
import Model.repository.Database;
import Model.model.Empresa;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class TelaRegistroEmpresaController {
    
    @FXML
    private Button BotaoRegistrarEmpresa;
    @FXML
    private Button BotaoVoltar;
    @FXML
    private TextField tfCep;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfCnpj;
    @FXML
    private PasswordField tfConfirmacaoSenha;
    @FXML
    private TextArea tfDescricao;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfEndereco;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfNome;
    @FXML
    private PasswordField tfSenha;
    @FXML
    private TextField tfTelefone;
    @FXML
    private Label labelMensagem;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/TelaLoginEmpresa.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public List<String> listEmpresa(Empresa empresa){
        List<String> list = new ArrayList<>();
        list.add(empresa.getNome());
        list.add(empresa.getCnpj());
        list.add(empresa.getCep());
        list.add(empresa.getTelefone());
        list.add(empresa.getDescricao());
        list.add(empresa.getEmail());
        list.add(empresa.getCidade());
        list.add(empresa.getEstado());
        list.add(empresa.getSenha());
        return list;
    }
    
    public void onClickRegistrar(ActionEvent event){
        try{
            String nome = tfNome.getText();
            String cnpj = tfCnpj.getText();
            String descricao = tfDescricao.getText();
            String email = tfEmail.getText();
            String cep = tfCep.getText();
            String cidade = tfCidade.getText();
            String telefone = tfTelefone.getText();
            String estado = tfEstado.getText();
            String endereco = tfEndereco.getText();
            String senha = tfSenha.getText();
            String confirmacaoSenha = tfConfirmacaoSenha.getText();
            
            Empresa empresa = new Empresa(nome, cnpj, cep, telefone, descricao, email, cidade, estado, endereco, senha);
            List<String> list = listEmpresa(empresa);
            if(Util.existeVazio(list)){
                labelMensagem.setText("Dados inválidos! Tente novamente.");
            }
            else if(!Util.verificarIgualdade(senha, confirmacaoSenha)){
                labelMensagem.setText("As senhas não conferem! Tente novamente.");
            }
            else{
                System.out.println("aaa");
                Database database = new Database("empresasDatabase");
                database.getConnection();
                EmpresaRepository empresaRP = new EmpresaRepository(database);
                empresaRP.create(empresa);
                database.close();
                Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/TelaLoginEmpresa.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch(Exception e){
            labelMensagem.setText("Não foi posível realizar o cadastro. Tente novamente");
        }
    }
}
