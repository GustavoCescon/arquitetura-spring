package io.github.gustavocescon.arquiteturaspring;

import io.github.gustavocescon.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws Exception {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/seubanco");
        dataSource.setUsername("seu_usuario");
        dataSource.setPassword("sua_senha");
        Connection connection = dataSource.getConnection();


        EntityManager entityManager = null;

        TodoRepository repository = null; //new SimpleJpaRepository<TodoEntity, Integer>(null, null );

        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender mainSender = new MailSender();
        TodoService todoService = new TodoService(repository, todoValidator, mainSender);
    }
}
