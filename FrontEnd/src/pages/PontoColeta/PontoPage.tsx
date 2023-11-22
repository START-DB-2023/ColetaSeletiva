import { Link } from "react-router-dom";
import CollectionPoint from "../../components/CollectionPoint/CollectionPoint";
import { 
  List, 
  Heading, 
  Button, 
  Header, 
  Navigation, 
  MainContainer, 
} from "../../components";
import useQueryPonto from "../../hooks/CollectionPoint/useQueryPonto";

function PontoPage() {
    const { pontos, pontosQueryIsLoading} = useQueryPonto();
    console.log(pontos);

    return(
      <>
        <Header />
        <Navigation />
        <Heading color="#31357f">Pontos de Coleta</Heading>
        <MainContainer>
          <center>
            <Button color="white">
              <Link
                style={{ color: "var(--blue)", textDecorationLine: "none" }}
                to={"/pontos/novo"}
              >
                Novo Ponto
              </Link>
            </Button>
          </center>
          <section>
            {pontosQueryIsLoading && <p>Carregando Informações</p>}
            <List>
              {pontos?.map(
                (point: {
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
                  administradoraId: number;
                  materiaisIds: number[];
                }) => {
                  const { nome, descricao, latitude, longitude, logradouro, numero, bairro, estado, pais, cep, horario_inicio, horario_termino, funcionamento, administradoraId, materiaisIds } = point;
                  return (
                    <CollectionPoint 
                      key={nome}
                      nome={nome}
                      descricao={descricao}
                      latitude={latitude}
                      longitude={longitude}
                      logradouro={logradouro}
                      numero={numero}
                      bairro={bairro}
                      estado={estado}
                      pais={pais}
                      cep={cep}
                      horario_inicio={horario_inicio}
                      horario_termino={horario_termino}
                      funcionamento={funcionamento}
                      administradoraId={administradoraId}
                      materiaisIds={materiaisIds}
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

export default PontoPage;