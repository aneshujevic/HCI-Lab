import {useEffect, useState} from 'react';
import StudentList from "../presentational/students_list/StudentList";

const axios = require('axios');

function MainContainer() {
    const [state, setState] = useState({
        students: [],
        departments: []
    });


    useEffect(() => {
            const fetchStudents = async () => {
                const studentsResponse = await axios.get('http://localhost:8080/student');
                return studentsResponse.data._embedded.student
            }
            const fetchDepartments = async () => {
                const departmentsResponse = await axios.get('http://localhost:8080/department');
                return departmentsResponse.data._embedded.department
            }

            fetchDepartments().then(
                departments => {
                    fetchStudents().then(
                        students => setState({students: students, departments: departments})
                    );
                }
            );
        }, []
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
                <StudentList globalState={state} setGlobalState={setState}/>
            </div>
        </div>
    );
}

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

export default MainContainer;
