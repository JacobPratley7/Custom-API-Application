package Model.InputAPI.InputObjects;
import org.json.*;


import java.util.List;

public class League {

    private String id;
    private String imageUrl;
    private String modifiedAt;
    private String name;
    private List<Series> series;
    private String slug;
    private String url;
    private VideoGame videoGame;

    public League() {

    }

    public String getID() {
        return this.id;
    }

    public void setID(Object id) {
        if(id.equals(JSONObject.NULL)) {
            this.id = "null";
        } else {
            int intID = (int) id;
            this.id = Integer.toString(intID);
        }
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(Object imageUrl) {
        if(imageUrl.equals(JSONObject.NULL)) {
            this.imageUrl = "null";
        } else {
            this.imageUrl = (String) imageUrl;
        }
    }

    public String getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Object modifiedAt) {
        if(modifiedAt.equals(JSONObject.NULL)) {
            this.modifiedAt = "null";
        } else {
            this.modifiedAt = (String) modifiedAt;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(Object name) {
        if(name.equals(JSONObject.NULL)) {
            this.name = "null";
        } else {
            this.name = (String) name;
        }
    }

    public List<Series> getSeries() {
        return this.series;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(Object slug) {
        if(slug.equals(JSONObject.NULL)) {
            this.slug = "null";
        } else {
            this.slug = (String) slug;
        }
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(Object url) {
        if(url.equals(JSONObject.NULL)) {
            this.url = "null";
        } else {
            this.url = (String) url;
        }
    }

    public VideoGame getVideoGame() {
        return this.videoGame;
    }





}
