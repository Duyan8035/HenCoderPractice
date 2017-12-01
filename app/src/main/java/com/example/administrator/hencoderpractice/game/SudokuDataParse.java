package com.example.administrator.hencoderpractice.game;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public class SudokuDataParse {
    public static String DEFAULT_1 = "" +
            "[[10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]" +
            ",[10,1,2,3,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,10,10,10,10,10,10,0,0,0,0,0,0,0,0,0,10,10,10,10,10,10,10]" +
            ",[10,10,10,10,10,10,10,0,0,0,0,0,0,0,0,0,10,10,10,10,10,10,10]" +
            ",[10,10,10,10,10,10,10,0,0,0,0,0,0,0,0,0,10,10,10,10,10,10,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,0,0,0,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,8,8,8,0,0,0,0,0,0,10,10,10,0,0,0,0,0,0,0,0,0,10]" +
            ",[10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]]";

    public static List<SudokuListModel> getList(String string) {
        List<SudokuListModel> listModels = new ArrayList<>();
        if (TextUtils.isEmpty(string)) {
            SPUtils.getInstance().put("default_1", "");

            return getList(DEFAULT_1);
        }
        SudokuData data = new Gson().fromJson("{\"data\":" + string + "}", SudokuData.class);
        if (data == null) {
            return listModels;
        }
        for (int i = 0; i < data.getData().size(); i++) {
            listModels.add(getData(data.getData().get(i)));
        }
        return listModels;
    }


    public static SudokuListModel getData(List<Integer> ints) {
        SudokuListModel model = new SudokuListModel();
        List<SudokuListModel.bean> beans = new ArrayList<>();
        for (int i = 0; i < ints.size(); i++) {
            beans.add(new SudokuListModel.bean().setValue(ints.get(i)));
        }
        model.strings = beans;
        return model;
    }

    public static String getString(SudokuListModel model) {
        StringBuffer string = new StringBuffer();
        if (null == model || model.strings = 0) {
            return;
        }
        for (int i = 0; i < model.strings.size(); i++) {
            if (i == model.strings.size() - 1) {
                string.append("[");
            } else if ()

                for (int j = 0; j <; j++) {

                }
            beans.add(new SudokuListModel.bean().setValue(ints.get(i)));
        }
        model.strings = beans;
        return model;
    }

    class SudokuData {
        private List<List<Integer>> data = new ArrayList<>();

        public List<List<Integer>> getData() {
            return data;
        }

        public void setData(List<List<Integer>> data) {
            this.data = data;
        }
    }
}
