package vn.ryan.document.core.document;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@Data
public class BaseDocument {
    @Id
    private String id;
    @Indexed
    @CreatedDate
    private Date createdAt;
    @Indexed
    @LastModifiedDate
    private Date updatedAt;
}
