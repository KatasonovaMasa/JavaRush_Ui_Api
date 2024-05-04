package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsActivities {

    public int id;

    public long time;

    public String type;
    public String title;
    public String description;

    public Users user;
}
