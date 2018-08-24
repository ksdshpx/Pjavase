package cn.ksdshpx.javase.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/24
 * Time: 10:00
 * Description:jdbc操作大文本Blob数据
 */
public class BlobTest {
    public static void main(String[] args) {
        //create();
        read();
    }

    static void create() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        File file = null;
        InputStream in = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into blob_test(image) values(?)";
            file = new File("src\\cn\\ksdshpx\\javase\\jdbc\\desk.png");
            in = new FileInputStream(file);
            pstmt = conn.prepareStatement(sql);
            pstmt.setBinaryStream(1, in, file.length());
            int effectRowNum = pstmt.executeUpdate();
            System.out.println("effectRowNum=" + effectRowNum);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
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
        InputStream in = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select image from blob_test";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("src\\cn\\ksdshpx\\javase\\jdbc\\desk_bak.png")));
            while (rs.next()) {
                in = rs.getBinaryStream("image");
                byte[] bbuff = new byte[1024];
                int len = 0;
                while ((len = in.read(bbuff)) != -1) {
                    bufferedOutputStream.write(bbuff, 0, len);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
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
