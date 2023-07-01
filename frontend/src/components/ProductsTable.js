
import {Component} from "react";
import Link from "react-router-dom";
import Button from "bootstrap/js/src/button";


export default class ProductsTable extends Component {

    constructor(props) {
        super(props);
        this.state = {products: []};

    }

    async componentDidMount() {
        let testURL = window.location.pathname;
        let splitted = testURL.split("/");

        const response = await fetch('/' + splitted[1] + '/ProductsTable')
            .then(response => response.json())
            .then(data => this.setState({products: data}));

    }

    async remove(productClass, productId) {
        await fetch(`/${productClass}/Delete/${productId}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedProducts = [...this.state.products].filter(element => element.id !== productId);
            this.setState({products: updatedProducts})
        });
    }

    render() {

        const {products} = this.state;


        const productsList = products.map(product => {

            return <tr key={product.id}>

                <td>{product.name}</td>
                <td>{product.price}</td>
                <td>{product.type}</td>
                <td>

                        <button type="button">
                            Edit
                        </button>

                </td>
                <td>
                    <button onClick={() => this.remove(product.className, product.id)}>Delete</button>
                </td>

            </tr>

        });



        return (
            <table>
                <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Product price</th>
                        <th>Product Type</th>
                    </tr>
                </thead>
                <tbody>
                     {productsList}
                </tbody>
            </table>
        )

    }
}