package com.example.data.model

enum class ReadingCategory(val label: String, val subtitle: String) {
    SASTRA("Sastra", "Puisi, Cerpen & Hikayat"),
    NON_SASTRA("Non-Sastra", "Observasi, Biografi & Opini"),
    PENGETAHUAN_UMUM("Pengetahuan Umum", "Bahasa, Budaya & Literasi")
}

enum class ReaderThemeMode(val label: String) {
    KERTAS("Kertas"),
    SEPIA("Sepia"),
    MALAM("Malam")
}

data class ReaderPreferences(
    val fontSizeSp: Float = 17f,
    val themeMode: ReaderThemeMode = ReaderThemeMode.KERTAS
)

data class StructurePart(
    val label: String,
    val explanation: String,
    val sampleExcerpt: String
)

data class LanguageRule(
    val title: String,
    val explanation: String,
    val example: String
)

data class MateriChapter(
    val id: String,
    val orderNumber: Int,
    val title: String,
    val subtitle: String,
    val estimatedMinutes: Int,
    val summaryEasy: String,
    val realWorldUse: String,
    val structures: List<StructurePart>,
    val languageRules: List<LanguageRule>,
    val practicalTips: List<String>,
    val commonMistakes: List<Pair<String, String>>,
    val quizTopicId: String
)

data class GlossaryTerm(
    val word: String,
    val wordClass: String,
    val definition: String,
    val contextExample: String
)

data class QuizQuestion(
    val id: String,
    val topicId: String,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class ReadingPassage(
    val id: String,
    val title: String,
    val subtitle: String,
    val authorOrSource: String,
    val category: ReadingCategory,
    val subGenre: String,
    val readingMinutes: Int,
    val coverKey: String,
    val paragraphs: List<String>,
    val glossary: List<GlossaryTerm>,
    val teacherReflection: String,
    val questions: List<QuizQuestion>
)

data class QuizTopic(
    val id: String,
    val title: String,
    val subtitle: String,
    val badgeLabel: String,
    val estimatedMinutes: Int
)

data class EffectiveSentenceCase(
    val id: String,
    val title: String,
    val wrongSentence: String,
    val options: List<String>,
    val correctOptionIndex: Int,
    val issueType: String,
    val teacherNote: String
)

data class MajasItem(
    val id: String,
    val name: String,
    val group: String,
    val definition: String,
    val literaryExample: String,
    val everydayExample: String
)

data class EydRuleItem(
    val id: String,
    val title: String,
    val explanation: String,
    val wrongExample: String,
    val rightExample: String
)

data class BuilderField(
    val key: String,
    val label: String,
    val promptHint: String,
    val sampleText: String
)

data class TextBuilderTemplate(
    val id: String,
    val textType: String,
    val description: String,
    val fields: List<BuilderField>
)
