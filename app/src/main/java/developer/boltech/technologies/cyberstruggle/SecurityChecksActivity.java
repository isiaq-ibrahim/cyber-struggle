package developer.boltech.technologies.cyberstruggle;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityChecksActivity extends AppCompatActivity {
    // The expected SHA-1 signature hash of the application
    private static final String EXPECTED_SIGNATURE = "AB:CD:EF:12:34:56:78:90:AB:CD:EF:12:34:56:78:90:AB:CD:EF:12";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_checks);

//        if (!isAppSignatureValid()) {
//            Log.e("Security", "Signature mismatch! Exiting the app.");
//            finish();  // Terminate the app if the signature does not match
//        }
    }

    // Check if the app's signature matches the expected signature
    private boolean isAppSignatureValid() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(signature.toByteArray());
                String currentSignature = toHexString(md.digest());
                Log.d("Security", "Current Signature: " + currentSignature);

                if (EXPECTED_SIGNATURE.equals(currentSignature)) {
                    return true;  // Signature matches
                }
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Convert byte array to hex string for easy comparison
    private String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X:", b));
        }
        return sb.substring(0, sb.length() - 1);  // Remove trailing colon
    }
}
