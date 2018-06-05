# edge-service

Simple service with fallback capabilities (Hystrix) which prevent the client from receiving an HTTP error when the service is not available.

# Start the application
./mvnw spring-boot:run

After it starts you should be able to open: [http://localhost:8763/good-beers](http://localhost:8763/good-beers) endpoint which will deliver a filtered list of from the [https://github.com/ldimitrov/beer-catalog-service](https://github.com/ldimitrov/beer-catalog-service)

If you start the following eureka service:

[https://github.com/ldimitrov/eureka-service](https://github.com/ldimitrov/eureka-service) you should see the `edge-service` as a registered instance with Eureka. If the `beer-catalog-service` is not available the default fallback method will return an empty list.
