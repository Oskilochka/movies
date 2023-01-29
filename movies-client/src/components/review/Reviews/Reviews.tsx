import React, { useRef } from "react";
import { Col, Container, Row } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { ReviewForm } from "../ReviewForm";
import api from "api/axiosConfig";

type ReviewsProps = {
  getMovieData: (movieId: string) => void,
  movie: any,
  reviews: any,
  setReviews: any
}

export const Reviews = React.memo<ReviewsProps>((
  {
    getMovieData,
    movie,
    reviews,
    setReviews,
  },
) => {
  const reviewText = useRef();
  const { movieId } = useParams();

  React.useEffect(() => {
    getMovieData(movieId!);
  }, [ getMovieData, movieId ]);

  const addReview = React.useCallback(async (e: any) => {
    e.preventDefault();
    const review: any = reviewText.current;

    try {
      await api.post("/api/v1/reviews",
        {
          reviewContent: review?.value,
          imdbId: movieId,
        });

      const updatedReviews = [ ...reviews, { body: review?.value } ];
      setReviews(updatedReviews);
      review.value = "";
    } catch (e) {
      console.log(e);
    }

  }, [ setReviews, movieId, reviews ]);

  return (
    <Container>
      <Row>
        <Col>
          <p>Reviews</p>
        </Col>
      </Row>
      <Row className="mt-2">
        <Col>
          <img src={movie?.poster} alt="poster" />
        </Col>
        <Col>
          {
            <Row>
              <Col>
                <ReviewForm reviewText={reviewText} handleSubmit={addReview} labelText="Write a review" />
              </Col>
            </Row>
          }
          {
            reviews?.map((review: any) =>
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
});