package kg.Arstan.weatherapp.domain.repository;

import androidx.lifecycle.MutableLiveData;

import kg.Arstan.weatherapp.data.model.WeatherApp;
import kg.Arstan.weatherapp.common.Resource;

public interface MainRepository {

    MutableLiveData<Resource<WeatherApp>> getWeatherByCityName(String cityName);
}
