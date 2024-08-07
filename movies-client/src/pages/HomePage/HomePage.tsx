import React from "react";
import { Paper } from "@mui/material";
import Carousel from "react-material-ui-carousel";
// import api from "api/axiosConfig";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCirclePlay } from "@fortawesome/free-solid-svg-icons";
import { Link, useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";
import styles from "./style.module.scss";
import { getMovies, Movie, useMoviesList } from "../../api/movie.api";
import { useApiGet } from "api/axiosConfig";

export const HomePage = React.memo(() => {
    // const [ movies, setMovies ] = React.useState([]);
    const navigate = useNavigate();
    const reviews = (movieId: string) => {
        navigate(`/reviews/${movieId}`);
    };

    const { data, isLoading } = useMoviesList()

    console.log(data, isLoading)

    if (isLoading) {
        return <div>Loading</div>;
    }

    // if (isError || isLoadingError) {
    //     return <div>Error</div>
    // }

    return (
        <Carousel className={styles.carousel}>
            {
                (data as Movie[])?.map((el: Movie) => {
                    return (
                        <Paper key={el?.imdbId}>
                            <div className={styles.wrapper}>
                                <div
                                    className={styles.item}
                                    style={{ backgroundImage: `url(${el?.backdrops?.[0]})` }}
                                >
                                    <div className={styles.details}>
                                        <div className={styles.poster}>
                                            <img src={el?.poster} alt="poster" />
                                        </div>
                                        <p className={styles.title}>
                                            {el?.title}
                                        </p>
                                        <div className={styles.btnWrap}>
                                            <Link
                                                to={`/trailer/${el?.trailerLink?.substring(el?.trailerLink?.length - 11)}`}>
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
