import { useMutation } from "react-query";
import fetchAPIData from "../../utils/fetchAPIData";

const addPonto = (data: {
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
  return fetchAPIData.post("/pontos", data);
};

const useCreatePonto = () => {
  return useMutation(addPonto);
};

export default useCreatePonto;
