import {useEffect} from 'react';
import StudentList from "../presentational/students_list/StudentList";
import {createStudentApi, deleteStudentApi, fetchDepartmentsApi, fetchStudentsApi} from "../../state/api";
import {connect} from "react-redux";

function MainContainer(props) {
    const state = props.state;
    const {getDepartments, getStudents} = props;

    useEffect(() => {
        getDepartments();
        getStudents();
        }, [getDepartments, getStudents]
    )

    return (
        <div style={styles.containerStyle}>
            <div style={styles.leftCol}>
                <h1>departments</h1>
                <ul>
                    {state.departments && state.departments.map((department, id) =>
                        <li key={id}>
                            Ime departmana: {department.name}<br/>
                            Link:
                            <a href={department._links.self.href}>
                                {department._links.self.href}
                            </a>
                        </li>
                    )}
                </ul>
            </div>

            <div style={styles.rightCol}>
                <h1>students</h1>
                <StudentList createStudent={props.createStudent} deleteStudent={props.deleteStudent}/>
            </div>
        </div>
    );
}

const mapStateToProps = state => ({
    state: state
});

const mapDispatchToProps = dispatch => ({
    getStudents: () => dispatch(fetchStudentsApi()),
    getDepartments: () => dispatch(fetchDepartmentsApi()),
    deleteStudent: (studLink) => dispatch(deleteStudentApi(studLink)),
    createStudent: (student) => dispatch(createStudentApi({student: student}))
})

const styles = {
    containerStyle: {
        display: "flex",
        flexDirection: "row",
    },
    leftCol: {
        flex: 1,
        textAlign: "center"
    },
    rightCol: {
        flex: 2,
        textAlign: "center"
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(MainContainer);
