import {Component} from "react";
import {Navbar, NavLink} from "reactstrap";

export default class NavigationBar extends Component {

    render() {
        return <Navbar>
            <NavLink  href="/Tea/ProductsTable">Tea List</NavLink>
        </Navbar>
    }
}