package com.example.mockito.sampleapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.util.KeyboardUtil;

import java.util.ArrayList;

/**
 * Created by power on 24.11.2015.
 */
public class NavigationDrawerManager implements Drawer.OnDrawerListener {

    private final AppCompatActivity activity;
    private AccountHeader headerResult;
    private Drawer drawer;
    private Drawer rightDrawer;

    public NavigationDrawerManager(AppCompatActivity activity) {
        this.activity = activity;
        buildNavigationDrawer();
    }

    public void buildNavigationDrawer() {
        this.drawer = buildDrawer();
        this.rightDrawer = buildRightDrawer();
    }

    private Drawer buildDrawer() {
        headerResult = createAccountHeader(getActivity(), R.drawable.header);
        return new DrawerBuilder()
                .withActivity(getActivity())
                .withAccountHeader(headerResult)
                .addDrawerItems(createDrawerItems())
                .withOnDrawerItemClickListener(new DrawerItemClickListener())
                .withOnDrawerListener(this).build();
    }

    private IDrawerItem[] createDrawerItems() {
        ArrayList<IDrawerItem> items = new ArrayList<>();
        return items.toArray(new IDrawerItem[0]);
    }

    private Drawer buildRightDrawer() {
        return new DrawerBuilder()
                .withActivity(getActivity())
                .withAccountHeader(createAccountHeader(getActivity(), R.drawable.newspaper_glasses))
                .withOnDrawerItemClickListener(new RightDrawerItemClickListener())
                .withDrawerWidthDp(250)
                .withDrawerGravity(Gravity.END)
                .append(drawer);
    }

    public static AccountHeader createAccountHeader(Activity activity, int headerBackgroundRes) {
        return new AccountHeaderBuilder()
                .withActivity(activity)
                .withCompactStyle(true)
                .withCloseDrawerOnProfileListClick(false)
                .withCurrentProfileHiddenInList(true)
                .withHeaderBackground(headerBackgroundRes)
                .withHeaderBackgroundScaleType(ImageView.ScaleType.CENTER_CROP)
                .build();
    }

    private AppCompatActivity getActivity() {
        return activity;
    }


    @Override
    public void onDrawerOpened(View view) {
        KeyboardUtil.hideKeyboard(getActivity());
    }

    @Override
    public void onDrawerClosed(View view) {

    }

    @Override
    public void onDrawerSlide(View view, float v) {

    }

    class DrawerItemClickListener implements Drawer.OnDrawerItemClickListener {

        @Override
        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            return false;
        }
    }

    class RightDrawerItemClickListener implements Drawer.OnDrawerItemClickListener {

        @Override
        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            return false;
        }
    }
}
