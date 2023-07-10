export function deleteRecord(productClass, productId) {
    $.ajax({
        url: '/' + productClass + '/Delete/' + productId,
        type: 'DELETE',
        success: function () {
            window.location = '/' + productClass + '/ProductsTable'
        }
    });
}