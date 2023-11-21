import "./Heading.css";

function Title(props: { children: string; color?: string; }) {
  const titleColor = props.color || 'black';
  return <h2 className="c-heading" style={{color: titleColor}}>{props.children}</h2>;
}

export default Title;
