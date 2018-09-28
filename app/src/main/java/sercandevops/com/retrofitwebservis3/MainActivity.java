package sercandevops.com.retrofitwebservis3;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sercandevops.com.retrofitwebservis3.Models.Adaptor;
import sercandevops.com.retrofitwebservis3.Models.Bilgi;
import sercandevops.com.retrofitwebservis3.RestApi.ManagerAll;

public class MainActivity extends AppCompatActivity {

    List<Bilgi> listbilgi;
    ListView listeview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listeview = (ListView)findViewById(R.id.listview);

        istek();
    }

    public void istek(){

        Call<List<Bilgi>> servis = ManagerAll.getInstance().getirBilgi();

        listbilgi = new ArrayList<>();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Bilgiler Ekranı");
        progressDialog.setMessage("İÇerik Yükleniyor..Lütfen Bekleyiniz.");
        progressDialog.setCancelable(false);
        progressDialog.show();

        servis.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {

                    if(response.isSuccessful()){

                        listbilgi = response.body();
                        Adaptor adaptor = new Adaptor(getApplicationContext(),listbilgi);
                        listeview.setAdapter(adaptor);
                        Log.i("cvp",response.body().toString());
                    }
                    progressDialog.cancel();

            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }
}
