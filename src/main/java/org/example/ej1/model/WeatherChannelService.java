package org.example.ej1.model;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class WeatherChannelService implements ClimaOnline{

    private String apiKey;

    public WeatherChannelService(String apiKey) {
        this.apiKey = apiKey;
    }


    @Override
    public String temperatura() {
        try {
            String urlStr = "https://api.openweathermap.org/data/2.5/weather?q=Viedma,AR&units=metric&appid=" + apiKey;
            URL url = new URL(urlStr);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status != 200) {
                throw new RuntimeException("Error en la conexión: código " + status);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            // Parse JSON
            JSONObject json = new JSONObject(content.toString());
            double temp = json.getJSONObject("main").getDouble("temp");

            return temp + " °C";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error obteniendo temperatura";
        }
    }
}
