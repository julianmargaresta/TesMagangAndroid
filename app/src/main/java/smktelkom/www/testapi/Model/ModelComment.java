package smktelkom.www.testapi.Model;

/**
 * Created by M12RjUL14n on 29/04/2018.
 */

public class ModelComment {
    private String name;
    private String email;
    private String body;

    public ModelComment(String nm, String eml, String bd) {
        this.name = nm;
        this.email = eml;
        this.body = bd;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
