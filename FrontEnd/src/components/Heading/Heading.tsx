import "./Heading.css";

function Title(props: { children: string }) {
  return <h2 className="c-heading">{props.children}</h2>;
}

export default Title;
