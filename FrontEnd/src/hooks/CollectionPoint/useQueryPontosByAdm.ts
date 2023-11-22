import { useQuery } from "react-query";
import fetchAPIData from "../../utils/fetchAPIData";
const useQueryPontosByAdm = (id: number) => {
  const {
    isLoading: isLoadingPontoByAdm,
    isError: isErrorPontoByAdm,
    error: errorPontoByAdm,
    data: pontosByAdm,
  } = useQuery({
    queryKey: ["pontos", id],
    queryFn: () => fetchAPIData.get(`/pontos/por-administradora/${id}`),
    select: (responseData) => {
      return responseData.data;
    },
  });
  return {
    isLoadingPontoByAdm,
    isErrorPontoByAdm,
    errorPontoByAdm,
    pontosByAdm,
  };
};

export default useQueryPontosByAdm;
