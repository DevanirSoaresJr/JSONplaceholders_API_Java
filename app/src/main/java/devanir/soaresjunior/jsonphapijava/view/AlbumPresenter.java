package devanir.soaresjunior.jsonphapijava.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import devanir.soaresjunior.jsonphapijava.model.AlbumResult;
import devanir.soaresjunior.jsonphapijava.networking.AlbumService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AlbumPresenter implements AlbumPresenterContract {


    AlbumsActivityContract albumsActivityContract;

    CompositeDisposable disposable = new CompositeDisposable();
    AlbumService albumService;
    private String TAG = "AlbumPresenter";

    public AlbumPresenter(AlbumsActivityContract albumsActivityContract, AlbumService albumService) {
        this.albumsActivityContract = albumsActivityContract;
        this.albumService = albumService;
    }

    @Override
    public void getAlbums() {

        disposable.add(
                albumService.getAlbums().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(albumResults -> {
                            Collections.sort(albumResults, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
                            albumsActivityContract.showAlbums(albumResults);
                        }, throwable -> throwable.printStackTrace())
        );

    }


}


