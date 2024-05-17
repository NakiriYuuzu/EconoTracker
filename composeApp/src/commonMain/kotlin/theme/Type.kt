package theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import econotracker.composeapp.generated.resources.Res
import econotracker.composeapp.generated.resources.poppins_bold
import econotracker.composeapp.generated.resources.poppins_light
import econotracker.composeapp.generated.resources.poppins_medium
import econotracker.composeapp.generated.resources.poppins_regular
import econotracker.composeapp.generated.resources.poppins_semibold
import org.jetbrains.compose.resources.Font

/**
 * Label typography is small
 * Body typography is medium
 * Headline typography is large
 * @return [Typography] with Poppins font family
 */
@Composable
fun PoppinsTypography(): Typography {
    val poppins = FontFamily(
        Font(
            resource = Res.font.poppins_light,
            weight = FontWeight.Light
        ),
        Font(
            resource = Res.font.poppins_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resource = Res.font.poppins_medium,
            weight = FontWeight.Medium
        ),
        Font(
            resource = Res.font.poppins_semibold,
            weight = FontWeight.SemiBold
        ),
        Font(
            resource = Res.font.poppins_bold,
            weight = FontWeight.Bold
        )
    )

    return Typography(
        labelSmall = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 20.sp,
        ),
        labelMedium = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            lineHeight = 22.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 24.sp,
        ),
        bodySmall = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 20.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 22.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
        ),
        titleSmall = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        ),
        titleMedium = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        ),
        titleLarge = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    )
}