import React, { useRef, useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { ReviewForm } from "../ReviewForm";
import {  Movie, useGetMovie } from "api/movie.api";
import { useAddReview } from "../../../api/review.api";

export const Reviews = React.memo(() => {
    const reviewText = useRef();
    const { movieId } = useParams();
    const [ reviews, setReviews ] = useState<any[]>([])

    const { mutate } = useAddReview();

    const addReview = React.useCallback(async (e: any) => {
        e.preventDefault();
        const review: any = reviewText.current;

        try {

            mutate(
                { reviewContent: review, imdbId: movieId || '' },
                {
                    onSuccess: (data) => {
                        // Оновлюємо локальний стан після успішного додавання відгуку
                        setReviews((oldReviews) => [ ...oldReviews, { body: review } ]);
                        if (reviewText.current) {
                            (reviewText.current as any).value = '';
                        }
                    },
                }
            );

            const updatedReviews: any = [ ...reviews, { body: review?.value } ];
            setReviews(updatedReviews);
            review.value = "";
        } catch (e) {
            console.log(e);
        }

    }, [ mutate, movieId, reviews ]);

    const { data } =  useGetMovie(movieId || "")

    return (
        <Container>
            <Row>
                <Col>
                    <p>Reviews</p>
                </Col>
            </Row>
            <Row className="mt-2">
                <Col>
                    <img src={(data as Movie)?.poster} alt="poster" />
                </Col>
                <Col>
                    {
                        <Row>
                            <Col>
                                <ReviewForm reviewText={reviewText} handleSubmit={addReview}
                                    labelText="Write a review" />
                            </Col>
                        </Row>
                    }
                    {
                        (reviews as any)?.map((review: any) =>
                            <Row>
                                <Col key={review?.imdbId}>
                                    {review?.body}
                                </Col>
                            </Row>)
                    }
                </Col>
            </Row>
        </Container>
    );
})
;
