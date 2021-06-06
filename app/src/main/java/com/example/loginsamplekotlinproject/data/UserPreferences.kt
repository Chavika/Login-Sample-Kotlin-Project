package com.example.loginsamplekotlinproject.data

import android.content.Context
import androidx.datastore.core.DataStore
import java.util.prefs.Preferences//wrong dependency imported,unable to find correct dependency


class UserPreferences (
    context: Context
){
    private val applicationContext = context.applicationContext
    private val dataStore:DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(
            name = "my_data_store"
        )
    }
    val authToken: Flow<String?>
    get() = dataStore.data.map{preferences ->
        preferences[KEY_AUTH]
    }

    suspend fun saveAuthToken(authToken: String){
        dataStore.edit{ preferences->
            preferences[KEY_AUTH] = authToken
        }
    }
    companion object{
        private val KEY_AUTH = prefrencesKey<String>("key_auth")
    }
}