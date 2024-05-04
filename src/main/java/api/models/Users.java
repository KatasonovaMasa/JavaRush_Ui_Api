package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {

    private int id;
    private int userId;
    private int level;
    private int rating;

    private String key;
    private String pictureUrl;
    private String displayName;
    private String position;
    private String job;
    private String country;
    private String city;
    private String publicStatus;

    public boolean isFriend;

    public Object publicStatusMessage;
    public Object subscription;
    public Object badge;
}
