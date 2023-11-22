import { useEffect, useState } from "react";
import { Header, List, MainContainer, Navigation } from "../../components";
import useQueryPonto from "../../hooks/CollectionPoint/useQueryPontos";
import Spinner from "../../components/Spinner/Spinner";
import useQueryPontosByAdm from "../../hooks/CollectionPoint/useQueryPontosByAdm";
import useQueryAdministradoras from "../../hooks/Administrators/useQueryAdministradoras";
import CollectionPoint from "../../components/CollectionPoint/CollectionPoint";
import { MapContainer, Marker, Popup, TileLayer } from "react-leaflet";
import "leaflet/dist/leaflet.css";
// import { LatLngTuple } from "leaflet";

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
  const [administradoraId, setAdministradoraId] = useState<number>(-1);

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
    if (administradoraId === -1) {
      if (filtro.trim() === "") {
        setLista(pontos);
      } else {
        const novaLista = pontos.filter((ponto: Ponto) =>
          ponto.nome.toLowerCase().includes(filtro.toLowerCase())
        );
        setLista(novaLista);
      }
    } else {
      if (filtro.trim() === "") {
        setLista(pontosByAdm ?? []);
      } else {
        const novaLista = (pontosByAdm ?? []).filter((ponto: Ponto) =>
          ponto.nome.toLowerCase().includes(filtro.toLowerCase())
        );
        setLista(novaLista);
      }
    }
  }, [pontosByAdm, pontos, administradoraId, filtro]);

  if (pontosQueryIsLoading || administradorasQueryIsLoading) {
    return <Spinner />;
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
        <section>
          <MapContainer
            center={
              lista?.length > 0
                ? [lista[0]?.latitude, lista[0]?.longitude]
                : [51.505, -0.09]
            }
            zoom={2}
            style={{ height: "400px", width: "100%" }}
          >
            <TileLayer
              url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
              attribution="© OpenStreetMap contributors"
            />

            {lista?.map((ponto) => (
              <Marker
                key={ponto.id}
                position={[ponto.latitude, ponto.longitude]}
              >
                <Popup>
                  <div>
                    <h2>{ponto.nome}</h2>
                    <p>{ponto.descricao}</p>
                    <p>Materiais:</p>
                    <ul>
                      {ponto?.materiais?.map((material) => {
                        return (
                          <li key={material.id}>
                            {material.nome} - {material.cor}
                          </li>
                        );
                      })}
                    </ul>
                  </div>
                </Popup>
              </Marker>
            ))}
          </MapContainer>
        </section>
      </MainContainer>
    </>
  );
}

export default PageSearch;
