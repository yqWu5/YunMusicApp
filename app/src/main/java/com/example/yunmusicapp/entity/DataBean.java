package com.example.yunmusicapp.entity;

import java.util.ArrayList;
import java.util.List;
public class DataBean {
        public Integer imageRes;
        public String imageUrl;
        public String title;
        public int viewType;

        public DataBean(Integer imageRes, String title, int viewType) {
            this.imageRes = imageRes;
            this.title = title;
            this.viewType = viewType;
        }

        public DataBean(String imageUrl, String title, int viewType) {
            this.imageUrl = imageUrl;
            this.title = title;
            this.viewType = viewType;
        }

        public static List<DataBean> getTestData3() {
            List<DataBean> list = new ArrayList<>();
            list.add(new DataBean("", null, 1));
            list.add(new DataBean("", null, 1));
            list.add(new DataBean("", null, 1));
            list.add(new DataBean("", null, 1));
            list.add(new DataBean("", null, 1));
            list.add(new DataBean("", null, 1));
            list.add(new DataBean("", null, 1));
            list.add(new DataBean("", null, 1));
            list.add(new DataBean("", null, 1));
            return list;
        }
}

