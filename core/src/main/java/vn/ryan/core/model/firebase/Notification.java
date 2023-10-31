package vn.ryan.core.model.firebase;

import lombok.Data;

@Data
public class Notification {
    private String title;
    private String body;
    private String sound = "default";
}
