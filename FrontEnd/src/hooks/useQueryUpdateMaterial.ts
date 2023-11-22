import { useMutation } from "react-query";
import fetchAPIData from "../utils/fetchAPIData";

const updateMaterial = (data: { descricao: string; id: string }) => {
  const { descricao, id } = data;
  const body = {
    descricao,
  };
  return fetchAPIData.patch(`/materiais/${id}`, body);
};

const useUpdateMaterial = () => {
  return useMutation(updateMaterial);
};

export default useUpdateMaterial;
