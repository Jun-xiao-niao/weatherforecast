package updatedatabase;

import dataobject.Weather;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.zip.GZIPInputStream;

import static sqlconnection.connection.getConnection;

public class UpdateWeather {
    public static void updateweather() {

        String url1 = "https://devapi.qweather.com/v7/weather/3d?key=8623308df361462796e4d3906390e866&location=101010100";
        String url2 = "https://devapi.qweather.com/v7/weather/3d?key=8623308df361462796e4d3906390e866&location=101020100";
        String url3 = "https://devapi.qweather.com/v7/weather/3d?key=8623308df361462796e4d3906390e866&location=101230101";
        method1(url1, "北京", 100);  //北京今日
        method1(url1, "北京", 101);  //北京明日
        method1(url1, "北京", 102);  //北京后日
        method1(url2, "上海", 200);  //上海今日
        method1(url2, "上海", 201);  //上海明日
        method1(url2, "上海", 202);  //上海后日
        method1(url3, "福州", 300);  //福州今日
        method1(url3, "福州", 301);  //福州明日
        method1(url3, "福州", 302);  //福州后日

    }

    public static void method1(String str, String name, int id) {

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
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //用net.sf.json找到对应信息
        JSONObject jsonObject = JSONObject.fromObject(s);
        JSONArray jsonArray = jsonObject.getJSONArray("daily");
        JSONObject J = jsonArray.getJSONObject(id % 100);

        //获得了weather的信息
        String fxData = J.getString("fxDate");
        String tempMax = J.getString("tempMax");
        String tempMin = J.getString("tempMin");
        String textDay = J.getString("textDay");

        //生成对象weather，并打印更新的信息
        Weather weather = new Weather(id, name, fxData, tempMax, tempMin, textDay);
        System.out.println(weather);

        //连接数据库，更新数据库的数据
        String sql = "update weather set fxData =?, tempMax =?, tempMin =?, textDay =?  where id=?";
        Connection conn;
        PreparedStatement pstmt;
        try {
            conn = getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, fxData);
            pstmt.setString(2, tempMax);
            pstmt.setString(3, tempMin);
            pstmt.setString(4, textDay);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

}