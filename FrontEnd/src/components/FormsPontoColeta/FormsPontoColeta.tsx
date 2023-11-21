import { useState } from "react";
import "./FormsPontoColeta.css";
import useQueryAdministradoras from "../../hooks/useQueryAdministradoras";
import Spinner from "../Spinner/Spinner";
import useQueryMateriais from "../../hooks/useQueryMateriais";
import useQueryCreatePonto from "../../hooks/useQueryCreatePonto";
import { useNavigate } from "react-router";
import { normalizeColorName } from "../../utils/normalizeColorName";

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
  const [latitude, setLatitude] = useState<number>();
  const [longitude, setLongitude] = useState<number>();
  const [logradouro, setLogradouro] = useState("");
  const [numero, setNumero] = useState(0);
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
    if (numero <= 0) {
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
      latitude: latitude!,
      longitude: longitude!,
      logradouro: logradouro,
      numero: numero,
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
    <div className="formsMaterial">
      <hr />
      <form id="formWrapper" onSubmit={submit}>
        <div>
          <label htmlFor="namePonto">Nome </label>
          <input
            id="namePonto"
            type="text"
            value={nome}
            onChange={(e) => setNome(e.currentTarget.value)}
            placeholder="Ponto X"
            maxLength={255}
            required
          />
        </div>
        <div>
          <label htmlFor="descricaoPonto">Descricao </label>
          <input
            id="descricaoPonto"
            type="text"
            value={descricao}
            onChange={(e) => setDescricao(e.currentTarget.value)}
            placeholder="Seleciona os materiais..."
            maxLength={255}
            required
          />
        </div>
        <div>
          <label htmlFor="latitudePonto">Latitude</label>
          <input
            id="latitudePonto"
            type="number"
            value={latitude}
            onChange={(e) => setLatitude(+e.currentTarget.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="longitudePonto">Longitude</label>
          <input
            id="longitudePonto"
            type="number"
            value={longitude}
            onChange={(e) => setLongitude(+e.currentTarget.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="logradouroPonto">Logradouro</label>
          <input
            id="logradouroPonto"
            type="text"
            value={logradouro}
            onChange={(e) => setLogradouro(e.currentTarget.value)}
            placeholder="Praça"
            required
          />
        </div>
        <div>
          <label htmlFor="numeroPonto">Numero</label>
          <input
            id="numeroPonto"
            type="number"
            value={numero}
            onChange={(e) => setNumero(+e.currentTarget.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="logradouroPonto">Bairro</label>
          <input
            id="bairroPonto"
            type="text"
            value={bairro}
            onChange={(e) => setBairro(e.currentTarget.value)}
            placeholder="Centro"
            required
          />
        </div>
        <div>
          <label htmlFor="estadoPonto">UF(Sigla)</label>
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
          <label htmlFor="paisPonto">País</label>
          <input
            id="paisPonto"
            type="text"
            value={pais}
            onChange={(e) => setPais(e.currentTarget.value)}
            placeholder="Brasil"
            required
          />
        </div>
        <div>
          <label htmlFor="cepPonto">CEP</label>
          <input
            id="cepPonto"
            type="text"
            value={cep}
            onChange={(e) => setCep(e.currentTarget.value)}
            placeholder="xxxxx-abc"
            required
          />
        </div>
        <div>
          <label htmlFor="inicioPonto">Início (HH:mm)</label>
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
          <label htmlFor="terminoPonto">Término (HH:mm)</label>
          <input
            id="terminoPonto"
            type="text"
            value={horarioTermino}
            onChange={(e) => setHorarioTermino(e.currentTarget.value)}
            placeholder="19:00"
            required
          />
        </div>
        <div>
          <label htmlFor="funcionamentoPonto">Funcionamento (dia-dia)</label>
          <input
            id="funcionamentoPonto"
            type="text"
            value={funcionamento}
            onChange={(e) => setFuncionamento(e.currentTarget.value)}
            placeholder="seg-sex"
            required
          />
        </div>
        <div>
          <label htmlFor="selectAdministradora">
            Selecione uma administradora
          </label>
          {administradorasQueryIsLoading && <Spinner />}
          {!administradorasQueryIsLoading && !administradorasQueryIsError && (
            <select
              id="selectAdministradora"
              value={administradoraId}
              onChange={(e) => setAdministradoraId(+e.currentTarget.value)}
              required
            >
              <option value={-1} disabled>
                Selecione uma administradora
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
          <label htmlFor="selectMateriais">
            Selecione um ou mais materiais
          </label>
          {materiaisQueryIsLoading && <Spinner />}
          {!materiaisQueryIsLoading && !materiaisQueryIsError && (
            <select
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
              <option disabled>Selecione os materiais</option>
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
        {(materiaisQueryIsError || administradorasQueryIsError) && (
          <p>
            Não foi possível encontrar as informações necessárias para cadastro.
            Contate o administrador do sistema
          </p>
        )}
        {!materiaisQueryIsError && !administradorasQueryIsError && (
          <button className="registerButton" type="submit">
            Cadastrar
          </button>
        )}
      </form>
    </div>
  );
}

export default FormsPontoColeta;
