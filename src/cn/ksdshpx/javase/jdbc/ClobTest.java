package cn.ksdshpx.javase.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/23
 * Time: 9:58
 * Description:jdbc操作大文本数据
 */
public class ClobTest {
    public static void main(String[] args) {
        //create();
        read();
    }

    static void create() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        File file = null;
        Reader reader = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into clob_test(article) values(?)";
            file = new File("src\\cn\\ksdshpx\\javase\\jdbc\\JdbcUtils.java");
            reader = new FileReader(file);
            pstmt = conn.prepareStatement(sql);
            pstmt.setCharacterStream(1, reader, file.length());
            int effectRowNum = pstmt.executeUpdate();
            System.out.println("effectRowNum=" + effectRowNum);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    JdbcUtils.close(conn, pstmt, rs);
                }
            }
        }
    }

    static void read() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Reader reader = null;
        BufferedWriter bufferedWriter = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select article from clob_test";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            bufferedWriter = new BufferedWriter(new FileWriter(new File("src\\cn\\ksdshpx\\javase\\jdbc\\JdbcUtils_bak.java")));
            while (rs.next()) {
                reader = rs.getCharacterStream("article");
                char[] cbuff = new char[1024];
                int len = 0;
                while ((len = reader.read(cbuff)) != -1) {
                    bufferedWriter.write(cbuff, 0, len);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            JdbcUtils.close(conn, pstmt, rs);
                        }
                    }
                }
            }
        }
    }
}
