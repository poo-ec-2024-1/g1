
package Controller.cliente;

import Model.model.Agendamento;
import Model.repository.AgendamentoRepository;
import Model.repository.Database;
import Util.*;
import static Util.ExibirAgendamento.getAgendamentoExibivel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * TelaVerAgendamentos Controller Class
 */
public class TelaVerAgendamentos implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button BotaoVoltar;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colData;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colEmpresa;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colEndereco;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colHora;
    @FXML
    private TableColumn<AgendamentoExibivel, Integer> colId;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colPreco;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colServico;
    @FXML
    private TableColumn<AgendamentoExibivel, String> colVeiculo;
    @FXML
    private TableView<AgendamentoExibivel> tabel;
    
    ObservableList<AgendamentoExibivel> agends;
    
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
    /**
     * Sai da tela de ver agendamentos do cliente para o menu principal do cliente
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
     * Carrega os agendamentos já feitos pelo cliente
     */
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
    /**
     * Sai da tela de ver agendamentos do cliente para a tela de editar agendamentos do cliente
     * @param event event
     * @throws IOException e
     */
    public void onClickEditar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/EditarAgendamento.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
