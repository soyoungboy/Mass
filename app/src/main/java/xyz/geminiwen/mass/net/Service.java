package xyz.geminiwen.mass.net;

import android.content.Context;

import me.drakeet.retrofit2.adapter.agera.AgeraCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.geminiwen.mass.App;
import xyz.geminiwen.mass.BuildConfig;
import xyz.geminiwen.mass.dagger.components.AppComponent;

import static java.util.Objects.requireNonNull;

/**
 * Created by geminiwen on 16/8/25.
 */
public class Service {
    private static Service sFactory;

    public static void createFactory(Context context) {
        sFactory = new Service(context);
    }

    public static Service factory() {
        return requireNonNull(sFactory);
    }

    private Retrofit mServiceRetrofit;

    private Service(Context context) {
        App app = (App) context.getApplicationContext();
        AppComponent component = app.getAppComponent();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(component.httpClient())
                .addCallAdapterFactory(AgeraCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.API_BASE_URL);

        mServiceRetrofit = builder.build();
    }

    public <T> T createService(Class<T> type) {
        return mServiceRetrofit.create(type);
    }
}
