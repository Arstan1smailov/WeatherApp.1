package kg.Arstan.weatherapp.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kg.Arstan.weatherapp.data.model.WeatherApp;
import kg.Arstan.weatherapp.common.Resource;
import kg.Arstan.weatherapp.data.repositories.MainRepositoryImpl;

@HiltViewModel
public class WeatherViewModel extends ViewModel {

    public LiveData<Resource<WeatherApp>> liveData;
    private MainRepositoryImpl repository;

    public WeatherViewModel() {
    }

    @Inject
    public WeatherViewModel(MainRepositoryImpl repository) {
        this.repository = repository;
    }

    public void getWeatherByCityName(String cityName) {
        liveData = repository.getWeatherByCityName(cityName);
    }

}
