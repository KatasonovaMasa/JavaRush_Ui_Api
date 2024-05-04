package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostsApi {

    public String code;
    public String message;
    public String recommendation;

    public Object developerMessage;
    public Object moreInfoUrl;
    public Object premiumRequired;
}
