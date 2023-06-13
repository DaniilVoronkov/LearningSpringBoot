function deleteRecord(productClass, productName) {
    $.ajax({
        url: '/' + productClass + '/Delete/' + productName,
        type: 'DELETE',
        success: function () {
            window.location = '/' + productClass + '/ProductsTable'
        }
    });
}