function MateriaisPage() {
  return (
    <>
      <h2>Materiais</h2>
      <section>
        <ul>
          <Material
            nome="Metal"
            cor="Amarelo"
            descricao="Resíduos magnéticos"
          />
        </ul>
      </section>
    </>
  );
}

function Material(props: { nome: string; cor: string; descricao: string }) {
  return (
    <li>
      <p>
        {props.nome} - {props.cor} - {props.descricao}
      </p>
    </li>
  );
}

export default MateriaisPage;
