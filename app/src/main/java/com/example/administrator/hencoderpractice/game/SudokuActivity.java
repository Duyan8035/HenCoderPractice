package com.example.administrator.hencoderpractice.game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.example.administrator.hencoderpractice.R;

import java.util.ArrayList;
import java.util.List;

public class SudokuActivity extends AppCompatActivity {

    private SudokuActivity mContext = this;
    //    private NestedScrollView scrollView;
    private RecyclerView recyclerView;
    private BaseQuickAdapter<SudokuListModel, BaseViewHolder> baseQuickAdapter;
    private List<SudokuListModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        initView();
        initData();
    }

    private void initView() {
//        scrollView = findViewById(R.id.act_sv_sudoku_main);
        recyclerView = findViewById(R.id.act_rv_sudoku_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(layoutManager);

        baseQuickAdapter = new BaseQuickAdapter<SudokuListModel, BaseViewHolder>(R.layout.item_sudoku_main) {
            @Override
            protected void convert(BaseViewHolder helper, SudokuListModel item) {
                RecyclerView recyclerView = helper.getView(R.id.item_rv_sudoku_main);
                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
                layoutManager.setSmoothScrollbarEnabled(true);
                layoutManager.setAutoMeasureEnabled(true);

                recyclerView.setHasFixedSize(true);
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setLayoutManager(layoutManager);

                FinanceDetailsRightAdapter quickAdapter = new FinanceDetailsRightAdapter();
                recyclerView.setAdapter(quickAdapter);
                quickAdapter.setNewData(item.strings);
            }
        };
        recyclerView.setAdapter(baseQuickAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add(getList(8, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 0, 0, 0, 0, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 0, 0, 0, 0, 4, 0));
        mList.add(getList(5, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 0, 0, 0, 0, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 0, 0, 0, 0, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 0, 0, 0, 0, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 0, 0, 0, 0, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 0, 0, 0, 0, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 0, 0, 0, 0, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 0, 0, 0, 0, 4, 0));

        mList.add(getList(10, 10, 10, 10, 10, 10, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(10, 10, 10, 10, 10, 10, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(10, 10, 10, 10, 10, 10, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));

        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(1, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(8, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(0, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(7, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));
        mList.add(getList(3, 0, 0, 0, 0, 4, 0, 0, 9, 10, 10, 10, 1, 0, 7, 10, 10, 10, 10, 4, 0));

        baseQuickAdapter.addData(mList);
    }

    public SudokuListModel getList(int... ints) {
        SudokuListModel model = new SudokuListModel();
        List<SudokuListModel.bean> beans = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            beans.add(new SudokuListModel.bean().setValue(ints[i]));
        }
        model.strings = beans;
        return model;
    }

    class FinanceDetailsRightAdapter extends BaseQuickAdapter<SudokuListModel.bean, BaseViewHolder> {

        public FinanceDetailsRightAdapter() {
            super(null);
            setMultiTypeDelegate(new MultiTypeDelegate<SudokuListModel.bean>() {
                @Override
                protected int getItemType(SudokuListModel.bean titleBean) {
                    switch (titleBean.type) {
                        //不可修改数字区域
                        case 1:
                            return SudokuListModel.bean.NUM;
                        //填空区域
                        case 2:
                            return SudokuListModel.bean.ORIGINAL;
                        //空白区域
                        default:
                            return SudokuListModel.bean.EMETY;
                    }
                }
            });
            getMultiTypeDelegate()
                    .registerItemType(SudokuListModel.bean.EMETY, R.layout.item_tv_sudoku_empty)
                    .registerItemType(SudokuListModel.bean.ORIGINAL, R.layout.item_tv_sudoku_value)
                    .registerItemType(SudokuListModel.bean.NUM, R.layout.item_tv_sudoku_value);
        }

        @Override
        protected void convert(BaseViewHolder helper, SudokuListModel.bean item) {
            switch (helper.getItemViewType()) {
                //不可修改数字区域
                case SudokuListModel.bean.ORIGINAL:
                    helper.setText(R.id.item_tv_sudoku_value, (item.original == 0) ? "" : item.original + "");
                    break;
                //填空区域
                case SudokuListModel.bean.NUM:
                    helper.setText(R.id.item_tv_sudoku_value, (item.value == 0) ? "" : item.value + "")
                            .addOnClickListener(R.id.item_tv_sudoku_value);
                    break;
                //空白区域
                default:
                    helper.setText(R.id.item_tv_sudoku_empty, "");
                    break;
            }
        }
    }
}
