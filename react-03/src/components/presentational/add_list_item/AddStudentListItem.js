import {useRef} from 'react';

const axios = require('axios');

function AddStudentListItem(props) {
    // ovo je losa praksa, ne treba koristiti useRef toliko cesto
    // primer bolje implementacije bi bio pomocu formi
    const nameValue = useRef(null);
    const surnameValue = useRef(null);
    const departmentValue = useRef(null);
    const genderValue = useRef(null);

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

                axios.post("http://localhost:8080/student", student)
                    .then(resp => {
                    props.setGlobalState({
                        ...props.globalState,
                        students: [...props.globalState.students, student]
                    });
                })
            }} style={{margin: 5}}> Dodaj studenta
            </button>
        </div>
    )
}

export default AddStudentListItem;