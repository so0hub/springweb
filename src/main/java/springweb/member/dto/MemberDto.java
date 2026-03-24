package springweb.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.member.entity.MemberEntity;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class MemberDto {
    private Long mno; // 회원번호
    private String mid; // 회원아이디
    private String mpwd; // 회원비밀번호
    private String mname; // 회원닉네임

    // + BaseTime 멤버변수
    private String createDate;
    private String updateDate;


    // + DTO --> ENTITY ,    주로 저장/수정
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mid(mid)
                .mpwd(mpwd)
                .mname(mname)
                .build();
    }
}
