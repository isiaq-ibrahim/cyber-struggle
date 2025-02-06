package developer.boltech.technologies.cyberstruggle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameField, passwordField,codeField;
    private Button loginButton, executeCodeButton;
    private boolean isLoggedIn = false;

    // SharedPreferences for storing the session token
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String PREF_NAME = "userSession";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);
        codeField = findViewById(R.id.codeField);
        loginButton = findViewById(R.id.loginButton);
        executeCodeButton = findViewById(R.id.executeCodeButton);

        // SharedPreferences for storing the session token
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        // Hardcoded sensitive data, easily extractable through reverse engineering
        String secretKey = "hardcoded-secret-key";  // Can be extracted using decompilers

        Log.d("VulnerableApp", "Secret Key: " + secretKey);  // Logging sensitive data

        // In production, use ProGuard or R8 for obfuscation to make reverse engineering difficult.

        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        isLoggedIn = sharedPreferences.getBoolean("loggedIn", false);

//        Unsecure authentication bypass vulnerability
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();

//          Hardcoded password check: easily bypassed
                if (username.equals(getString(R.string.username)) && password.equals(getString(R.string.password))) {
                    sharedPreferences.edit().putBoolean("loggedIn", true).apply();
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        Code Injection Vulnerability
        executeCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String code = codeField.getText().toString();

//                    Dynamically execute user input (dangerous)
                    Runtime.getRuntime().exec(code);
                    Toast.makeText(MainActivity.this, "Code Executed!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Code Execution Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        This will encrypt sensitive information with the hardcoded key
//        User's sensitive password
        String userPassword = "1234";
        String encryptedPassword = EncryptionUtils.encryptData(userPassword);

//        Just to show how it works, you can log or display the encrypted data (insecure practice)
        Toast.makeText(this, "Encrypted Password: " + encryptedPassword, Toast.LENGTH_LONG).show();

//        Decrypting to demonstrate reverse engineering vulnerability
        String decryptedPassword = EncryptionUtils.decryptData(encryptedPassword);
        Toast.makeText(this, "Decrypted Password: " + decryptedPassword, Toast.LENGTH_LONG).show();
    }
}