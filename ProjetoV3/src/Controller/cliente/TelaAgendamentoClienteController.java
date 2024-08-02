
package Controller.cliente;

import Model.model.Empresa;
import Model.repository.Database;
import Model.repository.EmpresaRepository;
import Util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaAgendamentoClienteController implements Initializable{
    @FXML
    private Button BotaoAgendar;
    @FXML
    private Button BotaoVoltar;
    @FXML
    private ComboBox<Empresa> boxEmpresa;
    @FXML
    private ChoiceBox<?> boxFormaPagamento;
    @FXML
    private ChoiceBox<?> boxHora;
    @FXML
    private ChoiceBox<?> boxServico;
    @FXML
    private DatePicker dateData;
    @FXML
    private TextField tfEndereco;
    @FXML
    private TextField tfModeloVeiculo;
    @FXML
    private TextField tfPlaca;
    
    private Scene scene;
    private Parent root;
    private Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Database database = Util.openDatabase("empresasDatabase");
        EmpresaRepository empresaRP = new EmpresaRepository(database);
        ObservableList<Empresa> empresas = FXCollections.observableArrayList(empresaRP.loadAll());
        boxEmpresa.setItems(empresas);
    }
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaMenuPrinc.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
