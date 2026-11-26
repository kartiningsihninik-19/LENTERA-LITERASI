package com.example.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.model.ReadingCategory

@DrawableRes
fun coverDrawableForKey(key: String): Int {
    return when (key) {
        "sastra" -> R.drawable.img_sastra_cover
        "nonsastra" -> R.drawable.img_nonsastra_cover
        "pengetahuan" -> R.drawable.img_pengetahuan_cover
        else -> R.drawable.img_hero_literasi
    }
}

@Composable
fun CategoryBadge(
    category: ReadingCategory,
    modifier: Modifier = Modifier
) {
    val (bgColor, textColor) = when (category) {
        ReadingCategory.SASTRA ->
            MaterialTheme.colorScheme.tertiaryContainer to MaterialTheme.colorScheme.onTertiaryContainer
        ReadingCategory.NON_SASTRA ->
            MaterialTheme.colorScheme.secondaryContainer to MaterialTheme.colorScheme.onSecondaryContainer
        ReadingCategory.PENGETAHUAN_UMUM ->
            MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.onPrimaryContainer
    }
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(50),
        color = bgColor
    ) {
        Text(
            text = category.label,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun AnswerOptionButton(
    labelPrefix: String,
    text: String,
    selectedIndex: Int?,
    optionIndex: Int,
    correctIndex: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isAnswered = selectedIndex != null
    val isSelected = selectedIndex == optionIndex
    val isCorrect = optionIndex == correctIndex

    val targetContainer = when {
        !isAnswered -> MaterialTheme.colorScheme.surface
        isCorrect -> MaterialTheme.colorScheme.secondaryContainer
        isSelected && !isCorrect -> MaterialTheme.colorScheme.errorContainer
        else -> MaterialTheme.colorScheme.surface.copy(alpha = 0.65f)
    }
    val targetBorder = when {
        !isAnswered -> MaterialTheme.colorScheme.outlineVariant
        isCorrect -> MaterialTheme.colorScheme.secondary
        isSelected && !isCorrect -> MaterialTheme.colorScheme.error
        else -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
    }
    val targetContentColor = when {
        !isAnswered -> MaterialTheme.colorScheme.onSurface
        isCorrect -> MaterialTheme.colorScheme.onSecondaryContainer
        isSelected && !isCorrect -> MaterialTheme.colorScheme.onErrorContainer
        else -> MaterialTheme.colorScheme.onSurfaceVariant
    }

    val containerColor by animateColorAsState(targetValue = targetContainer, label = "optBg")
    val borderColor by animateColorAsState(targetValue = targetBorder, label = "optBorder")

    Surface(
        onClick = onClick,
        enabled = !isAnswered,
        shape = RoundedCornerShape(14.dp),
        color = containerColor,
        border = BorderStroke(1.2.dp, borderColor),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = if (isAnswered && isCorrect) {
                    MaterialTheme.colorScheme.secondary
                } else if (isAnswered && isSelected) {
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.surfaceVariant
                },
                modifier = Modifier.size(28.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = labelPrefix,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (isAnswered && (isCorrect || isSelected)) {
                            Color.White
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = targetContentColor,
                modifier = Modifier.weight(1f)
            )
            if (isAnswered && (isCorrect || isSelected)) {
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = if (isCorrect) Icons.Rounded.CheckCircle else Icons.Rounded.Close,
                    contentDescription = if (isCorrect) "Jawaban benar" else "Jawaban kurang tepat",
                    tint = if (isCorrect) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun SectionHeader(
    title: String,
    subtitle: String? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        if (!subtitle.isNullOrBlank()) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
    }
}
