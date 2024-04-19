package Service;

import Dao.userdao;
import Dao.userdaoimpl;
import face.*;

import java.util.List;

public class serviceimpl implements  service {
    private userdao userdao = new userdaoimpl();

    @Override
    public boolean findusernameandpassword(User uses) {
        User u = userdao.findbyusernameandpassword(uses);
        if (u != null) {
            //用户存在，注册失败
            return false;
        }
        userdao.save(uses);
        return true;
    }

    @Override
    public boolean login(User use) {
        User u=userdao.login( use);
        if(u!=null){
            //找到该用户信息，允许登录
            return true;
        }
        //没找到用户信息，登录失败
        return false;
    }

    @Override
    public boolean findgamesname(Game game) {
            Game g=userdao.findgamesname(game);
            if(g!=null){
                //找到游戏名，并进行删除
                userdao.delete(game);
                return true;
            }
            //没找到游戏名，删除失败
          return false;

    }
    public boolean findgamesnameandadd(Game game) {
        Game g=userdao.Findgamesname(game);
        if(g!=null){
            //找到游戏名,无法添加游戏
            return false;
        }
        //没找到游戏名，进行添加
        userdao.add(game);
        return true;

    }

    @Override
    public List<Allgames> findAll() {
        //调用dao完成查询

        return userdao.findall();
    }

    @Override
    public Game find(Game game) {
        Game g=userdao.Findgamesname(game);
        if(g!=null){
            //找到游戏名，调用相应方法
            Game gm=userdao.checkgames(game);
            return gm;
        }
        //没找到相应的游戏
        return null;
    }

    @Override
    public boolean Speaking(speaking speak) {
        boolean g=userdao.speaking(speak);
        return g;
    }

    @Override
    public List<speaking> speakarea() {
        return userdao.Speakingarea();
    }

    @Override
    public boolean gamesadd(Allgames games, gamesanduser gu) {
        //先对游戏是否存在进行判断
        Allgames g=userdao.checkusergame(games);
        if(g!=null){
            //游戏存在
            gu.setGamesname(games.getGamesname());
            uidandgid ug=new uidandgid();
            ug=userdao.findug(gu);
            //往中间表添加信息
            userdao.setug(ug);
            return true;
        }
        else{
            //游戏不存在
            return false;
        }

    }

    @Override
    public boolean gamesuserlogin(User use) {
        User u=userdao.gamesuserlogin( use);
        if(u!=null){
            //找到该用户信息，允许登录
            return true;
        }
        //没找到用户信息，登录失败
        return false;
    }

    @Override
    public List<gamesanduser> mygames(String username) {
     //1.先找到uid，通过uid来确定购物车内是否有商品
//        int uid=userdao.finduid(username);
//        List<uidandgid> u=userdao.findtable(uid);
//        if(u!=null){
//        List<gamesanduser> gau=userdao.gau(username);
//            return  gau;
//        }else{
//            return null;
//        }
//
        return userdao.gau(username);
  }
}




