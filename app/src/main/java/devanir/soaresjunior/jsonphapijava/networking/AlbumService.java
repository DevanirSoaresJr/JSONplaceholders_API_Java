package devanir.soaresjunior.jsonphapijava.networking;

import java.util.List;

import devanir.soaresjunior.jsonphapijava.Constants;
import devanir.soaresjunior.jsonphapijava.model.AlbumResult;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface AlbumService {
    @GET(Constants.END_POINT)
    Single<List<AlbumResult>> getAlbums();
}
