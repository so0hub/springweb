package example.day05.practice5;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CRUDDto {
    private Integer bno;
    private String bid;
    private String bname;
    private String bauthor;
    private String bpublisher;
}
