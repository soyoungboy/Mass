package xyz.geminiwen.mass.presenter;

import com.google.android.agera.Repositories;
import com.google.android.agera.Repository;
import com.google.android.agera.Result;

import xyz.geminiwen.mass.App;
import xyz.geminiwen.mass.api.ArticleAPI;
import xyz.geminiwen.mass.model.ArticleModel;
import xyz.geminiwen.mass.net.Service;
import xyz.geminiwen.mass.response.ListData;

/**
 * Created by geminiwen on 16/8/26.
 */
public class ArticlePresenter extends BasePresenter {
    Repository<Result<ArticleModel>> mArticleRepository;
    private ArticleAPI mArticleAPI;

    public ArticlePresenter() {
        mArticleAPI = Service.factory()
                             .createService(ArticleAPI.class);
    }

    public Repository<Result<ListData<ArticleModel>>> hottest() {
        return Repositories.repositoryWithInitialValue(Result.<ListData<ArticleModel>>absent())
                .observe()
                .onUpdatesPerLoop()
                .goTo(App.sNetworkExecutors)
                .attemptGetFrom(mArticleAPI.hottest()).orSkip()
                .thenTransform(input -> Result.present(input.getData()))
                .compile();
    }
}
