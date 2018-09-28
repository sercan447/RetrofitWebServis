package sercandevops.com.retrofitwebservis3.RestApi;

import java.util.List;

import retrofit2.Call;
import sercandevops.com.retrofitwebservis3.Models.Bilgi;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourgetInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){
        return ourgetInstance;
    }

    public Call<List<Bilgi>> getirBilgi(){
        Call<List<Bilgi>> x = getRestApiClient().getir();
        return x;
    }
}
