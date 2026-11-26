package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val LightColorScheme = lightColorScheme(
    primary = NusantaraIndigo,
    onPrimary = PaperWhite,
    primaryContainer = NusantaraIndigoContainer,
    onPrimaryContainer = NusantaraIndigo,
    secondary = SageForest,
    onSecondary = PaperWhite,
    secondaryContainer = SageContainer,
    onSecondaryContainer = SageForest,
    tertiary = TerracottaBatik,
    onTertiary = PaperWhite,
    tertiaryContainer = TerracottaContainer,
    onTertiaryContainer = Color(0xFF5D2109),
    background = WarmIvory,
    onBackground = InkPrimary,
    surface = PaperWhite,
    onSurface = InkPrimary,
    surfaceVariant = SoftParchment,
    onSurfaceVariant = InkSecondary,
    surfaceContainerLow = SoftParchment,
    surfaceContainer = Color(0xFFEFE7D8),
    surfaceContainerHigh = DeepParchment,
    outline = OutlineWarm,
    outlineVariant = Color(0xFFE5DEC9)
)

private val DarkColorScheme = darkColorScheme(
    primary = DarkIndigoPrimary,
    onPrimary = Color(0xFF0E253D),
    primaryContainer = DarkIndigoContainer,
    onPrimaryContainer = Color(0xFFD5E6F7),
    secondary = DarkSage,
    onSecondary = Color(0xFF0D2E25),
    secondaryContainer = DarkSageContainer,
    onSecondaryContainer = Color(0xFFC4ECE0),
    tertiary = DarkTerracotta,
    onTertiary = Color(0xFF421908),
    tertiaryContainer = DarkTerracottaContainer,
    onTertiaryContainer = Color(0xFFFFD8C8),
    background = DarkCharcoal,
    onBackground = DarkInk,
    surface = DarkSurface,
    onSurface = DarkInk,
    surfaceVariant = DarkSurfaceElevated,
    onSurfaceVariant = DarkInkMuted,
    surfaceContainerLow = DarkSurface,
    surfaceContainer = DarkSurfaceElevated,
    surfaceContainerHigh = Color(0xFF35312B),
    outline = Color(0xFF4C473E),
    outlineVariant = Color(0xFF38342E)
)

val LenteraShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

@Composable
fun LenteraKataTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = LenteraTypography,
        shapes = LenteraShapes,
        content = content
    )
}
