import "./Title.css";

function Title(props: { content: string }) {
  return <h1 className="c-title">{props.content}</h1>;
}

export default Title;
