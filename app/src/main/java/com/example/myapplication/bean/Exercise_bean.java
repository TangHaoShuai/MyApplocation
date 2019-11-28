package com.example.myapplication.bean;

import java.io.Serializable;
import java.util.List;

public class Exercise_bean implements Serializable {
    /**
     * msg : 0
     * code : 0
     * data : [{"item2":"C++","item1":"C#","question":"Android是用什么语言写的","answer":"3","id":"402891816eab7691016eab7f55090002","item4":"Swift","explains":"Android是用Java开发编写的","item3":"Java","tid":"002","url":"sta/mzz.jpn","sid":"001"},{"item2":"答案B","item1":"答案A","question":"这个一个测试！！！！","answer":"1","id":"402891816eac9479016eac9486a70001","item4":"答案D","explains":"因为这是一个测试！没有对错","item3":"答案C","tid":"50","url":"hemo/img","sid":null},{"item2":"答案B","item1":"答案A","question":"这个一个测试！！！！","answer":"1","id":"402891816ead4b8a016ead4b970b0001","item4":"答案D","explains":"因为这是一个测试！没有对错","item3":"答案C","tid":"50","url":"hemo/img","sid":null},{"item2":"答案B","item1":"答案A","question":"这个一个测试！！！！","answer":"1","id":"402891816ead5180016ead518d4d0001","item4":"答案D","explains":"因为这是一个测试！没有对错","item3":"答案C","tid":"50","url":"hemo/img","sid":null},{"item2":"231","item1":"21","question":"Andorid","answer":"2","id":"8ad35aed6eac1dda016eac1e73610000","item4":"1","explains":"32","item3":"23","tid":"003","url":"1231","sid":"001 "},{"item2":"1231","item1":"123","question":"123","answer":"12","id":"8ad35aed6eac1dda016eac1f42710001","item4":"231","explains":"123","item3":"31","tid":"001","url":"123","sid":"50 "},{"item2":"答案B","item1":"答案A","question":"这个一个测试！！！！","answer":"1","id":"8ad35aed6eac2350016eac2362770001","item4":"答案D","explains":"因为这是一个测试！没有对错","item3":"答案C","tid":"50","url":"hemo/img","sid":null},{"item2":"答案B","item1":"答案A","question":"这个一个测试！！！！","answer":"1","id":"8ad35aed6eaf8115016eaf81240f0000","item4":"答案D","explains":"因为这是一个测试！没有对错","item3":"答案C","tid":"50","url":"hemo/img","sid":null},{"item2":"答案B","item1":"答案A","question":"这个一个测试！！！！","answer":"1","id":"8ad35aed6eb00c9b016eb00cae2e0000","item4":"答案D","explains":"因为这是一个测试！没有对错","item3":"答案C","tid":"50","url":"hemo/img","sid":null}]
     * count : 9
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

    public static class DataBean implements Serializable{
        /**
         * item2 : C++
         * item1 : C#
         * question : Android是用什么语言写的
         * answer : 3
         * id : 402891816eab7691016eab7f55090002
         * item4 : Swift
         * explains : Android是用Java开发编写的
         * item3 : Java
         * tid : 002
         * url : sta/mzz.jpn
         * sid : 001
         */

        private String item2;
        private String item1;
        private String question;
        private String answer;
        private String id;
        private String item4;
        private String explains;
        private String item3;
        private String tid;
        private String url;
        private String sid;

        public String getItem2() {
            return item2;
        }

        public void setItem2(String item2) {
            this.item2 = item2;
        }

        public String getItem1() {
            return item1;
        }

        public void setItem1(String item1) {
            this.item1 = item1;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getItem4() {
            return item4;
        }

        public void setItem4(String item4) {
            this.item4 = item4;
        }

        public String getExplains() {
            return explains;
        }

        public void setExplains(String explains) {
            this.explains = explains;
        }

        public String getItem3() {
            return item3;
        }

        public void setItem3(String item3) {
            this.item3 = item3;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }
    }
}
