import { useMutation } from "react-query";
import fetchAPIData from "../utils/fetchAPIData";

const addAdministrator = (data: {
    name: string;
    state: string;
    city: string;
    description: string;
}) => {
    const { name, state, city, description } = data;
    const body = {
        nome: name,
        estado: state,
        cidade: city,
        descricao: description,
    };
    return fetchAPIData.post("/administradoras", JSON.stringify(body), {headers:{ "Content-Type": "application/json"}});
};

const useCreateAdministrator = () => {
    return useMutation(addAdministrator);
}

export default useCreateAdministrator;