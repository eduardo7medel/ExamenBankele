import logo from './logo.svg';
import './App.css';
import { useState } from "react"
import { sendRequest } from "./api/request"

function App() {
  const headers = (
         <div style={{flexDirection: "row"}}>
          <label style={style.div}>
            Cuota
          </label>
          <label style={style.div}>
            Valor Cuota
          </label>
          <label style={style.div}>
            Intereses
          </label>
          <label style={style.div}>
            Capital Amortizado
          </label>
          <label style={style.div}>
            Capital Vivo
          </label>
        </div>
  )
  const [response, setresponse] = useState(null)

  const handleSubmit = async () => {
    const amount = document.getElementById("amount")
    const type = document.getElementById("type")
    const body = {
      montoSolicitado: (amount.value.includes(".")) ? amount.value : amount.value+".00",
      periodicidad: type.value
    }
    
    const r = await sendRequest(body);
	console.log(r)
    setresponse(
      r.map((item, index) => (
        <div style={{flexDirection: "row"}}>
          <label style={style.div}>
            {index+1}
          </label>
          <label style={style.div}>
            {item.cuota}
          </label>
          <label style={style.div}>
            {item.interes}
          </label>
          <label style={style.div}>
            {item.capitalAmortizado}
          </label>
          <label style={style.div}>
            {item.capitalVivo}
          </label>
        </div>
      ))
    )
  }



  return (
    <div>
      <div className="App">
          <label style={{padding: 10}}>
            Monto:
            <input type="numeric" id="amount" />
          </label>
          <label>
            Tipo:
            <select id="type">
              <option selected value="A">Anual</option>
              <option value="S">Semestral</option>
              <option value="C">Cuatrimestral</option>
              <option value="T">Trimestral</option>
              <option value="B">Bimensual</option>
              <option value="M">Mensual</option>
            </select>
          </label>
          <button onClick={handleSubmit} style={{margin: 10}}>
            Consultar
          </button>
      </div>
      <div style={{flexDirection: "column"}}>
        {headers}
        {response}
      </div>
    </div>
  );
}

export default App;

const style = {
  div:{
    margin: 10,
    padding: 10,
    width: "80px",
  }
}