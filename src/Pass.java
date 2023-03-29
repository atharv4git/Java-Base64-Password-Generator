import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Pass {
    public static String generatePassword(int length, boolean specialCharAllowed) throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        String password = Base64.getEncoder().encodeToString(bytes);
        if(!specialCharAllowed){
            password = password.replaceAll("[^a-zA-Z0-9]", "");
        }
        return password.substring(0, length);
    }
}
