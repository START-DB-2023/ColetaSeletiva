import { Link } from "react-router-dom";
import Material from "../../components/Material/Material";
import { List, Heading, Button } from "../../components";
import useQueryMateriais from "../../hooks/useQueryMateriais";

function MateriaisPage() {
  const { materiais, materiaisQueryIsLoading } = useQueryMateriais();
  console.log(materiais);

  return (
    <>
      <Heading color="#31357f">Materiais</Heading>
      <center>
            <Button color="white">
                <Link style={{color: "var(--blue)", textDecorationLine: 'none'}} to={"/materiais/novo"}>
                    Novo Material
                </Link>
            </Button>
          </center>
      <section>
        {materiaisQueryIsLoading && <p>Carregando informações</p>}
        <List>
          {materiais?.map(
            (material: { nome: string; cor: string; descricao: string }) => {
              const { nome, cor, descricao } = material;
              return (
                <Material
                  key={nome}
                  nome={nome}
                  cor={cor}
                  descricao={descricao}
                />
              );
            }
          )}
        </List>
      </section>
    </>
  );
}

export default MateriaisPage;
