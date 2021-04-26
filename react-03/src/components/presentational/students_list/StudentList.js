import StudentListItem from "../students_list_item/StudentListItem";
import AddStudentListItem from "../add_list_item/AddStudentListItem";

function StudentList(props) {
    return (
        <div style={styles.listContainer}>
            <AddStudentListItem globalState={props.globalState} setGlobalState={props.setGlobalState}/>
            {props.globalState && props.globalState.students.map( (student, id) =>
                <StudentListItem
                    key={id}
                    student={student}
                />)
            }
        </div>
    );
}

const styles = {
    listContainer: {
        backgroundColor: "navy",
        padding: 10
    }
}

export default StudentList;