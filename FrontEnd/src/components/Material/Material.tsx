import { normalizeColorName } from "../../utils/normalizeColorName";
import "./Material.css";
type Material = {
  nome: string;
  cor: string;
  descricao: string;
};

function Material(props: Material) {
  const { nome, cor, descricao } = props;
  return (
    <li className="c-material">
      <p className="c-material__name">{nome}</p>
      <p className="c-material__color">
        Cor de referência: {normalizeColorName(cor)}
      </p>
      <p className="c-material__description">{descricao}</p>
    </li>
  );
}

export default Material;
