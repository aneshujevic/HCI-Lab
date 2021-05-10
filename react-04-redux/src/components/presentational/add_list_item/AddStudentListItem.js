import {useRef} from 'react';
import {createStudentApi} from "../../../state/api";
import {connect, useDispatch} from "react-redux";

function AddStudentListItem(props) {
    // ovo je losa praksa, ne treba koristiti useRef toliko cesto
    // primer bolje implementacije bi bio pomocu formi
    const nameValue = useRef(null);
    const surnameValue = useRef(null);
    const departmentValue = useRef(null);
    const genderValue = useRef(null);
    const dispatch = useDispatch();

    return (
        <div>
            <input placeholder="Unesite ime" ref={nameValue}/> &nbsp;
            <input placeholder="Unesite prezime" ref={surnameValue}/> &nbsp;
            <input placeholder="Unesite pol" ref={genderValue}/> &nbsp;
            <input placeholder="Unesite departman" ref={departmentValue}/> &nbsp;

            <button onClick={_ => {
                const student = {
                    name: nameValue.current.value,
                    surname: surnameValue.current.value,
                    gender: genderValue.current.value,
                    department: departmentValue.current.value
                }
                props.createStudent(student);
            }} style={{margin: 5}}> Dodaj studenta
            </button>
        </div>
    )
}

const mapDispatchToProps = dispatch => ({
    createStudent: (student) => dispatch(createStudentApi({student: student}))
});

export default connect(null, mapDispatchToProps)(AddStudentListItem);