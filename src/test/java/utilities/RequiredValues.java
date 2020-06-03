package utilities;

import org.seleniumhq.jetty9.server.Authentication;

import java.util.List;

public class RequiredValues {
    public String code;
    public List<Authentication.User> data;

    public RequiredValues(String code, List<Authentication.User> data) {
        this.code = code;
        this.data = data;
    }
}
