import { ReactElement } from "react";
import "./ListCP.css";
function ListCP(props: { children: ReactElement[] | ReactElement }) {
  return <ul className="c-list__CP">{props.children}</ul>;
}

export default ListCP;