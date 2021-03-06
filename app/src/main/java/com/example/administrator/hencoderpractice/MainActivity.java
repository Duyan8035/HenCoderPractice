package com.example.administrator.hencoderpractice;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.hencoderpractice.base.BaseActivity;
import com.example.administrator.hencoderpractice.game.SudokuActivity;
import com.example.administrator.hencoderpractice.practice.practicedlayout1.PracticeLayout1Activity;
import com.example.administrator.hencoderpractice.practice.practicedraw1.PracticeDraw1Activity;
import com.example.administrator.hencoderpractice.practice.practicedraw2.PracticeDraw2Activity;
import com.example.administrator.hencoderpractice.practice.practicedraw3.PracticeDraw3Activity;
import com.example.administrator.hencoderpractice.practice.practicedraw4.PracticeDraw4Activity;
import com.example.administrator.hencoderpractice.practice.practicedraw5.PracticeDraw5Activity;
import com.example.administrator.hencoderpractice.practice.practicedraw6.PracticeDraw6Activity;
import com.example.administrator.hencoderpractice.practice.practicedraw7.PracticeDraw7Activity;
import com.example.administrator.hencoderpractice.test.TestActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity {

    private MainActivity mContext = this;
    private RecyclerView recyclerView;
    private BaseQuickAdapter<Items, BaseViewHolder> adapter;
    private List<Items> items = new ArrayList<>();

    private enum Items {
        TEST(TestActivity.class, "测试增删改", R.mipmap.ic_launcher),
        DRAW1(PracticeDraw1Activity.class, "Draw1", R.drawable.icon_practice_draw_1),
        DRAW2(PracticeDraw2Activity.class, "Draw2", R.drawable.icon_practice_draw_2),
        DRAW3(PracticeDraw3Activity.class, "Draw3", R.drawable.icon_practice_draw_3),
        DRAW4(PracticeDraw4Activity.class, "Draw4", R.drawable.icon_practice_draw_4),
        DRAW5(PracticeDraw5Activity.class, "Draw5", R.drawable.icon_practice_draw_5),
        DRAW6(PracticeDraw6Activity.class, "Draw6", R.drawable.icon_practice_draw_6),
        DRAW7(PracticeDraw7Activity.class, "Draw7", R.drawable.icon_practice_draw_7),
        LAYOUT1(PracticeLayout1Activity.class, "Layout1", R.drawable.icon_practice_layout_1),
        SODOKU(SudokuActivity.class, "Sudoku", R.drawable.icon_practice_layout_1);
        Class activity;
        String name;
        int imgUrl;

        Items(Class activity, String name, int imgUrl) {
            this.activity = activity;
            this.name = name;
            this.imgUrl = imgUrl;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        recyclerView = findViewById(R.id.act_rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));

        adapter = new BaseQuickAdapter<Items, BaseViewHolder>(R.layout.item_rv_main) {
            @Override
            protected void convert(BaseViewHolder helper, Items item) {
                helper.setText(R.id.item_tv_main_title, item.name)
                        .setImageResource(R.id.item_img_main_bg, item.imgUrl);
            }
        };

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivity(items.get(position).activity);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        items = new ArrayList<>();
        for (int i = 0; i < Items.values().length; i++) {
            items.add(Items.values()[i]);
        }
        adapter.setNewData(items);
    }
}
