/**
 * @providesModule @ammora/react-native-iccid
 */

var ReactNative = require('react-native');

if (ReactNative.Platform.OS === "android") {
  module.exports = {
    getDeviceId: function (slot) {
      return ReactNative.NativeModules.RNIccid.deviceId(slot);
    },
    getIccid: function (slot) {
      return ReactNative.NativeModules.RNIccid.iccId(slot);
    }
  };
} else {
  module.exports = {
    getDeviceId: function () {
      throw new Error("Not supported");
    },
    getIccid: function () {
      throw new Error("Not supported");
    }
  }
}
