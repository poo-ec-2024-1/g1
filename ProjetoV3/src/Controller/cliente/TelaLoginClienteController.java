package Controller.cliente;

import Model.model.Cliente;
import Model.repository.ClienteRepository;
import Model.repository.Database;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TelaLoginClienteController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button BotaoEntrar;
    @FXML
    private Button BotaoRegistrar;
    @FXML
    private Label labelMensagem;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfSenha;
    @FXML
    private Button BotaoLadoEmpresa;
    @FXML
    private Label labelRegistro;
    
    public static int idSelecionado = 0;
    
    
    
    
    
    
    @FXML
    public void switchToMenu(ActionEvent event) throws IOException{
        if(verificarLogin()){
            Parent root = FXMLLoader.load(getClass().getResource("/View/TelaMenuPrinc.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    @FXML
    public void switchToRegistro(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaRegistrarCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToEmpresaSide(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/TelaLoginEmpresa.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public boolean verificarLogin(){
        boolean validador = false;
        try{
            String email = tfEmail.getText();
            String senha = tfSenha.getText();
            Database database = new Database("clientesDatabase");
            database.getConnection();
            ClienteRepository clienteRP = new ClienteRepository(database);
            int id = clienteRP.autenticarCliente(email, senha);
            if(id == 0){
                labelMensagem.setText("Email ou senha incorretos! Tente novamente");
                this.tfEmail.setText("");
                this.tfSenha.setText((""));
            }
            else{
                validador = true;
                idSelecionado = id;
            }
       } catch(Exception e){
            labelMensagem.setText("Não foi possível fazer login. Tente novamente!");
        }
        return validador;
    }
}