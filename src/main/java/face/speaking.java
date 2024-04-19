package face;

public class speaking {
    private String id;
    private String usernames;
    private String speaking;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getUsernames() {
        return usernames;
    }

    public void setUsernames(String usernames) {
        this.usernames = usernames;
    }

    public String getSpeaking() {
        return speaking;
    }

    public void setSpeaking(String speaking) {
        this.speaking = speaking;
    }

    @Override
    public String toString() {
        return "speaking{" +
                "usernames='" + usernames + '\'' +
                ", speaking='" + speaking + '\'' +
                '}';
    }
}
