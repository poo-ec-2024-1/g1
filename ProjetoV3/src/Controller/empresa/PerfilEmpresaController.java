
package Controller.empresa;

import static Controller.empresa.EmpresaMenuController.idSelecionado;
import Model.model.Empresa;
import Model.repository.Database;
import Model.repository.EmpresaRepository;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class PerfilEmpresaController implements Initializable {

    @FXML
    private Button botaoEditarPerfil;
    @FXML
    private Button botaoSalvar;
    @FXML
    private Button botaoVoltar;
    @FXML
    private TextField tfCep;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfCnpj;
    @FXML
    private TextField tfConfirmarNovaSenha;
    @FXML
    private TextArea tfDescricao;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfNovaSenha;
    @FXML
    private TextField tfSenhaAtual;
    @FXML
    private TextField tfTelefone;
    @FXML
    private Label labelConfirmarNovaSenha;
    @FXML
    private Label labelNovaSenha;
    @FXML
    private Label labelSenhaAtual;
    @FXML
    private Label labelMensagem;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    Empresa empresaSelecionada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idSelecionado = TelaLoginEmpresaController.idSelecionado;
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        empresaSelecionada = empresaRP.loadFromId(idSelecionado);
        database.close();
        atualizarCampos();
        
    }
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/EmpresaMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickEditarPerfil(){
        isEdit(true);
    }
    
    public void onClickSalvar(){
        Empresa empresa = new Empresa();
        empresa.setNome(tfNome.getText());
        empresa.setCnpj(tfCnpj.getText());
        empresa.setDescricao(tfDescricao.getText());
        empresa.setTelefone(tfTelefone.getText());
        empresa.setCep(tfCep.getText());
        empresa.setCidade(tfCidade.getText());
        empresa.setEstado(tfEstado.getText());
        empresa.setEmail(tfEmail.getText());
        empresa.setSenha(tfSenhaAtual.getText());
        
        empresa.setId(TelaLoginEmpresaController.idSelecionado);
        
        String novaSenha = tfNovaSenha.getText();
        String confirmarNovaSenha = tfConfirmarNovaSenha.getText();
        
        if(!empresa.getSenha().equals(empresaSelecionada.getSenha())){
            labelMensagem.setText("Senha atual incorreta! Tente novamente.");
        }
        else if(!Util.stringVazia(novaSenha) || !Util.stringVazia(confirmarNovaSenha)){
            if(!novaSenha.equals(confirmarNovaSenha)){
                labelMensagem.setText("As senhas não conferem! Tente Novamente.");
            }
            else{
                empresa.setSenha(novaSenha);
                updateEmpresa(empresa);
                labelMensagem.setText("Dados salvos com sucesso!");
                isEdit(false);
            }
        }
        else{
            updateEmpresa(empresa);
            labelMensagem.setText("Dados salvos com sucesso!");
            isEdit(false);
        }
    }
    
    public void atualizarCampos(){
        tfNome.setText(empresaSelecionada.getNome());
        tfCnpj.setText(empresaSelecionada.getCnpj());
        tfDescricao.setText(empresaSelecionada.getDescricao());
        tfTelefone.setText(empresaSelecionada.getTelefone());
        tfCep.setText(empresaSelecionada.getCep());
        tfCidade.setText(empresaSelecionada.getCidade());
        tfEstado.setText(empresaSelecionada.getEstado());
        tfEmail.setText(empresaSelecionada.getEmail());
    }
    
    public void isEdit(boolean x){
        tfNome.setEditable(x);
        tfCnpj.setEditable(x);
        tfDescricao.setEditable(x);
        tfTelefone.setEditable(x);
        tfCep.setEditable(x);
        tfCidade.setEditable(x);
        tfEstado.setEditable(x);
        tfEmail.setEditable(x);
        
        tfSenhaAtual.setVisible(x);
        tfNovaSenha.setVisible(x);
        tfConfirmarNovaSenha.setVisible(x);
        
        labelSenhaAtual.setVisible(x);
        labelNovaSenha.setVisible(x);
        labelConfirmarNovaSenha.setVisible(x);
        
        botaoSalvar.setDisable(!x);
        
        tfSenhaAtual.setText("");
        tfNovaSenha.setText("");
        tfConfirmarNovaSenha.setText("");
    }
    
    public void updateEmpresa(Empresa empresa){
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        empresaRP.update(empresa);
        database.close();
    }
}
