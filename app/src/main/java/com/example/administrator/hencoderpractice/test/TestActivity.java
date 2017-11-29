package com.example.administrator.hencoderpractice.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.example.administrator.hencoderpractice.R;
import com.example.administrator.hencoderpractice.base.BaseActivity;
import com.example.administrator.hencoderpractice.model.TestModel;
import com.example.library.AutoFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends BaseActivity {

    private AutoFlowLayout flowLayout;

    private List<TestModel> lists = new ArrayList<>();
    private LayoutInflater myLayoutInflater;

    private TextView tv_01, tv_02, tv_03;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        myLayoutInflater = getLayoutInflater();

        initView();
        initData();
    }

    private void initData() {
        int k = 0;
        String str = "";
        for (int i = 1000; i < 2000; i++) {
            for (int j = 10; j < 20; j++) {
                k = i * j;
                if (k > 10000 && k < 99999) {
                    if (i / 1000 == j / 10 && j / 10 == k / 10000) {
                        if (i % 1000 / 100 == j % 10) {
                            ArrayList<Integer> integers = new ArrayList<>();
                            integers.add(i / 1000);
                            integers.add(j % 10);
                            integers.add(i % 100 / 10);
                            integers.add(i % 10);
                            integers.add(k % 10000 / 1000);
                            integers.add(k % 1000 / 100);
                            integers.add(k % 100 / 10);
                            integers.add(k % 10);
                            boolean isRepeat = false;
                            for (int l = 0; l < integers.size(); l++) {
                                for (int m = l + 1; m < integers.size(); m++) {
                                    count++;
                                    if (integers.get(l).equals(integers.get(m))) {
                                        isRepeat = true;
                                        continue;
                                    }
                                }
                            }
                            if (!isRepeat) {
                                String num = "";
                                for (int l = 0; l < integers.size(); l++) {
                                    num += integers.get(l) + " ";
                                }
                                LogUtils.e("不相同：list:" + num);
                                str += "   " + i + "\nx      " + j + "\n----------\n" + k + "\n\n\n";
                            }
                        }
                    }
                }
            }
        }
        tv_02.setText("共运算：" + count);
        tv_03.setText(str);

//        for (int i = 0; i < 20; i++) {
//            lists.add(new TestModel("类型" + i, "详细数据", ""));
//        }
    }

    private void initView() {
//        flowLayout = findViewById(R.id.act_afl_test);
//
//        flowLayout.setAdapter(new FlowAdapter(lists) {
//            @Override
//            public View getView(int i) {
//                View view = getLayoutInflater().inflate(R.layout.item_test, null);
//                Chip chip = view.findViewById(R.id.item_chip_test);
//                chip.setChipText(lists.get(i).getName());
//                return view;
//            }
//        });
        tv_01 = findViewById(R.id.act_tv_test_01);
        tv_02 = findViewById(R.id.act_tv_test_02);
        tv_03 = findViewById(R.id.act_tv_test_03);
    }
}
