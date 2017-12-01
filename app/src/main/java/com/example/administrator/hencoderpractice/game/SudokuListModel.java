package com.example.administrator.hencoderpractice.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */

public class SudokuListModel {
    List<bean> strings = new ArrayList<>();

    public static class bean {
        static final int EMETY = 0;
        static final int ORIGINAL = 1;
        static final int NUM = 2;
        int original = 0;
        int value = 0;
        String label = "";
        boolean ifSelect = false;
        /**
         * 0表示无方格区域 1表示原始已存在数字方格 2表示可填入数字区域
         */
        int type = 0;

        public bean() {
        }

        public bean setValue(int original) {
            if (original == 10) {
                this.type = 0;
                this.value = 10;
                this.original = 10;
            } else if (original == 0) {
                this.type = 2;
                this.value = 0;
                this.original = 0;
            } else {
                this.type = 1;
                this.value = original;
                this.original = original;
            }
            return this;
        }
    }

    public SudokuListModel() {
    }

    public SudokuListModel(List<bean> strings) {
        this.strings = strings;
    }

}
