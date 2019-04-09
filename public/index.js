$(document).ready(function() {  

  console.log("index is ready");  

// read() command trigger

  $('#read').click(function(event) {
    // const headers = new Headers({
    //   "Content-Type": "application/json",
    // });
    // fetch('/buy', {
    //   method: 'post',
    //   headers: headers,
    //   body: JSON.stringify({ itemName: $('#itemName').val() }),
    // })
    // .then(() => {
    //   location.reload(true);
    // })
    // .catch(function() {
    //   // Error
    // });
  console.log("index is ready"); 
  });


// write() command trigger

  $('#write').click(function(event) {
    const headers = new Headers({
      "Content-Type": "application/json",
    });
    fetch('/buy', {
      method: 'post',
      headers: headers,
      body: JSON.stringify({ itemName: $('#itemName').val() }),
    })
    .then(() => {
      location.reload(true);
    })
    .catch(function() {
      // Error
    });
  });

});





  