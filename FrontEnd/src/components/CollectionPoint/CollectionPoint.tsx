import "./CollectionPoint.css";

type CollectionPoint = {
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
  administradoraId: number;
  materiaisIds: number[];
}

function CollectionPoint(props: CollectionPoint) {
    const { nome, descricao, latitude, longitude, logradouro, numero, bairro, estado, pais, cep, horario_inicio, horario_termino, funcionamento, administradoraId, materiaisIds } = props;
    return(
        <div className='c-pointContainer'>
          <li className="c-point">
            <p className="c-point__name">{nome}</p>
            <p>{descricao}</p>
            <p>Lat: {latitude} | Lon: {longitude}</p>
            <p>Pais: {pais} | Estado: {estado} | Bairro: {bairro}</p>
            <p>Logradouro: {logradouro} | N°: {numero}</p>
            <p>CEP: {cep}</p>
            <p>Administradora: {administradoraId}</p>
            <p>Funcionamento: {funcionamento}</p>
            <p>Abertura: {horario_inicio} | Fechamento: {horario_termino}</p>
            <p>Materiais Coletados: {materiaisIds}</p>
          </li>
        </div>
    );
}

export default CollectionPoint;