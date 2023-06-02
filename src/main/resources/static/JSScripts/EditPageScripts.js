$("#editButton").bind("click", function () {
    const testObj = {
        name: $("#productName").val(),
        price: $("#productPrice").val(),
        type: $("#productType option:selected").text()
    };
    $.ajax({
        async: false,
        url: 'http://localhost:8080/Teas/Edit/' + productId,
        type: 'PATCH',
        data: JSON.stringify(testObj),
        dataType: "JSON",
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            // alert("WOW!!!")
            window.location = '/Teas/TeaProducts'
            history.go(-1)
        }
    });
});