package example.day11.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity // JPA 해당 엔티티를 테이블 매핑
@Table( name = "category") // 테이블명 정의
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor // 롬복
public class CategoryEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno; // 카테고리 번호(pk)

    @Column(nullable = false, length = 100, unique = true)
    private String cname; // 카테고리명

    // 양방향 관계 : 카테고리 1개에는 여러개의 할일이 포함된다.
    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    private List<TodoEntity> todoList = new ArrayList<>();

}