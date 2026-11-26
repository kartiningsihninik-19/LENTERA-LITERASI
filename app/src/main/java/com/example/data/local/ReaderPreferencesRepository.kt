package com.example.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.data.model.ReaderPreferences
import com.example.data.model.ReaderThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.readerDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "lentera_reader_prefs"
)

class ReaderPreferencesRepository(private val context: Context) {

    private object Keys {
        val FONT_SIZE_SP = floatPreferencesKey("reader_font_size_sp")
        val THEME_MODE = stringPreferencesKey("reader_theme_mode")
    }

    val readerPreferences: Flow<ReaderPreferences> = context.readerDataStore.data.map { prefs ->
        val size = (prefs[Keys.FONT_SIZE_SP] ?: 17f).coerceIn(14f, 23f)
        val modeName = prefs[Keys.THEME_MODE] ?: ReaderThemeMode.KERTAS.name
        val mode = ReaderThemeMode.entries.firstOrNull { it.name == modeName }
            ?: ReaderThemeMode.KERTAS
        ReaderPreferences(fontSizeSp = size, themeMode = mode)
    }

    suspend fun updateFontSize(sizeSp: Float) {
        context.readerDataStore.edit { prefs ->
            prefs[Keys.FONT_SIZE_SP] = sizeSp.coerceIn(14f, 23f)
        }
    }

    suspend fun updateThemeMode(mode: ReaderThemeMode) {
        context.readerDataStore.edit { prefs ->
            prefs[Keys.THEME_MODE] = mode.name
        }
    }
}
