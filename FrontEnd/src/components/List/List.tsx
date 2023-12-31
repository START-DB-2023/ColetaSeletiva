import { ReactElement } from "react";
import "./List.css";
function List(props: { children: ReactElement[] | ReactElement }) {
  return <ul className="c-list">{props.children}</ul>;
}

export default List;
