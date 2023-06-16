import {isProductDataValid} from "./Validation.js";
import {createObjectForSending} from "./CreateObjectForSending.js";

//when we click on the edit button - trigger the edit process in the controller
$("#editButton").on("click", function () {
    if(isProductDataValid()) {
        performEdit();
    }
});



    function performEdit () {
        //getting the user input as object
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
            }))

    }