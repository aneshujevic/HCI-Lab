import {useState} from 'react';

function AddStudentListItem(props) {
    const [student, setStudent] = useState({
        name: null,
        surname: null,
        gender: null,
        department: null
    });

    return (
        <form onSubmit={(event) =>  {
            // ovde bismo ubacili logiku za validaciju
            props.createStudent(student);
            event.preventDefault();
        }}>
            <input
                placeholder="Unesite ime"
                onChange= {
                    e => setStudent({...student, name: e.target.value})
                }
            /> &nbsp;
            <input
                placeholder="Unesite prezime"
                onChange={
                    e => setStudent({...student, surname: e.target.value})
                }
            /> &nbsp;
            <input
                placeholder="Unesite pol"
                onChange={
                    e => setStudent({...student, gender: e.target.value})
                }
            /> &nbsp;
            <input
                placeholder="Unesite departman"
                onChange={
                    e => setStudent({...student, department: e.target.value})
                }
            /> &nbsp;

            <input type="submit" value="Dodaj studenta" style={{margin: 5}} />
        </form>
    )
}

export default AddStudentListItem;