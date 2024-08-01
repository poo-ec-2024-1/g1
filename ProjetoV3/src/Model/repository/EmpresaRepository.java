package Model.repository;

import Model.model.Empresa;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;
/**
 *  Repositório para o banco de dados das empresas
 * 
 * @author Matheus TP
 */
public class EmpresaRepository
{
    private static Database database;
    private static Dao<Empresa, Integer> dao;
    private List<Empresa> loadedEmpresas;
    private Empresa loadedEmpresa; 
    // Construtores
    public EmpresaRepository(Database database) {
        EmpresaRepository.setDatabase(database);
        loadedEmpresas = new ArrayList<Empresa>();
    }
    /**
     * Seleciona o banco de dados sobre qual o repositorio vai operar
     * 
     * @param database Banco de dados que deseja atribuir ao repositório 
     */
    public static void setDatabase(Database database) {
        EmpresaRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Empresa.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Empresa.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    /**
     *  Adiciona uma nova instância de Empresa ao banco de dados
     * 
     * @param empresa Instância do tipo Empresa
     * @return Retorna o mesmo empresa que foi dado no parâmetro, porém com o seu ID definido
     */
    public Empresa create(Empresa empresa) {
        int nrows = 0;
        try {
            nrows = dao.create(empresa);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedEmpresa = empresa;
            loadedEmpresas.add(empresa);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return empresa;
    }    
    /**
     * Atualiza a Empresa existente no banco de dados que possui o mesmo ID que o do parâmetro
     * 
     * @param empresa Instância do tipo Empresa
     */
    public void update(Empresa empresa) {
      try{
          dao.update(empresa);
      }catch (SQLException e){
          System.out.println("Não foi possível executar a atualização.");
      }
    }
    /**
     * Deleta a Empresa existente no banco de dados que possui o mesmo ID que o do parâmetro
     * 
     * @param empresa Instância do tipo Empresa
     */
    public void delete(Empresa empresa) {
      try{
          dao.delete(empresa);
      } catch (SQLException e){
          System.out.println("Não foi possível executar a exclusão.");
      }
    }
    /**
     * Deleta a empresa existente no banco de dados que possui o ID passado no parâmetro
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
     * Carrega a empresa do banco de dados que possui o ID passado no parâmetro
     * 
     * @param id ID para ser carregado
     * @return Retorna essa empresa
     */
    public Empresa loadFromId(int id) {
        try {
            this.loadedEmpresa = dao.queryForId(id);
            if (this.loadedEmpresa != null)
                this.loadedEmpresas.add(this.loadedEmpresa);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedEmpresa;
    }    
    /**
     * 
     * @return Uma lista com todas as empresas contidas no banco de dados
     */
    public List<Empresa> loadAll() {
        try {
            this.loadedEmpresas =  dao.queryForAll();
            if (this.loadedEmpresas.size() != 0)
                this.loadedEmpresa = this.loadedEmpresas.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedEmpresas;
    }
    /**
     * Método responsável por validar se uma empresa existe no banco de dados através de seu usuario e senha, e além disso,
     * obtêm o seu id.
     * 
     * @param usuario que deseja autenticar
     * @param senha que deseja autenticar
     * @return retorna o id do cliente se ele existir no banco de dados. Do contrário, retorna 0;
     */
    
    /*
    public int autenticarEmpresa(String usuario, String senha){
        int id = 0;
        try{
            List<Empresa> empresa = this.loadAll();
            for(int i = empresa.size(); i>0 ; i--){
                String usuarioDatabase = empresa.get(i-1).getEmail();
                String senhaDatabase = empresa.get(i-1).getSenha();
                if(usuarioDatabase.equals(usuario) && senhaDatabase.equals(senha)){
                        id = empresa.get(i-1).getId();
                        i=0;
                    }
                }
            } catch (Exception e){
            System.out.println("Não foi possível realizar a autenticação.");
        }
        return id;
    }
*/
}