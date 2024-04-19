package face;

public class useraddgames {
    private String usernames;
    private String gamesnames;

    public String getUsernames() {
        return usernames;
    }

    public void setUsernames(String usernames) {
        this.usernames = usernames;
    }

    public String getGamesnames() {
        return gamesnames;
    }

    public void setGamesnames(String gamesnames) {
        this.gamesnames = gamesnames;
    }

    @Override
    public String toString() {
        return "useraddgames{" +
                "usernames='" + usernames + '\'' +
                ", gamesnames='" + gamesnames + '\'' +
                '}';
    }
}
