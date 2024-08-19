import { useQuery } from '@tanstack/react-query';

import { fetchMovies, fetchMovieById } from './api';

export const useGetMovies = () => {
    return useQuery({
        queryKey: [ 'movies' ],
        queryFn: fetchMovies,
    });
};

export const useGetMovieById = (movieId: string) => {
    return useQuery({
        queryKey: [ 'movie', movieId ],
        queryFn: () => fetchMovieById(movieId),
    });
};
