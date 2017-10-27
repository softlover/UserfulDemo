package com.mydo.demo.model;

import java.util.List;

/**
 *
 * @author: LiBing.
 * @date: 2017/10/26.
 * @version: V1.0.0.
 */

public class News {

    private List<ContentBean> content;

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * id : 53cdf194-7e4c-4eda-873e-4ca1e3bff1a0
         * title : test4标题写得比较长的时候test4
         * content : test4无图片
         * image :
         * width : null
         * length : null
         * appVersion : 4.0
         * mobileOs : 0
         * position : 2
         * type : 1
         * viewCount : 3011
         * expires : 1514688820000
         * url :
         * createTime : 1490755941000
         */

        private String id;
        private String title;
        private String content;
        private String image;
        private Object width;
        private Object length;
        private String appVersion;
        private int mobileOs;
        private int position;
        private int type;
        private int viewCount;
        private long expires;
        private String url;
        private long createTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Object getWidth() {
            return width;
        }

        public void setWidth(Object width) {
            this.width = width;
        }

        public Object getLength() {
            return length;
        }

        public void setLength(Object length) {
            this.length = length;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public int getMobileOs() {
            return mobileOs;
        }

        public void setMobileOs(int mobileOs) {
            this.mobileOs = mobileOs;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public long getExpires() {
            return expires;
        }

        public void setExpires(long expires) {
            this.expires = expires;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }
    }
}
