package Model.InputAPI.InputObjects;

import org.json.JSONObject;

public class Series {

    private String beginAt;
    private String description;
    private String endAt;
    private String fullName;
    private String id;
    private String leagueId;
    private String modifiedAt;
    private String name;
    private String season;
    private String slug;
    private String tier;
    private String videoGameTitle;
    private String winnerId;
    private String winnerType;
    private String year;

//    public Series(String beginAt, String description, String endAt, String fullName, int id, int leagueId,
//                  String modifiedAt, String name, String season, String slug, String tier,
//                  String videoGameTitle, String winnerId, String winnerType, int year) {
//        this.beginAt = beginAt;
//        this.description = description;
//        this.endAt = endAt;
//        this.fullName = fullName;
//        this.id = id;
//        this.leagueId = leagueId;
//        this.modifiedAt = modifiedAt;
//        this.name = name;
//        this.season = season;
//        this.slug = slug;
//        this.tier = tier;
//        this.videoGameTitle = videoGameTitle;
//        this.winnerId = winnerId;
//        this.winnerType = winnerType;
//        this.year = year;
//    }

    public String getBeginAt() {
        return this.beginAt;
    }

    public void setBeginAt(Object beginAt) {
        if(beginAt.equals(JSONObject.NULL)) {
            this.beginAt = "null";
        } else {
            this.beginAt = (String) beginAt;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(Object description) {
        if(description.equals(JSONObject.NULL)) {
            this.description = "null";
        } else {
            this.description = (String) description;
        }
    }

    public String getEndAt() {
        return this.endAt;
    }

    public void setEndAt(Object endAt) {
        if(endAt.equals(JSONObject.NULL)) {
            this.endAt = "null";
        } else {
            this.endAt = (String) endAt;
        }
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(Object fullName) {
        if(fullName.equals(JSONObject.NULL)) {
            this.fullName = "null";
        } else {
            this.fullName = (String) fullName;
        }
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

    public String getLeagueId() {
        return this.leagueId;
    }

    public void setLeagueID(Object leagueId) {
        if(leagueId.equals(JSONObject.NULL)) {
            this.leagueId = "null";
        } else {
            int intID = (int) leagueId;
            this.leagueId = Integer.toString(intID);
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

    public String getSeason() {
        return this.season;
    }

    public void setSeason(Object season) {
        if(season.equals(JSONObject.NULL)) {
            this.season = "null";
        } else {
            this.season = (String) season;
        }
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

    public String getTier() {
        return this.tier;
    }

    public void setTier(Object tier) {
        if(tier.equals(JSONObject.NULL)) {
            this.tier = "null";
        } else {
            this.tier = (String) tier;
        }
    }

    public String getVideoGameTitle() {
        return this.videoGameTitle;
    }

    public void setVideoGameTitle(Object videoGameTitle) {
        if(videoGameTitle.equals(JSONObject.NULL)) {
            this.videoGameTitle = "null";
        } else {
            this.videoGameTitle = (String) videoGameTitle;
        }
    }

    public String getWinnerId() {
        return this.winnerId;
    }

    public void setWinnerId(Object winnerId) {
        if(winnerId.equals(JSONObject.NULL)) {
            this.winnerId = "null";
        } else {
            int intWinnerId = (int) winnerId;
            this.winnerId = Integer.toString(intWinnerId);
        }
    }

    public String getWinnerType() {
        return this.winnerType;
    }

    public void setWinnerType(Object winnerType) {
        if(winnerType.equals(JSONObject.NULL)) {
            this.winnerType = "null";
        } else {
            this.winnerType = (String) winnerType;
        }
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(Object year) {
        if(year.equals(JSONObject.NULL)) {
            this.year = "null";
        } else {
            int intYear = (int) year;
            this.year = Integer.toString(intYear);
        }
    }
}
