package face;

public class Game {
    private String gamesname;
    private String price;


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
        return "Game{" +
                "gamesname='" + gamesname + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
