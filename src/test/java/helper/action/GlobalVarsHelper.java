package helper.action;

public class GlobalVarsHelper {

    private static GlobalVarsHelper ourInstance = new GlobalVarsHelper();
    private String URL;
    private String responseheaderAuthorisationCode;
    private boolean useAuthcode = false;
    private String candidateUrl;

    private GlobalVarsHelper() {
    }

    public static GlobalVarsHelper getInstance() {
        return ourInstance;

    }

    public String getResponseheaderAuthorisationCode() {
        return responseheaderAuthorisationCode;

    }

    public void setResponseheaderAuthorisationCode(String authCode) {
        this.responseheaderAuthorisationCode = authCode;

    }

    public String getURL() {
        return URL;

    }

    public void setURL(String URL) {
        this.URL = URL;

    }

    public String getCandidateURL() {
        return candidateUrl;

    }

    public void setCandidateURL(String URL) {
        candidateUrl = URL;

    }

    public boolean isUseAuthcode() {
        return useAuthcode;

    }

    public void setUseAuthcode(boolean useAuthcode) {
        this.useAuthcode = useAuthcode;

    }
}
