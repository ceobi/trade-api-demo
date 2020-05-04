package com.ceo.apidemo.apidemo.wsclient.demo1;

public class ClientTest {

	public static String serverUrl = "wss://api.ceoex.com/websocket";

	public static void main(String[] args) {


		try {
			DemoWebSocketClient client = new DemoWebSocketClient(serverUrl, "name_test");

			client.addListener(new IOpenListener() {
				@Override
				public void onOpen() {
					client.subscribe("all_ticker");
					client.subscribe("ceo_qc_ticker");
				}
			});

			client.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}