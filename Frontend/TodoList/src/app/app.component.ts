import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,

} from '@angular/material/snack-bar';
import { Todo } from './models/todo';
import { HttpService } from './services/http.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  todoForm!: FormGroup;


  title = 'TodoList';
  todos: Todo[] = [];
  isEditMode: boolean = false;
  constructor(private snackBark: MatSnackBar, private formBuilder: FormBuilder, private httpService: HttpService,private http:HttpClient) {

  }

  ngOnInit(): void {
    this.todoForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      description: ['', Validators.required],
      completed: [''],
    });
    this.getTodo();
  }
  openSnackBar() {
    this.snackBark.open('Test', 'X', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: 2000,
    });


  }
  getTodo() {
    this.httpService.getTodo().subscribe(data => {
      this.todos = data;
    });
    // this.http.get('http://localhost:4200/getAllTodos')
    // .subscribe((response: any) => { this.todos = response; },
    //  (error: any) => { console.error('Error fetching todos:', error); });
  }
  // deleteTodo(id:number){
  //   this.httpService.deleteTodo(id).subscribe((data)=> {
  //     this.getTodo();
  //   })
  // }

  deleteTodo(id: number) { // Ensure id is a number
    const url = `http://localhost:8080/delete2/${id}`; // Correctly format the URL 
    this.http.delete(url).subscribe((response: any) => { 
      this.getTodo();
      console.log('Todo deleted successfully:', response); },
       (error: any) => { console.error('Error deleting todo:', error); });
  }

  updateTodo(todo:Todo){
    this.httpService.updateTodo(todo).subscribe((data) =>{
      this.getTodo();
      this.todoForm.reset();
    });
  }


  handleEdit(todo:Todo){
    this.isEditMode = true;
    delete todo.dateCreated;
    delete todo.lastUpdated;
    this.todoForm.setValue(todo);
 

  }

  onSubmit() {
    if (this.todoForm.invalid) {
      return;
    }
    const formValue: Todo = this.todoForm.value;
    if(this.isEditMode){
      this.updateTodo(formValue);

    }else{
     const todoRequest: Todo = {
      name: formValue.name,
      description: formValue.description,
      completed: false
    };
    this.httpService.createTodo(todoRequest).subscribe((data) => { 
      this.getTodo();
    });
  }
    
  }
}
