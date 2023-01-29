import React from "react";
import { Paper } from "@mui/material";
import Carousel from "react-material-ui-carousel";
import api from "api/axiosConfig";
import styles from "./style.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCirclePlay } from "@fortawesome/free-solid-svg-icons";
import { Link, useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";

export const HomePage = React.memo(() => {
  const [ movies, setMovies ] = React.useState([]);
  const navigate = useNavigate();

  const reviews = (movieId: string) => {
    navigate(`/reviews/${movieId}`);
  };

  const getMovies = React.useCallback(async () => {
    try {
      const response = await api.get("api/v1/movies");
      setMovies(response.data);
    } catch (err) {
      console.log(err);
    }
  }, [ setMovies ]);

  React.useEffect(() => {
    getMovies();
  }, []);

  return (
    <Carousel className={styles.carousel}>
      {
        movies?.map((el: any) => {
          return (
            <Paper key={el?.imdbId}>
              <div className={styles.wrapper}>
                <div
                  className={styles.item}
                  style={{ backgroundImage: `url(${el?.backdrops[0]})` }}
                >
                  <div className={styles.details}>
                    <div className={styles.poster}>
                      <img src={el?.poster} alt="poster" />
                    </div>
                    <p className={styles.title}>
                      {el?.title}
                    </p>
                    <div className={styles.btnWrap}>
                      <Link to={`/trailer/${el?.trailerLink?.substring(el?.trailerLink?.length - 11)}`}>
                        <div className={styles.playIconWrap}>
                          <FontAwesomeIcon icon={faCirclePlay} className={styles.playIcon} />
                        </div>
                      </Link>
                      <Button variant="info" onClick={() => reviews(el?.imdbId)}>Reviews</Button>
                    </div>
                  </div>
                </div>
              </div>
            </Paper>
          );
        })
      }
    </Carousel>
  );
});