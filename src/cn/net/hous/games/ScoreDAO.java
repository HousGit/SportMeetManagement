package cn.net.hous.games;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 帅 on 2015/6/21.
 */
public class ScoreDAO {
    public static void save(int mthid, String score){
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "insert into score values(null, ?, ?, ?)");
        try {
            pstm.setInt(1, mthid);
            pstm.setString(2, score);
            pstm.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }
    }

    public static Score getScoreById(int scoreid){
        Score s = new Score();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from score where scoreid=?");
        ResultSet rs = null;
        try {
            pstm.setInt(1, scoreid);
            rs = pstm.executeQuery();

            while (rs.next()){
                s.setScoreid(rs.getInt(1));
                s.setMatch(Match.getMatchById(rs.getInt(2)));
                s.setScore(rs.getString(3));
                s.setStime(rs.getTimestamp(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
            DB.closeRs(rs);
        }
        return s;
    }

    public static List<Score> getScores(){
        List<Score> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from score order by mthid asc");
        ResultSet rs = null;
        try {
            rs = pstm.executeQuery();

            while (rs.next()){
               Score s = new Score();

                s.setScoreid(rs.getInt(1));
                s.setMatch(Match.getMatchById(rs.getInt(2)));
                s.setScore(rs.getString(3));
                s.setStime(rs.getTimestamp(4));

                list.add(s);
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

    public static List<Score> getScoreByStuID(int id){
        List<Score> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select scoreid, mthid, scores, stime from score left join matches on mthid=matchid where stuid=?");

        ResultSet rs = null;
        try {
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()){
                Score s = new Score();
                s.setScoreid(rs.getInt(1));
                s.setMatch(Match.getMatchById(rs.getInt(2)));
                s.setScore(rs.getString(3));
                s.setStime(rs.getTimestamp(4));
                list.add(s);
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

    public static List<Score> getScoreByItmid(int itmid){
        List<Score> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select scoreid, mthid, scores, stime from score left join matches on mthid=matchid where itmid=?  order by scores");

        ResultSet rs = null;
        try {
            pstm.setInt(1, itmid);
            rs = pstm.executeQuery();
            while (rs.next()){
                Score s = new Score();
                s.setScoreid(rs.getInt(1));
                s.setMatch(Match.getMatchById(rs.getInt(2)));
                s.setScore(rs.getString(3));
                s.setStime(rs.getTimestamp(4));
                list.add(s);
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

    public static List<Score> getScoreByItmid(int itmid, int matchtype){
        List<Score> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select scoreid, mthid, scores, stime from score left join matches on mthid=matchid where itmid=? and matchtype=2 order by scores limit ? ");

        ResultSet rs = null;
        try {
            pstm.setInt(1, itmid);
            pstm.setInt(2, matchtype);
            rs = pstm.executeQuery();
            while (rs.next()){
                Score s = new Score();
                s.setScoreid(rs.getInt(1));
                s.setMatch(Match.getMatchById(rs.getInt(2)));
                s.setScore(rs.getString(3));
                s.setStime(rs.getTimestamp(4));
                list.add(s);
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

    public static void update(int scoreid, String scores) {
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "update score set scores=? where scoreid=?");
        try {
            pstm.setString(1, scores);
            pstm.setInt(2, scoreid);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }
    }

    public static List<Score> getScoreByStuName(String stuname) {
        List<Score> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select scoreid, mthid, scores, stime from score left join matches on mthid=matchid left join player on stuid = studentid  where playername=? order by scoreid");
        ResultSet rs = null;

        try {
            pstm.setString(1, stuname);
            rs = pstm.executeQuery();
            while (rs.next()){
                Score s = new Score();
                s.setScoreid(rs.getInt(1));
                s.setMatch(Match.getMatchById(rs.getInt(2)));
                s.setScore(rs.getString(3));
                s.setStime(rs.getTimestamp(4));
                list.add(s);
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

    public static List<Score> getScoresByItmName(String itmname) {
        List<Score> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select scoreid, mthid, scores, stime from score left join matches on mthid=matchid left join item on itmid=itemid where itemname=? order by scoreid");
        ResultSet rs = null;

        try {
            pstm.setString(1, itmname);
            rs = pstm.executeQuery();
            while (rs.next()){
                Score s = new Score();
                s.setScoreid(rs.getInt(1));
                s.setMatch(Match.getMatchById(rs.getInt(2)));
                s.setScore(rs.getString(3));
                s.setStime(rs.getTimestamp(4));
                list.add(s);
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
}
