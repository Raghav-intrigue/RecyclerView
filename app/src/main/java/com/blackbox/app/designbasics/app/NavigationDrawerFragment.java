package com.blackbox.app.designbasics.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.adapters.navBarAdapter;
import com.blackbox.app.designbasics.model.nav_item;

public class NavigationDrawerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.nav_drawer,container,false);

        setUpRecycler(view);

        return view;
    }

    private void setUpRecycler(View view) {

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.drawerList);
        navBarAdapter adapter = new navBarAdapter(getActivity(), nav_item.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    public void setUpDrawer(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar)
    {

        //mDrawerLayout = drawerLayout;

        /**
         *
         * Defining what to do on drawer opening and closing
         *
         */


        final ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                // Do something of Slide of Drawer
            }
        };

        drawerLayout.addDrawerListener(drawerToggle);


        //controlling that icon to open drawer
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });


    }


}
