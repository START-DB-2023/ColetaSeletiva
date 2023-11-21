import { ReactElement } from "react";
import "./Button.css";

function Button(props: { color: string; children: ReactElement | string }) {
  return (
    <button className="c-button" style={{ background: props.color }}>
      {props.children}
    </button>
  );
}

export default Button;
