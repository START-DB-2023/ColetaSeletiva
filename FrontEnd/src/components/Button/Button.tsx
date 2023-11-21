import { ReactElement } from "react";
import "./Button.css";

function Button(props: {
  color?: string;
  textColor?: string;
  fontSize?: string;
  children: ReactElement | string;
}) {
  return (
    <button
      className="c-button"
      style={{
        background: props.color,
        color: props.textColor,
        fontSize: props.fontSize,
      }}
    >
      {props.children}
    </button>
  );
}

export default Button;
