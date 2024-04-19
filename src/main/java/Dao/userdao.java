package Dao;

import face.*;

import java.util.List;

public interface userdao {
    public  User findbyusernameandpassword(User uses);
    public void save(User uses);
    public User login(User uses);
    public Game findgamesname(Game game);
    public Game Findgamesname(Game game);
    public void delete(Game game);
    public void add(Game game);
    public List<Allgames> findall();
    public Game checkgames(Game game);
    public boolean speaking(speaking speak);
    public List<speaking> Speakingarea();
    public Allgames checkusergame(Allgames games);
    public uidandgid findug(gamesanduser gu);
    public void setug(uidandgid ug);
    public User gamesuserlogin(User uses);
    public int finduid(String username);
    public List<uidandgid> findtable(int uid);
    public List<gamesanduser> gau(String username);
}
