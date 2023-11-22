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
      <p className="c-material__name">{nome}</p>
      <p className="c-material__color">
        Cor de referência: {normalizeColorName(cor)}
      </p>
      <p className="c-material__description">{descricao}</p>
      {children}
    </li>
  );
}

export default Material;
