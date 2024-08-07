import { useQuery } from '@tanstack/react-query';
import { request } from './axiosConfig';


export type Movie = {
    id: object,
    imdbId: string,
    title: string,
    releaseDate: string,
    trailerLink: string,
    poster: string,
    genres: string[],
    backdrops: string[]
}

export const fetchMoviesList = async () => {
    const res = await fetch('http://localhost:8080/api/v1/movies');

    if (!res.ok) {
        throw new Error('Network response was not ok');
    }

    return await res.json();
};

export const fetchMovie = async (movieId: string) => {
    const res = await fetch(`http://localhost:8080/api/v1/movies/${movieId}`);

    if (!res.ok) {
        throw new Error('Network response was not ok');
    }

    return await res.json();
};

export const useMoviesList = () => {
    return useQuery({
        queryKey: [ 'movies' ],
        queryFn: fetchMoviesList,
    });
};


export const useGetMovie = (movieId: string) => {
    return useQuery({
        queryKey: [ 'movie', movieId ],
        queryFn: () => fetchMovie(movieId),
    });
};

///////////////////////

export const getMovies = () =>
    request({
        url: `/api/v1/movies`,
        method: "GET",
    })

export const getMovieById = (movieId: string) =>
    request({
        url: `/api/v1/movies/${movieId}`,
        method: "GET",
    })
