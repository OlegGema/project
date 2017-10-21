
console.log("hi");

$("#b1").click(function () {
    console.log("cll");
    $.ajax({
        url:'/show',
        type:'get',
        success:function (response) {
            console.log(response);
            $("#showDiv").empty();
            for (let i=0;i<response.length;i++){
                $('<div style="border: solid royalblue 1px"/>')
                $('<p/>',{text:response[i].productName}).appendTo("#showDiv");
                $('<p/>',{text:response[i].productType}).appendTo("#showDiv");
                $('</div>')
            }
        },
        error:function () {
            alert("bad")
        }
    });
});

$('#setEnabled-${user.id}').click(function () {
    var enable=$('select').val();

    $.ajax({
        url:'/admin/banUser-${user.id}',
        type:'GET',
        data:JSON.stringify({enable:enable}),
        contentType:'application/json',
        success:function (result) {
            alert(result.enable)
        },
        error:function () {
            alert("no")
        }
    });
});

$('delProduct-${product.id}').click(function () {
    var delet=$('id').val();

    $.ajax({
        url:'/userPage/delProduct-${product.id}',
        type:'GET',
        data:JSON.stringify({delete:delet}),
        contentType:'application/json',
        success:function (result) {
            alert(result.delet)
        },
        error:function () {
            alert("no")
        }
    });
});