# trade-api-demo

- - - - - -

## 代码结构说明

```
 trade-api-demo
 ├─com.ceo.apidemo.apidemo.client      rest接口demo
 │    ├─API.java         api测试例子
 │    │
 │    └─SignUtil.java    签名工具类
 │
 ├─com.ceo.apidemo.apidemo.wsclient     WebSocket接口demo
 │    ├─demo1  java客户端
 │    │
 │    └─demo2  html客户端 html可直接运行
 │
```

## 接口说明

CEO为用户提供了两种调用接口的方式，分别为：Rest和WebSocket，开发者可根据自身需求来选择适合自己的方式查询市场深度信息、交易和查询相关的交易记录

----

##### REST API说明：
REST，即Representational State Transfer的缩写，是目前最流行的一种互联网软件架构。它利用了Web的现有特征和能力， 能更好地使用现有Web标准中的一些准则和约束。

##### WebSocket API说明：
WebSocket 是 HTML5 开始提供的一种在单个 TCP 连接上进行全双工通讯的协议。WebSocket 使得客户端和服务器之间的数据交换变得更加简单，允许服务端主动向客户端推送数据。在 WebSocket API 中，浏览器和服务器只需要完成一次握手，两者之间就直接可以创建持久性的连接，并进行双向数据传输。

----

##### 访问地址：
* REST：https://api.ceobi.com/
* WebSocket：wss://api.ceobi.com/websocket

----

## API接口

