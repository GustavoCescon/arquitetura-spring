package io.github.gustavocescon.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity save(@RequestBody TodoEntity todoEntity){
        try{
            return this.service.save(todoEntity);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("{id}")
    public void updateStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);
        this.service.updateStatus(todo);
    }

    @GetMapping("{id}")
    public TodoEntity search(@PathVariable("id") Integer id){
        return this.service.findById(id);
    }

}
