import './RegisterAdministration.css'

export function RegisterAdministration() {

    return (
        <>
        <div className='formsAdministration'>
            <h1 className='title'>Cadastro de Instituições Administrativas</h1>
            <hr/>
                <form id='formWrapper'>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Nome:</h3>
                        <input className='inputName' type='text' autoFocus required placeholder='Madeira'></input>
                    </div>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Descrição:</h3>
                        <textarea className='inputDesc' rows={3} maxLength={100} required placeholder='Descrição do Material...'></textarea>
                    </div>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Estado:</h3>
                        <input className='inputState' type='text' required placeholder='SP'></input>
                    </div>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Cidade:</h3>
                        <input className='inputCity' type='text' required placeholder='Taboão da Serra'></input>
                    </div>
                    <button className='registerButton' type='submit'>Cadastrar</button>
                </form>
            </div>
        </>
    )
}