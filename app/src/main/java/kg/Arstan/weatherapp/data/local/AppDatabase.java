package kg.Arstan.weatherapp.data.local;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import kg.Arstan.weatherapp.data.local.converters.CloudsConverter;
import kg.Arstan.weatherapp.data.local.converters.CoordConverter;
import kg.Arstan.weatherapp.data.local.converters.MainConverter;
import kg.Arstan.weatherapp.data.local.converters.SysConverter;
import kg.Arstan.weatherapp.data.local.converters.WeatherConverter;
import kg.Arstan.weatherapp.data.local.converters.WindConverter;
import kg.Arstan.weatherapp.data.model.WeatherApp;

@Database(entities = {WeatherApp.class}, version = 1, exportSchema = false)
@TypeConverters({MainConverter.class, WindConverter.class, SysConverter.class,
        WeatherConverter.class, CloudsConverter.class, CoordConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract WeatherDao weatherDao();
}
