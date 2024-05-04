package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

    public String applicationId;
    public String brandName;
    public String applicationEnvironment;
    public String defaultLanguage;
    public String serverName;
    public String serverUrl;
    public String cdnUrl;
    public String websocketUrl;
    public String recaptchaKey;
    public String gtmKey;
    public String intercomAppId;

    public ArrayList<String> supportedLanguages;
    public ArrayList<String> disabledFeatures;
    public ArrayList<String> supportedPaymentSystems;
    public ArrayList<String> accountsSocialNetworks;
    public ArrayList<String> sharingSocialNetworks;
}
