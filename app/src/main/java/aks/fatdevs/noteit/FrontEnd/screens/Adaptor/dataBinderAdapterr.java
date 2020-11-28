package aks.fatdevs.noteit.FrontEnd.screens.Adaptor;

import android.graphics.ColorSpace;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

import aks.fatdevs.noteit.DataAndModels.Model;
import aks.fatdevs.noteit.R;

public class dataBinderAdapterr extends RecyclerView.Adapter<dataBinderAdapterr.Holder> {
    private ArrayList<Model> data;
    public dataBinderAdapterr(ArrayList<Model> data) {
     this.data = data;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
       Model model = this.data.get(position);
       holder.setAttributes(model.getNote_title(), String.valueOf(model.getTime()), model.getImage_uri());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder{
        private TextView Title;
        private TextView Time;
        private ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.title);
            Time = itemView.findViewById(R.id.time_list);
            imageView = itemView.findViewById(R.id.imageView);
        }
        public void setAttributes(String title, String time, @Nullable String ImageUrl) {
            if(ImageUrl == null){
                imageView.setVisibility(View.INVISIBLE);
            }
            imageView.setVisibility(View.VISIBLE);
            Title.setText(title);
            Time.setText(time);
            Uri uriImage = Uri.parse(ImageUrl);
            Picasso.get().load(uriImage).into(imageView);
        }
    }
}
