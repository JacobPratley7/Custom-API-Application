package Model.InputAPI.InputObjects;

import org.json.JSONObject;

public class Tournament {

    private String beginAt;
    private String endAt;
    private String id;
    private String leagueID;
    private String liveSupported;
    private String modifiedAt;
    private String name;
    private String prizePool;
    private String seriesID;
    private String slug;
    private String winnerID;
    private String winnerType;

    /**
     * Simple accessor for beginAt
     * @return tournament begin at time
     */
    public String getBeginAt() {
        return this.beginAt;
    }

    /**
     * Sets beginAt for tournament object
     * @param beginAt The beginAt time to assign to the tournament object
     */
    public void setBeginAt(Object beginAt) {
        if(beginAt.equals(JSONObject.NULL)) {
            this.beginAt = "null";
        } else {
            this.beginAt = (String) beginAt;
        }
    }

    /**
     * Simple accessor for endAt
     * @return tournament end at time
     */
    public String getEndAt() {
        return this.endAt;
    }

    /**
     * Sets endAt for series object
     * @param endAt The endAt time to assign to the tournament object
     */
    public void setEndAt(Object endAt) {
        if(endAt.equals(JSONObject.NULL)) {
            this.endAt = "null";
        } else {
            this.endAt = (String) endAt;
        }
    }

    /**
     * Simple accessor for id
     * @return tournament id
     */
    public String getID() {
        return this.id;
    }

    /**
     * Sets id for tournament object
     * @param id The id to assign to the tournament object
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
     * Simple accessor for leagueID
     * @return tournament league id
     */
    public String getLeagueID() {
        return this.leagueID;
    }

    /**
     * Sets leagueID for tournament object
     * @param leagueID The league id to assign to the tournament object
     */
    public void setLeagueID(Object leagueID) {
        if(leagueID.equals(JSONObject.NULL)) {
            this.leagueID = "null";
        } else {
            int intID = (int) leagueID;
            this.leagueID = Integer.toString(intID);
        }
    }

    /**
     * Simple accessor for liveSupported
     * @return tournament live supported
     */
    public String getLiveSupported() {
        return this.liveSupported;
    }

    /**
     * Sets liveSupported for tournament object
     * @param liveSupported The live supported to assign to the tournament object
     */
    public void setLiveSupported(Object liveSupported) {
        if(liveSupported.equals(JSONObject.NULL)) {
            this.liveSupported = "null";
        } else {
            boolean supported = (boolean) liveSupported;
            if(supported) {
                this.liveSupported = "true";
            } else {
                this.liveSupported = "false";
            }
        }
    }

    /**
     * Simple accessor for modifiedAt
     * @return tournament modified at time
     */
    public String getModifiedAt() {
        return this.modifiedAt;
    }

    /**
     * Sets modifiedAt for series object
     * @param modifiedAt The modifiedAt time to assign to the tournament object
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
     * @return tournament name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name for tournament object
     * @param name The name to assign to the tournament object
     */
    public void setName(Object name) {
        if(name.equals(JSONObject.NULL)) {
            this.name = "null";
        } else {
            this.name = (String) name;
        }
    }

    /**
     * Simple accessor for prizePool
     * @return tournament prize pool
     */
    public String getPrizePool() {
        return this.prizePool;
    }

    /**
     * Sets prizePool for tournament object
     * @param prizePool The prize pool to assign to the tournament object
     */
    public void setPrizePool(Object prizePool) {
        if(prizePool.equals(JSONObject.NULL)) {
            this.prizePool = "null";
        } else {
            this.prizePool = (String) prizePool;
        }
    }

    /**
     * Simple accessor for seriesID
     * @return tournament series id
     */
    public String getSeriesID() {
        return this.seriesID;
    }

    /**
     * Sets seriesID for tournament object
     * @param seriesID The series id to assign to the tournament object
     */
    public void setSeriesID(Object seriesID) {
        if(seriesID.equals(JSONObject.NULL)) {
            this.seriesID = "null";
        } else {
            int intID = (int) seriesID;
            this.seriesID = Integer.toString(intID);
        }
    }


    /**
     * Simple accessor for slug
     * @return tournament slug
     */
    public String getSlug() {
        return this.slug;
    }

    /**
     * Sets slug for tournament object
     * @param slug The slug to assign to the tournament object
     */
    public void setSlug(Object slug) {
        if(slug.equals(JSONObject.NULL)) {
            this.slug = "null";
        } else {
            this.slug = (String) slug;
        }
    }

    /**
     * Simple accessor for winnerID
     * @return tournament winner id
     */
    public String getWinnerID() {
        return this.winnerID;
    }

    /**
     * Sets winnerID for tournament object
     * @param winnerID The winner id to assign to the tournament object
     */
    public void setWinnerID(Object winnerID) {
        if(winnerID.equals(JSONObject.NULL)) {
            this.winnerID = "null";
        } else {
            int intID = (int) winnerID;
            this.winnerID = Integer.toString(intID);
        }
    }

    /**
     * Simple accessor for winnerType
     * @return tournament winner type
     */
    public String getWinnerType() {
        return this.winnerType;
    }

    /**
     * Sets winnerType for tournament object
     * @param winnerType The winner type to assign to the tournament object
     */
    public void setWinnerType(Object winnerType) {
        if(winnerType.equals(JSONObject.NULL)) {
            this.winnerType = "null";
        } else {
            this.winnerType = (String) winnerType;
        }
    }
}
