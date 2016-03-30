package org.sample.client;

import java.awt.List;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class CustomClient implements CustomClientObserver {

	boolean isMessageRecieved;

	public static void main(String[] args) throws Exception {
		CustomClient customClient = new CustomClient();
		MyClient myClient = new MyClient();
		myClient.addClient(customClient);

		customClient.connect("asdf");
	}

	private void connect(String text) throws Exception {

		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		// String uri = "ws://localhost:8080/websocket-client/websocket";
		String uri = "ws://localhost:8080/endpoint/websocket";
		Session session = container.connectToServer(MyClient.class, URI.create(uri));
		System.out.println("starts "+new Date());
		sendMessage(session, text);
		System.out.println("ends "+new Date());
		session.getAsyncRemote().sendText("asdf ");
	}

	public void sendMessage(Session session, String text) {
		try {
			session.getBasicRemote().sendText(text);

			while (!isMessageRecieved) {
				System.out.print("-");
			}

		} catch (IOException ex) {
			Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void updateStatus() {
		isMessageRecieved = true;
	}

}
