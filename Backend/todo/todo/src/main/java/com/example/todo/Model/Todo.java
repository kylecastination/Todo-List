package com.example.todo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table (name ="TODO_APP")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name ="id")
    private int id ;
    @Column(name ="name")
    private String  name ;
    @Column(name ="description")
    private String description ;
    @Column(name ="completed")
   private boolean completed ;
    @Column(name ="date_created")
   private Date dateCreated ;
    @Column(name ="last_updated")
   private Date lastUpdated ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
