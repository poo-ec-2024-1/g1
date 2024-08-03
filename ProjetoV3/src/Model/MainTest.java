package Model;

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
        // Após isso, deve-se iniciar abrir o banco de dados.
        database.getConnection();

        // Um exemplo de objeto a serem registrados no banco de dados.
        Empresa empresa1 = new Empresa("Matheus LTDA", "66666666000166", "matheusltda", "123456");
        Empresa empresa2 = new Empresa("outra empresa", "214695467", "aaa", "111");
        Empresa empresa3 = new Empresa("slaaaaa","4536536378","bbb","222");
        
        // Cria-se então um objeto do tipo do repositório do objeto que deseja salvar, e no construtor deve-se colocar a
        // referência para o bando de dados criado anteriormente.
        
        EmpresaRepository empresaRepository = new EmpresaRepository(database);
        // Então use o método create para salvar o objeto no banco de dados.
        empresa1 = empresaRepository.create(empresa1);
        empresa2 = empresaRepository.create(empresa2);
        empresa3 = empresaRepository.create(empresa3);
        
        // Testanto algumas autenticações.
        System.out.println("Teste 1: "+empresaRepository.autenticarEmpresa("matheusltda", "123456")); // Usuario e senha corretos
        System.out.println("Teste 2: "+empresaRepository.autenticarEmpresa("matheusltda", "12346")); // Senha incorreta
        System.out.println("Teste 3: "+empresaRepository.autenticarEmpresa("mathtda", "123456")); // Usuario incorreto
        System.out.println("Teste 4: "+empresaRepository.autenticarEmpresa("mathe", "1234ew")); // Usuario e senha incorretos
        System.out.println("Teste 5: "+empresaRepository.autenticarEmpresa("aaa", "222")); // Usuario e senha de usuários diferentes
        System.out.println("Teste 6: "+empresaRepository.autenticarEmpresa("bbb", "111")); // Usuario e senha de usuários diferentes
        System.out.println("Teste 7: "+empresaRepository.autenticarEmpresa("aaa", "111")); // Usuario e senha corretos
        System.out.println("Teste 8: "+empresaRepository.autenticarEmpresa("bbb", "222")); // Usuario e senha corretos
        
        // Após encerrar as operações desejadas, é aconselhável encessar o banco de dados.
        database.close();
    }
}