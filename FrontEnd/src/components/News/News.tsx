import { Button, CardNews, Heading } from "../";
import "./News.css";

import { news } from "../../mock";

function News() {
  return (
    <section className="c-news">
      <header className="c-news__header">
        <Heading>Últimas Notícias</Heading>
        <div className="c-news__filters">
          <h3>Filtros:</h3>
          <Button color="#FFD74B">Novidade</Button>
          <Button color="#FF4B4B">Importante</Button>
          <Button color="#4B72FF">Comunidade</Button>
        </div>
      </header>
      <section className="c-news__grid">
        {news.map((item) => {
          return (
            <CardNews
              key={item.id}
              imgUrl={item.imgUrl}
              title={item.title}
              summary={item.summary}
            />
          );
        })}
      </section>
    </section>
  );
}

export default News;
