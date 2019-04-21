package com.example.toolbar;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;


    TabLayout tabLayout;

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("آموزش متریال دیزاین");

        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);

        configViewPager( viewPager );
        tabLayout.setupWithViewPager(viewPager);
        }

       private void configViewPager(ViewPager viewPager){
        ViewpagerAdapter adapter=new ViewpagerAdapter(getSupportFragmentManager());

           AdressFragment addFrg=new AdressFragment();
           PaternFragment patFrg=new PaternFragment();
           PremiseFragment preFrg=new PremiseFragment();


           adapter.addToList(addFrg,"تماس با ما" );
           adapter.addToList( patFrg,"درس ها");
           adapter.addToList(preFrg,"راهنما");

           viewPager.setAdapter( adapter );
       }


       class ViewpagerAdapter extends FragmentPagerAdapter {
        List<Fragment> myFragmentsList=new ArrayList<>(  );
        List<String> myPageTitlesList=new ArrayList<>(  );




           public ViewpagerAdapter(FragmentManager fm) {
               super( fm );
           }

           @Override
           public Fragment getItem(int position) {
               return myFragmentsList.get( position );
           }

           @Override
           public int getCount() {
               return myFragmentsList.size();
           }

           @Nullable
           @Override
           public CharSequence getPageTitle(int position) {
               return myPageTitlesList.get( position );
           }




           public void addToList(Fragment fragment,String title){

               myFragmentsList.add( fragment) ;
               myPageTitlesList.add( title );
           }
       }

}

