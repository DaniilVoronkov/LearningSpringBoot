import {Component} from "react";
import {Link} from "react-router-dom";

export default class ProductsData extends Component {
    constructor(props) {
        super(props);
        this.state = {products: []};

    }

    async componentDidMount() {

        const fetchPath = window.location.pathname;

        await fetch(fetchPath)
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
        console.log(this.state.products)

        return products.map(product => {
            const concatenatedClassPlusType = product.className.toLowerCase() + "Type";

            return <tr key={product.id}>
                <td>{product.name}</td>
                <td>{product.price}</td>
                <td>{product[concatenatedClassPlusType]}</td>
                <td>{product.className}</td>
                <td>

                    <button type="button" onClick={() => this.remove(product.className, product.id)}>
                        Delete
                    </button>

                </td>
                <td>
                    <Link to={'/' + product.className + "/EditProductPage/" + product.id}>
                        <button>Edit</button>
                    </Link>
                </td>

            </tr>
        });
    }
}