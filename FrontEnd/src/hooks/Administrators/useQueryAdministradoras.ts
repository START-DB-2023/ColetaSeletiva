import fetchAPIData from "../../utils/fetchAPIData";
import { useQuery } from "react-query";

const useQueryAdministradoras = () => {
  const {
    isLoading: administradorasQueryIsLoading,
    isError: administradorasQueryIsError,
    error: administradorasQueryError,
    data: administradoras,
  } = useQuery({
    queryKey: ['administradoras'],
    select: (responseData) => {
      return responseData.data;
    },
    queryFn: () => fetchAPIData.get("administradoras"),
  });

  return {
    administradorasQueryIsLoading,
    administradorasQueryIsError,
    administradorasQueryError,
    administradoras,
  };
};

export default useQueryAdministradoras;