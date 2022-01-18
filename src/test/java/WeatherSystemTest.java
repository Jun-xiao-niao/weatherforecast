import static querydatabase.QueryCity.queryCity;
import static querydatabase.QueryWeather.queryWeather;
import static updatedatabase.UpdateCity.updatecity;
import static updatedatabase.UpdateWeather.updateweather;

public class WeatherSystemTest {

    public static void main(String[] args) {

        //更新城市信息
        //updatecity();

        //更新天气信息
        //updateweather();

        //查询3个城市的信息
        //queryCity();

        //分别查询3个城市的天气信息
        queryWeather("北京");


    }

}
