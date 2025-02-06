package developer.boltech.technologies.cyberstruggle;
import android.os.Debug;
import android.util.Log;

public class AntiDebugging {

    // Detect if the application is being debugged
    public static void detectDebugger() {
        if (Debug.isDebuggerConnected()) {
            Log.e("AntiDebugging", "Debugger detected! Exiting the app.");
            System.exit(0);  // Exit the app if a debugger is connected
        }
    }
}
