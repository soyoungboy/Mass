package xyz.geminiwen.mass;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.agera.Function;
import com.google.android.agera.Functions;
import com.google.android.agera.Receiver;
import com.google.android.agera.Repositories;
import com.google.android.agera.Repository;
import com.google.android.agera.Result;
import com.google.android.agera.Updatable;

import java.util.List;

import xyz.geminiwen.mass.api.ArticleAPI;
import xyz.geminiwen.mass.model.ArticleModel;
import xyz.geminiwen.mass.net.Service;
import xyz.geminiwen.mass.response.DataResponse;
import xyz.geminiwen.mass.response.ListData;

public class MainActivity extends AppCompatActivity implements Updatable {

    private Repository<Result<List<ArticleModel>>> mRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArticleAPI api = Service.factory()
                .createService(ArticleAPI.class);

    }



    @Override
    public void update() {

    }
}
