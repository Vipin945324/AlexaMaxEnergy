package digi.coders.alexamaxenergy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    Button viewAllProd;
    TextView digiLink;
    private ViewPager2 viewPager2;
    private Handler sliderHandler=new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        viewPager2=view.findViewById(R.id.slideImage);
        viewAllProd=view.findViewById(R.id.viewAllProd);
        digiLink=view.findViewById(R.id.digiLink);

        digiLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web=new Intent(Intent.ACTION_VIEW, Uri.parse("https://digicoders.in/"));
                startActivity(web);
            }
        });

        viewAllProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.fragmentContainer1,new ProductsFragment()).commit();
            }
        });





        List<SliderModule> sliderModuleList=new ArrayList<>();

        sliderModuleList.add(new SliderModule(R.drawable.slider1));
        sliderModuleList.add(new SliderModule(R.drawable.slider2));
        sliderModuleList.add(new SliderModule(R.drawable.slider3));
        sliderModuleList.add(new SliderModule(R.drawable.slider4));
        sliderModuleList.add(new SliderModule(R.drawable.slider5));
        sliderModuleList.add(new SliderModule(R.drawable.slider6));
        sliderModuleList.add(new SliderModule(R.drawable.slider7));

        viewPager2.setAdapter(new SliderAdapter(sliderModuleList,viewPager2) );

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(0));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);
            }
        });




        return view;
    }
    Runnable sliderRunnable=new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };
}