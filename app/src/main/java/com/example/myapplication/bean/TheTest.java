package com.example.myapplication.bean;

import java.io.Serializable;
import java.util.List;

public class TheTest implements Serializable {


    /**
     * msg : 0
     * code : 0
     * data : [{"uid":"402880f46eedab73016eeef4beb60005","theName":"Android基础考试","theStartTime":"2019-12-10 16:37:10","State":"正在进行","theEndOfTime":"2020-01-10 00:00:00","TestPaperID":" 001 "},{"uid":"402880f46eedab73016eeef5167d0006","theName":"IOS基础考试","theStartTime":"2019-12-10 16:37:10","State":"正在进行","theEndOfTime":"2020-01-10 00:00:00","TestPaperID":" 002 "},{"uid":"402880f46eedab73016eeef5886e0007","theName":"Android进阶考试","theStartTime":"2019-12-10 16:38:07","State":"已经结束","theEndOfTime":"2020-01-11 00:00:00","TestPaperID":" 002 "},{"uid":"402880f46ef28b6a016ef28b7ee6000d","theName":"android测试","theStartTime":"2019.11.28 8:30","State":"正在进行","theEndOfTime":"2019.11.29 8:30","TestPaperID":"004"}]
     * count : 4
     */

    private int msg;
    private int code;
    private int count;
    private List<DataBean> data;

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 402880f46eedab73016eeef4beb60005
         * theName : Android基础考试
         * theStartTime : 2019-12-10 16:37:10
         * State : 正在进行
         * theEndOfTime : 2020-01-10 00:00:00
         * TestPaperID :  001
         */

        private String uid;
        private String theName;
        private String theStartTime;
        private String State;
        private String theEndOfTime;
        private String TestPaperID;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getTheName() {
            return theName;
        }

        public void setTheName(String theName) {
            this.theName = theName;
        }

        public String getTheStartTime() {
            return theStartTime;
        }

        public void setTheStartTime(String theStartTime) {
            this.theStartTime = theStartTime;
        }

        public String getState() {
            return State;
        }

        public void setState(String State) {
            this.State = State;
        }

        public String getTheEndOfTime() {
            return theEndOfTime;
        }

        public void setTheEndOfTime(String theEndOfTime) {
            this.theEndOfTime = theEndOfTime;
        }

        public String getTestPaperID() {
            return TestPaperID;
        }

        public void setTestPaperID(String TestPaperID) {
            this.TestPaperID = TestPaperID;
        }
    }
}
