package com.example

import com.example.data.model.ReadingCategory
import com.example.data.seed.KurikulumKelas10Seed
import com.example.data.seed.PraktikDanKuisSeed
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun curriculumChapters_haveCompleteStructuresAndRules() {
        val chapters = KurikulumKelas10Seed.chapters
        assertEquals(6, chapters.size)
        chapters.forEach { chapter ->
            assertTrue(chapter.title.isNotBlank())
            assertTrue(chapter.structures.isNotEmpty())
            assertTrue(chapter.languageRules.isNotEmpty())
            assertTrue(chapter.practicalTips.isNotEmpty())
        }
    }

    @Test
    fun literacyReadings_coverAllThreeRequiredCategories() {
        val readings = KurikulumKelas10Seed.readings
        assertEquals(9, readings.size)
        assertEquals(3, readings.count { it.category == ReadingCategory.SASTRA })
        assertEquals(3, readings.count { it.category == ReadingCategory.NON_SASTRA })
        assertEquals(3, readings.count { it.category == ReadingCategory.PENGETAHUAN_UMUM })
        readings.forEach { passage ->
            assertTrue(passage.paragraphs.isNotEmpty())
            assertTrue(passage.glossary.isNotEmpty())
            assertTrue(passage.questions.size >= 3)
        }
    }

    @Test
    fun quizAndPracticeData_areValid() {
        assertEquals(4, PraktikDanKuisSeed.quizTopics.size)
        assertTrue(PraktikDanKuisSeed.allQuizQuestions.size >= 20)
        PraktikDanKuisSeed.allQuizQuestions.forEach { q ->
            assertTrue(q.correctIndex in q.options.indices)
            assertTrue(q.explanation.isNotBlank())
        }
        PraktikDanKuisSeed.effectiveSentenceCases.forEach { c ->
            assertTrue(c.correctOptionIndex in c.options.indices)
        }
        assertEquals(4, PraktikDanKuisSeed.builderTemplates.size)
    }
}
