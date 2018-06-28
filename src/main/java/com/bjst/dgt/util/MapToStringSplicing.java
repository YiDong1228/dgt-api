package com.bjst.dgt.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapToStringSplicing {
    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     * @throws UnsupportedEncodingException
     */
    public static String createLinkStringByGet(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            try {
                value = URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }

    /*public static String Url(String url, String type, String query) throws Exception {
        URL restURL = new URL(url);
        *//*
         * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection
         *//*
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();

        //请求方式
        conn.setRequestMethod(type);
        //设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
        conn.setDoOutput(true);
        //allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
        conn.setAllowUserInteraction(false);
        //获取URLConnection对象对应的输出流
        PrintStream ps = new PrintStream(conn.getOutputStream());
        //发送请求参数即数据
        ps.print(query);

        ps.close();
        //构造一个字符流缓存
        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line = "";
        StringBuilder resultStr = new StringBuilder();

        while (null != (line = bReader.readLine())) {
            resultStr.append(line);
        }
        *//*resultStr.insert(0, "[");
        resultStr.insert(resultStr.length(), "]");*//*
        line = resultStr.toString();
        System.out.println(line);
        bReader.close();
        return line;

    }*/

}
