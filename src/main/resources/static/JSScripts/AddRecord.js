$("#addProductForm").on("submit", function () {
    const testObj = {
        name: $("#productName").val(),
        price: $("#productPrice").val(),
        type: $("#productType option:selected").text()
    };

    Promise.resolve(
        $.ajax({
            url: 'http://localhost:8080/'+ productClass +'/AddProduct',
            type: 'PUT',
            data: JSON.stringify(testObj),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            // success: function () {
            //    //window.location = '/' + productClass + '/TeaProducts'
            // }
        })).then($.ajax({
        url: '/' + productClass + '/ProductsTable',
        type: 'GET',
        success: function () {
            window.location = '/' + productClass + '/ProductsTable'
        }
    }))
});