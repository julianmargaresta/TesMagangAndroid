package smktelkom.www.testapi.Model;

/**
 * Created by M12RjUL14n on 29/04/2018.
 */

public class ModelPost {
    private String title;
    private String body;
    private int id;

    public ModelPost(int id, String tl, String bd) {
        this.title = tl;
        this.body = bd;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
