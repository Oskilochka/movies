import { apiAxios } from "api/config";
import axios, { AxiosResponse } from "axios";
import { Review } from "models/types";

import { CreateReviewPayload } from "./types";

export const fetchReviews = async () => {
    const { data, status }: AxiosResponse<Review> = await apiAxios.get('/reviews');

    if (status !== 200) {
        throw new Error('Network response was not ok');
    }

    return data;
};

export const createReview = async ({ reviewContent, imdbId }: CreateReviewPayload) => {
    const response = await axios.post('/reviews', {
        reviewContent,
        imdbId,
    });

    return response.data;
};
