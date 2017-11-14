package com.example.administrator.hencoderpractice.practice.practicedraw7;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
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

public class PracticeDraw7Activity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

        {
        pageModels.add(new PageModel(R.layout.sample_argb_evaluator, R.string.title_argb_evaluator, R.layout.practice_argb_evaluator));
        pageModels.add(new PageModel(R.layout.sample_hsv_evaluator, R.string.title_hsv_evaluator, R.layout.practice_hsv_evaluator));
        pageModels.add(new PageModel(R.layout.sample_of_object, R.string.title_of_object, R.layout.practice_of_object));
        pageModels.add(new PageModel(R.layout.sample_property_values_holder, R.string.title_property_values_holder, R.layout.practice_property_values_holder));
        pageModels.add(new PageModel(R.layout.sample_animator_set, R.string.title_animator_set, R.layout.practice_animator_set));
        pageModels.add(new PageModel(R.layout.sample_keyframe, R.string.title_keyframe, R.layout.practice_keyframe));
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
