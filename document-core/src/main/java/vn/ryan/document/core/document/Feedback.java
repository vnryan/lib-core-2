package vn.ryan.document.core.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.ryan.core.constants.FeedBackType;
import vn.ryan.document.core.model.FeedbackDetail;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "feed_back")
public class Feedback extends BaseDocument{
    private String userName;
    private FeedBackType type;
    private FeedbackDetail detail;
}
