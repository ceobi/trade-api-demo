package com.ceo.apidemo.apidemo.client;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class API {

    public static final String ACCESS_KEY = "";
    public static final String SECRET_KEY = "";

    public static final String HOST = "https://api.ceobi.com";
    //获取全币种行情
    public static final String PUB_MARKET_allTicker = HOST + "/api/market/allTicker";
    //行情
    public static final String PUB_MARKET_ticker = HOST + "/api/market/ticker";
    //委托记录
    public static final String PUB_MARKET_entrust = HOST + "/api/market/entrust";
    //历史成交
    public static final String PUB_MARKET_trades = HOST + "/api/market/trades";
    //K线
    public static final String PUB_MARKET_kline = HOST + "/api/market/kline";

    //获取用户信息
    public static final String PRI_DEAL_accountInfo = HOST + "/api/deal/accountInfo";
    //委托下单
    public static final String PRI_DEAL_order = HOST + "/api/deal/order";
    //取消委托
    public static final String PRI_DEAL_cancelOrder = HOST + "/api/deal/cancelOrder";
    //获取委托买单或卖单
    public static final String PRI_DEAL_getOrder = HOST + "/api/deal/getOrder";
    //获取多个委托买单或卖单
    public static final String PRI_DEAL_getOrders = HOST + "/api/deal/getOrders";
    //获取交易记录
    public static final String PRI_DEAL_getTrades = HOST + "/api/deal/getTrades";
    //获取用户充值地址
    public static final String PRI_DEAL_getUserAddress = HOST + "/api/deal/getUserAddress";
    //获取用户的数字币提现地址
    public static final String PRI_DEAL_getWithdrawAddress = HOST + "/api/deal/getWithdrawAddress";
    //获取数字币提现记录
    public static final String PRI_DEAL_getWithdrawRecord = HOST + "/api/deal/getWithdrawRecord";
    //获取数字币充值记录
    public static final String PRI_DEAL_getChargeRecord = HOST + "/api/deal/getChargeRecord";

    /**
     * 获取全币种行情
     * @throws Exception
     */
    public void allTicker() throws Exception {
        URL url = new URL(PUB_MARKET_allTicker);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 行情
     * @throws Exception
     */
    public void ticker() throws Exception {
        String connUrl = PUB_MARKET_ticker + "?market=ceo_qc";
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 委托记录
     * @throws Exception
     */
    public void entrust() throws Exception {
        String connUrl = PUB_MARKET_entrust + "?market=ceo_qc";
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 历史成交
     * @throws Exception
     */
    public void trades() throws Exception {
        String connUrl = PUB_MARKET_trades + "?market=ceo_qc";
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * K线
     * @throws Exception
     */
    public void kline() throws Exception {
        String connUrl = PUB_MARKET_kline + "?market=ceo_qc&type=1min";
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 获取用户信息
     * @throws Exception
     */
    public void accountInfo() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "accountInfo");
        params.put("reqTime", System.currentTimeMillis()+"");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_accountInfo + "?"+paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 委托下单
     * @throws Exception
     */
    public void order() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "order");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("price", "6000");
        params.put("amount", "0.113");
        params.put("tradeType",  "1");
        params.put("currency", "ceo_qc");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_order + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 取消委托
     * @throws Exception
     */
    public void cancelOrder() throws Exception{
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "cancelOrder");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("currency", "ceo_qc");
        params.put("id", "1");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_cancelOrder + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 获取委托买单或卖单
     * @throws Exception
     */
    public void getOrder() throws Exception{
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "getOrder");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("currency", "ceo_qc");
        params.put("id", "64");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_getOrder + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 获取多个委托买单或卖单
     * @throws Exception
     */
    public void getOrders() throws Exception{
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "getOrders");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("currency", "ceo_qc");
        params.put("pageIndex", "1");
        params.put("pageSize", "10");
        params.put("tradeType", "1");
        params.put("tradeStatus", "0");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_getOrders + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 获取交易记录
     * @throws Exception
     */
    public void getTrades() throws Exception{
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "getTrades");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("currency", "ceo_qc");
        params.put("pageIndex", "1");
        params.put("pageSize", "10");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_getTrades + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 获取用户充值地址
     * @throws Exception
     */
    public void getUserAddress() throws Exception{
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "getUserAddress");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("currency", "ceo");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_getUserAddress + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 获取用户的数字币提现地址
     * @throws Exception
     */
    public void getWithdrawAddress() throws Exception{
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "getWithdrawAddress");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("currency", "ceo");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_getWithdrawAddress + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 获取数字币提现记录
     * @throws Exception
     */
    public void getWithdrawRecord() throws Exception{
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "getWithdrawRecord");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("currency", "ceo");
        params.put("pageIndex", "1");
        params.put("pageSize", "10");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_getWithdrawRecord + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    /**
     * 获取数字币充值记录
     * @throws Exception
     */
    public void getChargeRecord() throws Exception{
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "getChargeRecord");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("currency", "ceo");
        params.put("pageIndex", "1");
        params.put("pageSize", "10");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_getChargeRecord + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }

    public static void main(String[] args) {
        try {
            API api = new API();
//            api.allTicker();
//            api.ticker();
//            api.entrust();
//            api.trades();
//            api.kline();
//            api.accountInfo();
//            api.order();
//            api.cancelOrder();
//            api.getOrder();
//            api.getOrders();
//            api.getTrades();
//            api.getUserAddress();
//            api.getWithdrawAddress();
//            api.getWithdrawRecord();
            api.getChargeRecord();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
