package com.example.todo.service;

import com.example.todo.Model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class Todoservice {
    @Autowired
    TodoRepository repo ;

    public List<Todo> getAllTodos(){
        return repo.findAll();
    }
    public Todo createTodo(String name ,String description){

        Todo todo = new Todo();
        todo.setName(name);
        todo.setDescription(description);
        todo.setCompleted(false);
        todo.setDateCreated(Date.valueOf(LocalDate.now()));
        todo.setLastUpdated(Date.valueOf(LocalDate.now()));
        repo.save(todo);
        return todo ;
    }
    public Todo createTodo2(Todo todo){

        todo.setDateCreated(Date.valueOf(LocalDate.now()));
        todo.setLastUpdated(Date.valueOf(LocalDate.now()));
        repo.save(todo);
        return todo ;
    }
    public String deleteTodo(int id){
        Todo todoobj =new Todo() ;
        Optional<Todo> optional = repo.findById(id);
        if(optional.isEmpty()){

            return "Failed";
        }
        todoobj = optional.get() ;

         repo.deleteById(id);
         return "Success" ;



    }
    public void updateTodo(  Todo todo ){
        Todo todoobj = new Todo();
      Optional<Todo> optional= repo.findById(todo.getId());
      todoobj = optional.get();
     todoobj.setId(todo.getId());
//     todoobj.setLastUpdated(Date.valueOf(LocalDate.now()));

        todoobj.setName(todo.getName());
        todoobj.setDescription(todo.getDescription());
        todoobj.setCompleted(todo.isCompleted());
        todoobj.setLastUpdated(todo.getLastUpdated());
        repo.save(todoobj) ;
    }

    public Todo getbyId(int id){

       Optional<Todo> opt= repo.findById(id);
       if(opt.isEmpty()){
          return new Todo();
       }
       return opt.get();

    }

}
