package face;

public class Allgames {
    private  int id;
    private String gamesname;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGamesname() {
        return gamesname;
    }

    public void setGamesname(String gamesname) {
        this.gamesname = gamesname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Allgames{" +
                "id=" + id +
                ", gamesname='" + gamesname + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
