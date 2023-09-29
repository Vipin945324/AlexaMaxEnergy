package digi.coders.alexamaxenergy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView recyclerGallery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);

        recyclerGallery=view.findViewById(R.id.recyclerGallery);

        List<GalleryModule> galleryModuleList=new ArrayList<>();

        galleryModuleList.add(new GalleryModule(R.drawable.glry1));
        galleryModuleList.add(new GalleryModule(R.drawable.glry2));
        galleryModuleList.add(new GalleryModule(R.drawable.glry3));
        galleryModuleList.add(new GalleryModule(R.drawable.glry4));
        galleryModuleList.add(new GalleryModule(R.drawable.glry5));
        galleryModuleList.add(new GalleryModule(R.drawable.glry6));
        galleryModuleList.add(new GalleryModule(R.drawable.glry7));
        galleryModuleList.add(new GalleryModule(R.drawable.glry8));

        recyclerGallery.setLayoutManager(new GridLayoutManager(getContext(),2));
        RecyclerGalleryAdapter adapter=new RecyclerGalleryAdapter(galleryModuleList,getContext());
        recyclerGallery.setAdapter(adapter);

        return view;
    }
}