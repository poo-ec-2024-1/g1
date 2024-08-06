
package Controller.cliente;

import Model.repository.ClienteRepository;
import Model.repository.Database;
import Util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * TelaMenuPrinc Controller Class
 * @author mathe
 */
public class TelaMenuPrincController implements Initializable{
    
    
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private ImageView Logout;
    @FXML
    private Button BotaoPerfil;
    @FXML
    private Button BotaoLogout;
    @FXML
    private Label labelNome;
    @FXML
    private Button BotaoAgendar;
    @FXML
    private Button BotaoVerAgendamentos;
    @FXML
    private Button BotaoConfig;
    @FXML
    private Button BotaoContato;
    
    public static int idSelecionado = 0;
   
    @FXML
    private Label labelClock;
    
   //Var's para trabalhar com datas e horas;
    Calendar calendar;
    SimpleDateFormat timeFormat;
    String time ;
    @FXML
    private Label labelCPF;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idSelecionado = TelaLoginClienteController.idSelecionado;
        Database database = Util.openDatabase("clientesDatabase");
        ClienteRepository clienteRP = new ClienteRepository(database);
        labelNome.setText(clienteRP.loadFromId(idSelecionado).getNome());
        labelCPF.setText("CPF: " + clienteRP.loadFromId(idSelecionado).getCpf());
        database.close();
        timeFormat = new SimpleDateFormat("dd/MM/YY E");
        time = timeFormat.format(Calendar.getInstance().getTime());
        labelClock.setText(time);
        
    
    }
    /**
     * Sai da tela de menu do cliente para a tela de login do cliente
     * @param event event
     * @throws IOException e
     */
    @FXML
    public void onClickLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Sai da tela de menu do clente para a tela de editar perfil do cliente
     * @param e event
     * @throws IOException e
     */
    @FXML
    public void onClickPerfil(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaPerfil.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Sai da tela de menu do clente para a tela de fazer agendamento do cliente
     * @param e event
     * @throws IOException e
     */
    @FXML
    public void onClickAgendar(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaAgendamentoCliente.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Sai da tela de menu do clente para a tela de ver agendamentos do cliente
     * @param event event
     * @throws IOException e
     */
    @FXML
    public void onClickAgendamentos(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaVerAgendamentosCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Sai da tela de menu do clente para a tela de contate-nos
     * @param event event
     * @throws IOException e
     */
    public void onClickContato(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ContatoView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


