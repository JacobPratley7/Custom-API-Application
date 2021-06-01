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

    public String getLeagueID() {
        return this.leagueID;
    }

    public void setLeagueID(Object leagueID) {
        if(leagueID.equals(JSONObject.NULL)) {
            this.leagueID = "null";
        } else {
            int intID = (int) leagueID;
            this.leagueID = Integer.toString(intID);
        }
    }

    public String getLiveSupported() {
        return this.liveSupported;
    }

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

    public String getPrizePool() {
        return this.prizePool;
    }

    public void setPrizePool(Object prizePool) {
        if(prizePool.equals(JSONObject.NULL)) {
            this.prizePool = "null";
        } else {
            this.prizePool = (String) prizePool;
        }
    }

    public String getSeriesID() {
        return this.seriesID;
    }

    public void setSeriesID(Object seriesID) {
        if(seriesID.equals(JSONObject.NULL)) {
            this.seriesID = "null";
        } else {
            int intID = (int) seriesID;
            this.seriesID = Integer.toString(intID);
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

    public String getWinnerID() {
        return this.winnerID;
    }

    public void setWinnerID(Object winnerID) {
        if(winnerID.equals(JSONObject.NULL)) {
            this.winnerID = "null";
        } else {
            int intID = (int) winnerID;
            this.winnerID = Integer.toString(intID);
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
}
