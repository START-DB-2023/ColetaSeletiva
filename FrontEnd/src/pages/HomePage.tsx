import { MainContainer, Navigation, News } from "../components";
import Banner from "../components/Banner/Banner";

function HomePage() {
  return (
    <>
      <Banner />
      <Navigation />

      <MainContainer>
        <News />
      </MainContainer>
    </>
  );
}

export default HomePage;
