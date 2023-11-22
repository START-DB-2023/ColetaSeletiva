import { useQuery } from "react-query";
import fetchAPIData from "../utils/fetchAPIData";

const useQuerySingleMaterial = (id: string) => {
  const {
    isLoading: materialQueryIsLoading,
    isError: materialQueryIsError,
    error: materialQueryError,
    data: material,
  } = useQuery({
    queryKey: ["material", id],
    queryFn: () => fetchAPIData.get(`/materiais/${id}`),
    select: (responseData) => {
      return responseData?.data;
    },
  });

  return {
    materialQueryIsLoading,
    materialQueryIsError,
    materialQueryError,
    material,
  };
};

export default useQuerySingleMaterial;
