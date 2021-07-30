package com.zj.study;

import cn.hutool.http.HttpUtil;

/**
 * @author ZhaoJiu
 * @since: 2021/7/27
 * @desc:
 */
public class HttpClientTest {

    public static void main(String[] args) {
        //发送get请求  HuTools 工具
        String result = HttpUtil.get("http://localhost:8080/user/list");
        System.out.println("result = " + result);
    }
}
