package vn.ryan.document.core.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.ryan.core.constants.MessageType;
import vn.ryan.document.core.model.CommentDetail;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "comment_message")
public class CommentMessage extends BaseDocument {
    private MessageType type;
    private String content;
    private String sender;
    private String phone;
    private String userName;
    private String avatar;
    private Long videoTime;
    private Long userId;
    private String liveClassUuid;
    private List<CommentDetail> detail;
}
