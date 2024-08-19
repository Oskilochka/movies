import React, { useRef, useState } from "react";
import { useParams } from "react-router-dom";

import { useCreateReview, useGetMovieById } from "api";
import { Review } from "models/types";
import { Col, Container, Row } from "react-bootstrap";

import { ReviewForm } from "../ReviewForm";

export const Reviews = React.memo(() => {
    const reviewText = useRef<HTMLTextAreaElement>(null);
    const { movieId } = useParams();
    const [ reviews, setReviews ] = useState<Review[]>([])

    const { data } = useGetMovieById(movieId || "")
    const { mutate } = useCreateReview();

    const addReview = React.useCallback(async (e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
        e.preventDefault();
        const review = reviewText.current;

        if (!review) return;

        try {
            mutate(
                { reviewContent: review?.value, imdbId: movieId || '' },
                {
                    onSuccess: () => {
                        setReviews((oldReviews) => [ ...oldReviews, { body: review?.value } ]);
                        if (reviewText.current) {
                            reviewText.current.value = '';
                        }
                    },
                }
            );

            const updatedReviews = [ ...reviews, { body: review?.value } ];
            setReviews(updatedReviews);
            review.value = "";
        } catch (e) {
            console.log(e);
        }

    }, [ mutate, movieId, reviews ]);


    return (
        <Container>
            <Row>
                <Col><p>Reviews</p></Col>
            </Row>
            <Row className="mt-2">
                <Col><img src={data?.poster} alt="poster" /></Col>
                <Col>
                    {<Row>
                        <Col>
                            <ReviewForm
                                reviewText={reviewText}
                                handleSubmit={addReview}
                                labelText="Write a review"
                            />
                        </Col>
                    </Row>}
                    {reviews?.map(review =>
                        <Row key={review?.id}>
                            <Col key={review?.id}>
                                {review?.body}
                            </Col>
                        </Row>
                    )}
                </Col>
            </Row>
        </Container>
    );
});
