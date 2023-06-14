//in separate file because it will be used on several pages (currently)
export function isProductDataValid() {
    //variable that stores the result of validation
    let isValid = true;
    //resetting the text of the previous errors (if it's not our first validation)
    document.querySelectorAll(".errorMessage").forEach(elem => elem.innerHTML = "");

    //checking if the name contains only letter and spaces and has a length between 2 and 40
    if(!(/^[a-zA-Z\s]{2,40}$/.test(document.querySelector("#productName").value.trim()))) {
        isValid = false;
        document.querySelector("#productNameError").innerHTML = "Name of the product can contain only letters and spaces!";
    }

    //storing product price value
    let productPrice = document.querySelector("#productPrice").value;
    let productPriceError = document.querySelector("#productPriceError");

    //checking if the product price is a number
    if(!($.isNumeric(productPrice))) {
        productPriceError.innerHTML = "Price can be only a number!";
        isValid = false;
    }
    //checking if the price is bigger than 0 and less than 99999.9
     else if(productPrice <= 0 || productPrice >= 99999.9) {
        productPriceError.innerHTML = "Product Price can't be less than 0 or bigger than 99999.9";
        isValid = false;
    }

    //returning the result of validation
    return isValid;
}