import fetchAPIData from "../../utils/fetchAPIData";
import { useQuery } from "react-query";

const useQueryPonto = () => {
  const {
    isLoading: pontosQueryIsLoading,
    isError: pontosQueryIsError,
    error: pontosQueryError,
    data: pontos,
  } = useQuery({
    queryKey: ["pontos"],
    select: (responseData) => {
      return responseData.data;
    },
    queryFn: () => fetchAPIData.get("pontos"),
  });

  return {
    pontosQueryIsLoading,
    pontosQueryIsError,
    pontosQueryError,
    pontos,
  };
};

export default useQueryPonto;