#### REST接口：
* [获取全币种行情](#获取全币种行情)
* [行情](#行情)
* [委托记录](#委托记录)
* [历史成交](#历史成交)
* [K线](#K线)
* [所有交易对市场详情](#所有交易对市场详情)
* [交易对市场详情](#交易对市场详情)
* [Get symbol info](#Get-symbol-info) 
* [条件查询成交记录](#条件查询成交记录)
* [Trades](#Trades)
* [获取用户信息](#获取用户信息)
* [委托下单](#委托下单)
* [取消委托](#取消委托)
* [获取委托买单或卖单](#获取委托买单或卖单)
* [获取多个委托买单或卖单](#获取多个委托买单或卖单)
* [获取交易记录](#获取交易记录)
* [获取单个订单交易记录](#获取单个订单交易记录)
* [获取用户充值地址](#获取用户充值地址)
* [获取用户的数字币提现地址](#获取用户的数字币提现地址)
* [获取数字币提现记录](#获取数字币提现记录)
* [获取数字币充值记录](#获取数字币充值记录)
* [Response状态](#Response状态)
* [签名方式](#签名方式)
* [访问限制](#访问限制)

#### WebSocket接口：

* [Ws获取全部市场行情](#Ws获取全部市场行情)
* [Ws获取市场行情](#Ws获取市场行情)
* [Ws获取市场深度](#Ws获取市场深度)
* [Ws获取历史成交](#Ws获取历史成交)

---

## 接口详细

### **获取全币种行情**
*Request*
> Method: GET
>
> URL: api/market/allTicker
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": {
              "ceo_qc": { //市场名
                  "buy": "91.00000000",  //买一价
                  "sell": "91.50000000", //卖一价
                  "last": "90.00000000", //最新成交价
                  "vol": "0.00000000",   //成交量(最近的24小时)
                  "high": "0.00000000",  //最高价
                  "low": "0.00000000",   //最低价
                  "change": "0.10"       //涨跌幅
              },
              "eth_ceo": {
                  "buy": "52.18000000",
                  "sell": "53.30000000",
                  "last": "53.30000000",
                  "vol": "5.00000000",
                  "high": "53.30000000",
                  "low": "53.00000000",
                  "change": "0.10"
              },
              ......
}
```
*示例*

[java](#获取全币种行情-allTicker)

----
### **行情**
*Request*
> Method: GET
>
> URL: api/market/ticker
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:   | :-----:  |  :-----:  |  :-----:  |
> | market        | string   |  Y   |  市场名称   |
>
> api/market/ticker?market=ceo_qc
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": {
              "buy": "91.00000000",  //买一价
              "sell": "91.50000000", //卖一价
              "last": "90.00000000", //最新成交价
              "vol": "0.00000000",   //成交量(最近的24小时)
              "high": "0.00000000",  //最高价
              "low": "0.00000000",   //最低价
              "change": "0.10",      //涨跌幅
              "time": 1535012914     //时间
          }
}
```
*示例*

[java](#行情-ticker)

----
### **委托记录**
*Request*
> Method: GET
>
> URL: api/market/entrust
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:   | :-----:  |  :-----:  |  :-----:  |
> | market        | string   |  Y   |  市场名称   |
>
> api/market/entrust?market=ceo_qc
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": {
              "b": [ //买
                  [
                      "11.37",      //价格
                      "877.627331"  //数量
                  ],
                  [
                      "11.01",
                      "1018.843536"
                  ],
              ],
              "s": [ //卖
                  [
                      "70.00", //
                      "1000.000000"
                  ],
                  [
                      "60.00",
                      "1000.000000"
                  ]
          ]
}
```
*示例*

[java](#委托记录-entrust)

----
### **历史成交**
*Request*
> Method: GET
>
> URL: api/market/trades
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:   | :-----:  |  :-----:  |  :-----:  |
> | market        | string   |  Y   |  市场名称   |
>
> api/market/trades?market=bit_qc
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": [
              {
                  "amount": "5000.000000", //交易数量
                  "price": "0.400000",     //交易价格
                  "type": 2,               //交易类型，1(买)/2(卖)
                  "time": 1530144000       //交易时间(时间戳)
              },
              {
                  "amount": "5000.000000",
                  "price": "0.400000",
                  "type": 1,
                  "time": 1530144000
              },
              ......
          ]
}
```
*示例*

[java](#历史成交-trades)

----
### **K线**
*Request*
> Method: GET
>
> URL: api/market/kline
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> | market      | string   |  Y   |  市场名称   |
> | type        | string    |Y   |  时间   |
> | size        | int       | Y  |返回数据的条数限制(默认为1000，大于1000，只返回1000)|
>
> type 值为： 1min 3min 5min 15min 30min 1day 3day 1week 1hour 2hour 4hour 6hour 12hour
>
> api/market/kline?market=bit_qc&type=1week
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": {
              "sellCoin": "bit", //卖出货币
              "buyCoin": "qc", //买入货币
              "data": [
                  [
                      1518843600, //时间戳
                      "2550558.083140", //交易量
                      "1.322000", //开盘价
                      "1.396000", //最高价
                      "1.005000", //最低价
                      "1.031000" //收盘价
                  ],
              ......
          }
}
```
*示例*

[java](#K线-kline)

----
### **所有交易对市场详情**
*Request*
> Method: GET
>
> URL: api/market/allSymbol
>
> Parameters:
> 无
>
> api/market/allSymbol
>
*Response*

```html
{
    "code": 1000,
    "message": "成功",
    "data": [{
        "id": "usdt_qc",                                  //交易对名称；string；required: true  
        "baseCurrency": "usdt",                           //交易货币名称；string; required: true
        "quoteCurrency": "qc",                            //计价货币名称；string；required: true
        "quantityIncrement": "0.001",                     //数量精度；string；required: true
        "tickSize": "0.00001",                            //价格精度；string；required: true
        "takeLiquidityRate": "0.0012",                    //taker手续费率；string；
        "provideLiquidityRate": "0.0012",                 //maker手续费率；string；
        "feeCurrency": "qc"                               //手续费币种；string；        
    }]
}
```
*示例*

[java](#所有交易对市场详情-symbol)

----
### **交易对市场详情**
*Request*
> Method: GET
>
> URL: api/market/symbol/{symbol}
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> | symbol      | string   |  Y   |  市场名称   |
>
>
> api/market/symbol/usdt_qc
>
*Response*

```html
{
    "code": 1000,
    "message": "成功",
    "data": {
        "id": "usdt_qc",                                  //交易对名称；string；required: true  
        "baseCurrency": "usdt",                           //交易货币名称；string; required: true
        "quoteCurrency": "qc",                            //计价货币名称；string；required: true
        "quantityIncrement": "0.001",                     //数量精度；string；required: true
        "tickSize": "0.00001",                            //价格精度；string；required: true
        "takeLiquidityRate": "0.0012",                    //taker手续费率；string；
        "provideLiquidityRate": "0.0012",                 //maker手续费率；string；
        "feeCurrency": "qc"                               //手续费币种；string；        
    }
}
```
*示例*

[java](#市场详情-symbol)

----
### **Get-symbol-info**
*Request*
> Method: GET
>
> URL: api/market/symbol/{symbol}
>
> Parameters:
>
> | Parameters  | type   |  required   |  description   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> | symbol      | string   |  Y   |  trading symbol   |
>
>
> api/market/symbol/usdt_qc
>
*Response*

```html
{
    "code": 1000,
    "message": "成功",
    "data": {
        "id": "usdt_qc",                                  //The trading symbol
        "baseCurrency": "usdt",                           //The main trading currency for this symbol
        "quoteCurrency": "qc",                            //The secondary trading currency for this symbol
        "quantityIncrement": "0.001",                     //Quantitative accuracyAll quantities must be divisible by this number, and cannot be less than this number
        "tickSize": "0.00001",                            //Price accuracy，All prices must be divisible by this number, and cannot be less than this number
        "takeLiquidityRate": "0.0012",                    //The buy/sell trading fee for taker orders. Taker orders remove an item from the order books
        "provideLiquidityRate": "0.0012",                 //The buy/sell trading fee for maker orders. Maker orders add an item to the order books.
        "feeCurrency": "qc"                               //The currency in which fees are taken   
    }
}
```
*Demo*

[java](#市场详情-symbol)

----
### **条件查询成交记录**
*Request*
> Method: GET
>
> URL: api/market/trades/{symbol}
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> | symbol      | string   |  Y   |  市场名称   |
> | sort      | string   |  N   |  排序方式   DESC   ASC    默认 DESC |
> | by      | string   |  N   |  根据（ID/时间）排序  (id  timestamp)  默认 timestamp|
> | from      | string   |  N   |   如果by-ID;tradeid；;否则时间;string   |
> | till      | string   |  N   |   如果by-ID;tradeid；;否则时间;string   |
> | limit      | integer   |  N   |   获取数量，默认100；integer   |
> | offset      | integer   |  N   |  查询记录的起始索引  起始为0  |
>
> api/market/trades/usdt_qc?sort=asc&by=timestamp&from=1573434000&till=1573436000&limit=100&offset=0
>

*Response*

```html
{
    "code": 1000,
    "message": "成功",
    "data": [
         {
            "id": 3107340,
            "uuid": "3107340",
            "price": "0.00679",         //价格
            "quantity": "1.046987",     //数量
            "side": "sell",                  //buy 买   sell 卖
            "timestamp": "2019-11-08 13:28:49.0",   
            "unixtimestamp": 1573219729
          },
        ......
    ]
}
```
*示例*

[java](#条件查询成交记录-trades)

----
### **Trades**
*Request*
> Method: GET
>
> URL: api/market/trades/{symbol}
>
> Parameters:
>
> | Parameters  | type   |  required   |  description   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> | symbol      | string   |  Y   |  trading symbol  |
> | sort      | string   |  N   |  Sort direction   (DESC ASC)   Default value: DESC |
> | by      | string   |  N   |  Filter field  (id  timestamp)   Default value: timestamp|
> | from      | string   |  N   | If filter by timestamp, then datetime in iso format or timestamp in millisecond otherwise trade id   |
> | till      | string   |  N   | If filter by timestamp, then datetime in iso format or timestamp in millisecond otherwise trade id  |
> | limit      | integer   |  N   | Default 100. Minimum value 1, Maximum value 1000   Default value: 100   |
> | offset      | integer   |  N   | offset  Starting from 0|
>
> api/market/trades/usdt_qc?sort=asc&by=timestamp&from=1573434000&till=1573436000&limit=100&offset=0
>

*Response*

```html
{
    "code": 1000,
    "message": "成功",
    "data": [
         {
            "id": 3107340,                              //ID   long
            "uuid": "3107340",                          //UUID   Default ID
            "price": "0.00679",                         //price
            "quantity": "1.046987",                     //quantity
            "side": "sell",                             //buy or sell  
            "timestamp": "2019-11-08 13:28:49.0",       //timestamp
            "unixtimestamp": 1573219729                 //unixtimestamp
          },
        ......
    ]
}
```
*Demo*

[java](#条件查询成交记录-trades)

----
### **获取用户信息**
*Request*
> Method: GET
>
> URL: api/deal/accountInfo
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 accountInfo|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
>
> api/deal/accountInfo?accesskey=519b3346-7198-47e3-81b8-20ce13513835&method=accountInfo&
> sign=3967426b6a1aaa3f26a2c7b382a50621&reqTime=1535102429
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": {
              "base": {
                  "auth_google_enabled": false, //是否开通谷歌验证
                  "auth_mobile_enabled": true, //是否开通手机验证
                  "trade_password_enabled": true, //是否开通交易密码
                  "username": "test" //用户名
              },
              "coins": [
                  {
                      "enName": "btc", //币种英文名
                      "cnName": "比特币", //币种中文名
                      "symbol": "฿", //币种符号
                      "available": "86114.16208700", //可用资产
                      "freez": "0.00000000", //冻结资产
                      "unitDecimal": "2", //保留小数位
                      "isCanRecharge": true, //是否可充值
                      "isCanWithdraw": true //是否可提现
                  },
              ......
              ]
          }
}
```
*示例*

[java](#获取用户信息-accountInfo)

----
### **委托下单**
*Request*
> Method: GET
>
> URL: api/deal/order
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 order|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |price|	float	|Y|	单价|
> |amount|	float	|Y	|交易数量|
> |tradeType|	int	|Y	|交易类型1/2[买/卖]|
> |currency	|string|	Y|	市场名字|
>
> api/deal/order?accesskey=519b3346-7198-47e3-81b8-20ce13513835&method=order&
> sign=f7169edac202a776b87811661817aeeb&reqTime=1535102429&price=60000&amount=0.113&tradeType=1&currency=btc_qc
>
*Response*

```html
{
              "code": 1000,
              "message": "委托挂单成功",
              "data": {
                  "orderId": "643" //订单ID
              }
}
```
*示例*

[java](#委托下单-order)

----
### **取消委托**
*Request*
> Method: GET
>
> URL: api/deal/cancelOrder
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 cancelOrder|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |currency	|string|	Y|	市场名字|
> |id|	int	|Y|	订单ID|
>
> api/deal/cancelOrder?accesskey=519b3346-7198-47e3-81b8-20ce13513835&method=cancelOrder&
> sign=1cb2d3c0d1fd708abb7eda37770172b5&reqTime=1535102429&id=626&currency=btc_qc
>
*Response*

```html
{
          "code": 1000,
          "message": "撤销成功",
          "data": ""
}
```
*示例*

[java](#取消委托-cancelOrder)

----
### **获取委托买单或卖单**
*Request*
> Method: GET
>
> URL: api/deal/getOrder
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 getOrder|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |currency	|string|	Y|	市场名字|
> |id|	int	|Y|	订单ID|
>
> api/deal/getOrder?accesskey=519b3346-7198-47e3-81b8-20ce13513835&method=getOrder&
> sign=d712dfa60eaf5bc4053ebcd4af5ec253&reqTime=1535102429&id=626&currency=btc_qc
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": {
              "currency": "btc_qc", //市场
              "id": 626, //委托挂单号
              "price": "60000.000000", //单价
              "status": 2, ////挂单状态 (状态(0:交易中,1:已完成,2:已撤销, 3:部分成交))
              "total_amount": "0.113000", //挂单总数量
              "trade_amount": "0.000000", //已成交数量
              "trade_time": 1534301098, //委托时间
              "trade_money": "6793.560000", //总交易金额
              "type": 1 //挂单类型 1/2[buy/sell]
              "deal_money": "15.560000", //实际成交金额
          }
}
```
*示例*

[java](#获取委托买单或卖单-getOrder)

----
### **获取多个委托买单或卖单**
*Request*
> Method: GET
>
> URL: api/deal/getOrders
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 getOrders|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |currency	|string|	Y|	市场名字|
> |pageIndex|	int	|Y|	当前页数|
> |pageSize	|int	|Y	|每页数量 10-100|
> |tradeType|	int	|N|	交易类型1/2[buy/sell]|
> |tradeStatus|	int|	N|	交易状态 0:交易中,1:已完成,2:已撤销,3:部分成交,4:合并1与3|
>
> api/deal/getOrders?accesskey=519b3346-7198-47e3-81b8-20ce13513835&method=getOrders&
>sign=6ed7b69018b4c151b2cf77f531a655a0&reqTime=1535102429&currency=btc_qc&pageIndex=1&pageSize=10&tradeStatus=1
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": [
              {
                  "currency": "btc_qc", //市场
                  "id": 631, //委托挂单号
                  "price": "60000.000000", //单价
                  "status": 0, //挂单状态 (状态(0:交易中,1:已完成,2:已撤销, 3:部分成交))
                  "total_amount": "0.113000", //挂单总数量
                  "trade_amount": "0.000000", //已成交数量
                  "trade_date": 1535162354, //委托时间
                  "trade_money": "6793.560000", //总交易金额
                  "type": 1 //挂单类型 1/2[buy/sell]
              },
              ......
          ]
}
```
*示例*

[java](#获取多个委托买单或卖单-getOrders)

----
### **获取交易记录**
*Request*
> Method: GET
>
> URL: api/deal/getTrades
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 getTrades|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |currency	|string|	Y|	市场名字|
> |pageIndex|	int	|Y|	当前页数|
> |pageSize|	int	|Y|	每页数量 10-100|
> |orderId	|int|	Y	|订单编号|
> |startTime|	int|	Y|	开始时间毫秒数|
> |endTime	|int	|Y|	结束时间毫秒数|
>
> api/deal/getTrades?accesskey=f11c8358-9b30-4a5c-9c2d-906e4adb71d0&method=getTrades&
> sign=6ed7b69018b4c151b2cf77f531a655a0&reqTime=1535102429&pageIndex=1&currency=ceo_qc&
> pageSize=10&orderId=16&startTime=1566355654&endTime=1566371318
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": [
              {
                  "currency": "ceo_qc", //市场
                  "id": 571, //交易id
                  "price": "36.000000", //单价
                  "amount": "0.261040", //交易量
                  "type": 1, //交易类型 1/2[buy/sell]
                  "date": 1538276466, //时间
                  "fee": "0.000210" //手续费
              }
          ]
}
```
*示例*

[java](#获取交易记录-getTrades)


----
### **获取单个订单交易记录**
*Request*
> Method: GET
>
> URL: api/deal/tradeLog
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 tradeLog|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |orderId	|long|	Y|	订单ID|
>
> api/deal/getTrades?accesskey=f11c8358-9b30-4a5c-9c2d-906e4adb71d0&method=tradeLog&
> sign=6ed7b69018b4c151b2cf77f531a655a0&reqTime=1535102429&orderId=1
>
*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": [
              {
                  "currency": "ceo_qc", //市场
                  "id": 571, //交易id
                  "price": "36.000000", //单价
                  "amount": "0.261040", //交易量
                  "type": 1, //交易类型 1/2[buy/sell]
                  "date": 1538276466, //时间
                  "fee": "0.000210" //手续费
              }
          ]
}
```
*示例*

[java](#单个订单交易记录-tradeLog)

----
### **获取用户充值地址**
*Request*
> Method: GET
>
> URL: api/deal/getUserAddress
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 getUserAddress|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |currency	|string|	Y|	币名|
>
> api/deal/getUserAddress?accesskey=519b3346-7198-47e3-81b8-20ce13513835&method=getUserAddress&
> sign=469595363c7a04a9b1f693273397cbc0&reqTime=1535102429&currency=gxs
>

*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": {
              "address": "qqfewfew", //地址
              "memo": "99" //备注
          }
}
```
*示例*

[java](#获取用户充值地址-getUserAddress)

----
### **获取用户的数字币提现地址**
*Request*
> Method: GET
>
> URL: api/deal/getWithdrawAddress
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 getWithdrawAddress|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |currency	|string|	Y|	币名|
>
> api/deal/getWithdrawAddress?accesskey=519b3346-7198-47e3-81b8-20ce13513835&method=getWithdrawAddress&
> sign=620f6c274e4dd0e9cd8312a8765f2c17&reqTime=1535102429&currency=btc
>

*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": [
              "1DZdA2WAzcsSak3tQYRVwuXWeSqhLuVCoA",
              "1DZdA2WAzcsSak3tQYRVwuXWeSqhLuVCoc"
          ]
}
```
*示例*

[java](#获取用户的数字币提现地址-getWithdrawAddress)

----
### **获取数字币提现记录**
*Request*
> Method: GET
>
> URL: api/deal/getWithdrawRecord
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 getWithdrawRecord|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |currency	|string|	Y|	币名|
> |pageIndex|	int|	Y|	当前页数|
> |pageSize|	int	|Y	|每页数量|
>
> api/deal/getWithdrawRecord?accesskey=519b3346-7198-47e3-81b8-20ce13513835&method=getWithdrawRecord&
> sign=0e94e185a41dcf339491bd4c6c958dea&reqTime=1535102429&currency=btc&pageIndex=1&pageSize=10
>

*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": {
              "pageIndex": 1, //当前页数
              "pageSize": 10, //每页数量
              "totalCount": 7, //总数量
              "totalPage": 1, //总页数
              "list": [
                  {
                      "amount": "5.00000000", //提现金额
                      "fees": "0.00150000", //提现手续费
                      "id": 165558, //提现记录id
                      "manageTime": 0, //提现处理的时间的时间戳
                      "status": 0, //提币状态状态（0：等待处理；1：转出成功；2：已经审核；3：已经撤销）
                      "submitTime": 1534920264, //提现发起的时间的时间戳
                      "toAddress": "1DZdA2WAzcsSak3tQYRVwuXWeSqhLuVCoc" //提现的接收地址
                  },
                  ......
              ]
          }
}
```
*示例*

[java](#获取数字币提现记录-getWithdrawRecord)

----
### **获取数字币充值记录**
*Request*
> Method: GET
>
> URL: api/deal/getChargeRecord
>
> Parameters:
>
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |accesskey	   |   string	   |Y      |	accesskey    |
> |method	|string|	Y|	直接赋值 getChargeRecord|
> |reqTime|	int	|Y|	当前时间秒数|
> |sign	|string	|Y|	签名串|
> |currency	|string|	Y|	币名|
> |pageIndex|	int|	Y|	当前页数|
> |pageSize|	int	|Y	|每页数量|
>
> api/deal/getChargeRecord?accesskey=519b3346-7198-47e3-81b8-20ce13513835&method=getChargeRecord&
> sign=538b6d053c32cd83f97fd2cfadfb7f31&reqTime=1535102429&currency=eth&pageIndex=1&pageSize=10
>

*Response*

```html
{
          "code": 1000,
          "message": "成功",
          "data": {
              "pageIndex": 1, //当前页数
              "pageSize": 10, //每页数量
              "totalCount": 2, //总数量
              "totalPage": 1, //总页数
              "list": [
                  {
                      "address": "0x5de61aec70dc1654456f75aa964daf754d2a7f30",
                      "amount": "0.01050000",
                      "confirmTimes": 3,
                      "currency": "ETH",
                      "hash": "0x84d073ef430e53e5b21bb35831b135ce217a69efbadddc187b9380fa3fdd5a3b",
                      "id": 19813,
                      "status": 1,
                      "submit_time": 1511961018,
                      "type": "站外"
                  },
                  {
                      "address": "0x5de61aec70dc1654456f75aa964daf754d2a7f30",
                      "amount": "5.00000000",
                      "confirmTimes": 0,
                      "currency": "ETH",
                      "hash": "",
                      "id": 15,
                      "status": 1,
                      "submit_time": 1507882027,
                      "type": "系统充值"
                  }
              ]
          }
}
```
*示例*

[java](#获取数字币充值记录-getChargeRecord)

----
### **Response状态**
> 1000; //成功
>
> 1001; //一般错误
>
> 1002; //内部错误
>
> 1003; //验证不通过
>
> 1004; //网站维护中
>
> 1005;// API接口维护中
>
> 1006; //权限不足
>
> 1007; //无效的参数
>
> 1008; //无效的IP或与绑定的IP不一致
----
### **签名方式**
>请求参数按照ASCII值排序，然后通过hmac MD5加密
>
*javascript*
```javascript
    function sign(params, secretKey) {
            if (typeof params != 'object') {
                throw Error('参数必须为对象')
            }
            let preSign = [];
            for (let key of Object.keys(params).sort()) {
                preSign.push(key+'='+params[key]);
            }
            return CryptoJS.HmacMD5(preSign.join('&'), secretKey).toString();
    }
```
*php*
```php
    function sign(array $params, $secretKey)
    {
        ksort($params);
        $preSign = http_build_query($params, '', '&');
        $sign = hash_hmac('md5', $preSign, $secretKey);
        return $sign;
    }
```
*java*
> 代码库中 SignUtil.java
```java
    public static String sign(Map<String, String> paramMap, String secret) throws Exception {
        StringBuilder sb = new StringBuilder();
        TreeMap<String, String> params = new TreeMap<>();
        params.putAll(paramMap);
        params.entrySet()
                .forEach(entry -> {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(entry.getKey()).append("=");
                    sb.append(entry.getValue());
                });
        return sign(sb.toString(), secret);
    }

    public static String convertStr(Map<String, String> paramMap){
        StringBuilder sb = new StringBuilder();
        TreeMap<String, String> params = new TreeMap<>();
        params.putAll(paramMap);
        params.entrySet()
                .forEach(entry -> {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(entry.getKey()).append("=");
                    sb.append(entry.getValue());
                });
        return sb.toString();
    }

    public static String sign(String paramString, String secretKey) throws Exception {
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacMD5");
        String actualSignature = "";
        try {
            actualSignature = Hex.encodeHexString(encodeHmacMD5(paramString.getBytes("UTF-8"), secret_key));
        } catch (UnsupportedEncodingException e) {
            throw new Exception("验签加密失败!");
        }
        return actualSignature;
    }


    /**
     * 根据给定密钥生成算法创建密钥
     *
     * @param algorithm 密钥算法
     * @return 密钥
     * @throws RuntimeException 当 {@link NoSuchAlgorithmException} 发生时
     */
    private static byte[] getHmacKey(String algorithm) {
        //初始化KeyGenerator
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
        //产生密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //获得密钥
        return secretKey.getEncoded();
    }

    /**
     * 使用HmacMD5消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    private static byte[] encodeHmacMD5(byte[] data, Key key) {
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacMD5");
            mac.init(key);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return new byte[0];
        }
        return mac.doFinal(data);
    }

```
>
*postman 交易API测试*
> Params
>
> | 参数名        |     值      |
> | :--------:  | :-----:   |
> |reqTime|{{sign}}	|
> |sign	|{{reqTime}}|
>
*Pre-request Script*
```javascript
    function signfn(params, secretKey) {
        let preSign = [];
        for (let key of Object.keys(params).sort()) {
            if (key == 'sign') {
                console.log(params[key]);
            }
            if (key === 'sign' || params[key] === '') {
                continue;
            }
            preSign.push(key+'='+params[key]);
        }
        return CryptoJS.HmacMD5(preSign.join('&'), secretKey).toString();
    }

    let now = Math.floor(Date.now());
    pm.globals.set("reqTime",  now);
    let query = {};
    pm.request.url.query.all().forEach((param) => { query[param.key] = param.value});
    query.reqTime = now;
    pm.globals.set("sign",  signfn(query, '8d06dae1-72ef-4d9c-82ca-5210b1a1dc48'));
```
----
### **访问限制**

>单个IP限制每分钟3000次访问
>
>交易API单个用户限制每秒钟50次访问
----
### **Ws获取全部市场行情**
*Request*
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |event	|string|	Y	|addChannel|
> |channel|	string|	Y	|all_ticker|
>
*Response*

```html
        {
             "channel": "all_ticker",
             "date": "1472800466093",
             "data":
             {
                 "ceo_qc": { //  市场名
                     "buy": "91.00000000", //  买一价
                     "sell": "91.50000000", //  卖一价
                     "last": "90.00000000", //  最新成交价
                     "vol": "0.00000000", //  成交量(最近的24小时)
                     "high": "0.00000000", //  最高价
                     "low": "0.00000000", //  最低价
                     "change": "0.10"     //涨跌幅
                 },
                 "eth_ceo": {
                     "buy": "52.18000000",
                     "sell": "53.30000000",
                     "last": "53.30000000",
                     "vol": "5.00000000",
                     "high": "53.30000000",
                     "low": "53.00000000",
                     "change": "0.10"     
                 },
                 ......
             }
         }
```
----
### **Ws获取市场行情**
*Request*
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |event	|string|	Y	|addChannel|
> |channel|	string|	Y	|ceo_qc_ticker|
>
*Response*

```html
      {
            "channel": "ceo_qc_ticker",
            "date": "1472800466093",
            "ticker":
            {
                "buy": "91.00000000", //  市场名
                "sell": "91.50000000", //  买一价
                "last": "90.00000000", //  卖一价
                "vol": "0.00000000", //  最新成交价
                "high": "0.00000000", //  成交量(最近的24小时)
                "low": "0.00000000", //  最高价
                "change": "0.10"     //涨跌幅
            }
        }
```
----
### **Ws获取市场深度**
*Request*
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |event	|string|	Y	|addChannel|
> |channel|	string|	Y	|ceo_qc_order|
>
*Response*

```html
      {
           "date" : 1567582150426 ,
           "b": [ // 买
               [
                   "11.37", //  价格
                   "877.627331" //  数量
               ],
               [
                   "11.37"
                   "877.627331"
               ],
               ......
           ],
           "s":[ // 卖
               [
                   "11.37"
                   "877.627331"
               ],
               [
                   "11.37",
                   "877.627331"
               ],
               ......
           ],
           "channel": "ceo_qc_order"
       }
```
----
### **Ws获取历史成交**
*Request*
> | 参数        | 类型   |  必填   |  描述   |
> | :--------:  | :-----:  |  :-----:  |  :-----:  |
> |event	|string|	Y	|addChannel|
> |channel|	string|	Y	|ceo_qc_trade|
>
*Response*

```html
       {
            "date" : 1567582150426 ,
            "data": [
                {   
                    "id": 1,
                    "amount": "5000.000000", //  交易数量
                    "price": "0.400000", //  交易价格
                    "type": 2, //  交易类型，1(买)/2(卖)
                    "time": 1530144000 //  交易时间(时间戳)
                },
                ......
            ],
            "channel": "ceo_qc_trade"
        }
```
----

 #### 接口示例

```java
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
    //获取交易对市场详情
    public static final String PUB_MARKET_symbol = HOST + "/api/market/symbol/%s";
    //条件查询成交记录
    public static final String PUB_MARKET_trades2 = HOST + "/api/market/trades/%s";

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
```
> ###### 获取全币种行情-allTicker
```java
  public void allTicker() throws Exception {
      URL url = new URL(PUB_MARKET_allTicker);
      URLConnection urlConnection = url.openConnection();
      urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
      InputStream inputStream = urlConnection.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      bufferedReader.lines().forEach(e -> System.out.print(e));
  }
```
> ###### 行情-ticker
```java
  public void ticker() throws Exception {
      String connUrl = PUB_MARKET_ticker + "?market=ceo_qc";
      URL url = new URL(connUrl);
      URLConnection urlConnection = url.openConnection();
      urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
      InputStream inputStream = urlConnection.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      bufferedReader.lines().forEach(e -> System.out.print(e));
  }
```
> ###### 委托记录-entrust
```java
    public void entrust() throws Exception {
        String connUrl = PUB_MARKET_entrust + "?market=ceo_qc";
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }
```
> ###### 历史成交-trades
```java
    public void trades() throws Exception {
        String connUrl = PUB_MARKET_trades + "?market=ceo_qc";
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }
```
> ###### K线-kline
```java
    public void kline() throws Exception {
        String connUrl = PUB_MARKET_kline + "?market=ceo_qc&type=1min";
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }
```
> ###### 所有交易对市场详情-symbol
```java
    /**
     * 获取所有交易对详情
     * @throws Exception
     */
    public void allSymbol() throws Exception {
        String connUrl = PUB_MARKET_allSymbol;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }
 ```

> ###### 市场详情-symbol
```java
    public void symbol() throws Exception {
        String symbol = "usdt_qc";
        String connUrl = String.format(PUB_MARKET_symbol, symbol);
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }
```
> ###### 条件查询成交记录-trades
```java
    public void trades2() throws Exception {
        String symbol = "usdt_qc";
        String connUrl = String.format(PUB_MARKET_trades2, symbol) + "?sort=asc&by=timestamp&from=1573434000&till=1573436000&limit=100&offset=0";
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }
```
> ###### 获取用户信息-accountInfo
```java
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
```
> ###### 委托下单-order
```java
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
```
> ###### 取消委托-cancelOrder
```java
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
```
> ###### 获取委托买单或卖单-getOrder
```java
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
```
> ###### 获取多个委托买单或卖单-getOrders
```java
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
```
> ###### 获取交易记录-getTrades
```java
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
```
> ###### 单个订单交易记录-tradeLog
```java
    public void getTradeLog() throws Exception{
        Map<String, String> params = new HashMap<>();
        params.put("accesskey", ACCESS_KEY);
        params.put("method", "getTrades");
        params.put("reqTime", System.currentTimeMillis()+"");
        params.put("orderId", "1");
        String sign = SignUtil.sign(params, SECRET_KEY);
        params.put("sign", sign);
        String paramsStr = SignUtil.convertStr(params);
        String connUrl = PRI_DEAL_tradeLog + "?"+ paramsStr;
        URL url = new URL(connUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(e -> System.out.print(e));
    }
```

> ###### 获取用户充值地址-getUserAddress
```java
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
```
> ###### 获取用户的数字币提现地址-getWithdrawAddress
```java
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
```
> ###### 获取数字币提现记录-getWithdrawRecord
```java
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
```
> ###### 获取数字币充值记录-getChargeRecord
```java
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
```
