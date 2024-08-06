package Model.repository;

import Model.model.Agendamento;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

/**
 *  Repositório para o banco de dados dos agendamentos
 */
public class AgendamentoRepository{
    private static Database database;
    private static Dao<Agendamento, Integer> dao;
    private List<Agendamento> loadedAgendamentos;
    private Agendamento loadedAgendamento; 
    // Construtores
    public AgendamentoRepository(Database database) {
        AgendamentoRepository.setDatabase(database);
        loadedAgendamentos = new ArrayList<Agendamento>();
    }
    /**
     * Seleciona o banco de dados sobre qual o repositorio vai operar
     * 
     * @param database Banco de dados que deseja atribuir ao repositório 
     */
    public static void setDatabase(Database database) {
        AgendamentoRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Agendamento.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Agendamento.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    /**
     *  Adiciona uma nova instância de Agendamento ao banco de dados
     * 
     * @param agendamento Instância do tipo Agendamento
     * @return Retorna o mesmo Agendamento que foi dado no parâmetro, porém com o seu ID definido
     */
    public Agendamento create(Agendamento agendamento) {
        int nrows = 0;
        try {
            nrows = dao.create(agendamento);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedAgendamento = agendamento;
            loadedAgendamentos.add(agendamento);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return agendamento;
    }    
    /**
     * Atualiza o Agendamento existente no banco de dados que possui o mesmo ID que o do parâmetro
     * 
     * @param agendamento Instância do tipo Agendamento
     */
    public void update(Agendamento agendamento) {
      try{
          dao.update(agendamento);
      }catch (SQLException e){
          System.out.println("Não foi possível executar a atualização.");
      }
    }
    /**
     * Deleta o Agendamento existente no banco de dados que possui o mesmo ID que o do parâmetro
     * 
     * @param agendamento Instância do tipo Agendamento
     */
    public void delete(Agendamento agendamento) {
      try{
          dao.delete(agendamento);
      } catch (SQLException e){
          System.out.println("Não foi possível executar a exclusão.");
      }
    }
    /**
     * Deleta o Agendamento existente no banco de dados que possui o ID passado no parâmetro
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
     * Carrega o agendamento do banco de dados que possui o ID passado no parâmetro
     * 
     * @param id ID para ser carregado
     * @return Retorna esse agendamento
     */
    public Agendamento loadFromId(int id) {
        try {
            this.loadedAgendamento = dao.queryForId(id);
            if (this.loadedAgendamento != null)
                this.loadedAgendamentos.add(this.loadedAgendamento);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedAgendamento;
    }    
    /**
     * 
     * @return Uma lista com todos os Agendamentos contidos no banco de dados
     */
    public List<Agendamento> loadAll() {
        try {
            this.loadedAgendamentos =  dao.queryForAll();
            if (this.loadedAgendamentos.size() != 0)
                this.loadedAgendamento = this.loadedAgendamentos.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedAgendamentos;
    }
      
}
