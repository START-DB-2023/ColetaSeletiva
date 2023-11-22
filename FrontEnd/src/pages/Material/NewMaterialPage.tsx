import {
  FormsMaterial,
  Header,
  Heading,
  MainContainer,
  Navigation,
} from "../../components";

function NewMaterialPage() {
  return (
    <>
      <Header />
      <Navigation />
      <MainContainer>
        <Heading>Novo Material</Heading>
        <FormsMaterial></FormsMaterial>
      </MainContainer>
    </>
  );
}

export default NewMaterialPage;
