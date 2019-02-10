package com.appgrouplab.pokedex.Type.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appgrouplab.pokedex.R;
import com.appgrouplab.pokedex.model.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterType extends RecyclerView.Adapter<AdapterType.ViewHolder> implements  View.OnClickListener {

    private List<Result> list;
    private Context context;
    private View.OnClickListener listener;

    public AdapterType(Context context) {
        list = new ArrayList<>();
        this.context=context;
    }

    public void setDataset(List<Result> dataset)
    {
        list = dataset;
        notifyDataSetChanged();
    }

    @Override
    public AdapterType.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_type,null,false);

        v.setOnClickListener(this);

        return new AdapterType.ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(AdapterType.ViewHolder holder, int position) {
        
        final Result type = list.get(position);
        holder.itemView.setTag(type.getUrl().concat("&").concat(type.getName()));
        holder.txtTypes.setText(type.getName());
        Picasso.with(context).load("https://raw.githubusercontent.com/josemsb/pokedex/master/" + type.getName() + ".png"  )
                .error(R.drawable.type)
                .fit()
                .into(holder.imgType);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener=listener;

    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView txtTypes;
        public ImageView imgType;
        private Context vcontext;

        public ViewHolder(View v){
            super(v);
            vcontext = v.getContext();
            txtTypes =  v.findViewById(R.id.txtTypes);
            imgType =  v.findViewById(R.id.imgType);
        }

    }
}
