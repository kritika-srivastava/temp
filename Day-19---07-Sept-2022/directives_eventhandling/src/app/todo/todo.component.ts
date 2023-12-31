import { Component, OnInit } from '@angular/core';
import { Todo } from '../models/Todo';


@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})

export class TodoComponent implements OnInit {
  // todoList contains all todos
  todoList: Todo[] = [];
  constructor() { }
  i?: number;
  ngOnInit() {
    this.i = 1;

  }
  // write logic to the onAddTodo method is to add a new todo to list
  // get maximum id in list and assign maximum id plus one while adding a todo
  onAddTodo(todoText: any) {
    if (typeof todoText == 'string' && todoText != '') {
      this.todoList.push({ todoId: this.i, text: todoText, isCompleted: false });
      this.i = this.i + 1;
    }
    else if (typeof todoText == 'object') {
      this.todoList.push(todoText);
      this.i = this.i + 1;
    }
    else { }

  }

  // write logic to the onClearTodos method to delete the all todos in the todoList
  onClearTodos() {
    this.todoList = [];
  }

  // write logic to method onCompletingTask, to mark todo as as completed or not
  onCompletingTodo(todo: Todo) {
    todo.isCompleted = true;
  }

  // write logic to method onDeletingTask, to delete the todo
  onDeletingTodo(todoId: number) {
    let index = this.todoList.findIndex(obj => obj.todoId == todoId);
    // console.log(index);

    this.todoList.splice(index, 1);
  }
}
