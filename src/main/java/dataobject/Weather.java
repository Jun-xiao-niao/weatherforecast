package dataobject;

public class Weather {
    private int id;
    private String name;
    private String fxData;
    private String tempMax;
    private String tempMin;
    private String textDay;

    public Weather(int id, String name,String fxData, String tempMax, String tempMin, String textDay) {
        this.id = id;
        this.fxData = fxData;
        this.name = name;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.textDay = textDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFxData() {
        return fxData;
    }

    public void setFxData(String fxData) {
        this.fxData = fxData;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    @Override
    public String toString() {
        return "CityDailyWeather{" +
                "\"id\":\"" + id + "\"" +
                ", \"name\":\"" + name + "\"" +
                ", \"fxData\":\"" + fxData + "\"" +
                ", \"tempMax\":\"" + tempMax + "\"" +
                ", \"tempMin\":\"" + tempMin + "\"" +
                ", \"textDay\":\"" + textDay + "\"" +
                "}";
    }
}

