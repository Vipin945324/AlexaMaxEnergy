package digi.coders.alexamaxenergy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class RecyclerGalleryAdapter extends RecyclerView.Adapter<RecyclerGalleryAdapter.myViewHolder> {

    private List<GalleryModule> galleryModuleList;
    private Context context;

    public RecyclerGalleryAdapter(List<GalleryModule> galleryModuleList, Context context) {
        this.galleryModuleList = galleryModuleList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        GalleryModule galleryModule=galleryModuleList.get(position);
        holder.img.setImageResource(galleryModule.getImage());

        holder.imgFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(context,GalleryFullViewActivity.class);
                a.putExtra("img",galleryModule.getImage());
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(a);
            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryModuleList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private MaterialCardView imgFull;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.galleryImg1);
            imgFull=itemView.findViewById(R.id.imgFull);
        }
    }
}
