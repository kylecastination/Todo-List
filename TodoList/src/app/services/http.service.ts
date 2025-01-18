import { Injectable } from '@angular/core';
import { Todo } from '../models/todo';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class HttpService {
    todoApi='/getAllTodos';
    createApi='/create';
    todos:Todo[]=[];
  constructor(private httpClient: HttpClient) { }
  createTodo(todo:Todo): Observable<Todo>{
    return this.httpClient.post<Todo>("http://localhost:8080/create",todo);
  }
  getTodo():Observable<Todo[]>{ 
    return this.httpClient.get<Todo[]>("http://localhost:8080/getAllTodos").pipe(map((data)=>{
      this.todos=data;
      return this.todos;
    }
    ));
  }
  deleteTodo(id:number):Observable<Todo>{
    return this.httpClient.delete<Todo>("http://localhost:8080/delete2/${id}");
  }

  updateTodo(todo:Todo) :Observable<Todo>{
    
    return this.httpClient.put<Todo>("http://localhost:8080/update",todo)
  }
}

// interface GetTodoResponse{
// _embedded:{
//   todos:Todo[];
// }
//}