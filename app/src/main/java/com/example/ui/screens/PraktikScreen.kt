package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.AutoFixHigh
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.DeleteOutline
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.components.AnswerOptionButton
import com.example.ui.components.SectionHeader
import com.example.ui.theme.LoraFontFamily
import com.example.ui.viewmodel.LenteraViewModel

@Composable
fun PraktikScreen(
    viewModel: LenteraViewModel,
    modifier: Modifier = Modifier
) {
    var selectedWorkshopTab by remember { mutableIntStateOf(0) }
    val tabLabels = listOf("Klinik Kalimat", "Rakit Teks", "Kamus Majas")

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 720.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                SectionHeader(
                    title = "Bengkel Bahasa Aplikatif",
                    subtitle = "Latihan langsung memperbaiki kalimat efektif, merakit kerangka tulisan, dan menguasai majas & EYD V"
                )
            }

            item {
                SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                    tabLabels.forEachIndexed { index, label ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(index = index, count = tabLabels.size),
                            onClick = { selectedWorkshopTab = index },
                            selected = selectedWorkshopTab == index,
                            modifier = Modifier.testTag("praktik_tab_$index")
                        ) {
                            Text(label, maxLines = 1)
                        }
                    }
                }
            }

            when (selectedWorkshopTab) {
                0 -> item { KlinikKalimatSection(viewModel = viewModel) }
                1 -> item { RakitTeksSection(viewModel = viewModel) }
                2 -> item { KamusMajasDanEydSection(viewModel = viewModel) }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}

