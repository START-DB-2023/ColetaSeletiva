import { Link } from "react-router-dom";
import Administrator from "../../components/Administrator/Administrator";
import { List, Heading, Button} from "../../components";
import useQueryAdministradoras from "../../hooks/useQueryAdministradoras";

function AdministratorPage() {
    const { administradoras, administradorasQueryIsLoading} = useQueryAdministradoras();
    console.log(administradoras);

    return (
        <>
          <Heading color="#31357f">Administradoras</Heading>
          <center>
            <Button color="white">
                <Link style={{color: "var(--blue)", textDecorationLine: 'none'}} to={"/administradoras/novo"}>
                    Nova Administradora
                </Link>
            </Button>
          </center>
          <section>
            {administradorasQueryIsLoading && <p>Carregando Informações</p>}
            <List>
                {administradoras?.map(
                    (administrator: { nome: string; estado: string, cidade: string, descricao: string}) => {
                        const { nome, estado, cidade, descricao} = administrator;
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
        </>
    );
}

export default AdministratorPage;