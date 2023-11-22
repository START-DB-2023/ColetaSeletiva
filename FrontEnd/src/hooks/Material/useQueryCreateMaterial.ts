import { useMutation } from "react-query";
import fetchAPIData from "../../utils/fetchAPIData";

const addMaterial = (data: {
  name: string;
  color: string;
  description: string;
}) => {
  const { name, color, description } = data;
  const body = {
    nome: name,
    cor: color,
    descricao: description,
  };
  return fetchAPIData.post("/materiais", body);
};

const useCreateMaterial = () => {
  return useMutation(addMaterial);
};

export default useCreateMaterial;