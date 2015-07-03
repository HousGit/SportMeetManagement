package cn.net.hous.games;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ˧ on 2015/6/16.
 */
public class PlayerDAO {

    public static void sava(Player player)
    {
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "insert into player values(null, ?, ?, ?, ?, ?, ?)");
        try {
            pstm.setInt(1, player.getStudentid());
            pstm.setString(2, player.getPlayerpassword());
            pstm.setString(3, player.getPlayername());
            pstm.setInt(4, player.getPlayersex());
            pstm.setString(5, player.getPlayerphone());
            pstm.setString(6, player.getPlayerother());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }

    }

    public static boolean update(Player player)
    {
        boolean flag = false;
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "update player set playerpassword=?, playername=?, playersex=?, playerphone=?, playerother=? where studentid=?");
        try {
            pstm.setString(1, player.getPlayerpassword());
            pstm.setString(2, player.getPlayername());
            pstm.setInt(3, player.getPlayersex());
            pstm.setString(4, player.getPlayerphone());
            pstm.setString(5, player.getPlayerother());
            pstm.setInt(6, player.getStudentid());
            pstm.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }

        return flag;
    }

    public static List<Player> getPlayers() {
        List<Player> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from player order by playerid asc");
        ResultSet rs = null;
        try {
            rs = pstm.executeQuery();

            while (rs.next()){
                Player p = new Player();
                p.setPlayerid(rs.getInt(1));
                p.setStudentid(rs.getInt(2));
                p.setPlayerpassword(rs.getString(3));
                p.setPlayername(rs.getString(4));
                p.setPlayersex(rs.getInt(5));
                p.setPlayerphone(rs.getString(6));
                p.setPlayerother(rs.getString(7));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
            DB.closeRs(rs);
        }

        return list;
    }

    public static void delete(int playerid) {
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "delete from player where studentid = ?");
        try {
            pstm.setInt(1, playerid);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }
    }

    public static boolean login(int studentid, String playerpassword) {
        boolean flag = false;
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from player where studentid=? and playerpassword=? ");
        ResultSet rs = null;
        try {
            pstm.setInt(1, studentid);
            pstm.setString(2, playerpassword);
            rs = pstm.executeQuery();
            while (rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
            DB.closeRs(rs);
        }
        return flag;
    }

    public static Player getPlayerById(int id) {
        Player p = new Player();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from player where studentid=?");
        ResultSet rs = null;
        try {
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()){

                p.setPlayerid(rs.getInt(1));
                p.setStudentid(rs.getInt(2));
                p.setPlayerpassword(rs.getString(3));
                p.setPlayername(rs.getString(4));
                p.setPlayersex(rs.getInt(5));
                p.setPlayerphone(rs.getString(6));
                p.setPlayerother(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
            DB.closeRs(rs);
        }

        return p;
    }
}
