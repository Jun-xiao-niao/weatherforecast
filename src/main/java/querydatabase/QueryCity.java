package querydatabase;

import dataobject.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static sqlconnection.connection.getConnection;

public class QueryCity {

    public static void queryCity(){
        String sql = "select * from city";
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        //创建一个集合对象用来存放查询到的数据
        List<City> cityList = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lon = rs.getString("lon");
                String lat = rs.getString("lat");
                //每个记录对应一个对象
                City city = new City(id,name,lon,lat);
                //将对象放到集合中
                cityList.add(city);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println(cityList);
    }

}
