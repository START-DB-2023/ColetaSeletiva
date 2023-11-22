import { Link } from "react-router-dom";
import "./Navigation.css";
function Navigation() {
  return (
    <div>
      <nav className="c-navigation">
        <ul className="c-navigation__list">
          <li className="c-navigation__item">
            <Link to="/">Home</Link>
          </li>
          <li className="c-navigation__item">
            <Link to="/busca">Busca</Link>
          </li>
          <li className="c-navigation__item">
            <Link to={"/materiais"}>Materiais</Link>
          </li>
          <li className="c-navigation__item">
            <Link to={"/administradoras"}>Administradoras</Link>
          </li>
          <li className="c-navigation__item">
            <Link to={"/pontos"}>Pontos de Coleta</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
}
export default Navigation;
