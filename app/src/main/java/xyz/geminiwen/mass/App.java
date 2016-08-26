package xyz.geminiwen.mass;

import android.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import xyz.geminiwen.mass.dagger.components.AppComponent;
import xyz.geminiwen.mass.dagger.components.DaggerAppComponent;
import xyz.geminiwen.mass.dagger.modules.AppModule;
import xyz.geminiwen.mass.net.Service;

/**
 * Created by geminiwen on 16/8/25.
 */
public class App extends Application {
    public final static Executor sNetworkExecutors = Executors.newFixedThreadPool(5);
    public final static Executor sComputeExecutors = Executors.newCachedThreadPool();

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        Service.createFactory(this);
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
