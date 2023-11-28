import { ReactElement } from "react";
import { normalizeColorName } from "../../utils/normalizeColorName";
import "./Material.css";

type Material = {
  nome: string;
  cor: string;
  descricao: string;
  children?: ReactElement | ReactElement[];
};

function Material(props: Material) {
  const { nome, cor, descricao, children } = props;
  let divColor = cor;
    switch (divColor) {
      case "AMARELO":
        divColor = "#c4b53d";
        break;
      case "VERDE":
        divColor = "#3B7732";
        break;
      case "AZUL":
        divColor = "#4460F4";
        break;
      case "VERMELHO":
        divColor = "#FF3B3B";
        break;
      case "CINZA":
        divColor = "#333";
        break;
      case "MARROM":
        divColor = "#964B00";
        break;
      case "ROXO":
        divColor = "#800080";
        break;
      case "LARANJA":
        divColor = "#FFA500";
        break;
      case "BRANCO":
        divColor = "#ddd";
        break;
      case "PRETO":
      default:
        divColor = "#000";
        break;
    }
  return (
    <li className="c-material">
      <div className="c-material__edit">
        <p className="c-material__name">{nome}</p>
        {children}
      </div>
      <div className="c-material__color">
        <p className="c-material__color__title">Cor</p>
        <div className="c-material__color__wrapper">
          <div className="c-material__color__example" style={{backgroundColor: divColor}}></div>
          <p className="c-material__color__info">{normalizeColorName(cor)}</p>
        </div>
      </div>
      <div className="c-material__description">
        <p className="c-material__description__title">Descrição</p>
        <p className="c-material__description__info">{descricao}</p>
      </div>
    </li>
  );
}

export default Material;
