import { Link } from "react-router-dom";

function ErrorPage() {
  return (
    <section>
      <h1>404</h1>
      <h2>Desculpe, essa página não pode ser encontrada.</h2>
      <Link to={"/"}>Início</Link>
    </section>
  );
}

export default ErrorPage;
