package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InternshipInfo {

    public int id;

    public Users user;

    public String key;
    public String title;
    public String type;
    public String description;
    public String content;
    public String visibilityStatus;
    public String language;
}
