
console.log("hi");

var token = $('#csrfToken').val();
var header = $('#csrfHeader').val();

// $("#b1").click(function () {
//     console.log("cll");
//     $.ajax({
//         url:'/show',
//         type:'get',
//         success:function (response) {
//             console.log(response);
//             $("#showDiv").empty();
//             for (let i=0;i<response.length;i++){
//                 $('<div style="border: solid royalblue 1px"/>')
//                 $('<p/>',{text:response[i].productName}).appendTo("#showDiv");
//                 $('<p/>',{text:response[i].productType}).appendTo("#showDiv");
//                 $('</div>')
//             }
//         },
//         error:function () {
//             alert("bad")
//         }
//     });
// });

$('#setEnable').click(function () {
    var enable=$('select').val();
    let atribute=$(this).attr("atribute");
    // var user={id:atribute,enable:enable}
    $.ajax({
        url:'/admin/listOfUsers/banUser',
        type:'get',
        // data:JSON.stringify(user),
        data:JSON.stringify({atribute:atribute}),
        data:JSON.stringify({enable:enable}),
        contentType:'application/json',

        success:function () {
            alert(enable)
        },
        error:function () {
            alert("no")
            alert(enable)
            alert(atribute)

        }


    });
});

// $('delProduct-${product.id}').click(function () {
//     var delet=$('id').val();
//
//     $.ajax({
//         url:'/userPage/delProduct-${product.id}',
//         type:'GET',
//         data:JSON.stringify({delete:delet}),
//         contentType:'application/json',
//         success:function (result) {
//             alert(result.delet)
//         },
//         error:function () {
//             alert("no")
//         }
//     });
// });