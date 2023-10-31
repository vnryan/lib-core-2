package vn.ryan.document.core.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.ryan.document.core.model.CommentBankContent;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comment_bank")
public class CommentBank extends BaseDocument {
    private Integer group;
    private Integer grade;
    private String time;
    private CommentBankContent content;
}
