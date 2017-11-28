package com.mydo.demo.activity.tab;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.mydo.demo.R;
import com.mydo.demo.base.BaseActivity;
import com.mydo.demo.databinding.ActivityTabMainBinding;
import com.mydo.demo.fragment.HomeFragment;
import com.mydo.demo.fragment.MineFragment;
import com.mydo.demo.fragment.OrderFragment;
import com.mydo.demo.fragment.ShoppingFragment;
import com.mydo.demo.movie.MoviePresenter;

import java.lang.reflect.Field;

/**
 * @author: LiBing.
 * @date: 2017/11/28.
 * @version: V1.0.0.
 */

public class TabMainActivity extends BaseActivity<MoviePresenter, ActivityTabMainBinding> implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    public int getLayoutId() {
        return R.layout.activity_tab_main;
    }

    @Override
    public void initView() {
        disableShiftMode();
        mViewBinding.navigation.setOnNavigationItemSelectedListener(this);
        mViewBinding.navigation.setSelectedItemId(R.id.navigation_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.content,TabFragment.from(item.getItemId()).fragment())
                .commit();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TabFragment.onDestory();
    }

    private enum TabFragment {
        home(R.id.navigation_home, HomeFragment.class),
        shopping(R.id.navigation_shopping, ShoppingFragment.class),
        order(R.id.navigation_order, OrderFragment.class),
        mine(R.id.navigation_mine, MineFragment.class);

        private Fragment fragment;
        private final int menuId;
        private final Class<? extends Fragment> fragmentClass;

        TabFragment(@IdRes int menuId, Class<? extends Fragment> fragmentClass) {
            this.menuId = menuId;
            this.fragmentClass = fragmentClass;
        }

        public Fragment fragment() {
            if (fragment == null) {
                try {
                    fragment = fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    fragment = new Fragment();
                }
            }

            return fragment;
        }

        public static TabFragment from(int itemId) {
            for (TabFragment fragment : values()) {
                if (fragment.menuId == itemId) {
                    return fragment;
                }
            }
            return order;
        }

        public static void onDestory() {
            for (TabFragment fragment : values()) {
                fragment.fragment = null;
            }
        }
    }

    private void disableShiftMode() {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) mViewBinding.navigation.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
