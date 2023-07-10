//creating an object based on the input fields
export function createObjectForSending() {
    return {
        name: $("#productName").val(),
        price: $("#productPrice").val(),
        type: $("#productType option:selected").text()
    };
}