package developer.boltech.technologies.cyberstruggle;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class IntegrityCheckActivity extends AppCompatActivity {
    private static final String EXPECTED_APK_CHECKSUM = "EXPECTED_APK_CHECKSUM";  // Replace with the actual checksum

    Button btnCheckIntegrity, tvIntegrityDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrity_check);

        btnCheckIntegrity = findViewById(R.id.btnCheckIntegrity);
//        tvIntegrityDetails = findViewById(R.id.tvIntegrityDetails);

        btnCheckIntegrity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAppSignatureValid()) {
                    tvIntegrityDetails.setText("App integrity verified. No tampering detected.");
                } else {
                    tvIntegrityDetails.setText("Warning! App integrity compromised.");
                }
            }
        });

        if (!isApkIntegrityValid()) {
            Log.e("IntegrityCheck", "APK tampered with! Exiting.");
            finish();
        }
    }

    private boolean isAppSignatureValid() {
        // Example check for app signature (simplified for demonstration)
        String validSignature = "VALID_SIGNATURE_HASH";
        String currentSignature = getCurrentAppSignature();
        return validSignature.equals(currentSignature);
    }

    private String getCurrentAppSignature() {
        // Retrieve app's signature (mock implementation)
        return "INVALID_SIGNATURE_HASH"; // Simulate tampered app for testing
    }

    // Verifies the integrity of the APK file by comparing the checksum
    private boolean isApkIntegrityValid() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            File apkFile = new File(packageInfo.applicationInfo.sourceDir);
            FileInputStream fis = new FileInputStream(apkFile);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[1024];
            int numRead;
            while ((numRead = fis.read(buffer)) > 0) {
                md.update(buffer, 0, numRead);
            }
            fis.close();

            byte[] apkChecksum = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : apkChecksum) {
                sb.append(String.format("%02X", b));
            }
            String apkChecksumStr = sb.toString();

            Log.d("IntegrityCheck", "Current APK Checksum: " + apkChecksumStr);
            return EXPECTED_APK_CHECKSUM.equals(apkChecksumStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
