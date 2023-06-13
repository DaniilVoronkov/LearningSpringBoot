$("#editForm").on("submit", function () {
    const testObj = {
        name: $("#productName").val(),
        price: $("#productPrice").val(),
        type: $("#productType option:selected").text()
    };


    Promise.resolve(
        $.ajax({
            url: '/' + productClass + '/Edit/' + productId,
            type: 'PATCH',
            data: JSON.stringify(testObj),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
        })).then($.ajax({
            url: '/' + productClass + '/ProductsTable',
            type: 'GET',
            success: function () {
                window.location = '/' + productClass + '/ProductsTable'
            }
        })).catch(function (e) {
            alert(e)
        })
});