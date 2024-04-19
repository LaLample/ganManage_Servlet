package face;

public class uidandgid {
    private int id;
    private int uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "uidandgid{" +
                "id=" + id +
                ", uid=" + uid +
                '}';
    }
}
