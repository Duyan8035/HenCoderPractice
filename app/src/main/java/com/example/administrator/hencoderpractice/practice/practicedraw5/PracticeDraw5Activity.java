package com.example.administrator.hencoderpractice.practice.practicedraw5;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.example.administrator.hencoderpractice.R;
import com.example.administrator.hencoderpractice.base.BaseActivity;
import com.example.administrator.hencoderpractice.practice.practicedraw1.PageDraw1Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2017/11/7
 */

public class PracticeDraw5Activity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.sample_after_on_draw, R.string.title_after_on_draw, R.layout.practice_after_on_draw));
        pageModels.add(new PageModel(R.layout.sample_before_on_draw, R.string.title_before_on_draw, R.layout.practice_before_on_draw));
        pageModels.add(new PageModel(R.layout.sample_on_draw_layout, R.string.title_on_draw_layout, R.layout.practice_on_draw_layout));
        pageModels.add(new PageModel(R.layout.sample_dispatch_draw, R.string.title_dispatch_draw, R.layout.practice_dispatch_draw));
        pageModels.add(new PageModel(R.layout.sample_after_on_draw_foreground, R.string.title_after_on_draw_foreground, R.layout.practice_after_on_draw_foreground));
        pageModels.add(new PageModel(R.layout.sample_before_on_draw_foreground, R.string.title_before_on_draw_foreground, R.layout.practice_before_on_draw_foreground));
        pageModels.add(new PageModel(R.layout.sample_after_draw, R.string.title_after_draw, R.layout.practice_after_draw));
        pageModels.add(new PageModel(R.layout.sample_before_draw, R.string.title_before_draw, R.layout.practice_before_draw));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_draw_1_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageDraw1Fragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private class PageModel {
        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
