package com.example.administrator.hencoderpractice.game;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.example.administrator.hencoderpractice.R;

import java.util.ArrayList;
import java.util.List;

public class SudokuActivity extends AppCompatActivity implements View.OnClickListener {

    private SudokuActivity mContext = this;
    //    private NestedScrollView scrollView;
    private RecyclerView recyclerView;
    private BaseQuickAdapter<SudokuListModel, BaseViewHolder> baseQuickAdapter;
    private List<SudokuListModel> mList = new ArrayList<>();

    private TextView tv01, tv02, tv03, tv04, tv05, tv06, tv07, tv08, tv09, tv00;

    /**
     * 是否已选中数字
     */
    private boolean ifSelect = false;
    /**
     * 是否已选中标记
     */
    private boolean ifHint = false;
    private int select = 0;
    private List<TextView> textViews = new ArrayList<>();

    private Resources resources;
    /**
     * 当前选中TextView
     */
//    private TextView tvSelect = null;
    private int select1 = -1, select2 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        resources = Utils.getApp().getResources();
        initView();
        initData();
    }

    private void initView() {
//        scrollView = findViewById(R.id.act_sv_sudoku_main);
        recyclerView = findViewById(R.id.act_rv_sudoku_main);
        tv00 = findViewById(R.id.act_tv_sudoku_num_0);
        tv01 = findViewById(R.id.act_tv_sudoku_num_1);
        tv02 = findViewById(R.id.act_tv_sudoku_num_2);
        tv03 = findViewById(R.id.act_tv_sudoku_num_3);
        tv04 = findViewById(R.id.act_tv_sudoku_num_4);
        tv05 = findViewById(R.id.act_tv_sudoku_num_5);
        tv06 = findViewById(R.id.act_tv_sudoku_num_6);
        tv07 = findViewById(R.id.act_tv_sudoku_num_7);
        tv08 = findViewById(R.id.act_tv_sudoku_num_8);
        tv09 = findViewById(R.id.act_tv_sudoku_num_9);
        tv00.setOnClickListener(this);
        tv01.setOnClickListener(this);
        tv02.setOnClickListener(this);
        tv03.setOnClickListener(this);
        tv04.setOnClickListener(this);
        tv05.setOnClickListener(this);
        tv06.setOnClickListener(this);
        tv07.setOnClickListener(this);
        tv08.setOnClickListener(this);
        tv09.setOnClickListener(this);
        textViews.add(tv00);
        textViews.add(tv01);
        textViews.add(tv02);
        textViews.add(tv03);
        textViews.add(tv04);
        textViews.add(tv05);
        textViews.add(tv06);
        textViews.add(tv07);
        textViews.add(tv08);
        textViews.add(tv09);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(layoutManager);

        baseQuickAdapter = new BaseQuickAdapter<SudokuListModel, BaseViewHolder>(R.layout.item_sudoku_main) {
            @Override
            protected void convert(final BaseViewHolder helper, SudokuListModel item) {
                RecyclerView recyclerView = helper.getView(R.id.item_rv_sudoku_main);
                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
                layoutManager.setSmoothScrollbarEnabled(true);
                layoutManager.setAutoMeasureEnabled(true);

                recyclerView.setHasFixedSize(true);
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setLayoutManager(layoutManager);

                FinanceDetailsRightAdapter quickAdapter = new FinanceDetailsRightAdapter();
                quickAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        try {
                            //目前只有一个地方有点击事件
                            if (view.getId() != R.id.item_tv_sudoku_value) {
                                return;
                            }
                            //只有非预设区域才可点击
                            switch (mList.get(helper.getAdapterPosition()).strings.get(position).type) {
                                case 2:
                                    LogUtils.e("点击了一次");
                                    //已选中数字
                                    if (ifSelect) {
                                        mList.get(helper.getAdapterPosition()).strings.get(position).ifSelect = false;
                                        select1 = -1;
                                        select2 = -1;
                                        //选中的数字与当前数字一致，则取消显示的数字
                                        if (mList.get(helper.getAdapterPosition()).strings.get(position).value == select) {
                                            mList.get(helper.getAdapterPosition()).strings.get(position).value = 0;
                                        } else {
                                            mList.get(helper.getAdapterPosition()).strings.get(position).value = select;
                                        }
                                    } else {
                                        //------------------视图修改
                                        if (select1 >= 0 && select2 >= 0) {
                                            //若之前已选择当前方格，则取消当前方格
                                            if (select1 == helper.getAdapterPosition() && select2 == position) {
                                                mList.get(helper.getAdapterPosition()).strings.get(position).ifSelect = false;
                                                select1 = -1;
                                                select2 = -1;
                                            } else {
                                                //若之前已选择某个方格，则将此方格设置为选中方格，并修改背景颜色及之前选中方格颜色
                                                mList.get(select1).strings.get(select2).ifSelect = false;
                                                select1 = helper.getAdapterPosition();
                                                select2 = position;
                                                mList.get(helper.getAdapterPosition()).strings.get(position).ifSelect = true;
                                            }
                                        } else {
                                            //若之前未选择某个方格，则将此方格设置为选中方格，并修改背景颜色
                                            LogUtils.e("选中的为空");
                                            mList.get(helper.getAdapterPosition()).strings.get(position).ifSelect = true;
                                            select1 = helper.getAdapterPosition();
                                            select2 = position;
                                        }
                                    }
                                    baseQuickAdapter.notifyItemChanged(helper.getAdapterPosition());
                                    break;
                                default:
                                    break;
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                recyclerView.setAdapter(quickAdapter);
                quickAdapter.setNewData(item.strings);
            }
        };

        recyclerView.setAdapter(baseQuickAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();
        mList = SudokuDataParse.getList("");
        baseQuickAdapter.addData(mList);
    }

    private void setValue(int select) {
        if (select1 >= 0 && select2 >= 0) {
            if (select1 < mList.size() && select2 < mList.get(select1).strings.size()) {
                if (mList.get(select1).strings.get(select2).value == select) {
                    mList.get(select1).strings.get(select2).value = 0;
                } else {
                    mList.get(select1).strings.get(select2).value = select;
                }
                baseQuickAdapter.notifyItemChanged(select1);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_tv_sudoku_num_0:
                ifHint = !ifHint;
                ToastUtils.showLong("暂时没做");
                break;
            case R.id.act_tv_sudoku_num_1:
                //若已选中
                if (ifSelect) {
                    //若重复选中当前
                    if (select == 1) {
                        ifSelect = false;
                        select = 0;
                        tv01.setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                    } else {
                        //若之前选中的是别的数字
                        textViews.get(select).setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                        select = 1;
                        tv01.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                    }
                } else {
                    //若未选中
                    ifSelect = true;
                    select = 1;
                    tv01.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                }
                setValue(1);
                break;
            case R.id.act_tv_sudoku_num_2:
                if (ifSelect) {
                    if (select == 2) {
                        ifSelect = false;
                        select = 0;
                        tv02.setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                    } else {
                        textViews.get(select).setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                        select = 2;
                        tv02.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                    }
                } else {
                    ifSelect = true;
                    select = 2;
                    tv02.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                }
                setValue(2);
                break;
            case R.id.act_tv_sudoku_num_3:
                if (ifSelect) {
                    if (select == 3) {
                        ifSelect = false;
                        select = 0;
                        tv03.setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                    } else {
                        textViews.get(select).setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                        select = 3;
                        tv03.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                    }
                } else {
                    ifSelect = true;
                    select = 3;
                    tv03.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                }
                setValue(3);
                break;
            case R.id.act_tv_sudoku_num_4:
                if (ifSelect) {
                    if (select == 4) {
                        ifSelect = false;
                        select = 0;
                        tv04.setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                    } else {
                        textViews.get(select).setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                        select = 4;
                        tv04.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                    }
                } else {
                    ifSelect = true;
                    select = 4;
                    tv04.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                }
                setValue(4);
                break;
            case R.id.act_tv_sudoku_num_5:
                if (ifSelect) {
                    if (select == 5) {
                        ifSelect = false;
                        select = 0;
                        tv05.setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                    } else {
                        textViews.get(select).setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                        select = 5;
                        tv05.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                    }
                } else {
                    ifSelect = true;
                    select = 5;
                    tv05.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                }
                setValue(5);
                break;
            case R.id.act_tv_sudoku_num_6:
                if (ifSelect) {
                    if (select == 6) {
                        ifSelect = false;
                        select = 0;
                        tv06.setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                    } else {
                        textViews.get(select).setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                        select = 6;
                        tv06.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                    }
                } else {
                    ifSelect = true;
                    select = 6;
                    tv06.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                }
                setValue(6);
                break;
            case R.id.act_tv_sudoku_num_7:
                if (ifSelect) {
                    if (select == 7) {
                        ifSelect = false;
                        select = 0;
                        tv07.setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                    } else {
                        textViews.get(select).setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                        select = 7;
                        tv07.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                    }
                } else {
                    ifSelect = true;
                    select = 7;
                    tv07.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                }
                setValue(7);
                break;
            case R.id.act_tv_sudoku_num_8:
                if (ifSelect) {
                    if (select == 8) {
                        ifSelect = false;
                        select = 0;
                        tv08.setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                    } else {
                        textViews.get(select).setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                        select = 8;
                        tv08.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                    }
                } else {
                    ifSelect = true;
                    select = 8;
                    tv08.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                }
                setValue(8);
                break;
            case R.id.act_tv_sudoku_num_9:
                if (ifSelect) {
                    if (select == 9) {
                        ifSelect = false;
                        select = 0;
                        tv09.setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                    } else {
                        textViews.get(select).setBackgroundColor(resources.getColor(R.color.default_tv_unselect));
                        select = 9;
                        tv09.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                    }
                } else {
                    ifSelect = true;
                    select = 9;
                    tv09.setBackgroundColor(resources.getColor(R.color.default_tv_select));
                }
                setValue(9);
                break;
            default:
                break;
        }
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
                            return SudokuListModel.bean.ORIGINAL;
                        //填空区域
                        case 2:
                            return SudokuListModel.bean.NUM;
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
                            .setBackgroundRes(R.id.item_tv_sudoku_value, item.ifSelect ? R.drawable.shape_tv_sudoku_num_select : R.drawable.shape_tv_sudoku_num)
                            .addOnClickListener(R.id.item_tv_sudoku_value);
                    break;
                //空白区域
                default:
//                    helper.setText(R.id.item_tv_sudoku_empty, "");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SPUtils.getInstance().put("default_1_change",SudokuDataParse.getString);
    }
}
