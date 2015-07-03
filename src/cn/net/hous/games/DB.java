package cn.net.hous.games;


import java.sql.*;
/**
 * Created by ? on 2015/6/4.
 */
public class DB {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn()
    {
        Connection conn=null;
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root", "hous");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static PreparedStatement getPstm (Connection conn, String sql){
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstm;
    }

    public static Statement getStm(Connection conn){
        Statement stm = null;
        try {
            stm = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stm;
    }

    public static ResultSet getRs(Statement stm, String sql){
        ResultSet rs = null;
        try {
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet getRs(PreparedStatement pstm){
        ResultSet rs = null;
        try {
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeConn(Connection conn){
        if (conn != null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closePstm (PreparedStatement pstm)
    {
        if (pstm != null)
        {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStm(Statement stm){
        if (stm != null)
        {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeRs(ResultSet rs )
    {
        if(rs != null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}


