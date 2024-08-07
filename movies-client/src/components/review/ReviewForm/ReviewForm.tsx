import React from "react";
import { Button, Form } from "react-bootstrap";

type ReviewFormProps = {
    defaultValue?: any,
    reviewText: any,
    handleSubmit: any,
    labelText: string
}

export const ReviewForm = React.memo<ReviewFormProps>((
    {
        defaultValue,
        reviewText,
        handleSubmit,
        labelText,
    },
) => {
    return (
        <Form>
            <Form.Group className="mb-3" controlId="exampleFro">
                <Form.Label>
                    {labelText}
                </Form.Label>
                <Form.Control ref={reviewText} as="textarea" rows={3} defaultValue={defaultValue} />
            </Form.Group>
            <Button variant="outline-info" onClick={handleSubmit}>Submit</Button>
        </Form>
    );
});
