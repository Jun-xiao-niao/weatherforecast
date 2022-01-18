package updatedatabase;

import dataobject.City;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

import static sqlconnection.connection.getConnection;

public class UpdateCity {
    public static void main(String[] args) {

        String url1 = "https://geoapi.qweather.com/v2/city/lookup?key=8623308df361462796e4d3906390e866&location=beijing";
        String url2 = "https://geoapi.qweather.com/v2/city/lookup?key=8623308df361462796e4d3906390e866&location=shanghai";
        String url3 = "https://geoapi.qweather.com/v2/city/lookup?key=8623308df361462796e4d3906390e866&location=fuzhou";
        City city1 = method1(url1);  //北京
        City city2 = method1(url2);  //上海
        City city3 = method1(url3);  //福州

    }

    public static City method1(String str) {

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
            System.out.println(res);
            s = res.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //用net.sf.json找到对应信息
        JSONObject jsonObject = JSONObject.fromObject(s);
        JSONArray jsonArray = jsonObject.getJSONArray("location");
        JSONObject J = jsonArray.getJSONObject(0);

        //生成对象city
        String id = J.getString("id");
        String name = J.getString("name");
        String lat = J.getString("lat");
        String lon = J.getString("lon");
        int intId = Integer.parseInt(id);
        City city = new City(intId, name, lon, lat);
        System.out.println(city);

        //连接数据库，更新数据
        String sql = "update city set id =?, lon =?, lat =? where name=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, intId);
            pstmt.setString(2, lon);
            pstmt.setString(3, lat);
            pstmt.setString(4, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return city;

    }

}
