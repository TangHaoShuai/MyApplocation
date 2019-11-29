package com.example.myapplication.bean;

import java.io.Serializable;
import java.util.List;

public class TheTest implements Serializable {


    /**
     * msg : 0
     * code : 0
     * data : [{"uid":"8ad35aed6eaf6d4a016eaf6d5a610000","theName":"android测试","theStartTime":"2019.11.28 8:30","State":"正在进行","theEndOfTime":"2019.11.29 8:30","TestPaperID":"001"},{"uid":"8ad35aed6eaf6e17016eaf6e24c20000","theName":"android测试","theStartTime":"2019.11.28 8:30","State":"正在进行","theEndOfTime":"2019.11.29 8:30","TestPaperID":"002"},{"uid":"8ad35aed6eaf7111016eaf7158e20000","theName":"android测试","theStartTime":"2019.11.28 8:30","State":"正在进行","theEndOfTime":"2019.11.29 8:30","TestPaperID":"003"},{"uid":"8ad35aed6eaf727a016eaf72881d0000","theName":"android测试","theStartTime":"2019.11.28 8:30","State":"正在进行","theEndOfTime":"2019.11.29 8:30","TestPaperID":"004"},{"uid":"8ad35aed6eaf8115016eaf8126e00002","theName":"android测试","theStartTime":"2019.11.28 8:30","State":"正在进行","theEndOfTime":"2019.11.29 8:30","TestPaperID":"004"}]
     * count : 5
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

    public TheTest() {
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TheTest{" +
                "msg=" + msg +
                ", code=" + code +
                ", count=" + count +
                ", data=" + data +
                '}';

        
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

    public static class DataBean implements Serializable {
        /**
         * uid : 8ad35aed6eaf6d4a016eaf6d5a610000
         * theName : android测试
         * theStartTime : 2019.11.28 8:30
         * State : 正在进行
         * theEndOfTime : 2019.11.29 8:30
         * TestPaperID : 001
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
