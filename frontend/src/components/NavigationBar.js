import {Component} from "react";
import {Navbar, NavbarBrand, NavLink} from "reactstrap";
import Link from "react-router-dom";

export default class NavigationBar extends Component {

    render() {
        return <Navbar>
            <NavbarBrand tag={NavLink} to="/Tea/ProductsTable">Tea List</NavbarBrand>
        </Navbar>
    }
}