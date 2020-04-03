
# @ammora/react-native-iccid

## Install package

`$ yarn add @ammora/react-native-iccid`

### Automatic add native Android modules

`$ react-native link @ammora/react-native-iccid`

### Manual installation

#### Android

1. Append the following lines to `android/settings.gradle`:

  	```
  	include ':@ammora_react-native-iccid'
  	project(':@ammora_react-native-iccid').projectDir = new File(rootProject.projectDir, 	'../node_modules/@ammora/react-native-iccid/android')
  	```
2. Add to `android/app/src/main/AndroidManifest.xml` the following permission:
    ```
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    ```
3. Open up `android/app/src/main/java/.../MainApplication.java`
  - Add `import com.ammora.RNIccid.RNIccidPackage;` to the imports at the top of the file
  - Add `new RNIccidPackage()` to the list returned by the `getPackages()` method

## Usage
```javascript
import ICCID from '@ammora/react-native-iccid';

ICCID.getIccid(0) // Parameter slot is required
     .then(iccid => {
       console.log(`Simcard at slot #${slot} got ICCID ${iccid}`);
     })
     .catch(e => {
       console.log(`Error trying to get ICCID from device simcard at slot #${slot}`);
       console.log(e);
     });
```
