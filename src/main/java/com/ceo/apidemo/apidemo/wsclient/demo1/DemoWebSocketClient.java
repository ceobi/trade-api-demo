package com.ceo.apidemo.apidemo.wsclient.demo1;

import com.alibaba.fastjson.JSONObject;
import com.ceo.apidemo.apidemo.wsclient.SubscribeReq;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

/**
 * websocket连接方式
 */
public class DemoWebSocketClient extends WebSocketClient {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String name;

    private Set<IOpenListener> listeners = new HashSet<>();

    public void addListener(IOpenListener listener){
        listeners.add(listener);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public DemoWebSocketClient(String url) throws URISyntaxException {
        super(new URI(url));
    }
    public DemoWebSocketClient(String url, String name) throws URISyntaxException {
        super(new URI(url));
        this.name = name;
    }

    @Override
    public void onOpen(ServerHandshake shake) {
        logger.info(name +"=>已连接");

        listeners.forEach(listener -> {
            listener.onOpen();
        });

    }

    @Override
    public void onMessage(String paramString) {
        logger.info(name + "=>接收到消息："+paramString);
    }

    @Override
    public void onClose(int paramInt, String paramString, boolean paramBoolean) {
        logger.info(name + "=>连接断开.{}， {}，{}；", paramInt, paramString, paramBoolean);
    }

    @Override
    public void onError(Exception e) {

    }

    public void subscribe(String chil) {
        SubscribeReq req = new SubscribeReq();
        req.setChannel(chil);
        req.setEvent("addChannel");
        this.send(JSONObject.toJSONString(req));
    }
    public void unsubscribe(String chil) {
        SubscribeReq req = new SubscribeReq();
        req.setChannel(chil);
        req.setEvent("removeChannel");
        this.send(JSONObject.toJSONString(req));
    }

}
