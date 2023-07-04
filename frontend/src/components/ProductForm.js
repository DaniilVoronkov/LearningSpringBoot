import {Component, useEffect, useState} from "react";
import "../Styling/FormsStyling.css";
import {useParams} from "react-router-dom";

export default function ProductForm() {


    const [productValue, setValue] = useState({
        product: "",

    });
    const [test, updateTypes] = useState({
        productTypes: []
    })



    let currentPath = window.location.pathname;
    let splittedPath = currentPath.split("/");


    let {id} = useParams();

    const myFunc = async () => {
        if (id !== 'NewProduct') {
           await fetch('/' + splittedPath[1] + '/' + id)
                .then(response => response.json())
                .then(data => setValue({product: data}));
        }

      await fetch('/' + splittedPath[1] + '/all' + splittedPath[1] + 'Types')
            .then(response => response.json())
            .then(data => updateTypes({productTypes: data}));

    }

    useEffect(() => {
       void myFunc();
    }, []);




        let isProductNew = id === 'NewProduct';
        const buttonText = isProductNew ? 'Add Product' : 'Edit Product';
        console.log(JSON.stringify(productValue))
        return (
            <form id="editForm">
                <div className="form-group">
                    {/* <!-- Product name input --> */}
                    <label htmlFor="productName">Product Name:</label>
                    <input id="productName" type="text" name="productName" placeholder="Name of the product"
                           maxLength="100"
                           className="form-control" value={isProductNew ? '' : productValue.product.name}/>
                    <label htmlFor="productName" className="errorMessage productNameError"
                           id="productNameError"></label>
                </div>

                <div className="form-group">
                    {/* <!-- Product price input --> */}
                    <label htmlFor="productPrice">Price:</label>
                    <input id="productPrice" type="number" name="productPrice" placeholder="Product price:"
                           className="form-control" value={isProductNew ? '' : productValue.product.price}/>
                    <label htmlFor="productPrice" className="errorMessage" id="productPriceError"></label>
                </div>

                {/*<div className="form-group">*/}
                {/*    /!* <!-- product type select --> *!/*/}
                {/*    <label htmlFor="productType">Product Type:</label>*/}
                {/*    <select name="productType" id="productType" className="form-select form-control">*/}
                {/*        {test.map(type => <option value={type.label}></option>)}*/}
                {/*    </select>*/}
                {/*</div>*/}

                <div className="form-group">
                    {/* <!-- Edit button --> */}
                    <button id="editButton" type="button" className="btn btn-primary active">{buttonText}</button>
                </div>
            </form>
        );

}