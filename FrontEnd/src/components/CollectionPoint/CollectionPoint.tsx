import { Link } from "react-router-dom";
import "./CollectionPoint.css";

type Material = {
  id: number;
  nome: string;
  cor: string;
  descricao: string;
};

type Administradora = {
  id: number;
  ativo: boolean;
  nome: string;
  cidade: string;
  estado: string;
  descricao: string;
};

type Ponto = {
  id: number;
  nome: string;
  descricao: string;
  latitude: number;
  longitude: number;
  logradouro: string;
  numero: number;
  bairro: string;
  estado: string;
  pais: string;
  cep: string;
  horario_inicio: string;
  horario_termino: string;
  funcionamento: string;
  administradora: Administradora;
  materiais: Material[];
};

// type Image = {
//   imgPath?: string;
//   imgAlt?: string;
// };

function CollectionPoint(props: { ponto: Ponto; hasMapLink?: boolean }) {
  const {
    nome,
    descricao,
    latitude,
    longitude,
    logradouro,
    numero,
    bairro,
    estado,
    pais,
    cep,
    horario_inicio,
    horario_termino,
    funcionamento,
    administradora,
    materiais,
  } = props.ponto;

  const { hasMapLink = true } = props;
  return (
    <div className="c-CP">
      <div className="c-CP__info">
        <div className="c-CP__info__main">
          <p className="c-CP__info__main__name">{nome}</p>
          <p className="c-CP__info__main__description">{descricao}</p>
        </div>

        <div className="c-CP__info__mapInfo">
          <div className="c-CP__info__mapInfo__lat">
            <p className="c-CP__info__mapInfo__lon__title c-CP__title">
              Latitude:
            </p>
            <p className="c-CP__info__mapInfo__lat__text">{latitude}</p>
          </div>
          <div className="c-CP__indo__mapInfo__lon">
            <p className="c-CP__info__mapInfo__lon__title c-CP__title">
              Longitude:
            </p>
            <p className="c-CP__info__mapInfo__lon__text">{longitude}</p>
          </div>
          {hasMapLink ? (
            <Link to={"/busca"}>
              <button className="c-CP__info__mapInfo__seeOnMap">
                Ver no Mapa
              </button>
            </Link>
          ) : (
            <></>
          )}
        </div>
        <div className="c-CP__info__administrator">
          <p className="c-CP__info__administrator__title c-CP__title">
            Administradora
          </p>
          <div className="c-CP__info__administrator__info">
            <img
              className="c-CP__info__administrator__info__image"
              src="./CollectionPoints/Embu_Brasao.png"
            />
            <div className="c-CP__info__administrator__info__main">
              <p className="c-CP__info__administrator__info__main__name">
                {administradora.nome}
              </p>
              <p className="c-CP__info__administrator__info__main__local">
                {administradora.cidade} - {administradora.estado}
              </p>
            </div>
          </div>
        </div>
        <div className="c-CP__info__materials">
          <p className="c-CP__info__materials__title c-CP__title">Materiais:</p>
          <div className="c-CP__info__materials__wrapper">
            {materiais.map((material) => {
              let divColor = material.cor;
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
                <div
                  className="c-CP__info__materials__single"
                  key={material.id}
                  style={{ backgroundColor: divColor }}
                >
                  <p className="c-CP__info__materials__text">{material.nome}</p>
                </div>
              );
            })}
          </div>
        </div>
      </div>
      <div className="c-CP__disponibility">
        <div className="c-CP__disponibility__wrapper1">
          <img
            className="c-CP__disponibility__wrapper1__image"
            src="./CollectionPoints/Coleta_Campinal.jpg"
            alt="Uma construção branca com formato de um T invertido. A paisagem possui um céu azul e uma grama amarelada."
          />
        </div>
        <div className="c-CP__disponibility__adressInfo">
          <p className="c-CP__disponibility__adressInfo__mainInfo">
            {logradouro}, {numero}
          </p>
          <p className="c-CP__disponibility__adressInfo__secondInfo">
            {bairro}, {estado}
          </p>
          <p className="c-CP-disponibility__adresInfo__otherInfo">
            {cep} - {pais}
          </p>
        </div>
        <div className="c-CP__disponibililty__Wrapper">
          <div className="c-CP__disponibility__wrapper2__funcionality">
            <p className="c-CP_disponibility__wrapper2__funcionality__title c-CP__title">
              Funcionalidade:
            </p>
            <p className="funcionality__days">{funcionamento}</p>
          </div>
          <div className="c-CP__disponibility__wrapper__hour">
            <div className="c-CP__disponibility__wrapper3__opening">
              <p className="c-CP__disponibility__wrapper3__opening__title c-CP__title">
                Abertura:
              </p>
              <p className="c-CP__disponibility__wrapper3__opening__info">
                {horario_inicio}
              </p>
            </div>
            <div className="c-CP__disponibility__wrapper3__closing">
              <p className="c-CP__disponibility__wrapper3__closing__title c-CP__title">
                Fechamento:
              </p>
              <p className="c-CP__disponibility__wrapper3__closing__info">
                {horario_termino}
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default CollectionPoint;
