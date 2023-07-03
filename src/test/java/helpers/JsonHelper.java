package helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonHelper {

    private static JSONObject getJson(File file) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(new FileReader(file));
    }

    public static String getProperty(File file, String key) throws IOException, ParseException {
        JSONObject json = getJson(file);
        return (String) json.get(key);
    }
}
