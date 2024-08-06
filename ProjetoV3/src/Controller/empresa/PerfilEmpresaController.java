
package Controller.empresa;

import static Controller.empresa.EmpresaMenuController.idSelecionado;
import Model.model.Empresa;
import Model.repository.Database;
import Model.repository.EmpresaRepository;
import Util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * PerfilEmpresa Controller Class
 */
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
    private PasswordField tfConfirmarNovaSenha;
    @FXML
    private TextArea tfDescricao;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfNome;
    @FXML
    private PasswordField tfNovaSenha;
    @FXML
    private PasswordField tfSenhaAtual;
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
    public Database database;
    public EmpresaRepository empresaRP;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idSelecionado = TelaLoginEmpresaController.idSelecionado;
        database = Util.openDatabase("empresasDatabase");
        empresaRP = new EmpresaRepository(database);
        empresaSelecionada = empresaRP.loadFromId(idSelecionado);
        database.close();
        atualizarCampos();
        
    }
    /**
     * Sai da tela de editar perfil da empres para o menu da empresa
     * @param event e
     * @throws IOException  e
     */
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/EmpresaMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Habilita a edição dos campos de texto
     */
    public void onClickEditarPerfil(){
        isEdit(true);
    }
    /**
     * Habilita a edição dos campos de texto
     */
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
        
        List<String> list = listEmpresa(empresa);
        if(Util.existeVazio(list)){
            labelMensagem.setText("Dados inválidos! Tente novamente.");
            }
        if(!verificarRegistro(empresa)){
            
        }
        else if(!empresa.getSenha().equals(empresaSelecionada.getSenha())){
            labelMensagem.setText("Senha atual incorreta! Tente novamente.");
        }
        else if(!Util.stringVazia(novaSenha) || !Util.stringVazia(confirmarNovaSenha)){
            if(!novaSenha.equals(confirmarNovaSenha)){
                labelMensagem.setText("As senhas não conferem! Tente Novamente.");
            }
            else if(!Util.verificarSenha(novaSenha)){
                labelMensagem.setText("A nova senha precisa ter no mínimo 8 caractéres!");
            }
            else{
                empresa.setSenha(novaSenha);
                updateEmpresa(empresa);
                labelMensagem.setText("Dados salvos com sucesso!");
                isEdit(false);
                empresaSelecionada = empresa;
            }
        }
        else{
            updateEmpresa(empresa);
            labelMensagem.setText("Dados salvos com sucesso!");
            isEdit(false);
            empresaSelecionada = empresa;
        }
    }
    /**
     * Atualiza os campos para os dados atuais da empresa
     */
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
    /**
     * Define se os campos de texto são editáveis e se alguns são visíveis
     * @param x true para editáveis, false para o contrário
     */
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
    /**
     * Salva a empresa do parâmetro no lugar da empresa do banco de dados com o mesmo ID
     * @param empresa empresa a ser salva
     */
    public void updateEmpresa(Empresa empresa){
        database = Util.openDatabase("empresasDatabase");
        empresaRP = new EmpresaRepository(database);
        empresaRP.update(empresa);
        database.close();
    }
    /**
     * Verifica se os dados passados para registro são válidos
     * @param empresa empresa a ser verificada
     * @return true se passar pela verificação, false do contrário
     */
    public boolean verificarRegistro(Empresa empresa){
        if(!Util.verificarCep(empresa.getCep())){
            labelMensagem.setText("CEP Inválido! Tente novamente."); return false;
        }
        if(!Util.verificarCnpj(empresa.getCnpj())){
            labelMensagem.setText("CNPJ Inválido! Tente noavamente."); return false;
        }
        if(!Util.verificarTelefone(empresa.getTelefone())){
            labelMensagem.setText("Telefone Inválido! Tente noavamente."); return false;
        }
        if(Util.existeCnpj(empresa.getCnpj())){
            Empresa empresaOld = empresaRP.loadFromId(empresa.getId());
            if(!empresaOld.getCnpj().equals(empresa.getCnpj())){
                labelMensagem.setText("CNPJ já está em uso!"); return false;
            }
        }
        if(!Util.verificarEmail(empresa.getEmail())){
            Empresa empresaOld = empresaRP.loadFromId(empresa.getId());
            if(!empresaOld.getEmail().equals(empresa.getEmail())){
                labelMensagem.setText("Email já está em uso!"); return false;
            }
        }
        return true;
    }
    
    /**
     * Cria uma lista com todos os atributos da empresa do parâmetro
     * @param empresa empresa a ser salva na lista
     * @return lista com todos os atributos da empresa
     */
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
}
