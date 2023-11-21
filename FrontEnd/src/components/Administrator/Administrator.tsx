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
        <li className="c-administrator">
          <p className="c-administrator__name">{nome}</p>
          <p className="c-administrator__state">
            Estado: {estado}
          </p>
          <p className='c-administrator__city'>
            Cidade: {cidade}
          </p>
          <p className="c-administrator__description">{descricao}</p>
        </li>
    );
}

export default Administrator;