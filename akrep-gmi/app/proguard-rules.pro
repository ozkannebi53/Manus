# Firebase
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.firebase.**
-dontwarn com.google.android.gms.**

# Kotlin
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }
-dontwarn kotlin.**
-dontwarn kotlinx.**

# Jetpack Compose
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# Room Database
-keep class androidx.room.** { *; }
-dontwarn androidx.room.**

# Retrofit
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }
-dontwarn retrofit2.**
-dontwarn okhttp3.**

# GSON
-keep class com.google.gson.** { *; }
-dontwarn com.google.gson.**

# Coroutines
-keep class kotlinx.coroutines.** { *; }
-dontwarn kotlinx.coroutines.**

# App Classes
-keep class com.akrep.gmi.galactic.** { *; }
-keep class com.akrep.gmi.galactic.models.** { *; }
-keep class com.akrep.gmi.galactic.firebase.** { *; }
-keep class com.akrep.gmi.galactic.game.** { *; }
-keep class com.akrep.gmi.galactic.ui.** { *; }

# Timber
-keep class timber.log.** { *; }
-dontwarn timber.log.**
