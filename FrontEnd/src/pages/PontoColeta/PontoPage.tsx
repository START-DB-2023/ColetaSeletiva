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
import useQueryPonto from "../../hooks/CollectionPoint/useQueryPontos";

type Material = {
  id: number;
  nome: string;
  cor: string;
  descricao: string;
};

type Administradora = {
  id: number;
  ativo: boolean;
  nome: string;
  cidade: string;
  estado: string;
  descricao: string;
};

type Ponto = {
  id: number;
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
  administradora: Administradora;
  materiais: Material[];
};

function PontoPage() {
  const { pontos, pontosQueryIsLoading } = useQueryPonto();
  console.log(pontos);

  return (
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
            {pontos?.map((ponto: Ponto) => {
              return <CollectionPoint key={ponto.id} ponto={ponto} />;
            })}
          </List>
        </section>
      </MainContainer>
    </>
  );
}

export default PontoPage;
