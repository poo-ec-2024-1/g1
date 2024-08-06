# Projeto POO - Car Wash
## Relatório Matheus Teixeira Pires

### Introdução
Para o projeto de programação orientada a objeto, nossa equipe se propôs a desenvolver um sistema para solucionar um problema referente ao automobilismo e praticidade na vida das pessoas. Muitas vezes, proprietários de veículos necessitam realizar alguns serviços nos mesmos, que muitas vezes necessitam de um profissional competente para tal. Porém sabemos que, para contratar esses serviços, os proprietários precisam levar seus veículos até o estabelecimento onde o profissional está atuando. Algumas pessoas não se importam em fazer isso, mas outras se incomodam. Se alguém quer, por exemplo, fazer uma lavagem completa em seu carro para poder sair a noite, ela precisa levar seu carro a um lava jato. Mas talvez essa pessoa não tenha tempo ou disposição para fazer isso.
Visando resolver esse problema, idealizamos um sistema que tem por objetivo conectar prestadores de serviços para carros e possíveis clientes. Basicamente, é um programa em que uma pessoa pode entrar, se cadastrar, e então procurar pelo serviço que precisa para o seu veículo. Ao encontrá-lo, ela pode solicitá-lo, e então a empresa responsável pode aceitá-lo. Ao fazer isso, a empresa se propõe a enviar um profissional até a localização indicada pelo cliente para que ele realize o serviço lá mesmo, sem a necessidade de levar o carro até o seu estabelecimento. Os serviços são vários, como uma lavagem completa no veículo, troca de óleo, troca de pneu, instalação de insulfilm, entre outros. As empresas podem entrar nesse sistema e registrar os serviços que disponibiliza. Desse modo, a empresa aumentaria sua captação de clientes, e os clientes resolveriam seus eventuais problemas. O foco principal do sistema, seriam serviços de limpeza para veículos em geral, mas nada impede que outros serviços relacionados a carros sejam oferecidos.

### Planejamento
Devido a magnitude do projeto, o grupo decidiu por utilizar a IDE Apache Netbeans ao invés do BlueJ e o VSCode, como sujerido pelo professor. Fizemos isso porque o VSCode não é uma IDE focada em java, e por isso preferimos usar alguma que tivesse mais relação com essa linguagem. O BlueJ é bom para aprendizado inicial, porém quando se têm um volume muito grande de códigos e packages, ele acaba deixando a desejar. A organização e a praticidade fica precária, por isso optamos por não utilizá-lo. 
O projeto foi subdividido em duas partes: O fronend e o backend. Eu fiquei responsável pelo backend, que diz respeito a criação e codificação das classes necessárias, implementação de métodos, integração com o banco de dados e integração com o frontend. Para isso, utilizei várias ferramentas diferentes. Para o banco de dados, utilizei o SQLite. Também instalei algumas bibliotecas no meu ambiente de desenvolvimento, como o ORMLite, que permite que a integração com o banco de dados seja feita de maneira orientada a objeto, o que é do interesse da disciplina. Para as interfaces gráficas, utilizamos o JavaFX com o auxílio da ferramenta Scennebuilder, porém por não ser algo relacionado ao backend, não interferi muito.

### Excecução

Inicialmente, foram modeladas as classes principais que representam as entidades utilizadas no projeto. Segue abaixo o diagrama UML das mesmas:
![imagem](/Relatório_Matheus_Teixeira_Pires/prints/Classe_UML_Database.png)
Todas essas classes precisarão ser guardadas em um banco de dados. Por isso, criei o repositório para cada uma delas, e então conectei os mesmos a classe Database, que basicamente fez a conexão com o banco de dados. O repositório é a ponte entre as classes e os seus respectivos bancos de dados.


Para cada uma das telas desenvolvidas, foi necessário fazer umn controller que as controla. Segue abaixo os principais controllers criados, e também um fluxo que descreve o caminho percorrido pelo usuário ao navegar pelo programa.
![imagem](/Relatório_Matheus_Teixeira_Pires/prints/Diagrama_UML_Controllers.png)


Para exemplificar a minha participação no projeto, vou referenciar alguns commits que fiz.

https://github.com/poo-ec-2024-1/g1/commit/fd8adeced516da8bd9f7231a3547a8bacff5ea54
Nesse commit, eu adicionei as classes e métodos responsáveis por possibilitar a criação, edição e exclusão de serviços por parte da empresa, e ao sistema que salva essas alterações no banco de dados.

https://github.com/poo-ec-2024-1/g1/commit/f7476615ab937056c5369c44bb57df12c9a5da57
Nesse commit, eu implemententei o sistema que possibilita o agendamento de serviços por parte dos clientes, e os salva no banco de dados.

https://github.com/poo-ec-2024-1/g1/commit/64b86d0da312a77a867d122624238bdafdd27605 
Nesse commit, eu implementei o sistema que permite o registro e o login por parte da empresa, e salva todas essas informações no banco de dados.

https://github.com/poo-ec-2024-1/g1/commit/d62393c97cfc1781a151171bb7589f771214f03b 
Nesse commit, eu implementei o sistema que permite aos clientes verem os serviços que ele agendou.

https://github.com/poo-ec-2024-1/g1/commit/35a6914b5cad9ab389593bf9b6cbd821c2567132
Nesse commit, adicionei a documentação javadoc ao projeto. Além disso, fiz alguns testes e implementei algumas correções

### Considerações finais

O projeto foi relativamente difícil. Muitos conceitos foram introduzidos em pouco tempo, e foi um grande esafio aplicá-los em um projeto voltado para o mundo real. O aprendizado obtido durante ese processo foi bem extenso, porém não muito profundo. Não houve tempo de entender profundamente cada um dos conceitos, somente como aplicá-los diretamente. Entre as maiores dificuldades, podemos citar a parte relacionada ao git. Não dominamos essa ferramenta, e por isso enfrentamos diversos problemas na hora de mesclar os códigos produzidos pelos membros do grupo. Bastante tempo foi perdido por isso. infelizmente, o projeto não foi 100% concluído. O sistema de gerenciamento de agendamentos ficou incompleto, além de alguns outros ajustes na programação e no visual que precisam ser feitos.
Apesar de tudo, creio que o projeto agregou para o nosso conhecimento. Boa parte das dificuldades foram vencidas, e o rsultado final foi satisfatório.
