
package Controller.empresa;

import static Controller.empresa.EmpresaMenuController.idSelecionado;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class PerfilEmpresaController implements Initializable {

    @FXML
    private TextField tfTelefone;
    @FXML
    private Button BotaoSalvar;
    @FXML
    private Button BotaoVoltar;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfCep;
    @FXML
    private TextField tfCNPJ;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfDescricao;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idSelecionado = TelaLoginEmpresaController.idSelecionado;
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        tfNome.setPromptText(empresaRP.loadFromId(idSelecionado).getNome());
        tfCep.setPromptText(empresaRP.loadFromId(idSelecionado).getCep());
        tfCNPJ.setPromptText(empresaRP.loadFromId(idSelecionado).getCnpj());
        tfEmail.setPromptText(empresaRP.loadFromId(idSelecionado).getEmail());
        tfCidade.setPromptText(empresaRP.loadFromId(idSelecionado).getCidade());
        tfEstado.setPromptText(empresaRP.loadFromId(idSelecionado).getEstado());
        tfDescricao.setPromptText(empresaRP.loadFromId(idSelecionado).getDescricao());
        
        database.close();
    }
    
    public void onClckVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/EmpresaMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
