const btnlogin = document.getElementById('btnlogin');

btnlogin.addEventListener('click', () => {
    // Define the API endpoint URL
    const apiUrl = 'https://localhost:8080/api/user/getjsbyID/1'; // Replace with your API endpoint URL

    // Make the API request using the Fetch API
    fetch('http://localhost:8080/api/user/getUser')
    .then(response => {
        if (!response.ok) {
            console.error('Response not okay:', response.status, response.statusText);
        }
        return response.json();
    })
    .then(data => {
        // Handle the response data
        console.log('Response data:', data);
    })
    .catch(error => {
        // Handle and log the error
        console.error('Fetch error:', error);
    });
});
