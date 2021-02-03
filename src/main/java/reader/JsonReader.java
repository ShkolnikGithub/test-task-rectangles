package reader;

import model.Rectangle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonReader {

    public List<Rectangle> readFromFile(String pathToFile) {
        List<Rectangle> rectangleList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(pathToFile);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) jsonObject.get("rects");
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject obj = (JSONObject) iterator.next();

                Rectangle rectangle = new Rectangle();
                double x1 = (Double) obj.get("x1");
                double x2 = (Double) obj.get("x2");
                double y1 = (Double) obj.get("y1");
                double y2 = (Double) obj.get("y2");
                rectangle.setX1(Math.min(x1, x2));
                rectangle.setX2(Math.max(x1, x2));
                rectangle.setY1(Math.max(y1, y2));
                rectangle.setY2(Math.min(y1, y2));

                rectangleList.add(rectangle);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rectangleList;
    }

    public String getPathToFile() {
        String pathToFile = null;

        System.out.println("Specify the path to the file for reading: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            pathToFile = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pathToFile;
    }
}
