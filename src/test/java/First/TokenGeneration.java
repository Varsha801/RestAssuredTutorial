package First;

import io.restassured.RestAssured;
import io.restassured.response.Response;
 
import java.time.Instant;
 
public class TokenGeneration {
 
    private static String accessToken;
    private static Instant tokenExpiryTime;
    static Response response;
    static int expiresIn;
    private static final long TOKEN_EXPIRY_BUFFER_SECONDS = 60;
 
    // Method to obtain initial token
    public static String getAccessToken() {
        if (accessToken == null || isTokenExpired()) {
            refreshAccessToken();
        }
        return accessToken;
    }
 
    // Method to check if the token is expired
    private static boolean isTokenExpired() {
        return tokenExpiryTime == null || Instant.now().isAfter(tokenExpiryTime.minusSeconds(TOKEN_EXPIRY_BUFFER_SECONDS));
    }
 
    // Method to refresh token
    private static void refreshAccessToken() {
            response = RestAssured.given()
            .contentType("application/x-www-form-urlencoded")
            .formParam("grant_type", "client_credentials")
            .formParam("client_id", "your-client-id")
            .formParam("client_secret", "your-client-secret")
            .post("https://your-auth-server.com/oauth/token");
 
        accessToken = response.jsonPath().getString("access_token");
        expiresIn = response.jsonPath().getInt("expires_in");
        tokenExpiryTime = Instant.now().plusSeconds(expiresIn);
 
        System.out.println("Access Token: " + accessToken);
        System.out.println("Token Expiry Time: " + tokenExpiryTime);
    }
}
