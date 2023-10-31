package vn.ryan.core.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity<T> {
    private Integer errorCode = 0;
    private String message = "";
    private T data;
}
