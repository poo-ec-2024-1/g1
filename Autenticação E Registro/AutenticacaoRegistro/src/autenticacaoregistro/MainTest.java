package autenticacaoregistro;

/**
 *
 * @author mathe
 */
public class MainTest {
    public static void main(String[] args){
        // Esse é o código base que deve ser utilizado para inserir algum objeto em seu respectivo banco de dados.
        
        // Primeiro, cria-se um objeto do tipo Database, e no contrutor deve-se colocar o nome do banco de dados que deseja
        // salvar os objetos. Se já existir um banco de dados com esse nome, os objetos serão atribuídos a ele.
        Database database = new Database("databaseEmpresa");
        try{
            database.getConnection();
        }catch (Exception e){
            System.out.println("Não foi possível iniciar o database");
        }
        
        // Um exemplo de objeto a ser guardado no banco de dados.
        Empresa empresa1 = new Empresa("Matheus LTDA", "66666666000166", "matheusltda", "123456");
        
        // Cria-se então um objeto do tipo do repositório do objeto que deseja salvar, e no construtor deve-se colocar a
        // referência para o bando de dados criado anteriormente.
        
        EmpresaRepository empresaRepository = new EmpresaRepository(database);
        // Então use o método create para salvar o objeto no banco de dados.
        empresa1 = empresaRepository.create(empresa1);
    }
}
