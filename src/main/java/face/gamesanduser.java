package face;

public class gamesanduser {
    private String gamesname;
    private String username;

    public String getGamesname() {
        return gamesname;
    }

    public void setGamesname(String gamesname) {
        this.gamesname = gamesname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "gamesanduser{" +
                "gamesname='" + gamesname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
