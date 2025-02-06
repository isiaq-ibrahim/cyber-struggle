package developer.boltech.technologies.cyberstruggle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent startMainActivity = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(startMainActivity);
                finish();
            }
        },5000);
    }
}