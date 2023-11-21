import './Administrator.css'

type Administrator = {
    nome: string;
    estado: string;
    cidade: string;
    descricao: string;
}
function Administrator(props: Administrator) {
    const { nome, estado, cidade, descricao } = props; 
    return (
      <div className='c-administratorContainer'>
        <li className="c-administrator">
          <p className="c-administrator__name">{nome}</p>
          <p className="c-administrator__titleInfo">Estado</p>
          <p className='c-administrator__Info'>{estado}</p>
          <p className="c-administrator__titleInfo">Cidade</p>
          <p className='c-administrator__Info'>{cidade}</p>
          <p className="c-administrator__titleInfo">Descrição</p>
          <p className="c-administrator__description">{descricao}</p>
        </li>
      </div>
    );
}

export default Administrator;