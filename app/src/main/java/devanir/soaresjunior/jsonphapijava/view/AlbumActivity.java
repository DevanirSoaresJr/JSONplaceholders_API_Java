package devanir.soaresjunior.jsonphapijava.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import devanir.soaresjunior.jsonphapijava.R;
import devanir.soaresjunior.jsonphapijava.adapter.RecyclerAdapter;
import devanir.soaresjunior.jsonphapijava.model.AlbumResult;
import devanir.soaresjunior.jsonphapijava.networking.NetworkClient;

public class AlbumActivity extends AppCompatActivity implements AlbumsActivityContract {


    private AlbumPresenter mPresenter;
    private RecyclerView recyclerview;
    RecyclerAdapter recyclerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new AlbumPresenter(this, NetworkClient.getRetrofit());
        init();
    }

    @Override
    public void init() {
        recyclerview = findViewById(R.id.rvAlbums);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        mPresenter.getAlbums();
    }


    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAlbums(List<AlbumResult> albumResult) {
        recyclerAdapter = new RecyclerAdapter(albumResult, AlbumActivity.this);
        recyclerview.setAdapter(recyclerAdapter);
    }

}