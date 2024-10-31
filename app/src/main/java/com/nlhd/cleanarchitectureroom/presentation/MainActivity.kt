package com.nlhd.cleanarchitectureroom.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.nlhd.cleanarchitectureroom.presentation.add_note.AddNoteScreen
import com.nlhd.cleanarchitectureroom.presentation.navigation.Navigation
import com.nlhd.cleanarchitectureroom.presentation.navigation.Screen
import com.nlhd.cleanarchitectureroom.presentation.notes.NoteViewModel
import com.nlhd.cleanarchitectureroom.presentation.notes.NotesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}