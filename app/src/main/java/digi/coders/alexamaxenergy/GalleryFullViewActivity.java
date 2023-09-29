package digi.coders.alexamaxenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

public class GalleryFullViewActivity extends AppCompatActivity {

    ZoomageView myZoomageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_full_view);

        int img=getIntent().getIntExtra("img",0);

        myZoomageView=findViewById(R.id.myZoomageView);


        Picasso.get().load(img).into(myZoomageView);

    }
}