package WebSocket;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Message {
    private String content;
    private String source;
    private Date date;
}
