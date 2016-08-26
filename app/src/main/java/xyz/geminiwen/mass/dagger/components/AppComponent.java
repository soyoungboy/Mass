package xyz.geminiwen.mass.dagger.components;

import android.content.Context;

import com.segmentfault.app.agera.api.Service;
import com.segmentfault.app.agera.dagger.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

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
