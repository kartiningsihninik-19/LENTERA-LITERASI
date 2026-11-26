package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.LenteraDatabase
import com.example.data.local.ReaderPreferencesRepository
import com.example.data.model.EffectiveSentenceCase
import com.example.data.model.EydRuleItem
import com.example.data.model.MajasItem
import com.example.data.model.MateriChapter
import com.example.data.model.QuizQuestion
import com.example.data.model.QuizTopic
import com.example.data.model.ReaderPreferences
import com.example.data.model.ReaderThemeMode
import com.example.data.model.ReadingCategory
import com.example.data.model.ReadingPassage
import com.example.data.model.TextBuilderTemplate
import com.example.data.repository.LenteraRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class WarmUpUiState(
    val currentIndex: Int = 0,
    val selectedOption: Int? = null
)

data class ClinicUiState(
    val currentIndex: Int = 0,
    val selectedOption: Int? = null,
    val solvedCount: Int = 0
)

data class QuizSessionUiState(
    val topicId: String = "",
    val topicTitle: String = "",
    val questions: List<QuizQuestion> = emptyList(),
    val currentIndex: Int = 0,
    val selectedOption: Int? = null,
    val correctCount: Int = 0,
    val isFinished: Boolean = false
) {
    val isActive: Boolean get() = questions.isNotEmpty()
    val currentQuestion: QuizQuestion? get() = questions.getOrNull(currentIndex)
}

@OptIn(ExperimentalCoroutinesApi::class)
class LenteraViewModel(application: Application) : AndroidViewModel(application) {

    private val database = LenteraDatabase.getInstance(application)
    private val repository = LenteraRepository(database.catalogDao())
    private val prefsRepository = ReaderPreferencesRepository(application)

    private val _selectedCategory = MutableStateFlow<ReadingCategory?>(null)
    val selectedCategory: StateFlow<ReadingCategory?> = _selectedCategory.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _warmUpState = MutableStateFlow(WarmUpUiState())
    val warmUpState: StateFlow<WarmUpUiState> = _warmUpState.asStateFlow()

    private val _clinicState = MutableStateFlow(ClinicUiState())
    val clinicState: StateFlow<ClinicUiState> = _clinicState.asStateFlow()

    private val _kamusQuery = MutableStateFlow("")
    val kamusQuery: StateFlow<String> = _kamusQuery.asStateFlow()

    private val _selectedTemplateId = MutableStateFlow(repository.getBuilderTemplates().first().id)
    val selectedTemplateId: StateFlow<String> = _selectedTemplateId.asStateFlow()

    private val _builderFieldValues = MutableStateFlow<Map<String, String>>(emptyMap())
    val builderFieldValues: StateFlow<Map<String, String>> = _builderFieldValues.asStateFlow()

    private val _quizSession = MutableStateFlow(QuizSessionUiState())
    val quizSession: StateFlow<QuizSessionUiState> = _quizSession.asStateFlow()

