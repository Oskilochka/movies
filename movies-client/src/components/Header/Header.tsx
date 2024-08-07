import React from "react";
import { Button, Container, Nav, Navbar, NavLink } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faVideoSlash } from "@fortawesome/free-solid-svg-icons";

export const Header = React.memo(() =>
    (
        <Navbar bg="dark" variant="l" expand="lg">
            <Container fluid>
                <Navbar.Brand href="/" style={{ color: "yellow" }}>
                    <FontAwesomeIcon icon={faVideoSlash} />
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse>
                    <Nav className="me-auto my-2 my-lg-0">
                        <NavLink href="/">Home</NavLink>
                        <NavLink href="/watchList">Watch List</NavLink>
                    </Nav>
                    <Button variant="outline-info" className="me-2">Login</Button>
                    <Button variant="outline-info" className="me-2">Register</Button>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    ));
