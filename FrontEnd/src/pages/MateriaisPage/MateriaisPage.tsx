import useQueryMateriais from "../../hooks/useQueryMateriais";

function MateriaisPage() {
  const { materiais, materiaisQueryIsLoading } = useQueryMateriais();
  console.log(materiais);

  return (
    <>
      <h2>Materiais</h2>
      <section>
        {materiaisQueryIsLoading && <p>Carregando informações</p>}
        <ul>
          {materiais?.map(
            (material: { nome: string; cor: string; descricao: string }) => {
              const { nome, cor, descricao } = material;
              return <Material nome={nome} cor={cor} descricao={descricao} />;
            }
          )}
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
