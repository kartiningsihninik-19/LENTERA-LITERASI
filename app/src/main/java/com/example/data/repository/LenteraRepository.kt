package com.example.data.repository

import com.example.data.local.CatalogDao
import com.example.data.local.ReadingEntity
import com.example.data.model.EffectiveSentenceCase
import com.example.data.model.EydRuleItem
import com.example.data.model.MajasItem
import com.example.data.model.MateriChapter
import com.example.data.model.QuizQuestion
import com.example.data.model.QuizTopic
import com.example.data.model.ReadingCategory
import com.example.data.model.ReadingPassage
import com.example.data.model.TextBuilderTemplate
import com.example.data.seed.KurikulumKelas10Seed
import com.example.data.seed.PraktikDanKuisSeed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LenteraRepository(
    private val catalogDao: CatalogDao
) {
    private val passageMap: Map<String, ReadingPassage> =
        KurikulumKelas10Seed.readings.associateBy { it.id }

    suspend fun ensureSeeded() {
        val entities = KurikulumKelas10Seed.readings.mapIndexed { index, passage ->
            ReadingEntity(
                id = passage.id,
                title = passage.title,
                subtitle = passage.subtitle,
                authorOrSource = passage.authorOrSource,
                categoryName = passage.category.name,
                subGenre = passage.subGenre,
                readingMinutes = passage.readingMinutes,
                coverKey = passage.coverKey,
                searchableContent = passage.paragraphs.joinToString(" "),
                sortOrder = index
            )
        }
        if (catalogDao.getReadingCount() != entities.size) {
            catalogDao.insertAll(entities)
        }
    }

    fun observeReadings(
        category: ReadingCategory?,
        query: String
    ): Flow<List<ReadingPassage>> {
        return catalogDao.observeFilteredReadings(
            categoryName = category?.name,
            query = query.trim()
        ).map { entities ->
            entities.mapNotNull { passageMap[it.id] }
        }
    }

    fun getReadingById(id: String): ReadingPassage? = passageMap[id]

    fun getFeaturedReading(): ReadingPassage = KurikulumKelas10Seed.readings.first()

    fun getAllChapters(): List<MateriChapter> = KurikulumKelas10Seed.chapters

    fun getChapterById(id: String): MateriChapter? =
        KurikulumKelas10Seed.chapters.firstOrNull { it.id == id }

    fun getDailyWarmUps(): List<QuizQuestion> = PraktikDanKuisSeed.dailyWarmUps

    fun getEffectiveSentenceCases(): List<EffectiveSentenceCase> =
        PraktikDanKuisSeed.effectiveSentenceCases

    fun getMajasList(): List<MajasItem> = PraktikDanKuisSeed.majasList

    fun getEydRules(): List<EydRuleItem> = PraktikDanKuisSeed.eydRules

    fun getBuilderTemplates(): List<TextBuilderTemplate> = PraktikDanKuisSeed.builderTemplates

    fun getQuizTopics(): List<QuizTopic> = PraktikDanKuisSeed.quizTopics

    fun getQuestionsForTopic(topicId: String): List<QuizQuestion> {
        return if (topicId == "campuran") {
            PraktikDanKuisSeed.allQuizQuestions.shuffled().take(8)
        } else {
            PraktikDanKuisSeed.allQuizQuestions.filter { it.topicId == topicId }
        }
    }
}
