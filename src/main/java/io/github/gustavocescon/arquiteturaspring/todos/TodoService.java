package io.github.gustavocescon.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository repository, TodoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity save(TodoEntity novoTodo){
        this.validator.validate(novoTodo);

        return this.repository.save(novoTodo);
    }

    public void updateStatus(TodoEntity todo){
        this.repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
        this.mailSender.send("Todo " + todo.getDescricao() + "foi atualizado para " + status);
    }


    public TodoEntity findById(Integer id){
        return this.repository.findById(id).orElse(null);
    }
}
