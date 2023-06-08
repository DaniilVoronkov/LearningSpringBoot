function deleteRecord(productClass, productName) {
    $.ajax({
        url: 'http://localhost:8080/' + productClass + '/Delete/' + productName,
        type: 'DELETE',
        success: function () {
            window.location = '/' + productClass + '/TeaProducts'
        }
    });
}