import './RegisterMaterial.css'

export function RegisterMaterial() {

    return (
        <>
        <div className='formsMaterial'>
            <h1 className='title'>Cadastro de Materiais</h1>
            <hr/>
                <form id='formWrapper'>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Tipo:</h3>
                        <input className='inputType' type='text' autoFocus required placeholder='Madeira'></input>
                    </div>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Cor:</h3>
                        <select className='inputColor' required>
                            <option value={-1}>---</option>
                            <option value={1}>Azul</option>
                            <option value={2}>Vermelho</option>
                            <option value={3}>Verde</option>
                            <option value={4}>Amarelo</option>
                            <option value={5}>Preto</option>
                            <option value={6}>Laranja</option>
                            <option value={7}>Branco</option>
                            <option value={8}>Roxo</option>
                            <option value={9}>Marrom</option>
                            <option value={10}>Cinza</option>
                        </select>
                    </div>
                    <div className='wrapper'>
                        <h3 className='subtitle'>Descrição:</h3>
                        <textarea className='inputDescription' rows={5} maxLength={150} required placeholder='Descrição do Material...'></textarea>
                    </div>
                    <div className='colorWrapper'></div>
                    <div className='descriptionWrapper'></div>
                    <button className='registerButton' type='submit'>Cadastrar</button>
                </form>
            </div>
        </>
    )
}