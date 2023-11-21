import './PageSearch.css'

function PageSearch() {

    return (
            <div id="container">
                <header id='navbarS'>
                    <div id='headerInfo'>
                        <img src='/Logo.png' id='logo' alt='Lixeira com escritos "LxU"'/>
                        <h1 id='name'>LixUtil</h1>
                        <hr id='name-slogan'/>
                        <h2 id='slogan'>Seu lixo? Nosso trabalho!</h2>
                    </div>
                    <div id='headerNav'>
                        <h2 className='navbarText'>Cadastrar</h2>
                        <h2 className='navbarText'>Buscar</h2>
                        <h2 className='navbarText'>Sobre</h2>
                    </div>
                </header>
                <body>
                    <div id='cpWrapper'>
                        <div id='cpSearch'>

                        </div>

                    </div>
                    <div id='mapDiv'>

                    </div>
                </body>
            </div>
    );
}

export default PageSearch;