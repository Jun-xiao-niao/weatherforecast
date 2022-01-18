package querydatabase;

import dataobject.City;
import dataobject.Weather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static sqlconnection.connection.getConnection;

public class QueryWeather {

    public static void queryWeather(String name) {
        String sql = "select * from weather WHERE name =\'" + name + "\'";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //创建一个集合对象用来存放查询到的数据
        List<Weather> weatherList = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fxData = rs.getString("fxData");
                String tempMax = rs.getString("tempMax");
                String tempMin = rs.getString("tempMin");
                String textDay = rs.getString("textDay");
                //每个记录对应一个对象
                Weather weather = new Weather(id, name, fxData, tempMax, tempMin, textDay);
                //将对象放到集合中
                weatherList.add(weather);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println(weatherList);
    }

}
