package cn.net.hous.games;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 帅 on 2015/6/19.
 */
public class MatchDAO {

    public static void save(int stuid, int itmid) {

        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "insert into matches values(null, ?, ?, null, 1)");
        ResultSet rs = null;
        try {
            pstm.setInt(1, stuid);
            pstm.setInt(2, itmid);
            pstm.executeUpdate();
            pstm = DB.getPstm(conn, "select matchid from matches where stuid=? and itmid=? and matchtype=1");
            pstm.setInt(1, stuid);
            pstm.setInt(2, itmid);
            rs = pstm.executeQuery();
            while (rs.next()){
                ScoreDAO.save(rs.getInt(1), "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeRs(rs);
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }
    }

    public static void save(int stuid, int itmid, int matchtype) {

        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "insert into matches values(null, ?, ?, null, ?)");
        ResultSet rs = null;
        try {
            pstm.setInt(1, stuid);
            pstm.setInt(2, itmid);
            pstm.setInt(3,matchtype);
            pstm.executeUpdate();
            pstm = DB.getPstm(conn, "select matchid from matches where stuid=? and itmid=? and matchtype=?");
            pstm.setInt(1, stuid);
            pstm.setInt(2, itmid);
            pstm.setInt(3, matchtype);
            rs = pstm.executeQuery();
            while (rs.next()){
                ScoreDAO.save(rs.getInt(1), "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeRs(rs);
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }
    }


    public static List<Match> getMatches(){
        List<Match> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from matches order by matchid asc");
        ResultSet rs = null;
        try {
            rs = pstm.executeQuery();

            while (rs.next()){
                Match match = new Match();
                match.setMatchid(rs.getInt(1));
                match.setPlayer(Player.getPlayerById(rs.getInt(2)));
                match.setItem(Item.getItemById(rs.getInt(3)));
                match.setGroup(rs.getInt(4));
                match.setMatchtype(rs.getInt(5));
                list.add(match);
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

    public static void delete(int matchid) {
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "delete from matches where matchid = ?");
        try {
            pstm.setInt(1, matchid);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }
    }

    public static Match getMatchById(int id) {
        Match match = new Match();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from matches where matchid=?");
        ResultSet rs = null;
        try {
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()){
                match.setMatchid(rs.getInt(1));
                match.setPlayer(Player.getPlayerById(rs.getInt(2)));
                match.setItem(Item.getItemById(rs.getInt(3)));
                match.setGroup(rs.getInt(4));
                match.setMatchtype(rs.getInt(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
            DB.closeRs(rs);
        }
        return match;
    }


    public static List<Match> getMatchesByStuid(int id) {
        List<Match> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from matches where stuid=? order by matchid asc");

        ResultSet rs = null;
        try {
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()){
                Match match = new Match();
                match.setMatchid(rs.getInt(1));
                match.setPlayer(Player.getPlayerById(rs.getInt(2)));
                match.setItem(Item.getItemById(rs.getInt(3)));
                match.setGroup(rs.getInt(4));
                match.setMatchtype(rs.getInt(5));
                list.add(match);
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

    public static List<Match> getMatchesByItmid(int id) {
        List<Match> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from matches where itmid=? order by matchid asc");

        ResultSet rs = null;
        try {
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()){
                Match match = new Match();
                match.setMatchid(rs.getInt(1));
                match.setPlayer(Player.getPlayerById(rs.getInt(2)));
                match.setItem(Item.getItemById(rs.getInt(3)));
                match.setGroup(rs.getInt(4));
                match.setMatchtype(rs.getInt(5));
                list.add(match);
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


    public static void groupById(int id, int matchtype) {
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn,"select matchid from matches where itmid =? and matchtype=?");

        ResultSet rs = null;
        List<Integer> matchids = new ArrayList<>();
        int groupno=0;
        try {
            pstm.setInt(1,id);
            pstm.setInt(2,matchtype);
            rs = pstm.executeQuery();
            while (rs.next()){
                matchids.add(rs.getInt(1));
            }
            pstm = DB.getPstm(conn, "update  matches set matchgroup=? where matchid=?");
            for(int i=0; i<matchids.size(); i++){
                if (i%6==0){
                    groupno++;
                }
                pstm.setInt(2, matchids.get(i));
                pstm.setInt(1, groupno);
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeRs(rs);
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }
    }


    public static void generateFinal(int id) {
        Connection connection = DB.getConn();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = DB.getPstm(connection, "select stuid, itmid from score left join matches on mthid=matchid where itmid=? and matchtype=1 order by scores asc limit 3");
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Match.save(resultSet.getInt(1), resultSet.getInt(2), 2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeRs(resultSet);
            DB.closePstm(preparedStatement);
            DB.closeConn(connection);
        }

    }

    public static void deleteFinalById(int itmid) {
        Connection connection = DB.getConn();
        PreparedStatement preparedStatement = DB.getPstm(connection, "delete from matches where matchtype = 2 and itmid =?");
        try {
            preparedStatement.setInt(1, itmid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closePstm(preparedStatement);
            DB.closeConn(connection);
        }

    }
}

