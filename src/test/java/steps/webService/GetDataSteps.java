package steps.webService;

import aplications.Search;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GetDataSteps {
    public static String JSON = "src\\test\\resources\\search.json";
    private static Search[] searches;

    public static Search getSearchDataFromFile(Gson gson, int condition) throws FileNotFoundException {
        searches = gson.fromJson (new JsonReader (new FileReader (JSON)), Search[].class);
        return searches[condition];
    }

    public static List<String> getAllUserNames(String response) {
        Pattern pattern = Pattern.compile ("\"username\": \"[A-z]+\"");
        Matcher matcher = pattern.matcher (response);
        List<String> list = new ArrayList<> ();
        while (matcher.find ())
            list.add (matcher.group ());
        list = list.stream ().map (s -> s.replaceAll ("\"username\": ", "")).map
                (s -> s.replaceAll ("\"", "")).collect (Collectors.toList ());
        return list;
    }

    public static boolean fullCheck(List<String> list, String check) {
        Pattern pattern = Pattern.compile (String.format ("^%s$", check));
        for (String x : list) {
            if (!pattern.matcher (x).matches ())
                return false;
        }
        return true;
    }

    public static boolean partialCheck(List<String> list, String check) {
        Pattern pattern = Pattern.compile (String.format (".*%s.*", check));
        for (String x : list) {
            if (!pattern.matcher (x).matches ())
                return false;
        }
        return true;
    }
}
