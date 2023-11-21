import "./FormsMaterial.css";
import { useState } from "react";
import { useNavigate } from "react-router";
import useQueryCreateMaterial from "../../hooks/useQueryCreateMaterial";

function FormsMaterial() {
  const navigate = useNavigate();
  const [name, setName] = useState<string>("");
  const [color, setColor] = useState<string>("");
  const [description, setDescription] = useState<string>("");

  const selectChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const value = event.target.value;
    setColor(value);
  };

  const addMaterialMutation = useQueryCreateMaterial();

  const submit = (event: React.FormEvent) => {
    event.preventDefault();
    if (name.length === 0) {
      alert("O nome precisa ser preenchido!");
      return;
    }

    if (color.length === 0) {
      alert("A cor precisa ser selecionada!");
      return;
    }

    if (description.length === 200) {
      alert("A descrição está muito grande.");
      return;
    }

    addMaterialMutation.mutate({ name, color, description });

    alert("Material cadastrado");
    navigate("/materiais");
  };
  return (
    <>
      <div className="formsMaterial">
        <h1 className="title">Cadastro de Material</h1>
        <hr />
        <form id="formWrapper" onSubmit={submit}>
          <div className="wrapper">
            <h3 className="subtitle">Nome:</h3>
            <input
              className="inputType"
              type="text"
              autoFocus
              required
              value={name}
              onChange={(event) => setName(event.currentTarget.value)}
              placeholder="Madeira"
            ></input>
          </div>
          <div className="wrapper">
            <h3 className="subtitle">Cor:</h3>
            <select
              className="inputColor"
              onChange={selectChange}
              value={color}
              defaultValue={""}
              required
            >
              <option disabled value={""}>
                Escolher
              </option>
              <option value="AZUL">Azul</option>
              <option value="VERMELHO">Vermelho</option>
              <option value="VERDE">Verde</option>
              <option value="AMARELO">Amarelo</option>
              <option value="PRETO">Preto</option>
              <option value="LARANJA">Laranja</option>
              <option value="BRANCO">Branco</option>
              <option value="ROXO">Roxo</option>
              <option value="MARROM">Marrom</option>
              <option value="CINZA">Cinza</option>
            </select>
          </div>
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
            Cadastrar
          </button>
        </form>
      </div>
    </>
  );
}

export default FormsMaterial;
