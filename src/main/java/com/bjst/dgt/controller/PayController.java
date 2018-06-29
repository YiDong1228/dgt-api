package com.bjst.dgt.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.bjst.dgt.core.ProjectConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by zll on 2018/6/28.
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @GetMapping("alipay")
    public void alipay(HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse) throws ServletException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", ProjectConstant.APP_ID, ProjectConstant.APP_PRIVATE_KEY, "json", ProjectConstant.CHARSET,ProjectConstant. ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                " \"out_trade_no\":\"20150320010101002123456897\"," +
                " \"total_amount\":\"0.01\"," +
                " \"subject\":\"Iphone6 16G\"," +
                " \"product_code\":\"QUICK_WAP_PAY\"" +
                " }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + ProjectConstant.CHARSET);
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    /**
     * 支付宝网关  用户支付成功后 支付宝会把这个地址告诉用户 然后用户会访问这个地址 后台敷衍一下 提示成功就好了
     * @return
     */
    @RequestMapping("alipay/gateway")
    public ModelAndView returnUrl(){
        ModelAndView mv=new ModelAndView("pay_success");
        return mv;
    }

    /**
     * 授权回调地址 用户支付成功后 支付宝会直接访问这个地址 然后后台处理具体的业务逻辑
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value="alipay/notify",method= RequestMethod.POST)
    public void notifyUrl( String trade_status, String out_trade_no, String trade_no) throws UnsupportedEncodingException {
//        request.setCharacterEncoding("utf-8");
//        Map<String,String> params = new HashMap<String,String>();
//        Map requestParams = request.getParameterMap();
//
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//            params.put(name, valueStr);
//        }
//        try {
//            //aliPayService.notifyUrl(params, trade_status, out_trade_no, out_trade_no);
//        } catch (Exception e) {
//           // LOG.info(e.getMessage());
//        }

    }
}
