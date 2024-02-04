package com.rxuglr.m3kwoahelper.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.android.material.color.DynamicColors

private val DarkColorScheme = darkColorScheme(
    primary = BLACK,
    secondary = BLACK_DARK,
    tertiary = SECONDARY_DARK
)

private val LightColorScheme = lightColorScheme(
    primary = BLACK,
    secondary = BLACK_LIGHT,
    tertiary = SECONDARY_LIGHT
)


@Composable
fun WOAHelperTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = DynamicColors.isDynamicColorAvailable(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

  //  SideEffect {
  //      systemUiController.setStatusBarColor(
  //          color = colorScheme.surfaceColorAtElevation(12.dp),
   //         darkIcons = !darkTheme
  //      )

        // To match the App Navbar color
   //     systemUiController.setNavigationBarColor(
   //         color = colorScheme.surface,
   //         darkIcons = !darkTheme,
   //     )
   // }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}