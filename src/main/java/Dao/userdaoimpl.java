package Dao;

import face.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import jdbcutils.jdbcutils;

import java.util.List;

public class userdaoimpl implements userdao {
    private JdbcTemplate template=new JdbcTemplate(jdbcutils.getDataSource());
    @Override
    public User findbyusernameandpassword(User uses) {
        User user=null;
        try {
            String sql="select * from user where username=?";
            user=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),uses.getUsername());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User uses) {
        String sql="insert into user(username,password) values(?,?)";
        template.update(sql,uses.getUsername(),uses.getPassword());
    }

    @Override
    public User login(User uses) {
        User u=null;
        try {
            String sql="select * from user where username=? and password=?";
            u=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),uses.getUsername(),uses.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return u;
    }

    @Override
    public Game findgamesname(Game game) {
        Game g=null;
        try {
            String sql="select * from games where gamesname=?";
            g=template.queryForObject(sql,new BeanPropertyRowMapper<Game>(Game.class),game.getGamesname());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return g;
    }

    @Override
    public Game Findgamesname(Game game) {
        Game g=null;
        try {
            String sql="select * from games where gamesname=?";
            g=template.queryForObject(sql,new BeanPropertyRowMapper<Game>(Game.class),game.getGamesname());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return g;
    }

    @Override
    public void delete(Game game) {
        String sql="delete from games where gamesname=?";
        template.update(sql,game.getGamesname());
    }

    @Override
    public void add(Game game) {
        String sql="insert into games(gamesname,price) values(?,?)";
        template.update(sql,game.getGamesname(),game.getPrice());

    }

    @Override
    public List<Allgames> findall() {
        String sql="select * from games";
        List<Allgames> games=template.query(sql,new BeanPropertyRowMapper<Allgames>(Allgames.class));
        return games;
    }

    @Override
    public Game checkgames(Game game) {

        String sql="select * from games where gamesname=?";
        Game g=template.queryForObject(sql,new BeanPropertyRowMapper<Game>(Game.class),game.getGamesname());
        return g;
    }

    @Override
    public boolean speaking(speaking speak) {
        String sql="insert into speaking(Usernames,Speaking) values(?,?)";
        template.update(sql,speak.getUsernames(),speak.getSpeaking());
        return true;
    }

    @Override
    public List<speaking> Speakingarea() {
        String sql="select * from speaking";
        List<speaking> speak=template.query(sql,new BeanPropertyRowMapper<speaking>(speaking.class));
        return speak;
    }

    @Override
    public Allgames checkusergame(Allgames games) {
        Allgames ga=null;
        try {
            String sql="select * from games where gamesname=?";
            ga=template.queryForObject(sql,new BeanPropertyRowMapper<Allgames>(Allgames.class),games.getGamesname());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ga;
    }

    @Override
    public uidandgid findug(gamesanduser gu) {
        String sql="SELECT gamesuser.`uid`,games.`id` FROM gamesuser,games WHERE gamesuser.`username`=? AND games.`gamesname`=?;";
        uidandgid ug=template.queryForObject(sql,new BeanPropertyRowMapper<uidandgid>(uidandgid.class),gu.getUsername(),gu.getGamesname());
        return ug;
    }

    @Override
    public void setug(uidandgid ug) {
        String sql="insert into connectiongameanduser(gid,uid) values(?,?)";
        template.update(sql,ug.getId(),ug.getUid());
    }

    @Override
    public User gamesuserlogin(User uses) {
        User u=null;
        try {
            String sql="select * from gamesuser where username=? and password=?";
            u=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),uses.getUsername(),uses.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return u;
    }

    @Override
    public int finduid(String username) {
        String sql="SELECT uid FROM gamesuser WHERE username=?;";
        Integer uid=template.queryForObject(sql,new BeanPropertyRowMapper<Integer>(Integer.class),username);
        return uid;
    }

    @Override
    public List<uidandgid> findtable(int uid) {
        List<uidandgid> ug=null;
        try {
            String sql="SELECT * FROM connectiongameanduser WHERE uid=?;";
            ug=template.queryForObject(sql,new BeanPropertyRowMapper<List>(List.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ug;
    }

    @Override
    public List<gamesanduser> gau(String username) {
        String sql="SELECT gamesuser.`username`,games.`gamesname` FROM gamesuser,games, connectiongameanduser WHERE  gamesuser.`username`=? AND gamesuser.`uid`=connectiongameanduser.`uid`AND games.`id`=connectiongameanduser.`gid`;";
        List<gamesanduser> gu=template.query(sql,new BeanPropertyRowMapper<gamesanduser>(gamesanduser.class),username);
        return gu;

    }


}
