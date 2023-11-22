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

function CollectionPoint(props: { ponto: Ponto }) {
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
  return (
    <div className="c-pointContainer">
      <li className="c-point">
        <p className="c-point__name">{nome}</p>
        <p>{descricao}</p>
        <p>
          Lat: {latitude} | Lon: {longitude}
        </p>
        <p>
          Pais: {pais} | Estado: {estado} | Bairro: {bairro}
        </p>
        <p>
          Logradouro: {logradouro} | N°: {numero}
        </p>
        <p>CEP: {cep}</p>
        <div>
          <p>Administradora {administradora.nome}</p>
          <p>Status {administradora.ativo ? "Ativa" : "Desativada"}</p>
          <p>Cidade: {administradora.cidade}</p>
          <p>Estado: {administradora.estado}</p>
          <p>Descrição: {administradora.descricao}</p>
        </div>
        <p>Funcionamento: {funcionamento}</p>
        <p>
          Abertura: {horario_inicio} | Fechamento: {horario_termino}
        </p>
        <p>Materiais Coletados:</p>
        {materiais.map((material) => {
          return (
            <div key={material.id}>
              <p>
                {material.nome} - {material.cor}
              </p>
              <p>{material.descricao}</p>
            </div>
          );
        })}
      </li>
    </div>
  );
}

export default CollectionPoint;
