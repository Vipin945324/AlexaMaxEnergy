package digi.coders.alexamaxenergy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ImageView menuIcon;
    NavigationView navigationView1;
    DrawerLayout drawerLayout1;
    private BottomNavigationView bottomNavigation1;
    private FragmentContainerView fragmentContainer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation1=findViewById(R.id.bottomNavigation1);
        fragmentContainer1=findViewById(R.id.fragmentContainer1);
        menuIcon=findViewById(R.id.menuIcon);
        navigationView1=findViewById(R.id.navigationView1);
        drawerLayout1=findViewById(R.id.drawerLayout1);

        FragmentManager fm=getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragmentContainer1,new HomeFragment()).commit();

        //bottom menu click
        bottomNavigation1.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.bottom_menu1:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new HomeFragment()).commit();
                        drawerLayout1.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.bottom_menu2:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new AboutFragment()).commit();
                        break;
                    case R.id.bottom_menu3:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new ProductsFragment()).commit();
                        break;
                    case R.id.bottom_menu4:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new GalleryFragment()).commit();
                        break;
                    case R.id.bottom_menu5:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new ContactFragment()).commit();
                        break;

                }

                return true;
            }
        });

        //open Drawer
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout1.openDrawer(GravityCompat.START);
            }
        });

        //Drawer menu click
        navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout1.closeDrawer(GravityCompat.START);
                switch (item.getItemId())
                {
                    case R.id.bottom_menu1:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new HomeFragment()).commit();
                        break;
                    case R.id.bottom_menu2:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new AboutFragment()).commit();
                        break;
                    case R.id.bottom_menu3:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new ProductsFragment()).commit();
                        break;
                    case R.id.bottom_menu4:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new GalleryFragment()).commit();
                        break;
                    case R.id.bottom_menu5:
                        fm.beginTransaction().replace(R.id.fragmentContainer1,new ContactFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }
}