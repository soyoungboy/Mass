package xyz.geminiwen.mass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.agera.Repository;
import com.google.android.agera.Result;
import com.google.android.agera.Updatable;

import xyz.geminiwen.mass.model.ArticleModel;
import xyz.geminiwen.mass.presenter.ArticlePresenter;
import xyz.geminiwen.mass.response.ListData;

public class MainActivity extends AppCompatActivity implements Updatable {

    private Repository<Result<ListData<ArticleModel>>> mRepository;
    private ArticlePresenter mArticlePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mArticlePresenter = new ArticlePresenter();
        mRepository = mArticlePresenter.hottest();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRepository.addUpdatable(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRepository.removeUpdatable(this);
    }

    @Override
    public void update() {
        mRepository.get().ifSucceededSendTo(value -> {
            Toast.makeText(this, "article size :" +value.getRows().size(), Toast.LENGTH_LONG)
                    .show();
        });
    }
}
