package dev.codeio.helloworld.service;

import dev.codeio.helloworld.Models.Todo;
import dev.codeio.helloworld.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

   public Todo createTodo(Todo todo){
       return toDoRepository.save(todo);
   }

   public Todo getTodoById(Long id){
       return toDoRepository.findById(id).orElseThrow(()-> new RuntimeException("todo not found"));
   }
   
   public Page<Todo> GetAllPagetodos(int page, int size){
       Pageable pageable= PageRequest.of(page,size);
       return toDoRepository.findAll(pageable);
   }

   public List<Todo> getTodos(){
       return toDoRepository.findAll();
   }

   public Todo updatetodo(Todo todo){
       return toDoRepository.save(todo);
   }

    public void deleteTodoById (long id){
        toDoRepository.delete(getTodoById(id));
    }

    public void deleteTodo(Todo todo){
        toDoRepository.delete(todo);
    }
}
