package writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Rectangle;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JsonWriter {

    public static void writeToFile(List<Rectangle> rectangleList, String pathToFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("rects", rectangleList);
            objectMapper.writeValue(new File(pathToFile), jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPathToFile() {
        String pathToFile = null;

        System.out.println("Specify the path to the file for writing: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            pathToFile = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pathToFile;
    }
}
