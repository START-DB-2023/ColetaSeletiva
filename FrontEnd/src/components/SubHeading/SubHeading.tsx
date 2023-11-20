import "./SubHeading.css";
function SubHeading(props: { children: string }) {
  return <h3 className="c-subheading">{props.children}</h3>;
}

export default SubHeading;
