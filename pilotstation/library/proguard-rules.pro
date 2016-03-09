# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in d:\Users\lanbo\AppData\Local\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-dontoptimiz
-dontshrink
#-dontobfuscate
-dontskipnonpubliclibraryclasses

-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-dontnote **ILicensingService

-keep public class android.net.http.**{ *;}
-dontnote android.net.http.**
-keep public class org.apache.http.**{ *;}
-dontnote org.apache.http.**

-keep public class com.google.protobuf.**{ *;}
-dontnote com.google.protobuf.**

#-keep public class com.jcraf.**{ *;}
-dontwarn com.jcraf.**
-dontwarn org.ietf.jgss.**

-keep public class com.MAVLink.**{ *;}
-dontwarn  com.MAVLink.**

-keep class com.wingoflights.pilotstation.api.**{ *;}
-keep public class * implements android.os.Parcelable { *;}

#-libraryjars ./libs/j2xx.jar
#-dontwarn com.ftdi.j2xx.**
#-keep com.ftdi.j2xx.**{ *;}

#-libraryjars ./libs/droneapi-java-0.3-SNAPSHOT.jar
#-keep public class com.geeksville.dapi.**{ *;}
#-dontnote class com.geeksville.dapi.**

#-dontwarn class com.geeksville.dapi.**
#-keep class com.geeksville.dapi.**{ *;}

#-libraryjars .libs/isoparser-1.1.7.jar
#-keep com.googlecode.mp4parser.**{ *;}
#-dontnote com.googlecode.mp4parrser.**
-dontwarn com.googlecode.mp4parser.**
#-keep com.mp4parser.**{ *;}

#-dontwarn class com.coremedia.iso.**
-keep class com.coremedia.iso.**{ *;}

#-libraryjars .libs/timber-3.1.0.jar
#-dontwarn timber.log.**
#-keep timber.log.**{ *;}

#-libraryjars .libs/java-semver-0.9.0.jar
#-dontwarn class com.github.zafarkhaja.semver.**
#-keep class com.github.zafarkhaja.semver.**{ *;}