package WebSocket;

import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/test")
public class CustomEndpoint extends Endpoint {
    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig){}
    @OnClose
    public void onClose(Session session, CloseReason reason){}
    @OnMessage
    public void onMessage(Session session, String message){}
    @OnError
    public void onError(Session session, Throwable throwable){}

}
