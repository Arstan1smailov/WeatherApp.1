package kg.Arstan.weatherapp.di;

import android.content.Context;

import androidx.room.Room;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import kg.Arstan.weatherapp.data.local.WeatherDao;
import kg.Arstan.weatherapp.data.repositories.MainRepositoryImpl;
import kg.Arstan.weatherapp.domain.repository.MainRepository;
import kg.Arstan.weatherapp.data.local.AppDatabase;
import kg.Arstan.weatherapp.data.remote.WeatherApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public abstract class AppModule {
    @Provides
    public static OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Provides
    public static Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    public static WeatherApi provideApi(Retrofit retrofit) {
        return retrofit.create(WeatherApi.class);
    }

    @Provides
    public static MainRepository provideMainRepository(WeatherApi api, WeatherDao dao){
        return new MainRepositoryImpl(api, dao);
    }

    @Provides
    public static AppDatabase provideDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    public static WeatherDao provideDao(AppDatabase database){
        return database.weatherDao();
    }
}
