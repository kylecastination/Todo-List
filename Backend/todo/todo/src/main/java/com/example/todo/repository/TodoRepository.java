package com.example.todo.repository;

import com.example.todo.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoRepository extends JpaRepository< Todo, Integer> {

    //public ResponseEntity<List<Todo>>findAll();
    }