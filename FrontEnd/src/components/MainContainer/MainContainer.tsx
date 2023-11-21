import { ReactElement } from "react";
import "./MainContainer.css";

function MainContainer(props: { children: ReactElement[] | ReactElement }) {
  return <main className="c-container">{props.children}</main>;
}

export default MainContainer;
