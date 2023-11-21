import React, { useState } from 'react'
import './FormsAdministrator.css'
import { useNavigate } from 'react-router'
import useQueryCreateAdministrator from '../../hooks/useQueryCreateAdministrator';


function FormsAdministrator() {
    const navigate = useNavigate();
    const [name, setName] = useState<string>("");
    const [state, setState] = useState<string>("");
    const [city, setCity] = useState<string>("");
    const [description, setDescription] = useState<string>("");

    const addAdministratorMutation = useQueryCreateAdministrator();

    const submit = (event: React.FormEvent) => {
        event.preventDefault();
        if (name.length == 0) {
            alert("O nome precisa ser preenchido!")
            return;
        }

        if (state.length === 0) {
            alert("O estado precisa ser preenchido!")
            return;
        }

        if (city.length === 0) {
            alert("A cidade precisa ser preenchida!")
            return;
        }

        if (description.length === 200) {
            alert("A descrição está muito grande.")
            return;
        }

        addAdministratorMutation.mutate({ name, state, city, description });

        alert("Administradora cadastrada");
        navigate("/administradoras");
    }
    return (
        <>
        <div className='formsAdministration'>
            <h1 className='title'>Cadastro de Instituições Administrativas</h1>
            <hr />
                <form id='formWrapper' onSubmit={submit}>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Nome:</h3>
                        <input 
                          className='inputName' 
                          type='text' 
                          autoFocus 
                          required 
                          value={name}
                          onChange={(event) => setName(event.currentTarget.value)}
                          placeholder='Coleta da Serra'
                        ></input>
                    </div>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Estado:</h3>
                        <input 
                          className='inputState' 
                          type='text' 
                          required
                          value={state}
                          onChange={(event) => setState(event.currentTarget.value)}
                          placeholder='SP'
                        ></input>
                    </div>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Cidade:</h3>
                        <input 
                          className='inputCity' 
                          type='text' 
                          required
                          value={city}
                          onChange={(event) => setCity(event.currentTarget.value)}
                          placeholder='Taboão da Serra'></input>
                    </div>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Descrição:</h3>
                        <textarea 
                          className='inputDesc' 
                          rows={3} 
                          maxLength={200} 
                          required 
                          value={description}
                          onChange={(event) => setDescription(event.currentTarget.value)}
                          placeholder='Descrição da Administradora...'></textarea>
                    </div>
                    <button className='registerButton' type='submit'>Cadastrar</button>
                </form>
            </div>
        </>
    )
}

export default FormsAdministrator;