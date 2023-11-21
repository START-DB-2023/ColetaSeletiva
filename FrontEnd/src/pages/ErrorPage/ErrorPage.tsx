import { Link } from "react-router-dom";
import "./ErrorPage.css";
import { Button } from "../../components";

function ErrorPage() {
  return (
    <section className="c-error-page u-padding">
      <header className="c-error-page__header">
        <h1>404</h1>
        <h2>Desculpe, essa página não pode ser encontrada.</h2>
        <Button color={"blue"} textColor="#fff">
          <Link to={"/"}>Início</Link>
        </Button>
      </header>

      <img src="/404/404.png" alt="" />
    </section>
  );
}

export default ErrorPage;
