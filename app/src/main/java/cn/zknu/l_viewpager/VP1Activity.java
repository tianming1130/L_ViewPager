package cn.zknu.l_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.zknu.l_viewpager.fragment.FavoritesFragment;
import cn.zknu.l_viewpager.fragment.LinkFragment;
import cn.zknu.l_viewpager.fragment.MeFragment;
import cn.zknu.l_viewpager.fragment.NewListFragment;

public class VP1Activity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private ImageView mNewsList, mLink, mFavorites, mMe;
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp1);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mNewsList = (ImageView) findViewById(R.id.img_list);
        mLink = (ImageView) findViewById(R.id.img_link);
        mFavorites = (ImageView) findViewById(R.id.img_favorites);
        mMe = (ImageView) findViewById(R.id.img_me);

        mNewsList.setOnClickListener(this);
        mLink.setOnClickListener(this);
        mFavorites.setOnClickListener(this);
        mMe.setOnClickListener(this);

        addFragment();

        setDefaultFragment();
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                resetImageSelected();
                switch (position){
                    case 0:
                        mNewsList.setSelected(true);
                        break;
                    case 1:
                        mLink.setSelected(true);
                        break;
                    case 2:
                        mFavorites.setSelected(true);
                        break;
                    case 3:
                        mMe.setSelected(true);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setDefaultFragment() {
        mViewPager.setCurrentItem(0);
        mNewsList.setSelected(true);
    }

    private void addFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new NewListFragment());
        mFragmentList.add(new LinkFragment());
        mFragmentList.add(new FavoritesFragment());
        mFragmentList.add(new MeFragment());
    }

    @Override
    public void onClick(View v) {
        resetImageSelected();
        switch (v.getId()) {
            case R.id.img_list:
                mNewsList.setSelected(true);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.img_link:
                mLink.setSelected(true);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.img_favorites:
                mFavorites.setSelected(true);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.img_me:
                mMe.setSelected(true);
                mViewPager.setCurrentItem(3);
                break;
        }
    }

    private void resetImageSelected() {
        mNewsList.setSelected(false);
        mLink.setSelected(false);
        mFavorites.setSelected(false);
        mMe.setSelected(false);
    }
}
