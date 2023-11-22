import './Banner.css'

function Banner() {
    return(
        <div className='c-banner'>
            <div className='c-banner__information'>
                <img src='./Logo.png' className='c-banner__information__logo' alt="Lixeira azul escura com escritas LxU" />
                <h1 className='c-banner__information__name'>LixUtil</h1>
                <h2 className='c-banner__information__slogan'>Seu lixo? Nosso trabalho!</h2>
            </div>
            <img src="./Home-Banner.png" alt="Desenho de pessoas jogando lixo fora" className='c-banner__image'/>
        </div>
    );
}

export default Banner;