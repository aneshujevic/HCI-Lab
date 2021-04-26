const axios = require('axios');

function StudentListItem(props) {
    return (
        <div style={styles.containerStyle}>
            <span style={styles.spanStyle}>Name: {props.student.name}</span> <br/>
            <span style={styles.spanStyle}>Surname: {props.student.surname}</span> <br/>
            <span style={styles.spanStyle}>Gender: {props.student.gender}</span> <br/>
            <span style={styles.spanStyle}>
              Department: &nbsp;
                <a style={{color: "white"}} href={props.student._links.department.href}>
                    {props.student._links.department.href}
                </a>
          </span> <br/>

            <button onClick={() => {
                const studentLink = props.student._links.self.href;
                // state se ne azurira magicno, potrebno je dodati logiku za azuriranje state-a
                // nakon brisanja odredjenog studenta
                axios.delete(studentLink);
            }}>Izbrisi studenta
            </button>
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

export default StudentListItem;