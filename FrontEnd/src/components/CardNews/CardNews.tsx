import { Button, SubHeading } from "..";
import "./CardNews.css";

function CardNews(props: { title: string; summary: string; imgUrl: string }) {
  return (
    <div className="c-card-news">
      <img src={props.imgUrl} alt="Imagem da notícia" />
      <div className="c-card-news__info">
        <SubHeading>{props.title}</SubHeading>
        <h3 className="c-card-news__info__summary">{props.summary}</h3>
        <Button color="#4B72FF">Visualizar</Button>
      </div>
    </div>
  );
}

export default CardNews;
