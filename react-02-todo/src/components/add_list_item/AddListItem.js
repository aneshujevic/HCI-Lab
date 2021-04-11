import {useRef} from 'react';

function AddListItem(props) {
    const inputValue = useRef(null);

    return (
        <div>
            <input placeholder="Unesite zadatak" ref={inputValue} />
            <button onClick={ _ => {
                props.setTasks([...props.tasks, inputValue.current.value]);
            } } style={{margin: 5}}> Dodaj zadatak </button>
        </div>
    )
}

export default AddListItem;