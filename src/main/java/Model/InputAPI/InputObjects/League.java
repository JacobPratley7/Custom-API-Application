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
    private String videoGameCurrentVersion;
    private String videoGameID;
    private String videoGameName;
    private String videoGameSlug;

    public League() {

    }

    /**
     * Simple accessor for id
     * @return league id
     */
    public String getID() {
        return this.id;
    }

    /**
     * Sets id for league object
     * @param id The id to assign to the league object
     */
    public void setID(Object id) {
        if(id.equals(JSONObject.NULL)) {
            this.id = "null";
        } else {
            int intID = (int) id;
            this.id = Integer.toString(intID);
        }
    }

    /**
     * Simple accessor for imageUrl
     * @return league image url
     */
    public String getImageUrl() {
        return this.imageUrl;
    }

    /**
     * Sets imageUrl for league object
     * @param imageUrl The imageUrl to assign to the league object
     */
    public void setImageUrl(Object imageUrl) {
        if(imageUrl.equals(JSONObject.NULL)) {
            this.imageUrl = "null";
        } else {
            this.imageUrl = (String) imageUrl;
        }
    }

    /**
     * Simple accessor for modifiedAt
     * @return league modified at
     */
    public String getModifiedAt() {
        return this.modifiedAt;
    }

    /**
     * Sets modifiedAt for league object
     * @param modifiedAt The modifiedAt time to assign to the league object
     */
    public void setModifiedAt(Object modifiedAt) {
        if(modifiedAt.equals(JSONObject.NULL)) {
            this.modifiedAt = "null";
        } else {
            this.modifiedAt = (String) modifiedAt;
        }
    }

    /**
     * Simple accessor for name
     * @return league name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name for league object
     * @param name The name to assign to the league object
     */
    public void setName(Object name) {
        if(name.equals(JSONObject.NULL)) {
            this.name = "null";
        } else {
            this.name = (String) name;
        }
    }

    /**
     * Simple accessor for series
     * @return league series
     */
    public List<Series> getSeries() {
        return this.series;
    }

    /**
     * Sets series for league object
     * @param series The list of series to assign to the league object
     */
    public void setSeries(List<Series> series) {
        this.series = series;
    }

    /**
     * Simple accessor for slug
     * @return league slug
     */
    public String getSlug() {
        return this.slug;
    }

    /**
     * Sets slug for league object
     * @param slug The slug to assign to the league object
     */
    public void setSlug(Object slug) {
        if(slug.equals(JSONObject.NULL)) {
            this.slug = "null";
        } else {
            this.slug = (String) slug;
        }
    }

    /**
     * Simple accessor for url
     * @return league url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Sets url for league object
     * @param url The url to assign to the league object
     */
    public void setUrl(Object url) {
        if(url.equals(JSONObject.NULL)) {
            this.url = "null";
        } else {
            this.url = (String) url;
        }
    }

    /**
     * Simple accessor for videogame
     * @return league videogame
     */
    public VideoGame getVideoGame() {
        return this.videoGame;
    }

    /**
     * Simple accessor for videoGameCurrentVersion
     * @return league video game current version
     */
    public String getVideoGameCurrentVersion() {
        return this.videoGameCurrentVersion;
    }

    /**
     * Sets videoGameCurrentVersion for league object
     * @param currentVersion The current version to assign to the league object
     */
    public void setVideoGameCurrentVersion(Object currentVersion) {
        if(currentVersion.equals(JSONObject.NULL)) {
            this.videoGameCurrentVersion = "null";
        } else {
            this.videoGameCurrentVersion = (String) currentVersion;
        }
    }

    /**
     * Simple accessor for videoGameID
     * @return league video game id
     */
    public String getVideoGameID () {
        return this.videoGameID;
    }

    /**
     * Sets videoGameID for league object
     * @param id The video game id to assign to the league object
     */
    public void setVideoGameID(Object id) {
        if(id.equals(JSONObject.NULL)) {
            this.videoGameID = "null";
        } else {
            int intID = (int) id;
            this.videoGameID = Integer.toString(intID);
        }
    }

    /**
     * Simple accessor for videoGameName
     * @return league video game name
     */
    public String getVideoGameName() {
        return this.videoGameName;
    }

    /**
     * Sets videoGameName for league object
     * @param name The video game name to assign to the league object
     */
    public void setVideoGameName(Object name) {
        if(name.equals(JSONObject.NULL)) {
            this.videoGameName = "null";
        } else {
            this.videoGameName = (String) name;
        }
    }

    /**
     * Simple accessor for videoGameSlug
     * @return league video game slug
     */
    public String getVideoGameSlug() {
        return this.videoGameSlug;
    }

    /**
     * Sets videoGameSlug for league object
     * @param slug The video game slug to assign to the league object
     */
    public void setVideoGameSlug(Object slug) {
        if(slug.equals(JSONObject.NULL)) {
            this.videoGameSlug = "null";
        } else {
            this.videoGameSlug = (String) slug;
        }
    }






}
