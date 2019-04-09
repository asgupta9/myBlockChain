$(document).ready(function() {  

  console.log("index is ready");  

// read() command trigger

  $('#read').click(function(event) {
    const headers = new Headers({
      "Content-Type": "application/json",
    });
    fetch('/read', {
      method: 'get',
      headers: headers,
      // body: JSON.stringify({ itemName: $('#itemName').val() }),
    })
    .then(res => res.json())
    .then(res => {
      console.log(res);  
      // location.reload(true);
    })
    .catch(function() {
      // Error
    });
  });

// write() command trigger

  $('#write').click(function(event) {
    const headers = new Headers({
      "Content-Type": "application/json",
    });
    fetch('/write', {
      method: 'get',
      headers: headers,
      // body: JSON.stringify({ itemName: $('#itemName').val() }),
    })
    .then(res => res.json())
    .then(res => {
      console.log(res);  
      // location.reload(true);
    })
    .catch(function() {
      // Error
    });
  });


});





  