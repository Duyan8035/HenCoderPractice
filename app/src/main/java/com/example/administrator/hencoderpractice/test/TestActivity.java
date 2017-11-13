package com.example.administrator.hencoderpractice.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.hencoderpractice.R;
import com.example.administrator.hencoderpractice.base.BaseActivity;
import com.example.administrator.hencoderpractice.model.TestModel;
import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;
import com.robertlevonyan.views.chip.Chip;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends BaseActivity {

    private AutoFlowLayout flowLayout;

    private List<TestModel> lists = new ArrayList<>();
    private LayoutInflater myLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        myLayoutInflater = getLayoutInflater();

        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            lists.add(new TestModel("类型" + i, "详细数据", ""));
        }
    }

    private void initView() {
        flowLayout = findViewById(R.id.act_afl_test);

        flowLayout.setAdapter(new FlowAdapter(lists) {
            @Override
            public View getView(int i) {
                View view = getLayoutInflater().inflate(R.layout.item_test, null);
                Chip chip = view.findViewById(R.id.item_chip_test);
                chip.setChipText(lists.get(i).getName());
                return view;
            }
        });
    }
}
