import { useState } from "react";
import "./FormsPontoColeta.css";

import Spinner from "../Spinner/Spinner";

import { useNavigate } from "react-router";
import { normalizeColorName } from "../../utils/normalizeColorName";
import useQueryMateriais from "../../hooks/Material/useQueryMateriais";
import useQueryAdministradoras from "../../hooks/Administrators/useQueryAdministradoras";
import useQueryCreatePonto from "../../hooks/CollectionPoint/useQueryCreatePonto";

function FormsPontoColeta() {
  const navigate = useNavigate();
  const {
    administradorasQueryIsLoading,
    administradorasQueryIsError,
    administradoras,
  } = useQueryAdministradoras();

  const { materiaisQueryIsError, materiaisQueryIsLoading, materiais } =
    useQueryMateriais();

  const [nome, setNome] = useState("");
  const [descricao, setDescricao] = useState("");
  const [latitude, setLatitude] = useState<string>("");
  const [longitude, setLongitude] = useState<string>("");
  const [logradouro, setLogradouro] = useState("");
  const [numero, setNumero] = useState("");
  const [bairro, setBairro] = useState("");
  const [estado, setEstado] = useState("");
  const [pais, setPais] = useState("");
  const [cep, setCep] = useState("");
  const [horarioInicio, setHorarioInicio] = useState("");
  const [horarioTermino, setHorarioTermino] = useState("");
  const [funcionamento, setFuncionamento] = useState("");
  const [administradoraId, setAdministradoraId] = useState(-1);
  const [materiaisIds, setMateriaisIds] = useState<number[]>([]);

  const addPontoMutation = useQueryCreatePonto();

  const submit = (event: React.FormEvent) => {
    event.preventDefault();
    if (nome.length === 0 || nome.length >= 255) {
      alert("Nome inválido!");
      return;
    }

    if (descricao.length === 0 || descricao.length >= 255) {
      alert("Descricao inválida!");
      return;
    }

    if (logradouro.length === 0 || logradouro.length >= 255) {
      alert("Logradouro inválido!");
      return;
    }
    if (+numero <= 0) {
      alert("Numero inválido!");
      return;
    }

    if (pais.length === 0 || cep.length >= 255) {
      alert("País inválido!");
      return;
    }

    if (cep.length === 0 || cep.length >= 255) {
      alert("CEP inválido!");
      return;
    }

    if (horarioInicio.length === 0 || horarioInicio.length >= 255) {
      alert("Horário de início inválido!");
      return;
    }

    if (horarioTermino.length === 0 || horarioTermino.length >= 255) {
      alert("Horário de término inválido!");
      return;
    }

    if (funcionamento.length === 0 || funcionamento.length >= 255) {
      alert("Funcionamento inválido!");
      return;
    }

    if (administradoraId <= 0 || administradoraId == null) {
      alert("Administradora inválida!");
      return;
    }

    if (materiaisIds.length === 0) {
      alert("Materiais inválidos!");
      return;
    }

    const data = {
      nome: nome,
      descricao: descricao,
      latitude: +latitude,
      longitude: +longitude,
      logradouro: logradouro,
      numero: +numero,
      bairro: bairro,
      estado: estado,
      pais: pais,
      cep: cep,
      horario_inicio: horarioInicio,
      horario_termino: horarioTermino,
      funcionamento: funcionamento,
      administradoraId: administradoraId,
      materiaisIds: materiaisIds,
    };

    addPontoMutation.mutate(data);

    alert("Ponto cadastrado");
    navigate("/pontos");
  };

  return (
    <div className="formsCollectionPoint">
      <h1 className="title">Cadastro de Pontos de Coleta</h1>
      <hr className="collectionPointHr"/>
      <form id="formWrapper" onSubmit={submit}>
        <div className="c-forms">
          <div className="c-forms__location">
            <div>
              <label htmlFor="namePonto">Nome:</label>
              <input
                id="namePonto"
                type="text"
                value={nome}
                onChange={(e) => setNome(e.currentTarget.value)}
                placeholder="Coleta das Artes - PC 7"
                maxLength={255}
                required
              />
            </div>
            <div>
              <label htmlFor="paisPonto" >País:</label>
              <input
                id="paisPonto"
                type="text"
                value={pais}
                onChange={(e) => setPais(e.currentTarget.value)}
                placeholder="Brasil"
                required
              />
            </div>
            <div className="c-forms__double">
              <div>
                <label htmlFor="estadoPonto" >UF:</label>
                <input
                  id="estadoPonto"
                  type="text"
                  value={estado}
                  onChange={(e) => setEstado(e.currentTarget.value)}
                  placeholder="SP"
                  required
                />
              </div>
              <div>
              <label htmlFor="cepPonto" >CEP:</label>
                <input
                  id="cepPonto"
                  type="text"
                  value={cep}
                  onChange={(e) => setCep(e.currentTarget.value)}
                  placeholder="xxxxx-abc"
                  required
                />
              </div>
            </div>
            <div>
              <label htmlFor="bairroPonto" >Bairro:</label>
              <input
                id="bairroPonto"
                type="text"
                value={bairro}
                onChange={(e) => setBairro(e.currentTarget.value)}
                placeholder="Sininho"
                required
              />
            </div>
            <div>
              <label htmlFor="logradouroPonto" >Logradouro:</label>
              <input
                id="logradouroPonto"
                type="text"
                value={logradouro}
                onChange={(e) => setLogradouro(e.currentTarget.value)}
                placeholder="Rua Aparecida"
                required
              />
            </div>
            <div>
              <label htmlFor="numeroPonto" >Numero:</label>
              <input
                id="numeroPonto"
                type="text"
                value={numero}
                onChange={(e) => setNumero(e.currentTarget.value)}
                placeholder="23954"
                required
              />
            </div>
            <div className="c-forms__double">
              <div>
                <label htmlFor="latitudePonto" >Latitude:</label>
                <input
                  id="latitudePonto"
                  type="text"
                  value={latitude}
                  onChange={(e) => setLatitude(e.currentTarget.value)}
                  placeholder="-16.74522"
                  required
                />
              </div>
              <div>
                <label htmlFor="longitudePonto" >Longitude:</label>
                <input
                  id="longitudePonto"
                  type="text"
                  value={longitude}
                  onChange={(e) => setLongitude(e.currentTarget.value)}
                  placeholder="-53.89573"
                  required
                />
              </div>
            </div>
          </div>


          <hr className="c-forms__divisor"/>
          
          
          <div className="c-forms__information">
            <div>
              <label htmlFor="descricaoPonto" >Descricao:</label>
              <textarea
                id="descricaoPonto"
                rows={5}
                value={descricao}
                onChange={(e) => setDescricao(e.currentTarget.value)}
                placeholder="Descrição do Ponto..."
                maxLength={200}
                required
              />
            </div>
            <div>
              <label htmlFor="funcionamentoPonto" >Funcionamento:</label>
              <input
                id="funcionamentoPonto"
                type="text"
                value={funcionamento}
                onChange={(e) => setFuncionamento(e.currentTarget.value)}
                placeholder="seg-sex"
                required
              />
            </div>
            <div className="c-forms__double">
              <div>
                <label htmlFor="inicioPonto" >Início:</label>
                <input
                  id="inicioPonto"
                  type="text"
                  value={horarioInicio}
                  onChange={(e) => setHorarioInicio(e.currentTarget.value)}
                  placeholder="07:00"
                  required
                />
              </div>
              <div>
                <label htmlFor="terminoPonto" >Término:</label>
                <input
                  id="terminoPonto"
                  type="text"
                  value={horarioTermino}
                  onChange={(e) => setHorarioTermino(e.currentTarget.value)}
                  placeholder="19:00"
                  required
                />
              </div>
            </div>
            <div>
              <label htmlFor="selectAdministradora" >
                Administradora
              </label>
              {administradorasQueryIsLoading && <Spinner />}
              {!administradorasQueryIsLoading && !administradorasQueryIsError && (
                <select 
                  className="c-forms__information__administrator"
                  id="selectAdministradora"
                  value={administradoraId}
                  onChange={(e) => setAdministradoraId(+e.currentTarget.value)}
                  required
                >
                  <option value={-1} disabled>
                    Selecione uma Administradora...
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
              {administradorasQueryIsError && (
                <p>Erro ao recuperar as administradoras</p>
              )}
            </div>
            <div>
              <label htmlFor="selectMateriais" >
                Materiais:
              </label>
              {materiaisQueryIsLoading && <Spinner />}
              {!materiaisQueryIsLoading && !materiaisQueryIsError && (
                <select
                className="c-forms__information__material"
                  id="selectMateriais"
                  multiple
                  value={materiaisIds.map((id) => String(id))}
                  onChange={(e) => {
                    const opts = [...e.currentTarget.selectedOptions];
                    const ids = opts.map((opt) => +opt.value);
                    setMateriaisIds(ids);
                  }}
                  required
                >
                  <option disabled>Selecione os Materiais...</option>
                  {materiais?.map(
                    (material: { id: number; nome: string; cor: string }) => {
                      const { id, nome, cor } = material;
                      return (
                        <option value={id} key={id}>
                          {nome} - {normalizeColorName(cor)}
                        </option>
                      );
                    }
                  )}
                </select>
              )}
              {administradorasQueryIsError && <p>Erro ao recuperar os materiais</p>}
            </div>
          </div>
        </div>
        {(materiaisQueryIsError || administradorasQueryIsError) && (
          <p>
            Não foi possível encontrar as informações necessárias para cadastro.
            Contate o administrador do sistema
          </p>
        )}
        {!materiaisQueryIsError && !administradorasQueryIsError && (
          <button className="registerButtonP" type="submit">
            Cadastrar
          </button>
        )}
      </form>
    </div>
  );
}

export default FormsPontoColeta;
