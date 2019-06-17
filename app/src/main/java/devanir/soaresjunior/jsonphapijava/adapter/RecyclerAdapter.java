package devanir.soaresjunior.jsonphapijava.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import devanir.soaresjunior.jsonphapijava.R;
import devanir.soaresjunior.jsonphapijava.model.AlbumResult;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AlbumViewHolder> {
    public List<AlbumResult> albums;
    public Context context;


    public RecyclerAdapter(List<AlbumResult> albumResult, Context context){
               this.albums = albumResult;
               this.context = context;
     }


    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false);


        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder viewHolder, int position) {

        viewHolder.tvTitle.setText(albums.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return albums.size();
    }



    public class AlbumViewHolder extends RecyclerView.ViewHolder{

            TextView tvTitle;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

}
