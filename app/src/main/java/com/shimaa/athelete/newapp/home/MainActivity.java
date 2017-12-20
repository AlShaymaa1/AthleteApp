package com.shimaa.athelete.newapp.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shimaa.athelete.newapp.details.AthleteDetails;
import com.shimaa.athelete.newapp.home.adapter.DataAdapter;
import com.shimaa.athelete.newapp.home.adapter.OnHolderClicked;
import com.shimaa.athelete.newapp.R;
import com.shimaa.athelete.newapp.model.AthelteModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @Bind(R.id.card_recycler_view)
    RecyclerView recyclerView;

    private ArrayList<AthelteModel> data;
    private DataAdapter adapter;
    private MainPresenterIml atheletPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        atheletPresenter = new MainPresenterIml();
        atheletPresenter.attachedView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        initRecyclerView();
        atheletPresenter.getItems();
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
//        loadJSON();
    }

    //    private void loadJSON() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://gist.githubusercontent.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RequestInterface request = retrofit.create(RequestInterface.class);
//        Call<JSONResponse> call = request.getJSON();
//        call.enqueue(new Callback<JSONResponse>() {
//            @Override
//            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
//
//                JSONResponse jsonResponse = response.body();
//                Log.e("aplication", jsonResponse.toString());
//                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
//
//                adapter = new DataAdapter(data, getApplicationContext(), new OnHolderClicked() {
//                    @Override
//                    public void onClick(int position) {
//                        Intent intent = new Intent(MainActivity.this, AthleteDetails.class);
//                        intent.putExtra("position", position);
//                        startActivity(intent);
//                    }
//                });
//
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<JSONResponse> call, Throwable t) {
//                Log.d("Error", t.getMessage());
//            }
//        });
//    }
    @Override
    public void setItems(final ArrayList<AthelteModel> Athdata) {

        adapter = new DataAdapter(Athdata, getApplicationContext(), new OnHolderClicked() {
            @Override
            public void onClick(AthelteModel item) {
                Intent intent = new Intent(MainActivity.this, AthleteDetails.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgress() {
//        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
//        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        atheletPresenter.detachView();
    }
}

