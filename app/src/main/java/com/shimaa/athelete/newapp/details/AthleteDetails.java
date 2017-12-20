package com.shimaa.athelete.newapp.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.shimaa.athelete.newapp.model.JSONResponse;
import com.shimaa.athelete.newapp.R;
import com.shimaa.athelete.newapp.retrofit.RequestInterface;
import com.shimaa.athelete.newapp.model.AthelteModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AthleteDetails extends AppCompatActivity {

    private int position;
    private AthelteModel item;
    private ArrayList<AthelteModel> data;

    @Bind(R.id.title_details)
    TextView title;
    @Bind(R.id.breif_details)
    TextView breif;
    @Bind(R.id.img_details)
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete__details);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        item = getIntent().getParcelableExtra("item");

        title.setText(item.getName());
        String path = item.getImage();
        if (!path.isEmpty()) {
            Picasso.with(AthleteDetails.this).load(item.getImage()).into(img);
        } else {
            Picasso.with(AthleteDetails.this).load(R.drawable.image).into(img);
        }
        breif.setText(item.getBrief());
    }
}
