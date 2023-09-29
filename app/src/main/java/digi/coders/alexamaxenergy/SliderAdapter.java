package digi.coders.alexamaxenergy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{

    private List<SliderModule> sliderModules;
    private ViewPager2 viewPager2;

    SliderAdapter(List<SliderModule> sliderModules, ViewPager2 viewPager2) {
        this.sliderModules = sliderModules;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_item_container,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {

        holder.setImage(sliderModules.get(position));

        if(position==sliderModules.size()-2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliderModules.size();
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageSlide);
        }
        void setImage(SliderModule  sliderModule)
        {
            imageView.setImageResource(sliderModule.getImage());
        }
    }
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            sliderModules.addAll(sliderModules);
            notifyDataSetChanged();
        }
    };
}
