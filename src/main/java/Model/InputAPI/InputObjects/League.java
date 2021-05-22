package Model.InputAPI.InputObjects;

import java.util.List;

public class League {

    private int id;
    private String imageUrl;
    private String modifiedAt;
    private String name;
    private List<Series> series;
    private String slug;
    private String url;
    private VideoGame videoGame;

    public League(String id, String imageUrl, String modifiedAt, String name, List<Series> series,
                  String slug, String url, VideoGame videoGame) {
        return;
    }

    public int getID() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getModifiedAt() {
        return this.modifiedAt;
    }

    public String getName() {
        return this.name;
    }

    public List<Series> getSeries() {
        return this.series;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getUrl() {
        return this.url;
    }

    public VideoGame getVideoGame() {
        return this.videoGame;
    }





}
