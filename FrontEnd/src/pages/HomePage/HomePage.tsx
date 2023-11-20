import "./HomePage.css";
import { Header, MainContainer, Navigation, News } from "../../components";

function HomePage() {
  return (
    <>
      <Header />
      <Navigation />

      <MainContainer>
        <News />
      </MainContainer>
    </>
  );
}

export default HomePage;
