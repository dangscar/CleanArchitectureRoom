package com.nlhd.cleanarchitectureroom.presentation.notes

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nlhd.cleanarchitectureroom.presentation.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun NotesScreen(
    navController: NavController,
    noteViewModel: NoteViewModel = hiltViewModel()
) {
    val notes = noteViewModel.noteState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.AddNoteScreen.route) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn(

            ) {
                items(notes.value.size) {
                    NoteItem(
                        note = notes.value[it],
                        onDelete = {
                            noteViewModel.onEvent(NoteEvent.DeleteNote(notes.value[it]))
                        },
                        onUpdate = {
                            navController.navigate(route = Screen.UpdateNoteScreen.route+"/$it")
                        }
                    )
                }


            }
        }
    }
}