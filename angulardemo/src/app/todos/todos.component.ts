import { Component } from '@angular/core';
import { Todo } from '../model/todo';

@Component({
  selector: 'app-todos',
  standalone: false,
  
  templateUrl: './todos.component.html',
  styleUrl: './todos.component.css'
})
export class TodosComponent {
  todolist:Todo[] = [];
  todo:string = '';
  lastid:number = 0;
  removeTodo(id:number){
    
    this.todolist = this.todolist.filter((item, index) => id !== item.id )

  }
  addTodo(){
    console.log('**'+this.todo===''+'**');
    
    if(this.todo !== '' && this.todo !== undefined){
      let todo = {id: ++this.lastid, title:this.todo}
      this.todolist.push(todo);
      this.todo=''
    }
  }

}
