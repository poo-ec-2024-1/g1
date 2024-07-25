package autenticacaoregistro;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class EmpresaRepository
{
    private static Database database;
    private static Dao<Empresa, Integer> dao;
    private List<Empresa> loadedEmpresas;
    private Empresa loadedEmpresa; 
    
    public EmpresaRepository(Database database) {
        EmpresaRepository.setDatabase(database);
        loadedEmpresas = new ArrayList<Empresa>();
    }
    
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

    public void update(Empresa empresa) {
      try{
          dao.update(empresa);
      }catch (SQLException e){
          System.out.println("Não foi possível executar a atualização.");
      }
    }
    
    public void delete(Empresa empresa) {
      try{
          dao.delete(empresa);
      } catch (SQLException e){
          System.out.println("Não foi possível executar a exclusão.");
      }
    }
    
    public void deleteById(int id){
        try{
            dao.deleteById(id);
        } catch (SQLException e){
            System.out.println("Não foi possível executar a exclusão.");
        }
    }
    
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
}