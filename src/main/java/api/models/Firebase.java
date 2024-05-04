package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Firebase {

    public String apiKey;
    public String authDomain;
    public String databaseURL;
    public String projectId;
    public String storageBucket;
    public String messagingSenderId;
    public String appId;
    public String measurementId;
}
