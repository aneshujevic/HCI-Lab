import TodoListItem from "../todo_list_item/TodoListItem";
import AddListItem from "../add_list_item/AddListItem";
import {useState} from "react";

function TodoList() {
    const [tasks, setTasks] = useState(["napisi kod", "kompajluj kod"])

    return (
        <div style={styles.listContainer}>
            {tasks && tasks.map(
                (task, id) =>
                <TodoListItem
                    key={id}
                    id={id + 1}
                    task={task}
                    deleteTask={
                        () => setTasks([...tasks].filter(x => x !== task))
                    }
                /> )
            }
            <AddListItem tasks={tasks} setTasks={setTasks}/>
        </div>
    );
}

const styles = {
    listContainer: {
        backgroundColor: "navy",
        padding:10
    }
}

export default TodoList;