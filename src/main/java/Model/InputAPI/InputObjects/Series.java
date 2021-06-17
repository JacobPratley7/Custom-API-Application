package Model.InputAPI.InputObjects;

import org.json.JSONObject;
import java.util.List;

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
    private String videoGameID;
    private String videoGameSlug;
    private String videoGameName;
    private List<Tournament> tournaments;
    private League league;


    /**
     * Simple accessor for beginAt
     * @return series begin at time
     */
    public String getBeginAt() {
        return this.beginAt;
    }

    /**
     * Sets beginAt for series object
     * @param beginAt The beginAt time to assign to the series object
     */
    public void setBeginAt(Object beginAt) {
        if(beginAt.equals(JSONObject.NULL)) {
            this.beginAt = "null";
        } else {
            this.beginAt = (String) beginAt;
        }
    }

    /**
     * Simple accessor for description
     * @return series description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets description for series object
     * @param description The description to assign to the series object
     */
    public void setDescription(Object description) {
        if(description.equals(JSONObject.NULL)) {
            this.description = "null";
        } else {
            this.description = (String) description;
        }
    }

    /**
     * Simple accessor for endAt
     * @return series end at time
     */
    public String getEndAt() {
        return this.endAt;
    }

    /**
     * Sets endAt for series object
     * @param endAt The endAt time to assign to the series object
     */
    public void setEndAt(Object endAt) {
        if(endAt.equals(JSONObject.NULL)) {
            this.endAt = "null";
        } else {
            this.endAt = (String) endAt;
        }
    }

    /**
     * Simple accessor for fullName
     * @return series full name
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Sets fullName for series object
     * @param fullName The full name to assign to the series object
     */
    public void setFullName(Object fullName) {
        if(fullName.equals(JSONObject.NULL)) {
            this.fullName = "null";
        } else {
            this.fullName = (String) fullName;
        }
    }

    /**
     * Simple accessor for id
     * @return series id
     */
    public String getID() {
        return this.id;
    }

    /**
     * Sets id for series object
     * @param id The id to assign to the series object
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
     * Simple accessor for id
     * @return league id
     */
    public String getLeagueId() {
        return this.leagueId;
    }

    /**
     * Sets leagueID for series object
     * @param leagueId The league id to assign to the series object
     */
    public void setLeagueID(Object leagueId) {
        if(leagueId.equals(JSONObject.NULL)) {
            this.leagueId = "null";
        } else {
            int intID = (int) leagueId;
            this.leagueId = Integer.toString(intID);
        }
    }

    /**
     * Simple accessor for modifiedAt
     * @return series modified at time
     */
    public String getModifiedAt() {
        return this.modifiedAt;
    }

    /**
     * Sets modifiedAt for series object
     * @param modifiedAt The modified at time to assign to the series object
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
     * @return series name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name for series object
     * @param name The name to assign to the series object
     */
    public void setName(Object name) {
        if(name.equals(JSONObject.NULL)) {
            this.name = "null";
        } else {
            this.name = (String) name;
        }
    }

    /**
     * Simple accessor for season
     * @return series season
     */
    public String getSeason() {
        return this.season;
    }

    /**
     * Sets season for series object
     * @param season The season to assign to the series object
     */
    public void setSeason(Object season) {
        if(season.equals(JSONObject.NULL)) {
            this.season = "null";
        } else {
            this.season = (String) season;
        }
    }

    /**
     * Simple accessor for slug
     * @return series slug
     */
    public String getSlug() {
        return this.slug;
    }

    /**
     * Sets slug for series object
     * @param slug The slug to assign to the series object
     */
    public void setSlug(Object slug) {
        if(slug.equals(JSONObject.NULL)) {
            this.slug = "null";
        } else {
            this.slug = (String) slug;
        }
    }

    /**
     * Simple accessor for tier
     * @return series tier
     */
    public String getTier() {
        return this.tier;
    }

    /**
     * Sets tier for series object
     * @param tier The tier to assign to the series object
     */
    public void setTier(Object tier) {
        if(tier.equals(JSONObject.NULL)) {
            this.tier = "null";
        } else {
            this.tier = (String) tier;
        }
    }

    /**
     * Simple accessor for videogameTitle
     * @return series video game title
     */
    public String getVideoGameTitle() {
        return this.videoGameTitle;
    }

    /**
     * Sets videogameTitle for series object
     * @param videoGameTitle The video game title to assign to the series object
     */
    public void setVideoGameTitle(Object videoGameTitle) {
        if(videoGameTitle.equals(JSONObject.NULL)) {
            this.videoGameTitle = "null";
        } else {
            this.videoGameTitle = (String) videoGameTitle;
        }
    }

    /**
     * Simple accessor for winnerId
     * @return series winner id
     */
    public String getWinnerId() {
        return this.winnerId;
    }

    /**
     * Sets winnerId for series object
     * @param winnerId The winner id to assign to the series object
     */
    public void setWinnerId(Object winnerId) {
        if(winnerId.equals(JSONObject.NULL)) {
            this.winnerId = "null";
        } else {
            int intWinnerId = (int) winnerId;
            this.winnerId = Integer.toString(intWinnerId);
        }
    }

    /**
     * Simple accessor for winnerType
     * @return series winner type
     */
    public String getWinnerType() {
        return this.winnerType;
    }

    /**
     * Sets winnerType for series object
     * @param winnerType The winner type to assign to the series object
     */
    public void setWinnerType(Object winnerType) {
        if(winnerType.equals(JSONObject.NULL)) {
            this.winnerType = "null";
        } else {
            this.winnerType = (String) winnerType;
        }
    }

    /**
     * Simple accessor for year
     * @return series year
     */
    public String getYear() {
        return this.year;
    }

    /**
     * Sets year for series object
     * @param year The year to assign to the series object
     */
    public void setYear(Object year) {
        if(year.equals(JSONObject.NULL)) {
            this.year = "null";
        } else {
            int intYear = (int) year;
            this.year = Integer.toString(intYear);
        }
    }

    /**
     * Simple accessor for videoGameID
     * @return series video game id
     */
    public String getVideoGameID() {
        return this.videoGameID;
    }

    /**
     * Sets videoGameId for series object
     * @param videoGameID The video game id to assign to the series object
     */
    public void setVideoGameID(Object videoGameID) {
        if(videoGameID.equals(JSONObject.NULL)) {
            this.videoGameID = "null";
        } else {
            int intID = (int) videoGameID;
            this.videoGameID = Integer.toString(intID);
        }
    }

    /**
     * Simple accessor for videoGameSlug
     * @return series video game slug
     */
    public String getVideoGameSlug() {
        return this.videoGameSlug;
    }

    /**
     * Sets videoGameSlug for series object
     * @param videoGameSlug The video game slug to assign to the series object
     */
    public void setVideoGameSlug(Object videoGameSlug) {
        if(videoGameSlug.equals(JSONObject.NULL)) {
            this.videoGameSlug = "null";
        } else {
            this.videoGameSlug = (String) videoGameSlug;
        }
    }

    /**
     * Simple accessor for videoGameName
     * @return series video game name
     */
    public String getVideoGameName() {
        return this.videoGameName;
    }

    /**
     * Sets videoGameName for series object
     * @param videoGameName The video game name to assign to the series object
     */
    public void setVideoGameName(Object videoGameName) {
        if(videoGameName.equals(JSONObject.NULL)) {
            this.videoGameName = "null";
        } else {
            this.videoGameName = (String) videoGameName;
        }
    }

    /**
     * Simple accessor for tournaments
     * @return series tournaments
     */
    public List<Tournament> getTournaments() {
        return this.tournaments;
    }

    /**
     * Sets tournaments for series object
     * @param tournaments The list of tournaments to assign to the series object
     */
    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    /**
     * Simple accessor for league
     * @return series league
     */
    public League getLeague() {
        return this.league;
    }

    /**
     * Sets league for series object
     * @param league The league to assign to the series object
     */
    public void setLeague(League league) {
        this.league = league;
    }


}
