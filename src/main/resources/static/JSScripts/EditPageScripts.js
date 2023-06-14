import {isProductDataValid} from "./Validation.js";
import {createObjectForSending} from "./CreateObjectForSending.js";

$("#editButton").on("click", function () {
    if(isProductDataValid()) {
        const objectToSend = createObjectForSending();


        Promise.resolve(
            $.ajax({
                url: '/' + productClass + '/Edit/' + productId,
                type: 'PATCH',
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
            })).catch(function (e) {
                alert(e)
            })
    }
});