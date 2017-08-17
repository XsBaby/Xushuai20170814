package com.baway.xushuai.bean;

import java.util.List;

/**
 * date:2017/8/14
 * author:徐帅(acer)
 * funcation:实体类
 */

public class News {
    private List<美女Bean> 美女;

    public List<美女Bean> get美女() {
        return 美女;
    }

    public void set美女(List<美女Bean> 美女) {
        this.美女 = 美女;
    }

    public static class 美女Bean {
        /**
         * adtype : 0
         * boardid : comment_bbs
         * clkNum : 0
         * danmu : 1
         * digest : 摘自微博 不知道是哪位美女
         * docid : CQ91TK0R9001TK0S
         * downTimes : 85
         * img : http://dmr.nosdn.127.net/NWzVIyhX2e64vzeGubrARA==/6896093023037637938.jpg
         * imgType : 0
         * imgsrc : http://dmr.nosdn.127.net/NWzVIyhX2e64vzeGubrARA==/6896093023037637938.jpg
         * imgsum : 0
         * picCount : 0
         * pixel : 700*873
         * program : HY
         * prompt : 成功为您推荐20条新内容
         * rank : 0
         * recNews : 0
         * recType : 0
         * refreshPrompt : 0
         * replyCount : 8
         * replyid : CQ91TK0R9001TK0S
         * source : 堆糖网
         * title : 摘自微博 不知道是哪位美女
         * upTimes : 269
         */

        private int adtype;
        private String boardid;
        private int clkNum;
        private int danmu;
        private String digest;
        private String docid;
        private int downTimes;
        private String img;
        private int imgType;
        private String imgsrc;
        private int imgsum;
        private int picCount;
        private String pixel;
        private String program;
        private String prompt;
        private int rank;
        private int recNews;
        private int recType;
        private int refreshPrompt;
        private int replyCount;
        private String replyid;
        private String source;
        private String title;
        private int upTimes;

        public int getAdtype() {
            return adtype;
        }

        public void setAdtype(int adtype) {
            this.adtype = adtype;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public int getClkNum() {
            return clkNum;
        }

        public void setClkNum(int clkNum) {
            this.clkNum = clkNum;
        }

        public int getDanmu() {
            return danmu;
        }

        public void setDanmu(int danmu) {
            this.danmu = danmu;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public int getDownTimes() {
            return downTimes;
        }

        public void setDownTimes(int downTimes) {
            this.downTimes = downTimes;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public int getPicCount() {
            return picCount;
        }

        public void setPicCount(int picCount) {
            this.picCount = picCount;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public String getProgram() {
            return program;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public String getPrompt() {
            return prompt;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getRecNews() {
            return recNews;
        }

        public void setRecNews(int recNews) {
            this.recNews = recNews;
        }

        public int getRecType() {
            return recType;
        }

        public void setRecType(int recType) {
            this.recType = recType;
        }

        public int getRefreshPrompt() {
            return refreshPrompt;
        }

        public void setRefreshPrompt(int refreshPrompt) {
            this.refreshPrompt = refreshPrompt;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getReplyid() {
            return replyid;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUpTimes() {
            return upTimes;
        }

        public void setUpTimes(int upTimes) {
            this.upTimes = upTimes;
        }
    }
}