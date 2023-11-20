import { Link } from "react-router-dom";
import { List, Material, Heading } from "../../components";
import useQueryMateriais from "../../hooks/useQueryMateriais";

function MateriaisPage() {
  const { materiais, materiaisQueryIsLoading } = useQueryMateriais();
  console.log(materiais);

  return (
    <>
      <Link to={"/materiais/novo"}>Novo material</Link>
      <Heading>Materiais</Heading>
      <section>
        {materiaisQueryIsLoading && <p>Carregando informações</p>}
        <List>
          {materiais?.map(
            (material: { nome: string; cor: string; descricao: string }) => {
              const { nome, cor, descricao } = material;
              return <Material nome={nome} cor={cor} descricao={descricao} />;
            }
          )}
        </List>
      </section>
    </>
  );
}

export default MateriaisPage;
