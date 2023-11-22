import { Header, Heading, MainContainer, Navigation } from "../../components";
import FormsAdministrator from "../../components/FormsAdministrator/FormsAdministrator";

function NewAdministratorPage() {
  return (
    <>
      <Header />
      <Navigation />
      <MainContainer>
        <Heading>Nova Administradora</Heading>
        <FormsAdministrator></FormsAdministrator>
      </MainContainer>
    </>
  );
}

export default NewAdministratorPage;
