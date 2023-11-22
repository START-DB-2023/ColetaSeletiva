import { useNavigate, useParams } from "react-router-dom";
import {
  Header,
  Heading,
  MainContainer,
  Navigation,
  SubHeading,
} from "../../components";
import useQuerySingleMaterial from "../../hooks/useQuerySingleMaterial";
import Spinner from "../../components/Spinner/Spinner";
import { useEffect, useState } from "react";
import useUpdateMaterial from "../../hooks/useQueryUpdateMaterial";

function EditMaterialPage() {
  const { id } = useParams();
  const { material, materialQueryIsError, materialQueryIsLoading } =
    useQuerySingleMaterial(id!);
  const [description, setDescription] = useState<string>("");
  const navigate = useNavigate();

  const updateMaterial = useUpdateMaterial();
  useEffect(() => {
    if (!materialQueryIsLoading) {
      setDescription(material.descricao);
    }
  }, [materialQueryIsLoading, material]);

  if (materialQueryIsLoading) {
    return <Spinner />;
  }

  if (materialQueryIsError) {
    navigate("/404");
  }

  const submit = (event: React.FormEvent) => {
    event.preventDefault();
    if (description.length >= 255) {
      alert("A descrição está muito grande.");
      return;
    }
    updateMaterial.mutate({ descricao: description, id: id! });
    alert("Material atualizado");
    navigate("/materiais");
  };

  return (
    <>
      <Header />
      <Navigation />
      <MainContainer>
        <div className="formsMaterial">
          <Heading>{material.nome}</Heading>
          <center>
            <SubHeading>{material.cor}</SubHeading>
          </center>
          <hr />
          <form id="formWrapper" onSubmit={submit}>
            <div className="wrapper">
              <h3 className="subtitle">Descrição:</h3>
              <textarea
                className="inputDescription"
                rows={4}
                maxLength={200}
                required
                value={description}
                onChange={(event) => setDescription(event.currentTarget.value)}
                placeholder="Descrição do Material..."
              ></textarea>
            </div>
            <button className="registerButton" type="submit">
              Atualizar
            </button>
          </form>
        </div>
      </MainContainer>
    </>
  );
}

export default EditMaterialPage;
