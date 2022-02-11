import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class API {

    API() {
    }

    public double getMarketPrice(String coinCode) {
        try {
            String priceBTCUrl = "https://api.coinbase.com/v2/prices/" + coinCode + "-USD/spot";

            HttpResponse<JsonNode> jsonResponse =
                    Unirest.get(priceBTCUrl).header("accept", "application/json").asJson();

            JSONObject json = (JSONObject)jsonResponse.getBody().getObject().get("data");
            return json.getDouble("amount");

        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void getHistoricalData(String coinCode) {
        try {
            String priceBTCUrl = "https://api.coinbase.com/v2/prices/BTC-USD/historic?period=hour";

            HttpResponse<JsonNode> jsonResponse =
                    Unirest.get(priceBTCUrl).header("accept", "application/json").asJson();

            String responseBody = jsonResponse.getBody().toString();

            System.out.println(responseBody);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
