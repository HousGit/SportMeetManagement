package cn.net.hous.games;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 帅 on 2015/6/18.
 */
public class ItemDAO {

    public static void save(Item item) {
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "insert into item values(null, ?, 1)");
        try {
            pstm.setString(1, item.getItemname());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }
    }

    public static List<Item> getitems(){
        List<Item> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from item order by itemid asc");
        ResultSet rs = null;
        try {
            rs = pstm.executeQuery();

            while (rs.next()){
                Item item = new Item();
                item.setItemid(rs.getInt(1));
                item.setItemname(rs.getString(2));
                item.setItemtype(rs.getInt(3));
                list.add(item);
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

    public static List<Integer> getitemIds(){
        List<Integer> list = new ArrayList<>();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select itemid from item order by itemid asc");
        ResultSet rs = null;
        try {
            rs = pstm.executeQuery();

            while (rs.next()){
                list.add(rs.getInt(1));
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

    public static void delete(int itemid) {
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "delete from item where itemid = ?");
        try {
            pstm.setInt(1, itemid);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
        }
    }

    public static Item getItemById(int id) {
        Item i = new Item();
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "select * from item where itemid=?");
        ResultSet rs = null;
        try {
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()){
                i.setItemid(rs.getInt(1));
                i.setItemname(rs.getString(2));
                i.setItemtype(rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePstm(pstm);
            DB.closeConn(conn);
            DB.closeRs(rs);
        }

        return i;
    }

    public static boolean update(Item item)
    {
        boolean flag = false;
        Connection conn = DB.getConn();
        PreparedStatement pstm = DB.getPstm(conn, "update item set itemname=?, itemtype=? ");
        try {
            pstm.setString(1, item.getItemname());
            pstm.setInt(2, item.getItemtype());
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
}
