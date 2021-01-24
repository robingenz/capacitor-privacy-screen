package com.getcapacitor.plugin.privacyscreen;

import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin
public class PrivacyScreen extends Plugin {
    /**
     * Called when the plugin is first constructed in the bridge.
     * This method sets the FLAG_SECURE flag to treat the content of the window as secure,
     * preventing it from appearing in screenshots or from being viewed on non-secure displays.
     * @see <a href="https://developer.android.com/reference/android/view/WindowManager.LayoutParams#FLAG_SECURE">Android Developers</a>
     */
    public void load() {
        Window window = getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }

    @PluginMethod
    public void enable(PluginCall call) {
        Window window = getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        call.resolve();
    }

    @PluginMethod
    public void disable(PluginCall call) {
        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
        call.resolve();
    }
}
