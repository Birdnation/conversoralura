package conversorAlura.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class HTTPService {

	private final String apiKey = "f38a4c40063c2c982a619a42";
    private final String baseUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair";
    private final HttpClient httpClient;
    private final Gson gson;
    
    public HTTPService() {
        this.httpClient = HttpClient.newBuilder()
                                    .version(HttpClient.Version.HTTP_2)
                                    .build();
        this.gson = new Gson();
    }
    
    
    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        
    	String url = String.format("%s/%s/%s", baseUrl, fromCurrency, toCurrency);

        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(url))
                                         .GET()
                                         .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

        if (jsonResponse.get("result").getAsString().equals("success")) {
            double conversionRate = jsonResponse.get("conversion_rate").getAsDouble();
            return amount * conversionRate;
        } else {
            throw new Exception("Error en la API: " + jsonResponse.get("error-type").getAsString());
        }
    }
}