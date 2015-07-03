package cn.net.hous.games;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by 帅 on 2015/6/21.
 */
public class Score {
    private int scoreid;
    private Match match;
    private String score;
    private Timestamp stime;

    public int getScoreid() {
        return scoreid;
    }

    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Timestamp getStime() {
        return stime;
    }

    public void setStime(Timestamp stime) {
        this.stime = stime;
    }

    public static void save(int itmid, String score){
        ScoreDAO.save(itmid, score);
    }

    public static List<Score> getScores(){
        return ScoreDAO.getScores();
    }

    public static List<Score> getScoreByStuId(int id){
        return ScoreDAO.getScoreByStuID(id);
    }

    public static List<Score> getScoreByItmId(int id){
        return ScoreDAO.getScoreByItmid(id);
    }

    public static List<Score> getScoreByItmId(int id, int matchtype){
        return ScoreDAO.getScoreByItmid(id, matchtype);
    }

    public static void update(int scoreid, String scores){
        ScoreDAO.update(scoreid, scores);
    }

    public static List<Score> getScoreByStuName(String stuname) {
        return ScoreDAO.getScoreByStuName(stuname);
    }

    public static List<Score> getScoresByItmName(String itmname){
        return ScoreDAO.getScoresByItmName(itmname);
    }
}
