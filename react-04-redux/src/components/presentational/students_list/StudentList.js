import StudentListItem from "../students_list_item/StudentListItem";
import AddStudentListItem from "../add_list_item/AddStudentListItem";
import {connect} from "react-redux";

function StudentList(props) {
    return (
        <div style={styles.listContainer}>
            <AddStudentListItem createStudent={(student) => props.createStudent(student)}/>
            {props.students && props.students.map( (student, id) =>
                <StudentListItem
                    key={id}
                    student={student}
                    deleteStudent={(link) => props.deleteStudent(link)}
                />)
            }
        </div>
    );
}

const mapStateToProps = state => ({
    students: state.students
})

const styles = {
    listContainer: {
        backgroundColor: "navy",
        padding: 10
    }
}

export default connect(mapStateToProps)(StudentList);