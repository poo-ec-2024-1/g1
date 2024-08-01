
package Controller.empresa;

import Model.repository.EmpresaRepository;
import Model.repository.Database;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class TelaLoginEmpresaController {
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfSenha;
    @FXML
    private Label labelMensagem;
    
    private Stage stage;
    private Parent root;
    private Scene scene;
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaLoginCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickRegistrar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/TelaRegistroEmpresa.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void onClickEntrar(ActionEvent event) throws IOException{
        if(verificarLogin()){
            Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/DashboardEmpresa.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    public boolean verificarLogin(){
        boolean validador = false;
        try{
            String email = tfEmail.getText();
            String senha = tfSenha.getText();
            Database database = new Database("empresasDatabase");
            database.getConnection();
            EmpresaRepository empresaRP = new EmpresaRepository(database);
            if((empresaRP.autenticarEmpresa(email, senha)) == 0){
                labelMensagem.setText("Email ou senha incorretos! Tente novamente");
                this.tfEmail.setText("");
                this.tfSenha.setText((""));
            }
            else{
                validador = true;
            }
       } catch(Exception e){
            labelMensagem.setText("Não foi possível fazer login. Tente novamente!");
        }
        return validador;
    }
}
