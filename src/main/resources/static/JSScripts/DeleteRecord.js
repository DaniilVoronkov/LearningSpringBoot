function deleteRecord(productType, productName) {
    $.ajax({
        url: 'http://localhost:8080/' + productType + '/Delete/' + productName,
        type: 'DELETE',
        success: function () {
            window.location = '/Teas/TeaProducts'
        }
    });
}