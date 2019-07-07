
# react-native-iccid

## Getting started

`$ npm install react-native-iccid --save`

### Mostly automatic installation

`$ react-native link react-native-iccid`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-iccid` and add `RNIccid.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNIccid.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNIccidPackage;` to the imports at the top of the file
  - Add `new RNIccidPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-iccid'
  	project(':react-native-iccid').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-iccid/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-iccid')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNIccid.sln` in `node_modules/react-native-iccid/windows/RNIccid.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Iccid.RNIccid;` to the usings at the top of the file
  - Add `new RNIccidPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNIccid from 'react-native-iccid';

// TODO: What to do with the module?
RNIccid;
```
  