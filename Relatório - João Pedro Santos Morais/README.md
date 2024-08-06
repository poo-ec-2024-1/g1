# Ferramentas utilizadas:

O projeto foi desenvolvido por meio da IDE Apache netbeans, a qual foi utilizada em conjunto com o software de controle de versão (git) para salvar as respectivas fazes do projeto em repositórios gitHub. Em geral, os commits foram feitos diretamente no branch 'main', sobrepondo os arquivos editados. Em segundo plano, foi utilizado branch's secundários, os quais foram utilizados para edições mais significativas no projeto, aumentando o efetivo do merge de branch's. A IDE utilizada foi de grande valia, pelos motivos de facilidade de configuração e de criação de projetos.

![image](https://github.com/user-attachments/assets/a0ef0088-7a40-4e1c-a354-604c8a09609c)

A principio, todas as vezes que foi necessário a clonagem de repositórios git, exigiu-se a configuração das bibliotecas do projeto, trocando as versões do JDK e adicionando as bibliotecas de banco de dados.


# Linguagem:

Em primeiro plano, o projeto foi estruturado no modelo MVC (model, view, controller), no qual eu fiquei, marjoritariamente, responsável pelo front-end (view + controllers) do projeto. Para a criação das views, foi utilizada a linguagem css (Cascading Style Sheet) para a estilização dos componentes. Nos controllers, eu fiquei responsável pela conexão e harmonia entre as telas, input de informações, output de dados, e detalhes estéticos da visualização de informações, como nomes, datas, endereços, dentre outros.

![image](https://github.com/user-attachments/assets/09f7a725-634a-424e-ad98-c4e4211e2e22)

Para a conexão das telas, foram utilizados 7 principais imports:

1) import javafx.scene.Node;
2) import javafx.scene.Parent;
3) import javafx.scene.Scene;
4) import javafx.stage.Stage;
5) import javafx.event.ActionEvent;
6) import javafx.fxml.FXML;
7) import javafx.fxml.FXMLLoader;

Para a linguagem css, foi utilizado a referência do site da Oracle : https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html#:~:text=CSS%20styles%20are%20applied%20to,need%20CSS%20reapplied%20are%20visited.


# Modelagem de classes:

![Classe UML - Database](https://github.com/user-attachments/assets/f512c2b4-2eba-4476-afa5-f920b1f40277)

# Documentação e projetos:

A documentação foi feita através de commits, documentos markdown, e diagramas UML. O projeto foi estruturado através da colaboração dos membros do grupo por intermédio de reuniôes no discord, grupo de whatsapp, e de reuniões físicas. A divisão do projeto não foi algo bem estruturado, tendo em vista os imprevistos e a falta de integrantes, foi necessário a versatilidade dos membros restantes para preencher os papeis propostos pelo professor. Em geral, eu participei de toda a porção do projeto, todavia, com uma maior ênfase no aspecto estético e de prototipação, também participei da criação inicial dos modelos de estruturação dos packages dos arquivos.

Principais commits:

1) https://github.com/poo-ec-2024-1/g1/commit/8701a8673d7a04f4965cc831cb55b5bbb3042d62 (Criação de interfaces e controllers);
2) https://github.com/poo-ec-2024-1/g1/commit/7ea7e7dcbec2ce09b48bc3073f3a35b4dd3cec10 (Criação das interfaces e controllers de edição de serviços conectada ao banco de dados);
3) https://github.com/poo-ec-2024-1/g1/commit/ec8af52eeddef310d157c4b080f92030693cbfb7 (Repaginando a interface com css);
4) https://github.com/poo-ec-2024-1/g1/commit/306b183bc4e6fed337ecb439590d883d43662803 (Reformulação nos modelos, interfaces e controllers);

