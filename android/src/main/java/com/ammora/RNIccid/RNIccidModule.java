
package com.ammora.RNIccid;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.common.logging.FLog;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.List;

public class RNIccidModule extends ReactContextBaseJavaModule {
  private static final String TAG = "RNIccid";
  private final ReactApplicationContext reactContext;

  public RNIccidModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @RequiresApi(api = Build.VERSION_CODES.M)
  @ReactMethod
  public void deviceId(int slot, Promise promise) {
    if (!hasPermission()) {
      promise.reject(new RuntimeException("Missing permission " + Manifest.permission.READ_PHONE_STATE));
      return;
    }

    try {
      TelephonyManager telManager = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);
      promise.resolve(telManager.getDeviceId(slot));
    } catch (Exception e) {
      FLog.e(TAG, e.toString());
      promise.reject(e);
    }
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
  @ReactMethod
  public void iccId(int slot, Promise promise) {
    if (!hasPermission()) {
      promise.reject(new RuntimeException("Missing permission " + Manifest.permission.READ_PHONE_STATE));
      return;
    }

    try {
      SubscriptionManager manager = (SubscriptionManager) this.reactContext.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
      List<SubscriptionInfo> subscriptionInfos = manager.getActiveSubscriptionInfoList();
      if (subscriptionInfos == null) {
        promise.resolve(null);
        return;
      }
      SubscriptionInfo subscriptionInfo = subscriptionInfos.get(slot);
      if (subscriptionInfo == null) {
        promise.resolve(null);
        return;
      }
      promise.resolve(subscriptionInfo.getIccId());
    } catch (Exception e) {
      FLog.e(TAG, e.toString());
      promise.reject(e);
    }
  }

  private boolean hasPermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      return reactContext.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
    } else return true;
  }

  @Override
  public String getName() {
    return "RNIccid";
  }
}
