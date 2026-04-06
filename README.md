# 🛡️ Monitor de Referências - Controle de Acesso

Este projeto é uma simulação de um **Monitor de Referências** para controle de acesso baseado em regras, desenvolvido para a disciplina de Segurança da Informação.

## 📋 Sobre o Projeto
O sistema implementa uma arquitetura em Java para interceptar e validar requisições de usuários a determinados recursos do sistema. As permissões de acesso (Leitura `r`, Escrita `w`, Exclusão `d`) são gerenciadas dinamicamente através de um arquivo `JSON`, garantindo que as regras de segurança fiquem totalmente isoladas das entidades de domínio da aplicação.

## 🏗️ Estrutura e Arquitetura
O projeto segue o padrão de injeção de dependências e separação de responsabilidades:
* **`model.Pessoa`**: Representa o usuário do sistema. Esta classe não acessa recursos diretamente, delegando a validação para o monitor.
* **`security.MonitorReferencias`**: Mecanismo de infraestrutura que atua como interceptador. Ele lê as configurações e aprova ou bloqueia as requisições.
* **`resources/autorizacao.json`**: Base de autorização estática que atua como o contrato de permissões.

## 🚀 Como Executar

### Pré-requisitos
* Java JDK 11 ou superior
* Biblioteca `org.json` (já disponibilizada na pasta `/lib` para facilitar a execução)

### Executando via Terminal

1. Na raiz do projeto, crie o diretório para os binários:

```bash
mkdir bin
```

2. Compile o codigo-fonte:

```bash
javac -d bin -cp "lib/json-20231013.jar" src/main/java/br/com/murilobertelli/controleacesso/Main.java src/main/java/br/com/murilobertelli/controleacesso/model/Pessoa.java src/main/java/br/com/murilobertelli/controleacesso/security/MonitorReferencias.java
```

3. Execute a simulação (Sistemas Windows):

```bash
java -cp "bin;lib/json-20231013.jar;src/main/resources" br.com.murilobertelli.controleacesso.Main
```
