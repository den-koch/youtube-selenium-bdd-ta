package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTestData {
    private Integer videoPosition;
    private String searchRequest;
    private String subscribeButtonText;
}
