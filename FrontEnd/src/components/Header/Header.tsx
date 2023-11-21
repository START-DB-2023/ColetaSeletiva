import "./Header.css";
function Header() {
  return (
    <header className="c-header">
      <div className="c-logo">
        <img
          className="c-logo__img"
          src="/Logo.png"
          id="logo"
          alt='Logo de uma lixeira com as escritas "LxU"'
        />
        <h1 className="c-logo__name">LixUtil</h1>
      </div>
      <h2 className="c-header__slogan">Seu lixo? Nosso trabalho!</h2>
    </header>
  );
}

export default Header;
