import "./NewPontoColetaPage.css";
import {
  FormsPontoColeta,
  Header,
  Heading,
  MainContainer,
  Navigation,
} from "../../components";

function NewPontoColetaPage() {
  return (
    <>
      <Header />
      <Navigation />
      <MainContainer>
        <Heading>Novo ponto de coleta</Heading>
        <FormsPontoColeta />
      </MainContainer>
    </>
  );
}

export default NewPontoColetaPage;
