import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
import { Review } from 'models/types';
import { fetchReviews, createReview } from './api';
import { CreateReviewPayload } from './types';

export const useGetReviews = () => {
    return useQuery({
        queryKey: [ 'reviews' ],
        queryFn: fetchReviews,
    });
};

export const useCreateReview = () => {
    const queryClient = useQueryClient();

    return useMutation<Review, Error, CreateReviewPayload>({
        mutationFn: createReview,
        onSuccess: (data, variables) => {
            queryClient.setQueryData<Review[]>([ 'reviews', variables.imdbId ],
                (oldData = []) => [
                    ...oldData,
                    data,
                ]);
        },
        onError: (error) => {
            console.log(error);
        },
    });
};
