package telalogin;

/**
 *  FXMLTelaLogin Model Class
 * 
 * @author matheus teixeira pires
 */
public class Usuario {
    private String usuario, senha;

    public Usuario() {
    }
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}