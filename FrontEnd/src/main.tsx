import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";

import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { ErrorPage, HomePage } from "./pages";

const router = createBrowserRouter([
  {
    errorElement: <ErrorPage />,
  },
  {
    path: "/",
    element: <HomePage />,
  },
]);

const root = document.getElementById("root")!;
ReactDOM.createRoot(root).render(
  <React.StrictMode>
    <RouterProvider router={router}></RouterProvider>
  </React.StrictMode>
);
