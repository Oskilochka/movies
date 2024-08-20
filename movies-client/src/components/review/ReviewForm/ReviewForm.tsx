import React, { RefObject } from "react";

import { Button, Form } from "react-bootstrap";

type ReviewFormProps = {
    handleSubmit: (e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => void,
    labelText: string,
    defaultValue?: string,
    reviewText?: RefObject<HTMLTextAreaElement> | null,
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
