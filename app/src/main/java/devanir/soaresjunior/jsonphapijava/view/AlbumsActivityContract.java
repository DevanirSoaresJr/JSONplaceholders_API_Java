package devanir.soaresjunior.jsonphapijava.view;

import java.util.List;

import devanir.soaresjunior.jsonphapijava.model.AlbumResult;

public interface AlbumsActivityContract {


        void init();

        void showError(String message);

        void showAlbums(List<AlbumResult> albumResult);



}
