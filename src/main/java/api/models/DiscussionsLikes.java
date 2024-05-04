package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscussionsLikes {

    private int id;
    private int userDiscussionInfo;

    private Likes likes;

    private String type;

    private double rating;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Likes {

        private int count;
        private int status;
    }
}
