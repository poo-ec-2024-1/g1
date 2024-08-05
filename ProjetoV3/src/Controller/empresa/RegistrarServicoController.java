
package Controller.empresa;

import Model.model.Servico;
import Model.repository.Database;
import Model.repository.ServicoRepository;
import Util.Util;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegistrarServicoController implements Initializable{
    
    
    private Stage stage;
    private Parent root;
    private Scene scene;
    
    
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfPreco;
    @FXML
    private TextArea tfDescricao;
    @FXML
    private Button BotaoVoltar;
    @FXML
    private Button BotaoSalvar;
    @FXML
    private Label labelMensagem;

    Database database;
    ServicoRepository servicoRP;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database = Util.openDatabase("servicosDatabase");
        servicoRP = new ServicoRepository(database);
    }
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/EmpresaMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void onClickSalvar(ActionEvent event) {
        try{

            String nome = tfNome.getText();
            String preco = tfPreco.getText();
            String descricao = tfDescricao.getText();
            int idEmp = TelaLoginEmpresaController.idSelecionado;
            Servico servicoAtual = new Servico(nome, descricao, Float.parseFloat(preco), idEmp);
            
            if(Util.stringVazia(nome) || Util.stringVazia(preco) || Util.stringVazia(descricao) || servicoAtual.getPreco() <=0){
                labelMensagem.setText("Dados inválidos! Tente novamente.");
            }
            else{
                servicoRP.create(servicoAtual);
                clear();
                labelMensagem.setText("Serviço Cadastrado com Sucesso!");
            }
        } catch(Exception e){
            labelMensagem.setText("Dados inválidos! Tente novamente.");
        }
    }
    
    public void clear(){
        tfNome.setText("");
        tfPreco.setText("");
        tfDescricao.setText("");
    }
    
}
