import { useEffect, useState } from "react";
import { Header, List, MainContainer, Navigation } from "../../components";
import useQueryPonto from "../../hooks/CollectionPoint/useQueryPontos";
import Spinner from "../../components/Spinner/Spinner";
import useQueryPontosByAdm from "../../hooks/CollectionPoint/useQueryPontosByAdm";
import useQueryAdministradoras from "../../hooks/Administrators/useQueryAdministradoras";
import CollectionPoint from "../../components/CollectionPoint/CollectionPoint";

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

function PageSearch() {
  const [administradoraId, setAdministradoraId] = useState<number>();

  const {
    administradorasQueryIsLoading,
    administradorasQueryIsError,
    administradoras,
  } = useQueryAdministradoras();
  const { pontosByAdm } = useQueryPontosByAdm(administradoraId!);
  const { pontosQueryIsLoading, pontos } = useQueryPonto();
  const [lista, setLista] = useState<Ponto[]>(pontos);
  const [filtro, setFiltro] = useState<string>("");

  useEffect(() => {
    if (filtro.trim() === "") {
      // Se o filtro estiver vazio, mostra todos os pontos
      setLista(pontosByAdm ?? pontos);
    } else {
      // Se o filtro não estiver vazio, filtra a lista com base no nome
      const novaLista = (pontosByAdm ?? pontos).filter((ponto: Ponto) =>
        ponto.nome.toLowerCase().includes(filtro.toLowerCase())
      );
      setLista(novaLista);
    }
  }, [pontosByAdm, pontos, administradoraId, filtro]);

  if (pontosQueryIsLoading || administradorasQueryIsLoading) {
    return;
  }

  return (
    <>
      <Header />
      <Navigation />
      <MainContainer>
        <div>
          <label htmlFor="selectAdministradora">
            Selecione uma administradora
          </label>
          {administradorasQueryIsLoading && <Spinner />}
          {!administradorasQueryIsLoading && !administradorasQueryIsError && (
            <select
              id="selectAdministradora"
              value={administradoraId}
              defaultValue={-1}
              onChange={(e) => setAdministradoraId(+e.currentTarget.value)}
              required
            >
              <option value={-1} key={-1}>
                Todas
              </option>
              {administradoras?.map(
                (adm: {
                  id: number;
                  nome: string;
                  cidade: string;
                  estado: string;
                }) => {
                  const { id, nome, cidade, estado } = adm;
                  return (
                    <option value={id} key={id}>
                      {nome} - {cidade} - {estado}
                    </option>
                  );
                }
              )}
            </select>
          )}
        </div>
        <div>
          <label htmlFor="filtro">Filtrar resultados por nome:</label>
          <input
            type="text"
            placeholder="Filtre por nome"
            value={filtro}
            onChange={(e) => setFiltro(e.currentTarget.value)}
          />
        </div>
        <section>
          {pontosQueryIsLoading && <p>Carregando Informações</p>}
          <List>
            {lista?.map((ponto: Ponto) => {
              return <CollectionPoint key={ponto.id} ponto={ponto} />;
            })}
          </List>
        </section>
      </MainContainer>
    </>
  );
}

export default PageSearch;
