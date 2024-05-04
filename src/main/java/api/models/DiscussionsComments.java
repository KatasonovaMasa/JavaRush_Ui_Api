package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscussionsComments {

    public int id;

    public long time;

    public String message;
    public String answerTo;
    public String status;
    public String visibilityStatus;
    public String parentCommentId;
    public String childrenComments;

    private Owner owner;

    private Attributes attributes;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Owner {

        public int id;
        public int userId;
        public int level;
        public int rating;

        public String key;
        public String displayName;
        public String positionJob;
        public String country;
        public String city;
        public String publicStatus;
        public String badge;

        public Object publicStatusMessage;
        public Object isFriend;
        public Object subscription;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Likes {

        public int count;

        public Object status;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Attributes {

        public boolean answerUseful;
    }
}
