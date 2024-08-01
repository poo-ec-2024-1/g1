package Model.repository;

import Model.model.Servico;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

/**
 *  Repositório para o banco de dados dos servicos
 * 
 * @author Matheus TP
 */

public class ServicoRepository{
    private static Database database;
    private static Dao<Servico, Integer> dao;
    private List<Servico> loadedServicos;
    private Servico loadedServico; 
    // Construtores
    public ServicoRepository(Database database) {
        ServicoRepository.setDatabase(database);
        loadedServicos = new ArrayList<Servico>();
    }
    /**
     * Seleciona o banco de dados sobre qual o repositorio vai operar
     * 
     * @param database Banco de dados que deseja atribuir ao repositório 
     */
    public static void setDatabase(Database database) {
        ServicoRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Servico.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Servico.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    /**
     *  Adiciona uma nova instância de Servico ao banco de dados
     * 
     * @param servico Instância do tipo Servico
     * @return Retorna o mesmo Servico que foi dado no parâmetro, porém com o seu ID definido
     */
    public Servico create(Servico servico) {
        int nrows = 0;
        try {
            nrows = dao.create(servico);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedServico = servico;
            loadedServicos.add(servico);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return servico;
    }    
    /**
     * Atualiza o Servico existente no banco de dados que possui o mesmo ID que o do parâmetro
     * 
     * @param servico Instância do tipo Servico
     */
    public void update(Servico servico) {
      try{
          dao.update(servico);
      }catch (SQLException e){
          System.out.println("Não foi possível executar a atualização.");
      }
    }
    /**
     * Deleta o Servico existente no banco de dados que possui o mesmo ID que o do parâmetro
     * 
     * @param servico Instância do tipo Servico
     */
    public void delete(Servico servico) {
      try{
          dao.delete(servico);
      } catch (SQLException e){
          System.out.println("Não foi possível executar a exclusão.");
      }
    }
    /**
     * Deleta o Servico existente no banco de dados que possui o ID passado no parâmetro
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
     * Carrega o servico do banco de dados que possui o ID passado no parâmetro
     * 
     * @param id ID para ser carregado
     * @return Retorna esse servico
     */
    public Servico loadFromId(int id) {
        try {
            this.loadedServico = dao.queryForId(id);
            if (this.loadedServico != null)
                this.loadedServicos.add(this.loadedServico);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedServico;
    }    
    /**
     * 
     * @return Uma lista com todos os Servicos contidos no banco de dados
     */
    public List<Servico> loadAll() {
        try {
            this.loadedServicos =  dao.queryForAll();
            if (this.loadedServicos.size() != 0)
                this.loadedServico = this.loadedServicos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedServicos;
    }
    // getters and setters ommited...        
}