    val readerPreferences: StateFlow<ReaderPreferences> = prefsRepository.readerPreferences
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ReaderPreferences()
        )

    val filteredReadings: StateFlow<List<ReadingPassage>> =
        combine(_selectedCategory, _searchQuery) { category, query ->
            category to query
        }.flatMapLatest { (category, query) ->
            repository.observeReadings(category, query)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    init {
        viewModelScope.launch {
            repository.ensureSeeded()
        }
    }

    // Curriculum & Catalog accessors
    fun getChapters(): List<MateriChapter> = repository.getAllChapters()
    fun getChapterById(id: String): MateriChapter? = repository.getChapterById(id)
    fun getFeaturedReading(): ReadingPassage = repository.getFeaturedReading()
    fun getReadingById(id: String): ReadingPassage? = repository.getReadingById(id)
    fun getDailyWarmUps(): List<QuizQuestion> = repository.getDailyWarmUps()
    fun getEffectiveSentenceCases(): List<EffectiveSentenceCase> = repository.getEffectiveSentenceCases()
    fun getMajasList(): List<MajasItem> = repository.getMajasList()
    fun getEydRules(): List<EydRuleItem> = repository.getEydRules()
    fun getBuilderTemplates(): List<TextBuilderTemplate> = repository.getBuilderTemplates()
    fun getQuizTopics(): List<QuizTopic> = repository.getQuizTopics()
    fun getQuestionsForTopic(topicId: String): List<QuizQuestion> = repository.getQuestionsForTopic(topicId)

    // Pustaka filter & search
    fun selectCategory(category: ReadingCategory?) {
        _selectedCategory.value = category
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    // Reader settings persisted via DataStore
    fun increaseFontSize() {
        viewModelScope.launch {
            val next = (readerPreferences.value.fontSizeSp + 1.5f).coerceAtMost(23f)
            prefsRepository.updateFontSize(next)
        }
    }

    fun decreaseFontSize() {
        viewModelScope.launch {
            val next = (readerPreferences.value.fontSizeSp - 1.5f).coerceAtLeast(14f)
            prefsRepository.updateFontSize(next)
        }
    }

    fun setReaderThemeMode(mode: ReaderThemeMode) {
        viewModelScope.launch {
            prefsRepository.updateThemeMode(mode)
        }
    }

    // Home Warm-up
    fun selectWarmUpOption(optionIndex: Int) {
        _warmUpState.update { state ->
            if (state.selectedOption == null) state.copy(selectedOption = optionIndex) else state
        }
    }

    fun nextWarmUp() {
        val total = getDailyWarmUps().size
        _warmUpState.update { state ->
            WarmUpUiState(currentIndex = (state.currentIndex + 1) % total, selectedOption = null)
        }
    }

    // Klinik Kalimat Efektif
    fun selectClinicOption(optionIndex: Int) {
        val currentCase = getEffectiveSentenceCases().getOrNull(_clinicState.value.currentIndex) ?: return
        _clinicState.update { state ->
            if (state.selectedOption != null) return@update state
            val isCorrect = optionIndex == currentCase.correctOptionIndex
            state.copy(
                selectedOption = optionIndex,
                solvedCount = if (isCorrect) state.solvedCount + 1 else state.solvedCount
            )
        }
    }

    fun nextClinicCase() {
        val total = getEffectiveSentenceCases().size
        _clinicState.update { state ->
            state.copy(
                currentIndex = (state.currentIndex + 1) % total,
                selectedOption = null
            )
        }
    }

    // Kamus Majas & EYD
    fun updateKamusQuery(query: String) {
        _kamusQuery.value = query
    }

    // Perakit Kerangka Teks
    fun selectBuilderTemplate(templateId: String) {
        _selectedTemplateId.value = templateId
    }

    fun updateBuilderField(templateId: String, fieldKey: String, value: String) {
        _builderFieldValues.update { current ->
            current + ("$templateId:$fieldKey" to value)
        }
    }

    fun fillSampleForTemplate(template: TextBuilderTemplate) {
        _builderFieldValues.update { current ->
            val updated = current.toMutableMap()
            template.fields.forEach { field ->
                updated["${template.id}:${field.key}"] = field.sampleText
            }
            updated
        }
    }

    fun clearTemplateFields(template: TextBuilderTemplate) {
        _builderFieldValues.update { current ->
            val updated = current.toMutableMap()
            template.fields.forEach { field ->
                updated.remove("${template.id}:${field.key}")
            }
            updated
        }
    }

    fun buildAssembledText(template: TextBuilderTemplate, values: Map<String, String>): String {
        val parts = template.fields.mapNotNull { field ->
            val text = values["${template.id}:${field.key}"]?.trim().orEmpty()
            if (text.isBlank()) null else text
        }
        return if (parts.isEmpty()) "" else parts.joinToString("\n\n")
    }

    // Quiz Arena
    fun startQuiz(topicId: String, title: String) {
        val questions = repository.getQuestionsForTopic(topicId)
        _quizSession.value = QuizSessionUiState(
            topicId = topicId,
            topicTitle = title,
            questions = questions,
            currentIndex = 0,
            selectedOption = null,
            correctCount = 0,
            isFinished = false
        )
    }

    fun selectQuizOption(optionIndex: Int) {
        val current = _quizSession.value
        val question = current.currentQuestion ?: return
        if (current.selectedOption != null) return
        val isCorrect = optionIndex == question.correctIndex
        _quizSession.value = current.copy(
            selectedOption = optionIndex,
            correctCount = if (isCorrect) current.correctCount + 1 else current.correctCount
        )
    }

    fun advanceQuizQuestion() {
        val current = _quizSession.value
        val nextIndex = current.currentIndex + 1
        if (nextIndex >= current.questions.size) {
            _quizSession.value = current.copy(isFinished = true)
        } else {
            _quizSession.value = current.copy(
                currentIndex = nextIndex,
                selectedOption = null
            )
        }
    }

    fun restartQuiz() {
        val current = _quizSession.value
        startQuiz(current.topicId, current.topicTitle)
    }

    fun exitQuiz() {
        _quizSession.value = QuizSessionUiState()
    }
}
