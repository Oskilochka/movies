import { useMutation, UseMutationOptions, useQuery, useQueryClient } from '@tanstack/react-query';
import axios from 'axios';

export type Review = {
    id: object,
    body: string,
}

export const fetchReviews = async (d: any) => {
    const res = await fetch('http://localhost:8080/api/v1/reviews');

    if (!res.ok) {
        throw new Error('Network response was not ok');
    }

    return await res.json();
};

export const useReviews = () => {
    return useQuery({
        queryKey: [ 'reviews' ],
        queryFn: fetchReviews,
    });
};




interface ReviewQ {
    reviewContent: string;
    imdbId: string;
}

interface ReviewResponse {
    id: string;
    reviewContent: string;
    imdbId: string;
}

const postReview = async ({ reviewContent, imdbId }: ReviewQ) => {
    const response = await axios.post('/api/v1/reviews', {
        reviewContent,
        imdbId,
    });
    return response.data;
};

export const useAddReview = () => {
    const queryClient = useQueryClient();

    return useMutation<ReviewResponse, Error, ReviewQ>({
        mutationFn: postReview,
        onSuccess:(data, variables) => {
            // Оновлюємо кеш з новим відгуком після успішного запиту
            queryClient.setQueryData<ReviewResponse[]>([ 'reviews', variables.imdbId ], (oldData = []) => [
                ...oldData,
                data,
            ]);
        },
        onError: (error) => {
            console.log(error);
        },
    });

};
