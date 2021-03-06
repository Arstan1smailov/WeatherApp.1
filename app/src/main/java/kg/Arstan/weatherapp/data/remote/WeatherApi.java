package kg.Arstan.weatherapp.data.remote;

import kg.Arstan.weatherapp.data.model.WeatherApp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("data/2.5/weather")
    Call<WeatherApp> getTemp(
            @Query("q") String city,
            @Query("appid") String apiKey
            );
}
