AIRLINE DEMO
This is a demo application. It exposes an API to create and search for flight reservations.

Getting started:
The application can be run on docker using the 'docker-compose up' command from the main demo folder.
This app is configured for the windows docker host 192.168.99.100. If using another operating system or a different docker ip,
the spring.data.mongodb.host property must be modified at the application.properties file.

Using the API:
Reservations can be created using the following POST endpoint: /reservations
Request body example:
	{
		"flight": {
			"departure":"2020-06-17 23:20",
			"arrival": "2020-06-18 07:10",
			"origin": "BUE",
			"destination": "MIA"
		},
		"passenger": {
			"name": "lucy",
			"age":40
		},
		"price": 222.45,
		"luggageAllowed": true
	}

It will return the reservation using the same formatted, but adding the generated reservationId. For example:
	{
		"reservationId": "70ffd5a2-c72f-4ec0-b381-a740932c1b28",
		"flight": {
			"departure": "2020-06-17 23:20",
			"arrival": "2020-06-18 07:10",
			"origin": "BUE",
			"destination": "MIA"
		},
		"passenger": {
			"name": "lucy",
			"age": 40
		},
		"price": 222.45,
		"luggageAllowed": true
	}

Reservations can also be searched by Id, using the GET endpoint /reservations/{ID}
For example: /reservations/70ffd5a2-c72f-4ec0-b381-a740932c1b