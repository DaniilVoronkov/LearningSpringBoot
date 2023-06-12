$("#editForm").on("submit", function () {
    const testObj = {
        name: $("#productName").val(),
        price: $("#productPrice").val(),
        type: $("#productType option:selected").text()
    };

    Promise.resolve(
        $.ajax({
            url: '/Tea/Edit/' + productId,
            type: 'PATCH',
            data: JSON.stringify(testObj),
            dataType: "text",
            contentType: "application/json; charset=utf-8",
        })).then($.ajax({
        url: '/',
        type: 'GET',
        success: function () {
            window.location = '/'
        }
    })).catch(function (e) {
        alert(e)
    })
});