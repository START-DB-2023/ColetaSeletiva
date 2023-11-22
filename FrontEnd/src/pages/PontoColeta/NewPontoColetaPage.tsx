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
        <Heading>Novo Ponto de Coleta</Heading>
        <FormsPontoColeta />
      </MainContainer>
    </>
  );
}

export default NewPontoColetaPage;
