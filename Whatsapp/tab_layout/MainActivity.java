package com.example.akhildixit.tab_layout;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TabLayout tabLayout;
    public ViewPager viewPager;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    Toolbar mToolbar;
    Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager =(ViewPager) findViewById(R.id.viewPager);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("WhatsApp");


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);




        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();

}

    private void setupTabIcons() {
        tabLayout.getTabAt(3).setIcon(R.drawable.camerae);

    }


public void setupViewPager(ViewPager viewPager)
{
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());



    adapter.addFragment(new Users(),"CHATS");//will add tabs on tablayout
    adapter.addFragment(new status(),"STATUS");
    adapter.addFragment(new Calls(),"CALLS");
    adapter.addFragment(new camera(),"");


    viewPager.setAdapter(adapter);
}
    class ViewPagerAdapter extends FragmentPagerAdapter {//FragmentPagerAdapter is Predefined class

        ArrayList arrayList = new ArrayList();

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return fragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return fragmentTitleList.size();
        }

        public void addFragment(Fragment fragment, String  title)
        {
            fragmentList.add(fragment);     //data and view
            fragmentTitleList.add(title);   //title
        }

        @Override
        public CharSequence getPageTitle(int position){
            //return null; //--> if we don't want to show a title on tablayout
            return fragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(this,Settings.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_newbroadcast) {
            return true;
        }
        else if (id == R.id.action_newgroup) {
            return true;
        }
        else if (id == R.id.action_Starredmessages) {
            return true;
        }
        else if (id == R.id.action_whatsappweb) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void hideOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(false);
    }

    private void showOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(true);
    }
}





