package Model.InputAPI.InputObjects;

public class VideoGame {

    private String currentVersion;
    private int id;
    private String name;
    private String slug;

    public VideoGame(String currentVersion, int id, String name, String slug) {
        this.currentVersion = currentVersion;
        this.id = id;
        this.name = name;
        this.slug = slug;
    }

    public String getCurrentVersion() {
        return this.currentVersion;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.slug;
    }
}
