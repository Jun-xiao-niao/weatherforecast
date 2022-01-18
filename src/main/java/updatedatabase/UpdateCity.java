package updatedatabase;

import dataobject.City;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.zip.GZIPInputStream;

import static sqlconnection.connection.getConnection;

public class UpdateCity {
    public static void updatecity() {

        String url1 = "https://geoapi.qweather.com/v2/city/lookup?key=8623308df361462796e4d3906390e866&location=beijing";
        String url2 = "https://geoapi.qweather.com/v2/city/lookup?key=8623308df361462796e4d3906390e866&location=shanghai";
        String url3 = "https://geoapi.qweather.com/v2/city/lookup?key=8623308df361462796e4d3906390e866&location=fuzhou";
        method1(url1);  //北京
        method1(url2);  //上海
        method1(url3);  //福州

    }

    public static void method1(String str) {

        String s = "";  //定义返回的JSON字符串为s

        try {
            //获取了城市信息，记录在字符串s里
            URL url = new URL(str);
            InputStream is = url.openStream();
            GZIPInputStream gzipInputStream = new GZIPInputStream(is);
            StringBuilder res = new StringBuilder();
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
            s = res.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //用net.sf.json找到对应信息
        JSONObject jsonObject = JSONObject.fromObject(s);
        JSONArray jsonArray = jsonObject.getJSONArray("location");
        JSONObject J = jsonArray.getJSONObject(0);

        //获得了city的信息
        String id = J.getString("id");
        String name = J.getString("name");
        String lat = J.getString("lat");
        String lon = J.getString("lon");
        int intId = Integer.parseInt(id);

        //生成对象city，并打印更新的信息
        City city = new City(intId, name, lon, lat);
        System.out.println(city);

        //连接数据库，更新数据库的数据
        String sql = "update city set id =?, lon =?, lat =? where name=?";
        Connection conn;
        PreparedStatement pstmt;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, intId);
            pstmt.setString(2, lon);
            pstmt.setString(3, lat);
            pstmt.setString(4, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
