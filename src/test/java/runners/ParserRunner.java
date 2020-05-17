package runners;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.xml.sax.SAXException;
import utilities.JsonParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;

public class ParserRunner {

    static JsonParser jsonParser = new JsonParser ();

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        jsonParser.parseJSON ();
        jsonParser.parseGSON ();
//        jsonParser.parseJackson ();
        jsonParser.fromGSON ();


    }
}