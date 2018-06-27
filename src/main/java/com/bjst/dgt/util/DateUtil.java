package com.bjst.dgt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String isBelong(int is_domestic, String code, String begintime, String endtime) {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date now = null;
        Date beginTime = null;
        Date endTime = null;
        try {
            now = df.parse(df.format(new Date()));
            beginTime = df.parse(begintime);
            endTime = df.parse(endtime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int str1 = Integer.parseInt(begintime.substring(0, begintime.indexOf(":")));
        int str2 = Integer.parseInt(endtime.substring(0, endtime.indexOf(":")));

        Calendar date = Calendar.getInstance();
        date.setTime(now);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        Calendar endd = Calendar.getInstance();
        endd.setTime(endTime);
        try {
            if (is_domestic == 1) {
                endd.add(Calendar.MINUTE, -20);
                return getDate(code, str1, str2, date, begin, end, endd, begintime, endtime);
            } else {
                endd.add(Calendar.MINUTE, -3);
                return getDate(code, str1, str2, date, begin, end, endd, begintime, endtime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "未知错误";
    }

    private static String getDate(String code, int str1, int str2, Calendar date, Calendar begin, Calendar end, Calendar endd, String begintime, String endtime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");

        //日盘
        Calendar end_1 = Calendar.getInstance();
        end_1.setTime(df.parse("11:30"));
        Calendar start_1 = Calendar.getInstance();
        start_1.setTime(df.parse("13:30"));
        Date end_da = new Date();
        Date start_da = new Date();
        if (code.equals("SCau0001") || code.equals("SCag0001") || code.equals("DCp0001") || code.equals("DCi0001") || code.equals("SEsc0001")) {
            end_da = df.parse("21:00");
            start_da = df.parse("2:30");
            ;
        }
        //夜盘
        Calendar end_2 = Calendar.getInstance();
        end_2.setTime(end_da);
        Calendar start_2 = Calendar.getInstance();
        start_2.setTime(start_da);

        if (code.equals("DCi0001") || code.equals("DCp0001") || code.equals("SCag0001") || code.equals("SCau0001") || code.equals("SCcu0001") || code.equals("SCrb0001") || code.equals("SCru0001") || code.equals("SEsc0001") || code.equals("ZCSR0001")) {
            if (str2 < str1) {
                if (date.after(begin) || date.before(endd)) {
                    return "交易中 (交易时间" + begintime + "-次日" + endtime + ")";
                } else {
                    //带有英文开头的品种在这个时间段内显示交易中，在这个交易时间段后20分钟内显示非交易时间，其他时间显示未开盘
                    if (date.before(end) && date.after(endd)) {
                        return "非交易时间段 (只提供行情，不提供交易)";
                    } else {
                        return "未开盘 (交易时间" + begintime + "-次日" + endtime + ")";
                    }
                }
            } else {
                if ((date.after(begin) && date.before(end_1)) || (date.after(start_1) && date.before(endd))) {
                    return "交易中 (交易时间" + begintime + "-11:30,13:30-" + endtime + ")";
                } else {
                    //带有英文开头的品种在这个时间段内显示交易中，在这个交易时间段后20分钟内显示非交易时间，其他时间显示未开盘
                    if (date.before(end) && date.after(endd)) {
                        return "非交易时间段 (只提供行情，不提供交易)";
                    } else {
                        return "未开盘 (交易时间" + begintime + "-11:30,13:30-" + endtime + ")";
                    }
                }
            }
        } else {
            if (str2 < str1) {
                if (date.after(begin) || date.before(endd)) {
                    return "交易中 (交易时间" + begintime + "-次日" + endtime + ")";
                } else {
                    //带有英文开头的品种在这个时间段内显示交易中，在这个交易时间段后20分钟内显示非交易时间，其他时间显示未开盘
                    if (date.before(end) && date.after(endd)) {
                        return "非交易时间段 (只提供行情，不提供交易)";
                    } else {
                        return "未开盘 (交易时间" + begintime + "-次日" + endtime + ")";
                    }
                }
            } else {
                if (date.after(begin) && date.before(endd)) {
                    return "交易中 (交易时间" + begintime + "-" + endtime + ")";
                } else {
                    //带有英文开头的品种在这个时间段内显示交易中，在这个交易时间段后20分钟内显示非交易时间，其他时间显示未开盘
                    if (date.before(end) && date.after(endd)) {
                        return "非交易时间段 (只提供行情，不提供交易)";
                    } else {
                        return "未开盘 (交易时间" + begintime + "-" + endtime + ")";
                    }
                }
            }
        }
    }
}
