package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.Psychology
import androidx.compose.material.icons.rounded.TextFields
import androidx.compose.material.icons.rounded.Translate
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.ReaderThemeMode
import com.example.data.model.ReadingPassage
import com.example.ui.components.AnswerOptionButton
import com.example.ui.components.CategoryBadge
import com.example.ui.components.coverDrawableForKey
import com.example.ui.theme.DarkCharcoal
import com.example.ui.theme.DarkInk
import com.example.ui.theme.DarkInkMuted
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.InkPrimary
import com.example.ui.theme.InkSecondary
import com.example.ui.theme.LoraFontFamily
import com.example.ui.theme.PaperWhite
import com.example.ui.theme.SepiaBackground
import com.example.ui.theme.SepiaInk
import com.example.ui.theme.SepiaInkMuted
import com.example.ui.theme.SepiaSurface
import com.example.ui.theme.WarmIvory
import com.example.ui.viewmodel.LenteraViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ReaderScreen(
    passage: ReadingPassage?,
    viewModel: LenteraViewModel,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (passage == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Bacaan tidak ditemukan.")
        }
        return
    }

    val prefs by viewModel.readerPreferences.collectAsStateWithLifecycle()
    var showAppearanceBar by remember { mutableStateOf(false) }
    var selectedGlossaryIdx by remember(passage.id) { mutableIntStateOf(0) }
    val selectedAnswers = remember(passage.id) { mutableStateMapOf<String, Int>() }
    val listState = rememberLazyListState()

    val scrollProgress by remember {
        derivedStateOf {
            val total = listState.layoutInfo.totalItemsCount.coerceAtLeast(1)
            val first = listState.firstVisibleItemIndex
            ((first + 1).toFloat() / total.toFloat()).coerceIn(0.05f, 1f)
        }
    }

    val (paperBg, cardBg, textMain, textMuted) = when (prefs.themeMode) {
        ReaderThemeMode.KERTAS -> QuadColor(WarmIvory, PaperWhite, InkPrimary, InkSecondary)
        ReaderThemeMode.SEPIA -> QuadColor(SepiaBackground, SepiaSurface, SepiaInk, SepiaInkMuted)
        ReaderThemeMode.MALAM -> QuadColor(DarkCharcoal, DarkSurface, DarkInk, DarkInkMuted)
    }

    Scaffold(
        modifier = modifier,
        containerColor = paperBg,
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = passage.subGenre,
                            style = MaterialTheme.typography.titleMedium,
                            color = textMain
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = onBack,
                            modifier = Modifier.testTag("reader_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                                contentDescription = "Kembali ke Pustaka",
                                tint = textMain
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { showAppearanceBar = !showAppearanceBar },
                            modifier = Modifier.testTag("reader_appearance_button")
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.TextFields,
                                contentDescription = "Atur ukuran huruf dan tema baca",
                                tint = textMain
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = paperBg)
                )
                LinearProgressIndicator(
                    progress = { scrollProgress },
                    modifier = Modifier.fillMaxWidth().height(3.dp),
                    color = MaterialTheme.colorScheme.tertiary,
                    trackColor = textMuted.copy(alpha = 0.2f)
                )
                AnimatedVisibility(visible = showAppearanceBar) {
                    Surface(
                        color = cardBg,
                        tonalElevation = 2.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Ukuran Huruf (${prefs.fontSizeSp.toInt()} sp)",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = textMain
                                )
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    OutlinedButton(
                                        onClick = { viewModel.decreaseFontSize() },
                                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                                        modifier = Modifier.testTag("reader_font_decrease")
                                    ) {
                                        Text("A-", color = textMain)
                                    }
                                    OutlinedButton(
                                        onClick = { viewModel.increaseFontSize() },
                                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                                        modifier = Modifier.testTag("reader_font_increase")
                                    ) {
                                        Text("A+", color = textMain)
                                    }
                                }
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Kertas:",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = textMuted
                                )
                                ReaderThemeMode.entries.forEach { mode ->
                                    FilterChip(
                                        selected = prefs.themeMode == mode,
                                        onClick = { viewModel.setReaderThemeMode(mode) },
                                        label = { Text(mode.label) },
                                        modifier = Modifier.testTag("reader_theme_${mode.name.lowercase()}")
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(paperBg)
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .widthIn(max = 680.dp),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 18.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                // Header Cover & Title
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Image(
                            painter = painterResource(id = coverDrawableForKey(passage.coverKey)),
                            contentDescription = "Ilustrasi ${passage.title}",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(168.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CategoryBadge(category = passage.category)
                            Text(
                                text = "• ${passage.readingMinutes} menit baca",
                                style = MaterialTheme.typography.labelMedium,
                                color = textMuted
                            )
                        }
                        Text(
                            text = passage.title,
                            fontFamily = LoraFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 26.sp,
                            lineHeight = 34.sp,
                            color = textMain
                        )
                        Text(
                            text = "${passage.subtitle} — ${passage.authorOrSource}",
                            style = MaterialTheme.typography.bodySmall,
                            color = textMuted
                        )
                        HorizontalDivider(color = textMuted.copy(alpha = 0.25f))
                    }
                }

                // Reading Paragraphs
                itemsIndexed(passage.paragraphs) { _, paragraph ->
                    Text(
                        text = paragraph,
                        fontFamily = LoraFontFamily,
                        fontSize = prefs.fontSizeSp.sp,
                        lineHeight = (prefs.fontSizeSp * 1.68f).sp,
                        color = textMain
                    )
                }

                // Interactive KBBI Glossary
                if (passage.glossary.isNotEmpty()) {
                    item {
                        Card(
                            shape = MaterialTheme.shapes.large,
                            colors = CardDefaults.cardColors(containerColor = cardBg),
                            border = BorderStroke(1.dp, textMuted.copy(alpha = 0.22f))
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Translate,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = "Glosarium Kata Kunci (KBBI)",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = textMain
                                    )
                                }
                                FlowRow(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    passage.glossary.forEachIndexed { index, term ->
                                        FilterChip(
                                            selected = selectedGlossaryIdx == index,
                                            onClick = { selectedGlossaryIdx = index },
                                            label = { Text(term.word) },
                                            modifier = Modifier.testTag("glossary_chip_$index")
                                        )
                                    }
                                }
                                val activeTerm = passage.glossary.getOrNull(selectedGlossaryIdx)
                                if (activeTerm != null) {
                                    Surface(
                                        shape = RoundedCornerShape(12.dp),
                                        color = paperBg,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(12.dp),
                                            verticalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            Text(
                                                text = "${activeTerm.word} (${activeTerm.wordClass})",
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.tertiary
                                            )
                                            Text(
                                                text = activeTerm.definition,
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = textMain
                                            )
                                            Text(
                                                text = "Dalam teks: \"${activeTerm.contextExample}\"",
                                                style = MaterialTheme.typography.bodySmall,
                                                fontStyle = FontStyle.Italic,
                                                color = textMuted
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Teacher Reflection Box
                item {
                    Card(
                        shape = MaterialTheme.shapes.large,
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.72f)
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.AutoStories,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.secondary
                                )
                                Text(
                                    text = "Catatan & Refleksi Guru",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer
                                )
                            }
                            Text(
                                text = passage.teacherReflection,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                }

                // End-of-Reading Comprehension Questions
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Psychology,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Uji Pemahaman Bacaan",
                                style = MaterialTheme.typography.titleLarge,
                                color = textMain
                            )
                        }
                    }
                }

                itemsIndexed(passage.questions, key = { _, q -> q.id }) { qIdx, question ->
                    val chosen = selectedAnswers[question.id]
                    Card(
                        shape = MaterialTheme.shapes.large,
                        colors = CardDefaults.cardColors(containerColor = cardBg),
                        border = BorderStroke(1.dp, textMuted.copy(alpha = 0.22f))
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(
                                text = "Pertanyaan ${qIdx + 1}",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                            Text(
                                text = question.question,
                                style = MaterialTheme.typography.titleSmall,
                                color = textMain
                            )
                            val prefixes = listOf("A", "B", "C", "D")
                            question.options.forEachIndexed { optIdx, option ->
                                AnswerOptionButton(
                                    labelPrefix = prefixes.getOrElse(optIdx) { "${optIdx + 1}" },
                                    text = option,
                                    selectedIndex = chosen,
                                    optionIndex = optIdx,
                                    correctIndex = question.correctIndex,
                                    onClick = { selectedAnswers[question.id] = optIdx },
                                    modifier = Modifier.testTag("reader_q_${qIdx}_opt_$optIdx")
                                )
                            }
                            AnimatedVisibility(visible = chosen != null) {
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = question.explanation,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                                        modifier = Modifier.padding(12.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                item { Spacer(modifier = Modifier.height(24.dp)) }
            }
        }
    }
}

private data class QuadColor(
    val bg: Color,
    val card: Color,
    val textMain: Color,
    val textMuted: Color
)
