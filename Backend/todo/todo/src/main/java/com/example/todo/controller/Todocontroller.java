package com.example.todo.controller;

import com.example.todo.Model.Todo;
import com.example.todo.service.Todoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin (origins = "*")
@RestController
public class Todocontroller {

   @Autowired
    Todoservice service ;
    @GetMapping("/getAllTodos")
    public ResponseEntity< List<Todo>> getAll() {
       // System.out.println("inside getalltodos");
        return new ResponseEntity<>(service.getAllTodos(), HttpStatus.OK);

    }

    @PostMapping("/create/{name}/{description}")
    public Todo createTodo(@PathVariable String name ,  @PathVariable String description){
        return service .createTodo(name ,description) ;
    }

    @PostMapping("/create")
    public Todo createTodo2(@RequestBody Todo todo){
        System.out.println("inside create");
        return service .createTodo2(todo) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable int id){
        String string = service.deleteTodo(id);
        if(string == "Success") {
            return new ResponseEntity<>(string, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(string , HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/delete2/{id}")
    public void deleteTodo2(@PathVariable int id){
        System.out.println("Inside Delete");
         service.deleteTodo(id);

    }

    @PutMapping("/update")
    public void updateTodo( @RequestBody Todo todo ){
       service.updateTodo(todo);
    }
    @GetMapping("/getbyid/{id}")
        public Todo getbyId(@PathVariable int id){
        return service.getbyId(id);

    }
    @GetMapping("/getbyid2/{id}")
    public ResponseEntity<Todo> getbyId2(@PathVariable int id){
        Todo obj = new Todo();
         obj = service.getbyId(id);
         return new ResponseEntity<>(obj , HttpStatus.OK);

    }
}

