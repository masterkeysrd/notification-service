import React from "react";
import ReactDOM from "react-dom/client";
import { RouterProvider, createBrowserRouter } from "react-router-dom";
import RootRoute from "./routes/RootRoute";
import ErrorPage from "./pages/ErrorPage";
import SendMessagePage from "./pages/SendMessagePage";
import NotificationHistoryPage from "./pages/NotificationHistoryPage";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootRoute />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/send-message",
        element: <SendMessagePage />,
      },
      {
        path: "/notification-history",
        element: <NotificationHistoryPage />,
      }
    ],
  },
]);

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
