package com.example.yunmusicapp.entity.tmp;

public class Cookie {
    private static String cookie = null;
    private static Long userId = null;
    public static String getCookie(){
        return cookie;
    }

    public static void setCookie(String val){
        cookie = new String(val);
    }

    public static Long getUserId() {
        return userId;
    }

    public static void setUserId(Long userId) {
        Cookie.userId = userId;
    }
}
