package developer.boltech.technologies.cyberstruggle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReverseEngineeringActivity extends AppCompatActivity {
    private Button demoTamperButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_engineering);

        demoTamperButton = findViewById(R.id.demoTamperButton);

        demoTamperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vulnerable code that could be tampered after reverse engineering
                String tamperedMessage = "This message could be altered!";
                Toast.makeText(ReverseEngineeringActivity.this, tamperedMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
