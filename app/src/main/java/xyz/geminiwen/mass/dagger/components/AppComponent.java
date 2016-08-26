package xyz.geminiwen.mass.dagger.components;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import xyz.geminiwen.mass.dagger.modules.AppModule;
import xyz.geminiwen.mass.net.Service;

/**
 * Created by geminiwen on 16/8/25.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void injectService(Service service);

    Context getContext();
    OkHttpClient httpClient();
}
