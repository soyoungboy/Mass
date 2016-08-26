package xyz.geminiwen.mass.api;

import com.google.android.agera.Result;
import com.google.android.agera.Supplier;

import retrofit2.http.GET;
import xyz.geminiwen.mass.response.DataResponse;

/**
 * Created by geminiwen on 16/8/25.
 */
public interface ArticleAPI {

    @GET("/article/hottest")
    Supplier<Result<DataResponse<ListData<ArticleModel>>>> hottest();
}
