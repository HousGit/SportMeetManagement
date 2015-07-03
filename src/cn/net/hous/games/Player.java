package cn.net.hous.games;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ˧ on 2015/6/16.
 */
public class Player {

    private int playerid;
    private int studentid;
    private String playerpassword;
    private String playername;
    private int playersex;
    private String playerphone;
    private String playerother;
    Map<String, String > errors = new HashMap<>();

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getPlayerpassword() {
        return playerpassword;
    }

    public void setPlayerpassword(String playerpassword) {
        this.playerpassword = playerpassword;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public int getPlayersex() {
        return playersex;
    }

    public void setPlayersex(int playersex) {
        this.playersex = playersex;
    }

    public String getPlayerphone() {
        return playerphone;
    }

    public void setPlayerphone(String playerphone) {
        this.playerphone = playerphone;
    }

    public String getPlayerother() {
        return playerother;
    }

    public void setPlayerother(String playerother) {
        this.playerother = playerother;
    }

    public void sava()
    {
        PlayerDAO.sava(this);
    }

    public void putErr(String key, String value)
    {
        errors.put(key, value);
    }

    public String getErr(String key){

        if(errors.get(key)==null)
        {
            return "";
        }
        else
            return errors.get(key);
    }

    public boolean check()
    {
        boolean flag = true;

        if (! (Integer.toString(this.getStudentid())).matches("\\d{10}")) {
            this.putErr("pstuidErr", "请输入10位学号！");
            flag = false;
        }

        if (! this.getPlayerpassword().matches("\\w{6,12}")){
            this.putErr("ppswErr", "请输入6~12位密码");
            flag = false;
        }
//        if (null != this.getPlayername() || !this.getPlayername().trim().equals("")) {
//        this.putErr("pnameErr", "请输入姓名！");
//            flag = false;
//        }
        return flag;

    }

    public boolean update()
    {
       return PlayerDAO.update(this);
    }

    public static List<Player> getPlayers(){
        return  PlayerDAO.getPlayers();
    }

    public static void playerDel(int playerid)
    {
        PlayerDAO.delete(playerid);
    }


    public static boolean login(int studentid, String playerpassword) {
       return PlayerDAO.login(studentid, playerpassword);
    }

    public static Player getPlayerById(int id){
        return PlayerDAO.getPlayerById(id);
    }

    public static boolean update(Player p) {
        return PlayerDAO.update(p);
    }
}
