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
  return (
    <li className="c-material">
      <div className="c-material__edit">
        <p className="c-material__name">{nome}</p>
        {children}
      </div>
      <div className="c-material__color">
        <p className="c-material__color__title">Cor</p>
        <div className="c-material__color__wrapper">
          <div className="c-material__color__example"></div>
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
