import { AxiosResponse } from "axios";
import { apiAxios } from "api/config";
import { Movie } from "models/types";

export const fetchMovies = async () => {
    const { data, status }: AxiosResponse<Movie[]> = await apiAxios.get('/movies');

    if (status !== 200) {
        throw new Error('Network response was not ok');
    }

    return data;
};

export const fetchMovieById = async (movieId: string) => {
    const { data, status }: AxiosResponse<Movie> = await apiAxios.get(`/movies/${movieId}`);

    if (status !== 200) {
        throw new Error('Network response was not ok');
    }

    return data;
};

