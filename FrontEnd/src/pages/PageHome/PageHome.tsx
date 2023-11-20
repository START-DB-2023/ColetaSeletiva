import { CardNews } from '../../components/CardNews/CardNews';
import { TagNews } from '../../components/TagNews/TagNews';
import './PageHome.css';

export function PageHome() {

    return (
        <div id="container">
            <div id="banner">
                <div id="informationDiv">
                    <img src='/Logo.png' id='logoH'alt='Lixeira com escritos "LxU"'/>
                    <h1 id='name'>LixUtil</h1>
                    <h2 id='slogan'>Seu lixo? Nosso trabalho!</h2>
                </div>
                <div id='imageDiv'>
                    <img src="/Home-Banner.png" id='image' alt="Desenhos de pessoas separando o lixo e o jogando nas lixeiras corretas."/>
                </div>
            </div>
            <hr id='banner-navigation'/>
            <div id='navigation'>
                <div id='navbarH'>
                        <h2 className='navbarTextH'>Cadastrar</h2>
                        <h2 className='navbarTextH'>Buscar</h2>
                        <h2 className='navbarTextH'>Sobre</h2>
                </div>
                <div id='newsInfo'>
                    <h3 id='latestNews'>Últimas Notícias</h3>
                    <hr id='news-filter'/>
                    <div id='filters'>
                        <h3 id='filterText'>Filtros:</h3>
                        <TagNews tag="Novidade" color='#FFD74B'/>
                        <TagNews tag="Importante" color='#FF4B4B'/>
                        <TagNews tag="Comunidade" color='#4B72FF'/>
                        <h4 id='allNews'>Ver Todas as Notícias→</h4>
                    </div>                    
                </div>
                <div id='cardWrapper'>
                    <CardNews/>
                    <CardNews/>
                    <CardNews/>
                    <CardNews/>
                </div>
            </div>
        </div>
    );
}