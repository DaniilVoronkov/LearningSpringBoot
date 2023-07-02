
import {Component} from "react";
import Link from "react-router-dom";
import Button from "bootstrap/js/src/button";
import {Container} from "reactstrap";
import ProductsData from "./ProductsData";
import {remove} from "../Scripts/ProductInteractions";


export default class ProductsTable extends Component {

    render() {
        return (
            <Container fluid>
                <table>
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th>Product price</th>
                            <th>Product Type</th>
                        </tr>
                    </thead>
                    <tbody>
                         <ProductsData/>
                    </tbody>
                </table>
            </Container>
        )
    }
}