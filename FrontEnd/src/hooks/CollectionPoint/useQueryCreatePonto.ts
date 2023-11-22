import { useMutation } from "react-query";
import fetchAPIData from "../../utils/fetchAPIData";

const addPonto = (data: {
  name: string;
  description: string;
  latitude: number;
  longitude: number;
  adress: string;
  number: number;
  neighborhood: string;
  state: string;
  country: string;
  postal_code: string;
  start_time: string;
  end_time: string;
  operation: string;
  administratorId: number;
  materialIds: number[];
}) => {
  const { name, description, latitude, longitude, adress, number, neighborhood, state, country, postal_code, start_time, end_time, operation, administratorId, materialIds } = data;
  const body = {
    nome: name,
    descricao: description,
    latitude: latitude,
    longitude: longitude,
    logradouro: adress,
    numero: number,
    bairro: neighborhood,
    estado: state,
    pais: country,
    cep: postal_code,
    horario_inicio: start_time,
    horario_termino: end_time,
    funcionamento: operation,
    administradoraId: administratorId,
    materiaisIds: materialIds,
  };
  return fetchAPIData.post("/pontos", body);
};

const useCreatePonto = () => {
  return useMutation(addPonto);
};

export default useCreatePonto;
