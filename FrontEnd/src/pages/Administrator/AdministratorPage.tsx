import { Link } from "react-router-dom";
import Administrator from "../../components/Administrator/Administrator";
import {
  List,
  Heading,
  Button,
  Header,
  Navigation,
  MainContainer,
} from "../../components";
import useQueryAdministradoras from "../../hooks/Administrators/useQueryAdministradoras";
import Spinner from "../../components/Spinner/Spinner";

function AdministratorPage() {
  const { administradoras, administradorasQueryIsLoading } =
    useQueryAdministradoras();
  console.log(administradoras);

  return (
    <>
      <Header />
      <Navigation />
      <Heading>Administradoras</Heading>
      <MainContainer>
        <center>
          <Button color="white">
            <Link
              style={{ color: "var(--blue)", textDecorationLine: "none" }}
              to={"/administradoras/novo"}
            >
              Nova Administradora
            </Link>
          </Button>
        </center>
        <section>
          {administradorasQueryIsLoading && <Spinner />}
          <List>
            {administradoras?.map(
              (administrator: {
                nome: string;
                estado: string;
                cidade: string;
                descricao: string;
              }) => {
                const { nome, estado, cidade, descricao } = administrator;
                return (
                  <Administrator
                    key={nome}
                    nome={nome}
                    estado={estado}
                    cidade={cidade}
                    descricao={descricao}
                  />
                );
              }
            )}
          </List>
        </section>
      </MainContainer>
    </>
  );
}

export default AdministratorPage;
