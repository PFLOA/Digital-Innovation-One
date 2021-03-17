## Desenvolvendo um sistema de gerenciamento de pessoas via API REST com Spring Boot

Neste projeto desenvolvi uma API REST em localhost, para Inserir, 
Deletar, Atualizar, e obter a lista de
pessoas cadastradas em um banco de dados local h2.

### Tecnologias utilizadas:

* lombok 1.18.16:
  
    Utilizado para dar mais poder ao java, utilizando as suas 
    assinaturas é possível criar os getters e setters em tempo de 
    compilação e criar os construtores necessários também.
  
    <br>
  
* mapstruct 1.4.2.Final:

  Gerador de códigos qe simplifica a  implementação de mapeamentos 
  entre tipos de bean Java.
<br>
  
### Para executar o projeto no terminal, digite o seguinte comando:

``mvn spring-boot:run``

Após executar o comando acima, basta apenas abrir o seguinte 
endereço e visualizar a execução do projeto:

``http://localhost:8080/api/v1/people``

### Requisitos:

* Java 11
* Maven 3.6.3 ou versões superiores

Como um bônus o professor deixou códigos de testes unitários para estudo.

<a href="https://github.com/PFLOA/Digital-Innovation-One/tree/main/Projetos">Voltar para Projetos</a>
