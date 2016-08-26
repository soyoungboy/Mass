package xyz.geminiwen.mass.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import xyz.geminiwen.mass.BuildConfig;

/**
 * Created by geminiwen on 16/8/25.
 */
public class ServiceInterceptor implements Interceptor {

    private static final String KEY_VERSION = "X-Version";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader(KEY_VERSION, String.valueOf(BuildConfig.API_LEVEL));
        return chain.proceed(builder.build());
    }
}
