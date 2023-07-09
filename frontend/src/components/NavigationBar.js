import {Component} from "react";
import {Navbar, NavLink} from "reactstrap";

export default class NavigationBar extends Component {

    render() {
        return <Navbar>
            <NavLink href="/" className="NavigationLink">Home</NavLink>
            <NavLink href="#" className="NavigationLink">All Products</NavLink>
            <NavLink  href="/Tea/ProductsTable" name="Tea" className="NavigationLink">Tea Products</NavLink>
            <NavLink href="#" className="NavigationLink">Coffee products</NavLink>
        </Navbar>
    }
}