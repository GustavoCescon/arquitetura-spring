package io.github.gustavocescon.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validate(TodoEntity todo){
        if(this.existsTodoWithDescription(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe um TODO com esta descrição !");
        }
    }

    private boolean existsTodoWithDescription(String descricao){
        return this.repository.existsByDescricao(descricao);
    }
}
