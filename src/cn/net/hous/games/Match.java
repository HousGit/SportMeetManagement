package cn.net.hous.games;

import java.util.List;

/**
 * Created by 帅 on 2015/6/19.
 */
public class Match {

    private int matchid;
    private Player player;
    private Item item;
    private int group;
    private int matchtype;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getMatchtype() {
        return matchtype;
    }

    public void setMatchtype(int matchtype) {
        this.matchtype = matchtype;
    }



    public int getMatchid() {
        return matchid;
    }

    public void setMatchid(int matchid) {
        this.matchid = matchid;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public static void save(int stuid, int itmid){
        MatchDAO.save(stuid, itmid);
    }

    public static void save(int stuid, int itmid, int matchtype){
        MatchDAO.save(stuid, itmid, matchtype);
    }

    public static Match getMatchById(int matchid) {
        return MatchDAO.getMatchById(matchid);
    }

    public static List<Match> getMatches(){
        return MatchDAO.getMatches();
    }

    public static void delete(int id) {
        MatchDAO.delete(id);
    }


    public static List<Match> getMatchesByStuid(int id) {
        return MatchDAO.getMatchesByStuid(id);
    }

    public static List<Match> getMatchesByItmid(int id){
        return MatchDAO.getMatchesByItmid(id);
    }

    public static void groupById(int id, int matchtype){
        MatchDAO.groupById(id, matchtype);
    }

    public static void generateFinal(int id){
        MatchDAO.generateFinal(id);
    }

    public static void deleteFinalById(int itmid){
        MatchDAO.deleteFinalById(itmid);
    }
}