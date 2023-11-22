import { Link } from "react-router-dom";
import Material from "../../components/Material/Material";
import {
  List,
  Heading,
  Button,
  MainContainer,
  Navigation,
  Header,
} from "../../components";
import useQueryMateriais from "../../hooks/useQueryMateriais";
import Spinner from "../../components/Spinner/Spinner";

function MateriaisPage() {
  const { materiais, materiaisQueryIsLoading } = useQueryMateriais();
  console.log(materiais);

  return (
    <>
      <Header />
      <Navigation />
      <MainContainer>
        <Heading color="#31357f">Materiais</Heading>
        <center>
          <Button color="white">
            <Link
              style={{ color: "var(--blue)", textDecorationLine: "none" }}
              to={"/materiais/novo"}
            >
              Novo Material
            </Link>
          </Button>
        </center>
        <section>
          {materiaisQueryIsLoading && <Spinner />}
          <List>
            {materiais?.map(
              (material: {
                id: number;
                nome: string;
                cor: string;
                descricao: string;
              }) => {
                const { id, nome, cor, descricao } = material;
                return (
                  <>
                    <Material
                      key={id}
                      nome={nome}
                      cor={cor}
                      descricao={descricao}
                    >
                      <Button color="yellow">
                        <Link to={`/materiais/editar/${id}`}>Editar ✏️</Link>
                      </Button>
                    </Material>
                  </>
                );
              }
            )}
          </List>
        </section>
      </MainContainer>
    </>
  );
}

export default MateriaisPage;
