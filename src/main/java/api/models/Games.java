package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Games {

    public int id;

    public String key;
    public String title;
    public String description;
    public String content;
    public String taskKey;
    public String iconUrl;
    public String coverUrl;
    public String pictureUrl;
    public String appCoverUrl;
    public String videoUrl;
    public String status;
    public String visibilityStatus;

    public Object appId;
}
