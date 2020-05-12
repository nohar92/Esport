package com.Amy.esport;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Example {
    public static void main(String[] args) {
        String key = "";
        InputStream keyin = Example.class.getClassLoader().getResourceAsStream("key.txt");
        if (keyin != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(keyin));
            try {
                while (reader.ready()) {
                    key = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("key = " + key);

        ApiConfig config = new ApiConfig().setKey(key);
        RiotApi api = new RiotApi(config);

        if (args[0] != null) {
            try {
                Summoner summoner = api.getSummonerByName(Platform.EUNE, args[0]); // barbár módjára
                System.out.println("Name: " + summoner.getName());
            } catch (RiotApiException e) {
                e.printStackTrace();
            }
        }
    }
}