@Composable
private fun KlinikKalimatSection(viewModel: LenteraViewModel) {
    val cases = viewModel.getEffectiveSentenceCases()
    val state by viewModel.clinicState.collectAsStateWithLifecycle()
    val currentCase = cases[state.currentIndex % cases.size]

    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Card(
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(50),
                        color = MaterialTheme.colorScheme.tertiaryContainer
                    ) {
                        Text(
                            text = currentCase.issueType,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                    Text(
                        text = "Kasus ${state.currentIndex + 1}/${cases.size} • Benar: ${state.solvedCount}",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }

                Text(
                    text = currentCase.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.45f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "KALIMAT PERLU DIPERBAIKI",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.error
                        )
                        Text(
                            text = "\"${currentCase.wrongSentence}\"",
                            fontFamily = LoraFontFamily,
                            fontStyle = FontStyle.Italic,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                Text(
                    text = "Pilih perbaikan kalimat paling efektif & baku:",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                val prefixes = listOf("A", "B", "C")
                currentCase.options.forEachIndexed { idx, opt ->
                    AnswerOptionButton(
                        labelPrefix = prefixes.getOrElse(idx) { "${idx + 1}" },
                        text = opt,
                        selectedIndex = state.selectedOption,
                        optionIndex = idx,
                        correctIndex = currentCase.correctOptionIndex,
                        onClick = { viewModel.selectClinicOption(idx) },
                        modifier = Modifier.testTag("clinic_opt_$idx")
                    )
                }

                AnimatedVisibility(visible = state.selectedOption != null) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = "Catatan Guru Bahasa",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = currentCase.teacherNote,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }

                        Button(
                            onClick = { viewModel.nextClinicCase() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("clinic_next_button")
                        ) {
                            Text("Kasus Berikutnya")
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

@Composable
private fun RakitTeksSection(viewModel: LenteraViewModel) {
    val context = LocalContext.current
    val templates = viewModel.getBuilderTemplates()
    val selectedId by viewModel.selectedTemplateId.collectAsStateWithLifecycle()
    val fieldValues by viewModel.builderFieldValues.collectAsStateWithLifecycle()
    val activeTemplate = templates.firstOrNull { it.id == selectedId } ?: templates.first()
    val assembledText = viewModel.buildAssembledText(activeTemplate, fieldValues)

    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(templates, key = { it.id }) { template ->
                FilterChip(
                    selected = template.id == activeTemplate.id,
                    onClick = { viewModel.selectBuilderTemplate(template.id) },
                    label = { Text(template.textType.removePrefix("Teks ").removePrefix("Dialog Teks ")) },
                    modifier = Modifier.testTag("builder_template_${template.id}")
                )
            }
        }

        Card(
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = activeTemplate.textType,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = activeTemplate.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilledTonalButton(
                        onClick = { viewModel.fillSampleForTemplate(activeTemplate) },
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                        modifier = Modifier.testTag("builder_fill_sample")
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.AutoFixHigh,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Isi Contoh", style = MaterialTheme.typography.labelMedium)
                    }
                    OutlinedButton(
                        onClick = { viewModel.clearTemplateFields(activeTemplate) },
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                        modifier = Modifier.testTag("builder_clear")
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.DeleteOutline,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Kosongkan", style = MaterialTheme.typography.labelMedium)
                    }
                }

                activeTemplate.fields.forEach { field ->
                    val currentVal = fieldValues["${activeTemplate.id}:${field.key}"].orEmpty()
                    OutlinedTextField(
                        value = currentVal,
                        onValueChange = {
                            viewModel.updateBuilderField(activeTemplate.id, field.key, it)
                        },
                        label = { Text(field.label) },
                        placeholder = { Text(field.promptHint) },
                        minLines = if (field.key == "judul") 1 else 2,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("builder_input_${field.key}")
                    )
                }
            }
        }

        AnimatedVisibility(visible = assembledText.isNotBlank()) {
            Card(
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.35f))
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
                            imageVector = Icons.Rounded.EditNote,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Pratinjau Draf Tulisanmu",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text(
                        text = assembledText,
                        fontFamily = LoraFontFamily,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                clipboard.setPrimaryClip(ClipData.newPlainText(activeTemplate.textType, assembledText))
                                Toast.makeText(context, "Draf berhasil disalin!", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("builder_copy_button")
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.ContentCopy,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Salin")
                        }
                        Button(
                            onClick = {
                                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                    type = "text/plain"
                                    putExtra(Intent.EXTRA_SUBJECT, activeTemplate.textType)
                                    putExtra(Intent.EXTRA_TEXT, assembledText)
                                }
                                context.startActivity(Intent.createChooser(shareIntent, "Bagikan Draf Teks"))
                            },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("builder_share_button")
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Share,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Bagikan")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun KamusMajasDanEydSection(viewModel: LenteraViewModel) {
    val query by viewModel.kamusQuery.collectAsStateWithLifecycle()
    val majas = viewModel.getMajasList().filter {
        query.isBlank() ||
            it.name.contains(query, ignoreCase = true) ||
            it.definition.contains(query, ignoreCase = true) ||
            it.group.contains(query, ignoreCase = true)
    }
    val eydRules = viewModel.getEydRules().filter {
        query.isBlank() ||
            it.title.contains(query, ignoreCase = true) ||
            it.explanation.contains(query, ignoreCase = true)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { viewModel.updateKamusQuery(it) },
            placeholder = { Text("Cari majas (metafora, ironi) atau aturan EYD V...") },
            leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = "Cari kamus") },
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("kamus_search_input")
        )

        if (majas.isNotEmpty()) {
            Text(
                text = "Kamus Mini Majas Sastra",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            majas.forEach { item ->
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                            Text(
                                text = item.group,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Text(
                            text = item.definition,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Sastra: \"${item.literaryExample}\"",
                            fontFamily = LoraFontFamily,
                            fontStyle = FontStyle.Italic,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Sehari-hari: \"${item.everydayExample}\"",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }

        if (eydRules.isNotEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Panduan Cepat EYD Edisi V",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            eydRules.forEach { rule ->
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.surface,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = rule.title,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = rule.explanation,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "Salah: ${rule.wrongExample}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.error
                        )
                        Text(
                            text = "Benar: ${rule.rightExample}",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }
    }
}
