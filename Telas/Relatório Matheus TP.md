# Projeto POO - Relatório
	Autor: Matheus Teixeira Pires

## Introdução
Para o projeto de programação orientada a objeto, nossa equipe se propôs a desenvolver um sistema para solucionar um problema referente ao automobilismo e  praticidade na vida das pessoas. Muitas vezes, proprietários de veículos necessitam realizar alguns serviços nos mesmos, que muitas vezes necessitam de um profissional competente para tal. Porém sabemos que, para contratar esses serviços, os proprioetários precisam levar seus veículos até o estabelecimento onde o profissional está atuando. Algumas pessoas não se importam em fazer isso, mas outras se incomodam. Se alguém quer, por exemplo, fazer uma lavagem completa em seu carro para poder sair a noite, ela precisa levar seu carro a um lava jato. Mas talvez essa pessoa não tenha tempo ou disposição para fazer isso.

Visando resolver esse problema, idealizamos um sistema que tem por objetivo conectar prestadores de serviços para carros e possíveis clientes. Basicamente, é um programa em que uma pessoa pode entrar, se cadastrar, e então procurar pelo serviço que precisa para o seu veículo. Ao encontrá-lo, ela pode solicitá-lo, e então a empresa responsável pode aceitá-lo. Ao fazer isso, a empresa se propõe a enviar um profissional até a localização indicada pelo cliente para que ele realize o serviço lá mesmo, sem a necessidade de levar o carro até o seu estabelecimento. Os serviços são vários, como uma lavagem completa no veículo, troca de óleo, troca de pneu, instalação de insulfilm, entre outros. As empresas podem entrar nesse sistema e registrar os serviços que disponibiliza. Desse modo, a empresa aumentaria sua captação de clientes, e os clientes resolveriam seus eventuais problemas. O foco principal do sistema, seriam serviços de limpeza para veículos em geral, mas nada impede que outros serviços relacionados a carros sejam oferecidos.

## Planejamento
Pretendemos desenvolver a idea base para o projeto e uma visão de como ele funcionaria na prática. O objetivo da realização do projeto é didático, então não há pretensão de colocá-lo em prática na vida real. Portanto, alguns conceitos mais complexos não serão abordados.

Para a primeira parte do projeto, pretendemos desenvolver a ideia, e criar as possíveis telas que estarão no programa, e o seu funcionamento no geral. Elas basicamente ficaram separadas da seguinte maneira:

**Geral**

 - Tela de Login

**Lado do Cliente**

 - Tela de Registro
 - Tela Menu Principal
 - Tela Agendar Serviços
 - Tela Ver Agendamentos
 - Tela Editar Perfil
 
**Lado da Empresa**

 - Tela de Registro
 - Tela Menu Principal
 - Tela Ver Agendamentos
 - Tela Ver Solicitações de Agendamentos
 - Tela Editar Perfil

Essas são apenas as telas iniciais que pretendemos colocar. Futuramente serão feitas as adições necessárias conforme o andamento do projeto. Essas telas foram divididas entre os membros da equipe, e cada um deve elaborá-las utilizando o Scene Builder com o JavaFX.
Eu, Matheus Teixeira Pires, fiquei responsável pela tela de login e pelas telas de ver agendamentos do cliente e da empresa.


## Execução

### Tela de Login
Para a tela de login, será necessário somente as caixas de texto para que o usuário insira seus dados, um botão para fazer um login e outro para ir até a tela de registro.
![enter image description here](https://i.ibb.co/qgcPXtc/Print-Tela-Login.png)
Ao digitar o usuário e a senha e apertar em "Entrar", esses dados são guardados em uma instância de "usuario", que pode ser usada posteriormente para validar esses dados e adentrar na respectiva conta da pessoa. No canto inferior direito, está um "teste". Ao inserir dados e tentar fazer login, os dados digitados aparecerão nessa parte do teste, comprovando que está funcionando.

### Tela de Ver Agendamento Cliente
Para a tela de agendamento do cliente, desenvolvi a seguinte tela:
![enter image description here](https://i.ibb.co/nB9MvDX/Print-Tela-Agendamento-Cliente.png)

O usuário pode abrir a caixa de seleção, e então verá todos os agendamentos que foram realizados:
![enter image description here](https://i.ibb.co/HVr2gp2/Print-Tela-Agendamento-Cliente1.png)
Ao selecionar um dos agendamentos, todas as informações referentes ao mesmo vão aparecer nos seus respectivos espaços:
![enter image description here](https://i.ibb.co/n8Cnf2x/Print-Tela-Agendamento-Cliente2.png)

### Tela de Ver Agendamento Empresa

A tela de ver agendamentos da empresa funciona de modo semelhante a do cliente, com a diferença de que os dados exibidos são diferentes:
![enter image description here](https://i.ibb.co/7XNnxxG/Print-Tela-Agendamento-Empresa.png)

Enquanto a tela do cliente mostra o serviço agendado e os dados da empresa, a tela da empresa mostra o serviço agendado e os dados do cliente. São bem semelhantes

## Conclusão

Todas as telas vistas acima foram feitas com o Scene Builder e JavaFX, através da IDE NetBeans. Utilizei o modelo MVC para todas, que consiste em estruturar a tela a partir de um model, uma view e um controller.
![enter image description here](https://i.ibb.co/f4c3zhZ/MVC.png)

Todo esse código e sua documentação está disponível no github do grupo.
A seguir, estão os commits que fiz:
![enter image description here](https://i.ibb.co/HPRJyj0/Commits.png)

