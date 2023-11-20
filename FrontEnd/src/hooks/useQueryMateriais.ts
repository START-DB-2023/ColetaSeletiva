import fetchAPIData from "../utils/fetchAPIData";
import { useQuery } from "react-query";

const useQueryMateriais = () => {
  const {
    isLoading: materiaisQueryIsLoading,
    isError: materiaisQueryIsError,
    error: materiaisQueryError,
    data: materiais,
  } = useQuery({
    queryKey: ["materiais"],
    select: (responseData) => {
      return responseData.data;
    },
    queryFn: () => fetchAPIData.get("materiais"),
  });

  return {
    materiaisQueryIsLoading,
    materiaisQueryIsError,
    materiaisQueryError,
    materiais,
  };
};

export default useQueryMateriais;
