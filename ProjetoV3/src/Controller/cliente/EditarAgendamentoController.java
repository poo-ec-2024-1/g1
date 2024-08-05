
package Controller.cliente;

import Model.model.Agendamento;
import Model.repository.AgendamentoRepository;
import Model.repository.Database;
import Util.AgendamentoExibivel;
import static Util.ExibirAgendamento.getAgendamentoExibivel;
import Util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class EditarAgendamentoController implements Initializable {

    @FXML
    private TableColumn<AgendamentoExibivel, String> colId;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colServico;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colEmpresa;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colPreco;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colVeiculo;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colData;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colHora;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colEndereco;
    @FXML
    private DatePicker dateData;
    @FXML
    private ComboBox<?> boxEmpresa;
    @FXML
    private ComboBox<?> boxServico;
    @FXML
    private Button botaoVoltar;
    @FXML
    private Button botaoCancelar;
    @FXML
    private Button botaoEditar;
    @FXML
    private Button botaoSalvar;
    @FXML
    private TableView<AgendamentoExibivel> tabel;
    @FXML
    private TextField tfEndereço;
    @FXML
    private ComboBox<?> boxHora;
    
    ObservableList<AgendamentoExibivel> agends;
    
    private Stage stage;
    
    private Scene scene;
    
    private Parent root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agends = FXCollections.observableArrayList();
        Database database = Util.openDatabase("agendamentosDatabase");
        AgendamentoRepository agendamentoRP = new AgendamentoRepository(database);
        List<Agendamento> agendamentos = agendamentoRP.loadAll();
        for(Agendamento x : agendamentos){
            if(x.getCliente() == TelaLoginClienteController.idSelecionado){
                agends.add(getAgendamentoExibivel(x, "empresa"));
            }
        }
        carregarDados();
    }    

    public void carregarDados(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colServico.setCellValueFactory(new PropertyValueFactory<>("servico"));
        colEmpresa.setCellValueFactory(new PropertyValueFactory<>("entidade"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colVeiculo.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        
        tabel.setItems(agends);
    }
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaVerAgendamentosCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
