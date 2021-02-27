package com.example.springfeign.model;

public class Gif {
    private Data data;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public class Data {
        private String url;
        public String getUrl(){
            return url;
        }
        public void setUrl(String nurl){
            this.url=nurl;
        }
    }

}
