package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class FileReader {
    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            String currentLine = "";
            Map<String, String> data = new HashMap<>();
            while ((currentLine = reader.readLine()) != null) {
                String[] keyValue = currentLine.split(": ");
                data.put(keyValue[0].toLowerCase(), keyValue[1]);
            }
            System.out.println(data);
            Profile profile = new Profile(
                    data.get("name"),
                    Integer.parseInt(data.get("age")),
                    data.get("email"),
                    Long.parseLong(data.get("phone"))
            );
            return profile;
        } catch (IOException e) {
            return new Profile();
        }
    }
}
