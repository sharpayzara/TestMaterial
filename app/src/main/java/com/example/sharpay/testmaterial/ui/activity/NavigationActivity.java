package com.example.sharpay.testmaterial.ui.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sharpay.testmaterial.R;
import com.example.sharpay.testmaterial.ui.adapter.NavigationAdapter;
import com.example.sharpay.testmaterial.ui.fragment.TextInputLayoutFragment;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NavigationActivity extends RxAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    NavigationAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);
        initView();
        initDrawer();
    }


    private void initDrawer() {
        if (navView != null) {
            navView.setNavigationItemSelectedListener(this);
            //navigationView.setItemIconTintList(null);
            View headerLayout = navView.inflateHeaderView(R.layout.nav_header_main);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
        }
    }

    private void initView() {
        setSupportActionBar(toolbar);
        adapter = new NavigationAdapter(getSupportFragmentManager());
        adapter.addTab(new TextInputLayoutFragment(),"输入框");
        adapter.addTab(new TextInputLayoutFragment(),"输入框2");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, false);
        fab.setOnClickListener(view ->
            Toast.makeText(this,"悬浮框被点击了",Toast.LENGTH_SHORT));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
