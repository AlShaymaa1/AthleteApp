package com.shimaa.athelete.newapp.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shimaa.athelete.newapp.R;
import com.shimaa.athelete.newapp.model.AthelteModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AthelteModel> athletes;
    private Context context;
    private OnHolderClicked listner;

    public DataAdapter(ArrayList<AthelteModel> athletes, Context context , OnHolderClicked listner ) {
        this.context=context;
        this.athletes = athletes;
        this.listner=listner;
    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {

        viewHolder.title.setText(athletes.get(i).getName());
        //viewHolder.tv_version.setImageResource(athletes.get(i).getImage());

        String path=athletes.get(i).getImage();
        Log.e("bejbce",path);
        if(!path.isEmpty()) {
            Picasso.with(context).load(athletes.get(i).getImage()).into(viewHolder.img);

        }
        else{
            Picasso.with(context).load(R.drawable.image).into(viewHolder.img);
        }

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.img!=null)
                    listner.onClick(athletes.get(i));
            }
        });

    }


    @Override
    public int getItemCount() {
        return athletes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.title_id)
    TextView title;
    @Bind(R.id.image_id)
    ImageView img;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

