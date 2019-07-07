
package com.ammora.RNIccid;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.common.logging.FLog;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;

import java.util.List;

public class RNIccidModule extends ReactContextBaseJavaModule {
  private static final String TAG = "RNIccid";
  private final ReactApplicationContext reactContext;

  public RNIccidModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void deviceId(int slot, Promise promise) {
    try {
      TelephonyManager telManager = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);
      promise.resolve(telManager.getDeviceId(slot));
    } catch (Exception e) {
      FLog.e(TAG, e.toString());
      promise.reject(e);
    }
  }

  @ReactMethod
  public void iccId(int slot, Promise promise) {
    try {
      SubscriptionManager manager = (SubscriptionManager) this.reactContext.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
      List<SubscriptionInfo> subscriptionInfos = manager.getActiveSubscriptionInfoList();
      SubscriptionInfo subscriptionInfo = subscriptionInfos.get(slot);
      promise.resolve(subscriptionInfo.getIccId());
    } catch (Exception e) {
      FLog.e(TAG, e.toString());
      promise.reject(e);
    }
  }

  @Override
  public String getName() {
    return "RNIccid";
  }
}