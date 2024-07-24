document.addEventListener('DOMContentLoaded', function() {
    // Get search parameters from URL
    const urlParams = new URLSearchParams(window.location.search);
    const from = urlParams.get('from');
    const to = urlParams.get('to');
    const departure = urlParams.get('departure');
    const returnDate = urlParams.get('return');
    const tripType = urlParams.get('trip');

    // Construct the API endpoint
    const apiEndpoint = `http://your-backend-url/api/trips?from=${from}&to=${to}&departure=${departure}&return=${returnDate}&trip=${tripType}`;

    fetch(apiEndpoint)
        .then(response => response.json())
        .then(data => {
            const tripsContainer = document.getElementById('trips-container');
            if (data.length > 0) {
                data.forEach(trip => {
                    const tripElement = document.createElement('div');
                    tripElement.className = 'trip';
                    tripElement.innerHTML = `
                        <h3>${trip.title}</h3>
                        <p>${trip.details}</p>
                        <p>Price: $${trip.price}</p>
                    `;
                    tripsContainer.appendChild(tripElement);
                });
            } else {
                tripsContainer.innerHTML = '<p>No trips found.</p>';
            }
        })
        .catch(error => console.error('Error fetching trips:', error));
});
