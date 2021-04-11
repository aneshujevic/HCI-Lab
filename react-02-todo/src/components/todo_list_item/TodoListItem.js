
function TodoListItem(props) {
    return (
      <div style={styles.containerStyle}>
          <span style={styles.spanStyle}>{props.id}: {props.task}</span> <br/><br/>
          <button onClick={() => props.deleteTask()}>Delete me</button>
      </div>
    );
}

const styles = {
    containerStyle: {
        backgroundColor: "blue",
        padding: 25,
        margin: 15
    },
    spanStyle: {
        color: "white"
    }
};

export default TodoListItem;