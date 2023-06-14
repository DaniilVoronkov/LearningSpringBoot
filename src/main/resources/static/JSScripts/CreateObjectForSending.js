export function createObjectForSending() {
    const objectToSend = {
        name: $("#productName").val(),
        price: $("#productPrice").val(),
        type: $("#productType option:selected").text()
    };
    return objectToSend;
}