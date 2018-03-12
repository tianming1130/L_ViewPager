package cn.zknu.l_viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.zknu.l_viewpager.fragment.FavoritesFragment;
import cn.zknu.l_viewpager.fragment.LinkFragment;
import cn.zknu.l_viewpager.fragment.MeFragment;
import cn.zknu.l_viewpager.fragment.NewListFragment;

public class VP2Activity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerTabStrip mPagerTabStrip;
    private List<String> titles;// 标题
    private List<Fragment> fragments;// 页面
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp2);
        mViewPager=(ViewPager)findViewById(R.id.view_pager);

        mPagerTabStrip=(PagerTabStrip)findViewById(R.id.pager_tab_strip);

        mPagerTabStrip.setBackgroundColor(Color.RED);// 背景颜色
        mPagerTabStrip.setTextColor(Color.WHITE);// 标题颜色，这里需要带透明度的颜色值
        mPagerTabStrip.setTabIndicatorColor(Color.YELLOW);// 指示器颜色，这里需要带透明度的颜色值
        mPagerTabStrip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);// 字体大小

        initData();
    }

    private void initData() {
        titles = new ArrayList<String>(Arrays.asList("新闻列表", "关注", "收藏", "我"));

        fragments = new ArrayList<Fragment>();
        fragments.add(new NewListFragment());
        fragments.add(new LinkFragment());
        fragments.add(new FavoritesFragment());
        fragments.add(new MeFragment());

        adapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
