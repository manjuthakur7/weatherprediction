document.addEventListener("DOMContentLoaded", function () {
    const locationInput = document.getElementById("locationInput");
    const getWeatherButton = document.getElementById("getWeatherButton");
    const weatherDisplay = document.getElementById("weatherDisplay");

    getWeatherButton.addEventListener("click", function () {
        const location = locationInput.value;

        // Fetch weather data from an API
        fetchWeatherData(location)
            .then(data => {
                weatherDisplay.textContent = "Weather for " + location + ":\n" + data;
            })
            .catch(error => {
                // Display an error message to the user
                weatherDisplay.textContent = "Error: " + error.message;
            });
    });

    // Function to fetch weather data from the server
    function fetchWeatherData(location) {
        // Use the Fetch API to make the API request
        return fetch(`https://api.example.com/weather?location=${location}`)
            .then(response => {
                if (!response.ok) {
                    // Handle non-successful responses (e.g., 404 or 500 errors)
                    throw new Error(`Failed to fetch weather data for ${location}`);
                }
                return response.json();
            })
            .then(data => {
                // Check if the API response contains an error message
                if (data.error) {
                    throw new Error(data.error.message);
                }
                return data;
            });
    }
});
