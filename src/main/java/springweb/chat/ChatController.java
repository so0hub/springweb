package springweb.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller // RestController 사용하지 않은 이유 : HTTP 응답이 아니라서
public class ChatController {

    // @GetMapping // HTTP 요청이 아니라서 XXXMapping 하지 않는다.
    @MessageMapping("/chat") // 클라이언트가 서버에게 메시지를 보낸 주소 매핑 , 클라이언트 --->
    // @ResponseBody // HTTP 응답이 아니어서 하지 않는다.
    @SendTo("/topic/message") // 서버가 연동(구독)된 클라이언트들에게 메시지 응답 주소 매핑 , 클라이언트 <--- 서버


    // DTO : 속성들을 미리 구성한 구조 , MAP : 미리구성하는게 아님. 속성들을 직접 구조
    public Map<String,Object> sendMessage( Map<String,Object> message ){
        System.out.println("message = " + message); // soutp
        System.out.println("ChatController.sendMessage"); // soutm

        return message;
    }

}
