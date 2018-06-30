package com.bjst.dgt.core;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.bjst.dgt";//生成代码所在的基础包名称，可根据自己公司的项目修改（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";//生成的Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//生成的Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//生成的Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//生成的ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";//生成的Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";//Mapper插件基础接口的完全限定名

    public static final int PLATFORM_ANDROID = 1;  // android 平台类型
    public static final int PLATFORM_IOS = 2;   // ios 平台类型
    public static final int PLATFORM_RAPE = 1;   // 强制更新

    public static final int YIFU_TYPE_INNER = 0;   //接口地址类型 内盘
    public static final int YIFU_TYPE_OUTER = 1;   //接口地址类型 外盘

    public static final String REGISTER_SMS = "registerSMS";//注册验证码缓存
    public static final String PASSWORD_SMS = "passwordSMS";//忘记验证码缓存
    public static final String SMS_ERROR_CODE = "error_code";//验证码错误标签

    public static final String MARKET_GETPRODUCT = "getProduct";//行情缓存
    public static final String MARKET_GETUSERPRODUCTORDER = "getUserProductOrder";//自定义排序缓存

    public static final int SENDSMS_TYPE_1 = 1;//验证码类型 注册
    public static final int SENDSMS_TYPE_2 = 2;//验证码类型 忘记密码

    public static final int RECHARGEANDWITHDRAWAL_CODE_0 = 0;//status状态值
    public static final int RECHARGEANDWITHDRAWAL_CODE_2003 = 2003;//status状态值
    public static final int RECHARGEANDWITHDRAWAL_CODE_2004 = 2004;//status状态值
    public static final int RECHARGEANDWITHDRAWAL_CODE_200 = 200;//status状态值

    public static final int SORT_DEFAULT = 0;   // 默认顺序
    public static final int SORT_ZHENGXU = 1;   // 正序
    public static final int SORT_DAOXU = 2;   // 倒序

    public static final int TRADE_DIRECTION_BUY = 0; // 买
    public static final int TRADE_DIRECTION_SELL = 1; // 卖
    public static final int TRADE_COMB_OFFSET_FLAG_OPEN = 0; // 开
    public static final int TRADE_COMB_OFFSET_FLAG_CLOSE = 1; // 平
    public static final int TRADE_LIMIT_PRICE_RANGE = 100; // 委托限价范围
    public static final int TRADE_INNER_DISC_FLAG = 0; // 內盤表示
    public static final int TRADE_OUTER_DISC_FLAG = 1; // 外盤表示
    public static final String DGT_LOGIN_TOKEN_KEY = "DGT_LOGIN_TOKEN_KEY"; // TOKEN
    public static final String DGT_LOGIN_USER_ID_KEY = "DGT_LOGIN_USER_ID_KEY"; // USERID
    public static final String DGT_LOGIN_INNER_USER_KEY = "DGT_LOGIN_INNER_USER_KEY"; // 内盘用户 key
    public static final String DGT_LOGIN_INNER_PASSWORD_KEY = "DGT_LOGIN_INNER_PASSWORD_KEY"; // 内盘用户 password key
    public static final String DGT_LOGIN_OUTER_USER_KEY = "DGT_LOGIN_OUTTER_USER_KEY"; // 外盘用户 key
    public static final String DGT_LOGIN_OUTER_PASSWORD_KEY = "DGT_LOGIN_OUTER_PASSWORD_KEY"; // 外盘用户 password key
    public static final String DGT_TRADE_INVESTOR_POSITION_KEY = "DGT_TRADE_INVESTOR_POSITION_KEY"; // 持仓key redis
    public static final String DGT_TRADE_INVESTOR_POSITION_DETAIL_KEY = "DGT_TRADE_INVESTOR_POSITION_DETAIL_KEY"; // 持仓明细key redis

    public static final String APP_ID = "2018062860441303";
    public static final String APP_PRIVATE_KEY = "\n" +
            "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCvCp2xGCf2pDtJ\n" +
            "GCyTx20Y21HuH/ZH8vIOhKVAWzDU//Iz1gb3o1sXiq+S8g1ak056XmF1MI/NN6NW\n" +
            "vLYoKWdxGmxhL9qO2IjFq9huOnBvPNXpOuovGln9ccU8MJCoZCZCKY6dSJC5SkQD\n" +
            "XkbR4pHxXbzNurI6ho+b+waYkxQILtj5jQPORH0LxLECJKqIygcCr3BmrnQrZwNh\n" +
            "Pmr2D+pPo85jEZoz8Ws4zWmuYSFTpQFgXD5pulnhdV9zSmtZyv01Z2F2ifCX6Jt7\n" +
            "uFKpznfCsqZiraoj1aYEwm9ZCTzELPbGKFZ7gNhFDUz4mih8b+1lcKtfNEMwXg3c\n" +
            "jC5srdvfAgMBAAECggEBAJQrdFjYjdumIdk58WIWyi7kWHIt9BfreyL2/buAddGX\n" +
            "5roiTjuJuC4xY3YMF2m4kBHdmrnMpa2dj1J44+kTQ1DmgR+zllqcyQoq8UY9ibdf\n" +
            "0+Ndz6aXs91qVP8iTRF91TTkYKibKIbwaqo/P8ui8s9R/eRYSU5pYV80Gt1Egwx4\n" +
            "04w3Su8KJHuW0dzg1Uy+iYTz+xH82ezS1ze3px517a7FemeQE3pvuAvsRRRM09R1\n" +
            "IFpq4yViTNuoO3Qep/2lVMSlAMr6kyKvFkbYrQP80tAoSmf9ss/VorYlSEnn46No\n" +
            "0Sxit5I48ogT0SQNSYGM/0igpTiIQMILzYnuIw47C2ECgYEA6Lrz+JaU127uIRUY\n" +
            "zy1PEsu3mvDg2ryP37piULiR2EzH93Hhza9UN8tA1YXdXv+xF62n2Gd4KYr8W1DB\n" +
            "IE8LCW970eVhwWsq0WFTv8EUdBR+nif7cQj8D2GQsXONwXunyFfqXoslLzmmZ/6n\n" +
            "cNdxRrHayrAsQTfPiU5aYeLUBZsCgYEAwIsKH8T6/xdU3dckZYLtPPY1gNsoowFS\n" +
            "rm3PWmRXtovhKy5+gpSVlaWbHo6UvYEdvGc2lB3iV6By90SLowgtkNOp3FE4SepM\n" +
            "mRGOXUjGm8q5xSZo7h6hwiUfjIrVCOZNAnm9/xP2Q8Il5YyW0vfmAVygy+mcjiI2\n" +
            "/WUSFTUnaQ0CgYEAxuqcAlo6J5SB5jbQ+KsiTc9fRAgkN/E5C6GTzKikx3qA4+cr\n" +
            "d5Em63VHGfmLx1nGNJXRwy5UzzUjEq2IFCRbK5pk+3cSQa5mb4W/fkL6R2kI/Aby\n" +
            "a5+hSUg70uAQRlJ5isxR3rMRejbNG0/WL6WFBUaY2esQOEIKmbIloEquq4cCgYAp\n" +
            "39NC14cy5TMa0AhlX1UTFgTK0l8DHG2L6+vVn88Hr2I4DvOKmJ/znMGgoqeskyER\n" +
            "cW0IR3uLTSTTq/+mZEfsoGvns25HfQJNo+jPVt2C0lMWkmTtrJHHdGVpHmR4fAWx\n" +
            "jSKKECBV2ip9wtamaS2HjEqYLmVS8BP/hfSp0haRHQKBgQCzvNmH89B1SUCrW1lr\n" +
            "6HKOnbXGqr8kvN5CrbiJzzXx3cXu0kbM5Ojvii3KuAP8mF/Gw9wXu05WFuwslrYS\n" +
            "Au968BICf7VRtB31L3uB87aUkNLPLvRfyT4jDBWuL6r3AdHvUk3ZNN7qFgl5O0KM\n" +
            "+Cpz+CnKmqbVMStREyLE5LKirA==";

    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
    // 请求网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtXMrjLlKRB+amwB+g8tviL/NUTv3vdloMps4ho5mb9g3H4ALN4/FXPSl1h0jsGtARWe9s1pwLGsM9EH7f3R6TO38XuY87n/pQZzdlanAbSsh8PfiAWakuD9BzX9uglXI0PbogTLVJZrUr551DgDQsG+HXvf7z5sJF16guxwsyWLZ4K+HbywmoLuvY+hVGzQ4149Rf1dNYhpOsJRpgc+pi+foBFy+ofQ61BlGhRILhTwVwhQ3/EX4AecCC8KmKIpE0v0KXEOkz7d6bivBqvDTTlxuH5r92qRMUG48rU4K2NQEHled6C8cPimDlMIxoYhVQ4IWLB74SCtJumD3IVPioQIDAQAB";

    // RSA2
    public static String SIGNTYPE = "RSA2";

}
