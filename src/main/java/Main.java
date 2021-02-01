import service.IntersectRectangles;
import model.Rectangle;
import reader.JsonReader;
import writer.JsonWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        JsonWriter jsonWriter = new JsonWriter();
        IntersectRectangles intersect = new IntersectRectangles();

        String fileForReading = jsonReader.getPathToFile();
        List<Rectangle> allRectangles = jsonReader.readFromFile(fileForReading);
        List<Rectangle> intersects = intersect.getAllIntersects(allRectangles);

        String fileForWriting = jsonWriter.getPathToFile();
        jsonWriter.writeToFile(intersects, fileForWriting);
    }
}
