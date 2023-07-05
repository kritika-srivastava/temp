// Data model for Todo
export class Todo {
    todoId?: number;
    text?: string;
    isCompleted?: boolean;

    constructor(opt: {
        todoId?: number, text?: string, isCompleted?: boolean
    }) {
        this.todoId = opt.todoId;
        this.text = opt.text;
        this.isCompleted = false;
    }
}
