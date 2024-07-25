package autenticacaoregistro;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

/**
 *  Repositório para o banco de dados dos clientes
 * 
 * @author Matheus TP
 */

public class ClienteRepository{
    private static Database database;
    private static Dao<Cliente, Integer> dao;
    private List<Cliente> loadedClientes;
    private Cliente loadedCliente; 
    // Construtores
    public ClienteRepository(Database database) {
        ClienteRepository.setDatabase(database);
        loadedClientes = new ArrayList<Cliente>();
    }
    /**
     * Seleciona o banco de dados sobre qual o repositorio vai operar
     * 
     * @param database Banco de dados que deseja atribuir ao repositório 
     */
    public static void setDatabase(Database database) {
        ClienteRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Cliente.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Cliente.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    /**
     *  Adiciona uma nova instância de Cliente ao banco de dados
     * 
     * @param cliente Instância do tipo Cliente
     * @return Retorna o mesmo cliente que foi dado no parâmetro, porém com o seu ID definido
     */
    public Cliente create(Cliente cliente) {
        int nrows = 0;
        try {
            nrows = dao.create(cliente);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedCliente = cliente;
            loadedClientes.add(cliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cliente;
    }    
    /**
     * Atualiza o Cliente existente no banco de dados que possui o mesmo ID que o do parâmetro
     * 
     * @param cliente Instância do tipo Cliente
     */
    public void update(Cliente cliente) {
      try{
          dao.update(cliente);
      }catch (SQLException e){
          System.out.println("Não foi possível executar a atualização.");
      }
    }
    /**
     * Deleta o Cliente existente no banco de dados que possui o mesmo ID que o do parâmetro
     * 
     * @param cliente Instância do tipo Cliente
     */
    public void delete(Cliente cliente) {
      try{
          dao.delete(cliente);
      } catch (SQLException e){
          System.out.println("Não foi possível executar a exclusão.");
      }
    }
    /**
     * Deleta o Cliente existente no banco de dados que possui o ID passado no parâmetro
     * 
     * @param id ID para ser deletado
     */
    public void deleteById(int id){
        try{
            dao.deleteById(id);
        } catch (SQLException e){
            System.out.println("Não foi possível executar a exclusão.");
        }
    }
    /**
     * Carrega o cliente do banco de dados que possui o ID passado no parâmetro
     * 
     * @param id ID para ser carregado
     * @return Retorna esse cliente
     */
    public Cliente loadFromId(int id) {
        try {
            this.loadedCliente = dao.queryForId(id);
            if (this.loadedCliente != null)
                this.loadedClientes.add(this.loadedCliente);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCliente;
    }    
    /**
     * 
     * @return Uma lista com todos os clientes contidos no banco de dados
     */
    public List<Cliente> loadAll() {
        try {
            this.loadedClientes =  dao.queryForAll();
            if (this.loadedClientes.size() != 0)
                this.loadedCliente = this.loadedClientes.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedClientes;
    }
    /**
     * Método responsável por validar se um cliente existe no banco de dados através de seu usuario e senha, e além disso,
     * obtêm o seu id.
     * 
     * @param usuario que deseja autenticar
     * @param senha que deseja autenticar
     * @return retorna o id do cliente se ele existir no banco de dados. Do contrário, retorna 0;
     */
    public int autenticarCliente(String usuario, String senha){
        int id = 0;
        try{
            List<Cliente> clientes = this.loadAll();
            for(int i = clientes.size(); i>0; i--){
                String usuarioDatabase = clientes.get(i).getUsuario();
                String senhaDatabase = clientes.get(i).getSenha();
                if(usuarioDatabase.equals(usuario) && senhaDatabase.equals(senha)){
                        id = clientes.get(i).getId();
                        i=0;
                    }
                }
            } catch (Exception e){
            System.out.println("Não foi possível realizar a autenticação");
        }
        return id;
    }
    // getters and setters ommited...        
}