import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        URL accuWeatherUrl = new URL("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=V3gwcyf5ol53VdF7SN0uTiF2KnaTKmJm&language=ru-ru&metric=true");
        HttpURLConnection urlConnection = (HttpURLConnection) accuWeatherUrl.openConnection();
        StringBuilder response = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        System.out.println(response);
    }
}
