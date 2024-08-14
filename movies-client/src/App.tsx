import React from "react";
import { Route, Routes } from "react-router-dom";
import { HomePage } from "./pages";
import { Header, Trailer, Reviews } from "components";
import { ROUTES } from "./routes";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

import "./index.css";

const queryClient = new QueryClient();

function App() {
    return (
        <QueryClientProvider client={queryClient}>
            <div className="root">
                <Header />
                <Routes>
                    <Route path={ROUTES.base} element={<HomePage />} />
                    <Route path={ROUTES.trailer} element={<Trailer />} />
                    <Route path={ROUTES.reviews} element={<Reviews />} />
                </Routes>
            </div>
        </QueryClientProvider>
    );
}

export default App;
