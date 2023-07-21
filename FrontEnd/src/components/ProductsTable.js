import {Container} from "reactstrap";
import ProductsData from "./ProductsData";
import {Link, useLocation} from "react-router-dom";
import "../Styling/TablePageStyling.css";


export default function ProductsTable() {

    let tableStyling = "table table-bordered table-hover mx-auto";

    let productClass = useLocation().pathname.split("/")[1];
        return (
            <div>
                <Container fluid>
                    <div className="float-right">
                        <Link to={"/" + productClass + "/EditProductPage/NewProduct"} id="AddProductButton">{"Add " + productClass}</Link>
                    </div>
                    <table className={tableStyling}>
                        <thead className="thead-dark">
                            <tr>
                                <th>Product Name</th>
                                <th>Product price</th>
                                <th>Product Type</th>
                                <th>Product class</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                             <ProductsData/>
                        </tbody>
                    </table>
                </Container>
            </div>
        )
    }
