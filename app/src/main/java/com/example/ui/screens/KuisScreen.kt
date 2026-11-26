package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material.icons.rounded.Psychology
import androidx.compose.material.icons.rounded.Quiz
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Shuffle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.QuizTopic
import com.example.ui.components.AnswerOptionButton
import com.example.ui.components.SectionHeader
import com.example.ui.viewmodel.LenteraViewModel
import com.example.ui.viewmodel.QuizSessionUiState

@Composable
fun KuisScreen(
    viewModel: LenteraViewModel,
    modifier: Modifier = Modifier
) {
    val session by viewModel.quizSession.collectAsStateWithLifecycle()

    if (session.isActive) {
        BackHandler { viewModel.exitQuiz() }
        QuizSessionRunner(
            session = session,
            onSelectOption = { viewModel.selectQuizOption(it) },
            onNext = { viewModel.advanceQuizQuestion() },
            onRestart = { viewModel.restartQuiz() },
            onExit = { viewModel.exitQuiz() },
            modifier = modifier
        )
    } else {
        val topics = viewModel.getQuizTopics()
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .widthIn(max = 720.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    SectionHeader(
                        title = "Arena Uji Literasi",
                        subtitle = "Pilih topik kuis Kelas 10 lengkap dengan pembahasan langsung dari guru"
                    )
                }

                // Mixed Challenge Highlight Card
                item {
                    Card(
                        onClick = {
                            viewModel.startQuiz("campuran", "Tantangan Campuran Kelas 10")
                        },
                        shape = MaterialTheme.shapes.extraLarge,
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("quiz_topic_campuran")
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(18.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.16f),
                                modifier = Modifier.size(52.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Rounded.Shuffle,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Tantangan Campuran",
                                    style = MaterialTheme.typography.titleLarge,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                                Text(
                                    text = "8 soal acak Sastra, Non-Sastra, EYD V & Pengetahuan Umum",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f)
                                )
                            }
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                                contentDescription = "Mulai tantangan campuran",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }

                items(topics, key = { it.id }) { topic ->
                    val count = viewModel.getQuestionsForTopic(topic.id).size
                    QuizTopicCard(
                        topic = topic,
                        questionCount = count,
                        onClick = { viewModel.startQuiz(topic.id, topic.title) }
                    )
                }

                item { Spacer(modifier = Modifier.height(12.dp)) }
            }
        }
    }
}

@Composable
private fun QuizTopicCard(
    topic: QuizTopic,
    questionCount: Int,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("quiz_topic_${topic.id}")
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.tertiaryContainer,
                modifier = Modifier.size(48.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Rounded.Quiz,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = topic.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = topic.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "${topic.badgeLabel} • $questionCount soal • ~${topic.estimatedMinutes} menit",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                contentDescription = "Mulai kuis ${topic.title}",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun QuizSessionRunner(
    session: QuizSessionUiState,
    onSelectOption: (Int) -> Unit,
    onNext: () -> Unit,
    onRestart: () -> Unit,
    onExit: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 680.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    IconButton(
                        onClick = onExit,
                        modifier = Modifier.testTag("quiz_exit_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Keluar dari kuis"
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = session.topicTitle,
                            style = MaterialTheme.typography.titleMedium
                        )
                        if (!session.isFinished) {
                            Text(
                                text = "Soal ${session.currentIndex + 1} dari ${session.questions.size}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            if (session.isFinished) {
                item {
                    val total = session.questions.size.coerceAtLeast(1)
                    val scorePercent = (session.correctCount * 100) / total
                    val feedbackMessage = when {
                        scorePercent >= 80 -> "Luar biasa! Pemahaman literasi dan kaidah bahasamu sangat kuat."
                        scorePercent >= 60 -> "Bagus! Tinggal pertajam ketelitian di beberapa konsep kunci."
                        else -> "Semangat belajar! Coba baca ulang ringkasan bab dan glosarium, lalu ulangi kuis ini."
                    }

                    Card(
                        shape = MaterialTheme.shapes.extraLarge,
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                modifier = Modifier.size(72.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Rounded.EmojiEvents,
                                        contentDescription = "Hasil Kuis",
                                        tint = MaterialTheme.colorScheme.secondary,
                                        modifier = Modifier.size(38.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Skor Kamu: $scorePercent",
                                style = MaterialTheme.typography.displaySmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Menjawab benar ${session.correctCount} dari ${session.questions.size} soal",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = feedbackMessage,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                textAlign = TextAlign.Center
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                OutlinedButton(
                                    onClick = onExit,
                                    modifier = Modifier
                                        .weight(1f)
                                        .testTag("quiz_back_to_topics")
                                ) {
                                    Text("Pilih Topik")
                                }
                                Button(
                                    onClick = onRestart,
                                    modifier = Modifier
                                        .weight(1f)
                                        .testTag("quiz_restart_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Refresh,
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Ulangi")
                                }
                            }
                        }
                    }
                }
            } else {
                val question = session.currentQuestion
                if (question != null) {
                    item {
                        LinearProgressIndicator(
                            progress = { (session.currentIndex + 1).toFloat() / session.questions.size.toFloat() },
                            modifier = Modifier.fillMaxWidth().height(6.dp)
                        )
                    }
                    item {
                        Card(
                            shape = MaterialTheme.shapes.large,
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                        ) {
                            Column(
                                modifier = Modifier.padding(18.dp),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Text(
                                    text = question.question,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )

                                val prefixes = listOf("A", "B", "C", "D")
                                question.options.forEachIndexed { idx, option ->
                                    AnswerOptionButton(
                                        labelPrefix = prefixes.getOrElse(idx) { "${idx + 1}" },
                                        text = option,
                                        selectedIndex = session.selectedOption,
                                        optionIndex = idx,
                                        correctIndex = question.correctIndex,
                                        onClick = { onSelectOption(idx) },
                                        modifier = Modifier.testTag("quiz_option_$idx")
                                    )
                                }

                                AnimatedVisibility(visible = session.selectedOption != null) {
                                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                                        Surface(
                                            shape = RoundedCornerShape(14.dp),
                                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.72f),
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Row(
                                                modifier = Modifier.padding(14.dp),
                                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Rounded.Psychology,
                                                    contentDescription = null,
                                                    tint = MaterialTheme.colorScheme.primary
                                                )
                                                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                                    Text(
                                                        text = "Pembahasan Guru",
                                                        style = MaterialTheme.typography.labelMedium,
                                                        fontWeight = FontWeight.Bold,
                                                        color = MaterialTheme.colorScheme.primary
                                                    )
                                                    Text(
                                                        text = question.explanation,
                                                        style = MaterialTheme.typography.bodySmall,
                                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                                    )
                                                }
                                            }
                                        }

                                        Button(
                                            onClick = onNext,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .testTag("quiz_next_button")
                                        ) {
                                            val isLast = session.currentIndex == session.questions.lastIndex
                                            Text(if (isLast) "Lihat Hasil Skor" else "Soal Selanjutnya")
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Icon(
                                                imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                                                contentDescription = null,
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
