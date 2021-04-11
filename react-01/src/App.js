import logo from './logo.svg';
import './App.css';
import NasaKomponenta from "./components/NasaKomponenta/NasaKomponenta";

function App() {
  const x = "Softversko inzenjerstvo";
  const y = [1, 2, 3, 4, 5, 6, 7, 10];

  return (
      y.map(vrednost =>
        <NasaKomponenta
            key={vrednost}
            prosledjenaVrednost={vrednost}
            prikaziH3={false}
        />
      )
  );
}



export {App};
