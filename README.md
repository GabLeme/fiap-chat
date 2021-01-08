<h1 align="center">
  FIAP - CHAT 
</h1>

<p align="center">
  <a href="#-sobre">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-colaboradores">Colaboradores</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-banco-de-dados">Banco de Dados</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-contrato-api">Contrato API</a>
</p>

## 🗨 Sobre

Backend de um sistema de chat simples com calendério e cadastro de atividades. Para atender a atividade de Java, relacionamento entre 
classes e persistência de dados. No projeto contém operações que incluam cadastro, consulta, atualização e exclusão de registros (CRUD).

## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [Java](https://developer.amazon.com/)
- [Spring](https://spring.io/)
- [Maven](https://maven.apache.org/what-is-maven.html)
- [JRE 8u271](https://www.oracle.com/br/java/technologies/javase-jre8-downloads.html)
- [JDK 8u271](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- [JUnit](https://junit.org/)
- [H2 Database](https://www.h2database.com/html/main.html)

## 💻 Projeto
 
Projeto em Java simples, feito no Eclipse, para acomodar as classes e estruturas responsáveis pela persistência futura dos dados manipulados no protótipo. O projeto contém todas as entidades envolvidas e os seus relacionamentos, as classes para persistir e consultar os objetos e classes de teste unitário. Foi utilizado JPA (Java Persistence API), com o framework Spring.

## 👔 Colaboradores

Desenvolvido pelos profissionais:

- [Rafael Magalhães](https://www.linkedin.com/in/rlmagalhaes/)
- [Gabriel Leme](https://linkedin.com/in/gabriel-leme-71325b150)

## 🗄 Banco de Dados

Console do h2:
http://localhost:8080/h2-console/

JDBC URL: jdbc:h2:mem:testdb  
user: sa   
password: password

## :memo: Contrato API
  Veja arquivo collection: Fiap - Atividade 1.postman_collection.json 
  ### Usuário 
   #### 1. Criar: POST - http://localhost:8080/chat/v1/user 
   ##### Body Request:  
   ```json
    {
        "cpf": "89333800000",
        "login": {
            "email": "email@teste.com",
            "password": "12345678"
        }
    }
   ```
   ##### Response:  
   * 201 : Created
   ```json
    {
        "data": {
            "id": 1,
            "login": {
                "email": "email@teste.com",
                "password": "12345678"
            },
            "cpf": "89333800000"
        },
        "errors": []
    }
   ```  
   #### 2. Buscar: GET - http://localhost:8080/chat/v1/user/{id}
   ##### Response:    
   * 200 : OK
   ```json
    {
      "id": 1,
      "login": {
          "email": "email@teste.com",
          "password": "12345678"
      },
      "cpf": "89333800000"
    }
   ```
   #### 3. Atualizar: POST - http://localhost:8080/chat/v1/user 
   ##### Body Request:  
   ```json
    {
        "id": 15,
        "cpf": "77788420093",
        "login": {
            "email": "email@teste.com.br",
            "password": "a212345678"
        }
    }
   ```
   ##### Response:  
   * 201 : Created
   ```json
    {
        "data": {
            "id": 15,
            "login": {
                "email": "email@teste.com.br",
                "password": "a212345678"
            },
            "cpf": "77788420093"
        },
        "errors": []
    }
   ```  
   #### 4. Deletar: GET - http://localhost:8080/chat/v1/user/{id}
   ##### Response:    
   * 204 : No Content
   
   ### Calendário
   #### 1. Criar: POST - http://localhost:8080/chat/v1/calendar
   ##### Body Request:  
   ```json
    {
          "user": {
            "id": 1
        }
    }
   ```
   ##### Response:  
   * 201 : Created
   ```json
    {
        "data": {
            "id": 1,
            "login": {
                "email": "email@teste.com",
                "password": "12345678"
            },
            "cpf": "89333800000"
        },
        "errors": []
    }
   ```  
   * 500 : Internal Server Error
    
   `"message": "Já existe calendário cadastrado para esse usuário."`
   
   #### 2. Buscar: GET - http://localhost:8080/chat/v1/calendar/findByUserId?userID=1
   ##### Response:  
   * 200 : OK
   ```json
    {
        "id": 2,
        "diasNaoUteis": [
            {
                "id": 12,
                "diaNaoUtil": "2021-01-05"
            },
            {
                "id": 13,
                "diaNaoUtil": "2021-01-25"
            }
        ],
        "user": {
            "id": 1,
            "login": {
                "email": "teste@outlook.com",
                "password": "12345678"
            },
            "cpf": "89333800000"
        },
        "activity": [
            {
                "id": 3,
                "titulo": "Daily",
                "descricao": "Reunião",
                "dt_inicio": "2021-07-14T12:00:00",
                "dt_fim": "2021-07-14T13:00:00"
            },
            {
                "id": 4,
                "titulo": "Daily",
                "descricao": "Reunião",
                "dt_inicio": "2021-07-14T12:00:00",
                "dt_fim": "2021-07-14T13:00:00"
            },
            {
                "id": 5,
                "titulo": "Daily",
                "descricao": "Reunião",
                "dt_inicio": "2021-07-14T12:00:00",
                "dt_fim": "2021-07-14T13:00:00"
            }
        ]
    }
   ```  
   ### Atividade
   #### 1. Criar: POST - http://localhost:8080/chat/v1/activity
   ##### Body Request:  
   ```json
    {
      "titulo": "Daily",
      "descricao": "Reunião",
      "dt_inicio": "2021-01-14T12:00:00.00",
      "dt_fim": "2021-01-14T13:00",
      "calendar": {
          "id": 2      
      }
    }
   ```
   ##### Response:  
   * 201 : Created
   ```json
    {
      "data": {
        "id": 17,
        "titulo": "Daily",
        "descricao": "Reunião",
        "dt_inicio": "2021-01-14T12:00:00",
        "dt_fim": "2021-01-14T13:00:00"
      },
      "errors": []
    }
   ```  
   #### 2. Atualizar: POST - http://localhost:8080/chat/v1/activity
   ##### Body Request:  
   ```json
    {
      "id": 17,
      "titulo": "Daily 2",
      "descricao": "Reunião 2",
      "dt_inicio": "2021-01-14T15:00:00.00",
      "dt_fim": "2021-01-14T16:00",
      "calendar": {
          "id": 2      
      }
    }
   ```
   ##### Response:  
   * 201 : Created
   ```json
    {
      "data": {
        "id": 17,
        "titulo": "Daily 2",
        "descricao": "Reunião 2",
        "dt_inicio": "2021-01-14T15:00:00",
        "dt_fim": "2021-01-14T16:00:00"
      },
      "errors": []
    }
   ```  
   #### 3. Deletar: GET - http://localhost:8080/chat/v1/activity/{id}
   ##### Response:    
   * 204 : No Content
   
   ### Dia Não Útil
   #### 1. Criar: POST - http://localhost:8080/chat/v1/dianaoutil
   ##### Body Request:  
   ```json
    {
        "diaNaoUtil":"2021-05-25",
         "calendar": {
            "id": 2     
        }
    }
   ```
   ##### Response:  
   * 201 : Created
   ```json
    {
      "data": {
        "id": 18,
        "diaNaoUtil": "2021-05-25"
      },
      "errors": []
    }
   ```  
   * 500 : Internal Server Error    
   `"message": "Dia não util já cadastrado."`
   
   #### 2. Atualizar: POST - http://localhost:8080/chat/v1/dianaoutil
   ##### Body Request:  
   ```json
    {
      "id": 18,
      "diaNaoUtil":"2021-01-25",
       "calendar": {
          "id": 2     
      }
    }
   ```
   ##### Response:  
   * 201 : Created
   ```json
    {
      "data": {
        "id": 18,
        "diaNaoUtil": "2021-01-25"
      },
      "errors": []
    }
   ```  
   * 500 : Internal Server Error    
   `"message": "Dia não util já cadastrado."`
   
   #### 3. Deletar: GET - http://localhost:8080/chat/v1/dianaoutil/{id}
   ##### Response:    
   * 204 : No Content
