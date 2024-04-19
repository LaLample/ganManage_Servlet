package Service;

import face.*;

import java.util.List;

public interface service  {
    public boolean findusernameandpassword(User uses);
    public boolean login(User use);
    public boolean findgamesname(Game game);
    public boolean findgamesnameandadd(Game game);
    //查询所有用户信息
    public List<Allgames> findAll();
    public Game find(Game game);
    public boolean Speaking(speaking speak);
    public List<speaking> speakarea();
    public boolean gamesadd(Allgames games,gamesanduser gu);
    public boolean gamesuserlogin(User use);
    public List<gamesanduser> mygames(String username);





}
