package utilities;

import aplications.Ingredient;
import aplications.Recipe;
import aplications.Search;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {
    private final static String JSON = "D:\\Inna_Romankova_htp_at_project\\src\\main\\resources\\Recipe.json";

    File file = new File (JSON);

    public void parseJSON() throws IOException{
        String input = new String (Files.readAllBytes (Paths.get (JSON)));
        JSONObject obj = new JSONObject (input);
        System.out.println (obj.getString ("recipename"));

    }
    public  void parseGSON() throws FileNotFoundException {
        Gson gson = new Gson ();
        Recipe recipe = gson.fromJson (new JsonReader (new FileReader (JSON)),Recipe.class);
        System.out.println (recipe.recipename);
    }

    public void parseJackson() throws IOException {
        ObjectMapper mapper = new ObjectMapper ();
        Recipe recipe = mapper.readValue (file, Recipe.class);
        System.out.println (recipe.recipename);

    }

    public void fromGSON() throws FileNotFoundException {
        Gson gson = new Gson ();
        Recipe recipe = new Recipe ("Borsch", new Ingredient []{},120);
        System.out.println (gson.toJson (recipe));

    }
    public static String fromGSON(Search search){
        Gson gson = new Gson ();
        return gson.toJson (search);
    }
}
