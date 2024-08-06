
package Controller.empresa;


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
/**
 * TelaRegistroEmpresa Controller Class
 */
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
    /**
     * Sai da tela de registro da empresa para a tela de login da empresa
     * @param event e
     * @throws IOException e
     */
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/TelaLoginEmpresa.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    /**
     * Após uma verificação, registra a empresa informada
     * @param event e
     */
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
            String senha = tfSenha.getText();
            String confirmacaoSenha = tfConfirmacaoSenha.getText();
            
            Empresa empresa = new Empresa(nome, cnpj, cep, telefone, descricao, email, cidade, estado, senha);
            List<String> list = listEmpresa(empresa);
            if(Util.existeVazio(list)){
                labelMensagem.setText("Dados inválidos! Tente novamente.");
            }
            else if(!verificarRegistro(empresa)){
            }
            else if(!Util.verificarIgualdade(senha, confirmacaoSenha)){
                labelMensagem.setText("As senhas não conferem! Tente novamente.");
            }
            else{
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
        if(!Util.verificarSenha(empresa.getSenha())){
            labelMensagem.setText("A senha precisa ter, no mínimo, 8 caractéres!"); return false;
        }
        if(Util.existeCnpj(empresa.getCnpj())){
            labelMensagem.setText("CNPJ já está em uso!"); return false;
        }
        if(!Util.verificarEmail(empresa.getEmail())){
            labelMensagem.setText("Email já está em uso!"); return false;
        }
        return true;
    }
}
