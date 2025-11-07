package dev.codeio.helloworld.controller;

import dev.codeio.helloworld.Models.Todo;
import dev.codeio.helloworld.service.ToDoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private ToDoService toDoService;

    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description="Todos received "),
            @ApiResponse(responseCode = "404", description ="Todo was not found")
    }
    )
    @GetMapping("/{id}")
    ResponseEntity<Todo> GetTodoById(@PathVariable long id){
        try {
            Todo createtodo= toDoService.getTodoById(id);
            return new ResponseEntity<>(createtodo, HttpStatus.CREATED);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    ResponseEntity< List<Todo>> getTodos(){
        return new ResponseEntity<List<Todo>>(toDoService.getTodos(),HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> GetAlltodopages(@RequestParam int page,@RequestParam int size){
        return new ResponseEntity<>(toDoService.GetAllPagetodos(page,size),HttpStatus.OK);
    }



    @PostMapping ("/create")
    ResponseEntity<Todo> createuser(@RequestBody Todo todo){
        Todo createtodo= toDoService.createTodo(todo);
        return new ResponseEntity<>(toDoService.createTodo(todo), HttpStatus.CREATED);
    }

    @PutMapping("/todo/{id}")
    ResponseEntity<Todo> updatetodoid(@PathVariable long id, @RequestBody Todo todo){
        return new ResponseEntity<>(toDoService.updatetodo(todo),HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    void deletetodoid(@PathVariable long id){
       toDoService.deleteTodoById(id);
    }


}
