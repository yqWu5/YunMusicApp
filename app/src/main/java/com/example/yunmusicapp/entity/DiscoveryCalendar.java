package com.example.yunmusicapp.entity;

import java.util.List;

public class DiscoveryCalendar {
    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private Object abtest;
        private CalendarConfigBean calendarConfig;
        private List<CalendarEventsBean> calendarEvents;

        public Object getAbtest() {
            return abtest;
        }

        public void setAbtest(Object abtest) {
            this.abtest = abtest;
        }

        public CalendarConfigBean getCalendarConfig() {
            return calendarConfig;
        }

        public void setCalendarConfig(CalendarConfigBean calendarConfig) {
            this.calendarConfig = calendarConfig;
        }

        public List<CalendarEventsBean> getCalendarEvents() {
            return calendarEvents;
        }

        public void setCalendarEvents(List<CalendarEventsBean> calendarEvents) {
            this.calendarEvents = calendarEvents;
        }

        public static class CalendarConfigBean {
            private ButtonBean button;

            public ButtonBean getButton() {
                return button;
            }

            public void setButton(ButtonBean button) {
                this.button = button;
            }

            public static class ButtonBean {
                private String text;
                private String targetUrl;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getTargetUrl() {
                    return targetUrl;
                }

                public void setTargetUrl(String targetUrl) {
                    this.targetUrl = targetUrl;
                }
            }
        }

        public static class CalendarEventsBean {
            private String id;
            private String eventType;
            private long onlineTime;
            private long offlineTime;
            private String tag;
            private String title;
            private String imgUrl;
            private boolean canRemind;
            private boolean reminded;
            private String targetUrl;
            private String remindText;
            private Object logInfo;
            private Object alg;
            private String resourceType;
            private String resourceId;
            private String eventStatus;
            private String remindedText;
            private Object statusText;
            private Object statusTextColor;
            private boolean headline;
            private int subCount;
            private Object extInfo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getEventType() {
                return eventType;
            }

            public void setEventType(String eventType) {
                this.eventType = eventType;
            }

            public long getOnlineTime() {
                return onlineTime;
            }

            public void setOnlineTime(long onlineTime) {
                this.onlineTime = onlineTime;
            }

            public long getOfflineTime() {
                return offlineTime;
            }

            public void setOfflineTime(long offlineTime) {
                this.offlineTime = offlineTime;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public boolean isCanRemind() {
                return canRemind;
            }

            public void setCanRemind(boolean canRemind) {
                this.canRemind = canRemind;
            }

            public boolean isReminded() {
                return reminded;
            }

            public void setReminded(boolean reminded) {
                this.reminded = reminded;
            }

            public String getTargetUrl() {
                return targetUrl;
            }

            public void setTargetUrl(String targetUrl) {
                this.targetUrl = targetUrl;
            }

            public String getRemindText() {
                return remindText;
            }

            public void setRemindText(String remindText) {
                this.remindText = remindText;
            }

            public Object getLogInfo() {
                return logInfo;
            }

            public void setLogInfo(Object logInfo) {
                this.logInfo = logInfo;
            }

            public Object getAlg() {
                return alg;
            }

            public void setAlg(Object alg) {
                this.alg = alg;
            }

            public String getResourceType() {
                return resourceType;
            }

            public void setResourceType(String resourceType) {
                this.resourceType = resourceType;
            }

            public String getResourceId() {
                return resourceId;
            }

            public void setResourceId(String resourceId) {
                this.resourceId = resourceId;
            }

            public String getEventStatus() {
                return eventStatus;
            }

            public void setEventStatus(String eventStatus) {
                this.eventStatus = eventStatus;
            }

            public String getRemindedText() {
                return remindedText;
            }

            public void setRemindedText(String remindedText) {
                this.remindedText = remindedText;
            }

            public Object getStatusText() {
                return statusText;
            }

            public void setStatusText(Object statusText) {
                this.statusText = statusText;
            }

            public Object getStatusTextColor() {
                return statusTextColor;
            }

            public void setStatusTextColor(Object statusTextColor) {
                this.statusTextColor = statusTextColor;
            }

            public boolean isHeadline() {
                return headline;
            }

            public void setHeadline(boolean headline) {
                this.headline = headline;
            }

            public int getSubCount() {
                return subCount;
            }

            public void setSubCount(int subCount) {
                this.subCount = subCount;
            }

            public Object getExtInfo() {
                return extInfo;
            }

            public void setExtInfo(Object extInfo) {
                this.extInfo = extInfo;
            }
        }
    }
}
