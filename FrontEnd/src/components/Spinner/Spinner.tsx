import "./Spinner.css";
function Spinner() {
  return (
    <div className="c-spinner">
      <p>Carregando informações...</p>
      <p className="c-spinner__icon a-rotate-center">♻️</p>
    </div>
  );
}

export default Spinner;
