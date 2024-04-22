package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        final String url = "https://shipoffools.fandom.com/wiki/Devil_Fruit_Encyclopedia";


        JSONObject devilFruitInfo = new JSONObject();


        try {
            // fetching the target website with a Linux user agent

            final Document document = Jsoup.connect(url).get();

            for (Element row : document.select("tbody tr:not(:contains(Creator))")) {

                String japanName = row.select("td:nth-of-type(1)").text().trim();
                String englishName = row.select("td:nth-of-type(2)").text().trim();
                String type = row.select("td:nth-of-type(3)").text().trim();
                String power = row.select("td:nth-of-type(4)").text().trim();
                String user = row.select("td:nth-of-type(5)").text().replaceAll("User:.*", "").trim();

                JSONObject devilFruitJson = new JSONObject();
                devilFruitInfo.put("JPNname", japanName);
                devilFruitInfo.put("ENGname", englishName);
                devilFruitInfo.put("Consumer", user);
                devilFruitInfo.put("Type", type);
                devilFruitInfo.put("Power", power);
                devilFruitInfo.put("Consumer", user);




            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }




    }
}