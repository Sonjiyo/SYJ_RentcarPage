function sendFetchRequest(url, method, query, successCallback) {
    fetch(url, {
      method: method,
      headers: {
    	  "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
      },
      body:query
    })
      .then(response => response.text())
      .then(data => successCallback(data))
      .catch(error => console.error('Error:', error));
}