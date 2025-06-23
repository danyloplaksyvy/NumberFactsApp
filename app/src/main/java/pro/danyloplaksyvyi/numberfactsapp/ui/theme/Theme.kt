package pro.danyloplaksyvyi.numberfactsapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = SoftLavender,
    onPrimary = Color.White,
    primaryContainer = DeepLavender,
    onPrimaryContainer = Color.White,

    secondary = SoftMint,
    onSecondary = Color.White,
    secondaryContainer = DeepMint,
    onSecondaryContainer = Color.White,

    tertiary = SoftPeach,
    onTertiary = Color.White,
    tertiaryContainer = DeepPeach,
    onTertiaryContainer = Color.White,

    background = DarkPastelBackground,
    onBackground = DarkPastelOnSurface,
    surface = DarkPastelSurface,
    onSurface = DarkPastelOnSurface,
    surfaceVariant = Color(0xFF4A4A5A),
    onSurfaceVariant = Color(0xFFD0D0E0),

    error = SoftCoral,
    onError = Color.White,
    errorContainer = DeepCoral,
    onErrorContainer = Color.White,

    outline = Color(0xFF6A6A7A),
    outlineVariant = Color(0xFF5A5A6A)
)

private val LightColorScheme = lightColorScheme(
    primary = SoftBlue,
    onPrimary = Color.White,
    primaryContainer = PastelBlue,
    onPrimaryContainer = Color(0xFF1A365D),

    secondary = SoftMint,
    onSecondary = Color.White,
    secondaryContainer = PastelMint,
    onSecondaryContainer = Color(0xFF1A4D1A),

    tertiary = SoftPeach,
    onTertiary = Color.White,
    tertiaryContainer = PastelPeach,
    onTertiaryContainer = Color(0xFF8B4513),

    background = SoftWhite,
    onBackground = Color(0xFF2D2D2D),
    surface = PastelCream,
    onSurface = Color(0xFF2D2D2D),
    surfaceVariant = WarmGray,
    onSurfaceVariant = Color(0xFF5A5A5A),

    error = SoftCoral,
    onError = Color.White,
    errorContainer = PastelRose,
    onErrorContainer = Color(0xFF8B0000),

    outline = Color(0xFFB0B0B0),
    outlineVariant = Color(0xFFD0D0D0),

    // Additional beautiful pastel colors for variety
    inverseSurface = Color(0xFF4A4A4A),
    inverseOnSurface = PastelCream,
    inversePrimary = PastelLavender,

    surfaceTint = SoftBlue,
    scrim = Color(0x80000000)
)

@Composable
fun NumberFactsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}