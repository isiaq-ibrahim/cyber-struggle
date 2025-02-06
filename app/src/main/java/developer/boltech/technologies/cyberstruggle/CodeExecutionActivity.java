package developer.boltech.technologies.cyberstruggle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeExecutionActivity extends AppCompatActivity {
    private EditText codeField;
    private Button executeCodeButton;
    private TextView outputField;
    private Button logoutButton;

    // SharedPreferences for session management
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static final String PREF_NAME = "userSession";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_execution);

        codeField = findViewById(R.id.codeField);
        executeCodeButton = findViewById(R.id.executeCodeButton);
        outputField = findViewById(R.id.outputField);
        logoutButton = findViewById(R.id.logoutButton);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Check if user is logged in
        if (!isLoggedIn()) {
            // If not logged in, redirect to login screen
            navigateToLoginActivity();
        }

        executeCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userCode = codeField.getText().toString();

                try {
                    // Dangerous code injection vulnerability: Executes arbitrary user input
                    Process process = Runtime.getRuntime().exec(userCode);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    StringBuilder output = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        output.append(line).append("\n");
                    }
                    outputField.setText(output.toString());
                } catch (Exception e) {
                    outputField.setText("Error executing code");
                }
            }
        });

        // Handle logout
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    // Check if user is logged in
    private boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    // Logout the user by clearing session data
    private void logout() {
        editor.clear();
        editor.apply();
        Toast.makeText(CodeExecutionActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
        navigateToLoginActivity();
    }

    // Redirect to login activity
    private void navigateToLoginActivity() {
        Intent intent = new Intent(CodeExecutionActivity.this, MainActivity.class);
        startActivity(intent);
        finish();  // Prevent returning to protected page
    }
}
