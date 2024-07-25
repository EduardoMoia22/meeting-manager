# Projeto de Agendamento de Reuniões

Este projeto visa facilitar o gerenciamento e a organização de reuniões.

## Tecnologias Utilizadas

- **Java Spring Boot**: Framework para desenvolvimento de aplicações web.
- **Spring Data JPA**: Facilita a integração e manipulação dos dados no banco de dados.
- **Spring Scheduler**: Para agendamento e execução de tarefas automáticas.
- **PostgreSQL**: Banco de dados relacional.
- **Docker**: Para garantir portabilidade e consistência do ambiente de desenvolvimento.

## Funcionalidades Principais

- **Cadastro de Reuniões**: Permite que os usuários registrem detalhes das reuniões, como título, descrição e horários.
- **Listagem de Reuniões**: Facilita a visualização de todas as reuniões agendadas.
- **Notificações Automáticas**: Envia lembretes antes das reuniões ocorrerem, garantindo que todos estejam informados e preparados.

## Documentação

A documentação da API está disponível via Swagger UI. Acesse a documentação das rotas, incluindo erros e DTOs, em:

[Swagger UI](http://localhost:8080/swagger-ui/index.html#/)
(Após iniciar a aplicação.)

## Configuração e Execução com Docker

Para configurar e executar o projeto utilizando Docker, siga os passos abaixo:

### Passo 1: Configurar Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto e defina as variáveis de ambiente necessárias para o PostgreSQL:

```env
POSTGRES_USER=your_db_user
POSTGRES_PASSWORD=your_db_password
POSTGRES_DB=your_db_name
```

### Passo 2: Criar e Configurar o Docker Compose

Crie um arquivo `docker-compose.yml` na raiz do projeto com o seguinte conteúdo:

```yaml
version: '3'
services:
  postgres:
    container_name: postgres-meeting
    image: postgres:latest
    restart: always
    environment:
      POSTGRES_USER: ${POSTGRES_USER}
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
      POSTGRES_DB: ${POSTGRES_DB}
      PGDATA: /var/lib/postgresql/data/pgdata
    ports:
      - "5432:5432"
    volumes:
      - ./data/postgres/pgdata:/var/lib/postgresql/data/pgdata
```

### Passo 3: Iniciar os Contêineres

No terminal, navegue até a raiz do projeto e execute o comando:

```sh
docker-compose up -d
```

Este comando iniciará o contêiner do PostgreSQL em segundo plano, configurado conforme as variáveis definidas.

### Passo 4: Executar a Aplicação

Certifique-se de que sua aplicação Spring Boot está configurada para se conectar ao banco de dados PostgreSQL em `localhost:5432`. Inicie a aplicação Spring Boot normalmente, e ela se conectará ao banco de dados PostgreSQL executado pelo Docker.

---

Caso precise de mais informações ou tenha dúvidas, sinta-se à vontade para entrar em contato! 🚀
