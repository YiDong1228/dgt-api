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

    public static final int SORT_DEFAULT = 0;   // 默认顺序
    public static final int SORT_ZHENGXU = 1;   // 正序
    public static final int SORT_DAOXU = 2;   // 倒序
    public static final int TRADE_DIRECTION_BUY = 0; // 买
    public static final int TRADE_DIRECTION_SELL = 1; // 卖
    public static final int TRADE_COMB_OFFSET_FLAG_OPEN = 0; // 开
    public static final int TRADE_COMB_OFFSET_FLAG_CLOSE = 1; // 平
    public static final int TRADE_LIMIT_PRICE_RANGE = 100; // 委托限价范围

}
