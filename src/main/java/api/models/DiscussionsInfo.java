package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscussionsInfo {

    private int discussionId;

    private String discussionType;
    private String originalTitle;
    private String originalDescription;
    private String originalPictureUrl;
    private String originalPageUrl;
    private String title;
    private String description;
    private String ogTitle;
    private String ogDescription;
    private String ogPageUrl;
    private String ogPictureUrl;
}
