import './NasaKomponenta.css';

function NasaKomponenta(props) {

    if (props.prikaziH3) {
        return <h3 className="klasa">Hello, {props.prosledjenaVrednost}!
        </h3>;
    } else {
        return <h1 className="klasa">
            Pozdrav, {props.prosledjenaVrednost}!
            <button onClick={
                () => {
                    alert("Kliknuto je dugme " + props.prosledjenaVrednost)
                }
            }>
                Click me
            </button>
        </h1>;
    }
}

export default NasaKomponenta;