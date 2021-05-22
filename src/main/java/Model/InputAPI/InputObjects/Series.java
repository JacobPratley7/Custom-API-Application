package Model.InputAPI.InputObjects;

public class Series {

    private String beginAt;
    private String description;
    private String endAt;
    private String fullName;
    private int id;
    private int leagueId;
    private String modifiedAt;
    private String name;
    private String season;
    private String slug;
    private String tier;
    private String videoGameTitle;
    private String winnerId;
    private String winnerType;
    private int year;

    public Series(String beginAt, String description, String endAt, String fullName, int id, int leagueId,
                  String modifiedAt, String name, String season, String slug, String tier,
                  String videoGameTitle, String winnerId, String winnerType, int year) {
        this.beginAt = beginAt;
        this.description = description;
        this.endAt = endAt;
        this.fullName = fullName;
        this.id = id;
        this.leagueId = leagueId;
        this.modifiedAt = modifiedAt;
        this.name = name;
        this.season = season;
        this.slug = slug;
        this.tier = tier;
        this.videoGameTitle = videoGameTitle;
        this.winnerId = winnerId;
        this.winnerType = winnerType;
        this.year = year;
    }

    public String getBeginAt() {
        return this.beginAt;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEndAt() {
        return this.endAt;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getId() {
        return this.id;
    }

    public int getLeagueId() {
        return this.leagueId;
    }

    public String getModifiedAt() {
        return this.modifiedAt;
    }

    public String getName() {
        return this.name;
    }

    public String getSeason() {
        return this.season;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getTier() {
        return this.tier;
    }

    public String getVideoGameTitle() {
        return this.videoGameTitle;
    }

    public String getWinnerId() {
        return this.winnerId;
    }

    public String getWinnerType() {
        return this.winnerType;
    }

    public int getYear() {
        return this.year;
    }
}
