package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.seed.KurikulumKelas10Seed
import com.example.data.seed.PraktikDanKuisSeed
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read app name from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Lentera Kata", appName)
    }

    @Test
    fun `curriculum chapters and literacy readings are complete`() {
        assertEquals(6, KurikulumKelas10Seed.chapters.size)
        assertEquals(9, KurikulumKelas10Seed.readings.size)
        assertTrue(PraktikDanKuisSeed.allQuizQuestions.size >= 20)
        assertTrue(PraktikDanKuisSeed.builderTemplates.size == 4)
    }
}
