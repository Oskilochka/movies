import React from "react";
import { Route, Routes } from "react-router-dom";
import { HomePage } from "./pages";
import { Header, Trailer } from "components";
import "./App.css";
import { Reviews } from "./components/review";
import api from "./api/axiosConfig";

function App() {
  const [ movie, setMovie ] = React.useState([]);
  const [ reviews, setReviews ] = React.useState([]);

  const getMovieData = React.useCallback(async (movieId: string) => {
    try {
      const response = await api.get(`api/v1/movies/${movieId}`);
      setMovie(response.data);
    } catch (err) {
      console.log(err);
    }
  }, []);

  return (
    <div className="root">
      <Header />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/trailer/:ytTrailerId" element={<Trailer />} />
        <Route path="/reviews/:movieId" element={
          <Reviews
            setReviews={setReviews}
            reviews={reviews}
            movie={movie}
            getMovieData={getMovieData}
          />} />
      </Routes>
    </div>
  );
}

export default App;
