package digi.coders.alexamaxenergy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

import jahirfiquitiva.libs.fabsmenu.FABsMenu;
import jahirfiquitiva.libs.fabsmenu.FABsMenuListener;
import jahirfiquitiva.libs.fabsmenu.TitleFAB;


public class ContactFragment extends Fragment {

    private FABsMenu  fabs_menu;
    private TitleFAB whatsapp,email,call,custumerCare;
    private MaterialCardView mapOpen;
    private LinearLayout llWeb;
    TextView custumerCareC,callC1,callC2,callC3,emailC;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contact, container, false);


        fabs_menu=view.findViewById(R.id.fabs_menu);
        whatsapp=view.findViewById(R.id.whatsapp);
        email=view.findViewById(R.id.email);
        call=view.findViewById(R.id.call);
        custumerCare=view.findViewById(R.id.custumerCare);
        mapOpen=view.findViewById(R.id.mapOpen);
        llWeb=view.findViewById(R.id.llWeb);
        custumerCareC=view.findViewById(R.id.custumerCareC);
        callC1=view.findViewById(R.id.callC1);
        callC2=view.findViewById(R.id.callC2);
        callC3=view.findViewById(R.id.callC3);
        emailC=view.findViewById(R.id.emailC);

        emailC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailText("alexamaxplus@gmail.com");
            }
        });

        callC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { callNumber("9795187907");
            }
        });

        callC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNumber("7991478736");
            }
        });

        callC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNumber("7459048736");
            }
        });

        custumerCareC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNumber("05224101831");
            }
        });


        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number="919140967607";
                String message="Hello";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("https:api.whatsapp.com/send?phone=%s&text=%s",number,message))));
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailText("alexamaxplus@gmail.com");
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNumber("917459048736");
            }
        });

        custumerCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNumber("05224101831");
            }
        });
        mapOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location =Uri.parse("https://www.google.com/maps/dir/26.8467998,80.9318324/S+298+Shahara+shopping+centre+lekhraj,+Indira+nagar+faizabad+road+lucknow.+226016/@26.8712031,80.9714212,17.29z/data=!4m9!4m8!1m1!4e1!1m5!1m1!1s0x399bfd44e6eecde3:0x57ed5b24865b7e2c!2m2!1d80.9726486!2d26.8710995");
                Intent map=new Intent(Intent.ACTION_VIEW,location);
                startActivity(map);
            }
        });

        llWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web=new Intent(Intent.ACTION_VIEW,Uri.parse("http://alexamaxenergy.com/"));
                startActivity(web);
            }
        });

        return view;
    }

    void callNumber(String s)
    {
        String phone = s;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }
    void  emailText(String e)
    {
        String email = e;
        String subject = "Subject";
        String body ="I'm email body.";
        String chooserTitle =  "Your chooser title here ";
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);//If you are using HTML in your body text
        startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
    }
}