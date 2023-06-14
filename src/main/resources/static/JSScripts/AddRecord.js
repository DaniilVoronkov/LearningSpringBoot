import {isProductDataValid} from "./Validation.js";
import {createObjectForSending} from "./CreateObjectForSending.js";


$("#createButton").on("click", function () {
    alert(isProductDataValid())
    if(isProductDataValid()) {
        performAdding();
    }
})
function performAdding () {

        const objectToSend = createObjectForSending();

        Promise.resolve(
            $.ajax({
                url: 'http://localhost:8080/' + productClass + '/AddProduct',
                type: 'PUT',
                data: JSON.stringify(objectToSend),
                dataType: "json",
                contentType: "application/json; charset=utf-8",
            })).then(
            $.ajax({
                url: '/' + productClass + '/ProductsTable',
                type: 'GET',
                success: function () {
                    window.location = '/' + productClass + '/ProductsTable'
            }
        }))
}