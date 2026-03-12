//package example.종합.예제10.board.controller;
//import example.종합.예제10.board.dto.ReplyDto;
//import example.종합.예제10.board.service.ReplyService;
//import example.종합.예제10.board.service.ReplyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class ReplyController {
//    @Autowired
//    private ReplyService replyService;
//
//    // *****************************
//    // 1. 댓글 등록
//    @PostMapping("/reply")
//    public boolean 댓글등록(@RequestBody ReplyDto replyDto){
//        boolean result = replyService.댓글등록(replyDto);
//        return result;
//    }
//
//    // 2. 댓글 전체 조회
//    @GetMapping("/reply")
//    public List<ReplyDto> replyList(@RequestParam int bno){
//        return replyService.(bno);
//
//    }
//
//}
