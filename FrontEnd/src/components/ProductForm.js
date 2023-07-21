import {useEffect, useState} from "react";
import {useForm} from "react-hook-form";
import {useParams} from "react-router-dom";
import {ErrorMessage} from "@hookform/error-message";

//Styling
import "../Styling/ValidationStyling.css";
import "../Styling/FormsStyling.css";


export default function ProductForm() {

    //variable that will hold the product object
    const [productValue, setValue] = useState({
        product: "",
    });
    //product types
    const [productTypes, updateTypes] = useState({
        Types: []
    });

    //getting product class from the url
    let productClass = window.location.pathname.split("/")[1];

    //variable that holds id of the product (which is passed as the URL parameter)
    let {id} = useParams();

    //function that holds all the data about the product + its possible types
    const loadData = async () => {
        //getting the product data
        if (id !== 'NewProduct') {
            await fetch('/' + productClass + '/' + id)
                .then(response => response.json())
                .then(data => setValue({product: data}));
        }

        //getting all the possible types of the product
        await fetch('/' + productClass + '/all' + productClass + 'Types')
            .then(response => response.json())
            .then(data => updateTypes({Types: data}));
    }


    useEffect(() => {
       void loadData();
       //setting the page title based on the type of the product
       document.title = productClass + (isProductNew ? " Add " : " Edit ") + "Form";
    }, []);

    //react-hook-form values
    const {register, handleSubmit, formState: {errors}} = useForm({
        defaultValues: loadData
    });

        //check if we are adding a product or working with existing one
        let isProductNew = id === 'NewProduct';
        //generate button text based on the type of the product (new or existing one)
        const buttonText = isProductNew ? 'Add ' + productClass : 'Edit ' + productClass;

        //function that triggers when we submit the form with valid data
        const onSubmit = async data => {
                await fetch("/" + productClass + "/"+ (isProductNew ? "AddProduct" : "Edit/" + id), {
                    method: isProductNew ? "PUT" : "PATCH",
                    headers: {
                        "Content-Type": "application/json; charset=utf-8",
                    },
                    body: JSON.stringify(data)
                }).then(() => window.location.href="/" + productClass + "/ProductsTable")
        };

        return (
            <form id="editForm" onSubmit={handleSubmit(onSubmit)}>
                <div className="form-group">
                    {/* <!-- Product name input --> */}
                    <label htmlFor="productName">Product Name:</label>
                    {/* Default value property - for initial load!!! */}
                    <input id="productName" type="text" name="name" placeholder="Name of the product"
                           maxLength="100"
                           className="form-control" defaultValue={isProductNew ? '' : productValue.product.name}
                           {...register("name", {
                               required: "Product name is required",
                               pattern: {
                                   value: /^[a-zA-Z\s]{2,40}$/,
                                   message: "Product name can contain only letter and spaces and must be between 2 and 40 characters in length"
                               }
                           })}
                    />
                    <ErrorMessage name="name" errors={errors} render={({message}) => <p className="errorMessage">{message}</p>}></ErrorMessage>
                </div>

                <div className="form-group">
                    {/* <!-- Product price input --> */}
                    <label htmlFor="productPrice">Price:</label>
                    <input id="productPrice" type="text" inputMode="decimal" pattern="[0-9]{2,10}[,.]?[0-9]{0,2}" name="productPrice" placeholder="Product price:"
                           className="form-control" defaultValue={isProductNew ? '' : productValue.product.price}
                           {...register("price", {
                               min: {
                                   value: 1,
                                   message: "Product price can't be less than 0!"
                               },
                               max: {
                                   value: 99999.9,
                                   message: "Product price can't be bigger than 99999.9"
                               }
                           })}
                    />
                    <ErrorMessage name="price" errors={errors} render={({message}) => <p className="errorMessage">{message}</p>}></ErrorMessage>
                </div>
                {/*                         If we want to add data dynamically                                         */}
                {/*{*/}
                {/*    Object.keys(productValue.product).map(property => {*/}
                {/*        if(property !== 'id' && property !== 'type') {*/}
                {/*            return (*/}
                {/*                <div className="form-group">*/}
                {/*                    <label htmlFor={property}>{property}</label>*/}
                {/*                    <input id={property} type={property === 'price' ? "number" : "text"} placeholder={property} className="form-control"/>*/}
                {/*                </div>*/}
                {/*        )*/}
                {/*        }*/}
                {/*    })*/}
                {/*}*/}

                    <div className="form-group">
                        {/* <!-- product type select --> */}
                        <label htmlFor="productType">Product Type:</label>
                        <select name="productType" id="productType" className="form-select form-control" {...register("type")}>
                            {productTypes.Types.map(type => <option key={type} defaultValue={type}>{type}</option>)}
                        </select>
                    </div>

                <div className="form-group">
                    {/* <!-- Edit button --> */}
                    <button id="editButton" type="submit" className="btn btn-primary active">{buttonText}</button>
                </div>
            </form>
        );

}