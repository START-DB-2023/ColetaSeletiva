import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";

import { RouterProvider, createBrowserRouter } from "react-router-dom";
import {
  ErrorPage,
  HomePage,
  MaterialPage,
  NewMaterialPage,
  AdministratorPage,
  NewAdministratorPage,
  SearchPage,
  NewPontoColetaPage,
  EditMaterialPage,
  PontoPage,
} from "./pages";
import { QueryClient, QueryClientProvider } from "react-query";
import { ReactQueryDevtools } from "react-query/devtools";

const router = createBrowserRouter([
  {
    errorElement: <ErrorPage />,
  },
  {
    path: "/",
    element: <HomePage />,
  },
  {
    path: "/busca",
    element: <SearchPage />,
  },
  {
    path: "/materiais",
    element: <MaterialPage />,
  },
  {
    path: "/materiais/novo",
    element: <NewMaterialPage />,
  },
  {
    path: "/materiais/editar/:id",
    element: <EditMaterialPage />,
  },
  {
    path: "/administradoras",
    element: <AdministratorPage />,
  },
  {
    path: "/administradoras/novo",
    element: <NewAdministratorPage />,
  },
  {
    path: "/pontos",
    element: <PontoPage />,
  },
  {
    path: "/pontos/novo",
    element: <NewPontoColetaPage />,
  },
]);

const queryClient = new QueryClient();

const root = document.getElementById("root")!;
ReactDOM.createRoot(root).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <RouterProvider router={router}></RouterProvider>
      <ReactQueryDevtools></ReactQueryDevtools>
    </QueryClientProvider>
  </React.StrictMode>
);
