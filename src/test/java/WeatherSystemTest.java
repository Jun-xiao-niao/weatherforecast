import static querydatabase.QueryCity.queryCity;
import static querydatabase.QueryWeather.queryWeather;
import static updatedatabase.UpdateCity.updatecity;
import static updatedatabase.UpdateWeather.updateweather;

public class WeatherSystemTest {

    public static void main(String[] args) {

        //想用哪个功能，运行对应方法就可以啦！

        //更新城市信息，调用的是updatedatabase.UpdateCity类
        updatecity();

        //更新天气信息，调用的是updatedatabase.UpdateWeather类
        updateweather();

        //查询3个城市的信息，调用的是querydatabase.QueryCity类
        queryCity();

        //分别查询3个城市的天气信息，调用的是QueryWeather.queryWeather类
        queryWeather("北京");
        queryWeather("上海");
        queryWeather("福州");

    }

}
