package sercandevops.com.retrofitwebservis3.RestApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import sercandevops.com.retrofitwebservis3.Models.Bilgi;

public interface RestApi {


    @GET("/photos")
    Call<List<Bilgi>> getir();
}
