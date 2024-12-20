package io.github.gustavocescon.arquiteturaspring;
import io.github.gustavocescon.arquiteturaspring.todos.TodoEntity;
import io.github.gustavocescon.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

//singleton
@Component
//@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope("singleton")
//@Scope("request")
//@Scope("session")
//@Scope("application")
//@Lazy(true)
public class BeanGerenciado {

    private String idUsuarioLogado;

    @Autowired
    private TodoValidator validator;

    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validate(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator){
        this.validator = validator;
    }
}
