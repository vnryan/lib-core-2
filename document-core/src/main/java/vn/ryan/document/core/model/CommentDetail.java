package vn.ryan.document.core.model;

import lombok.Data;
import vn.ryan.core.constants.ReactType;

@Data
public class CommentDetail {
    private String commentId;
    private ReactType reactType;
}
