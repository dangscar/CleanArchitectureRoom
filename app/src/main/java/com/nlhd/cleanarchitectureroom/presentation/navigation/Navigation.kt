package com.nlhd.cleanarchitectureroom.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nlhd.cleanarchitectureroom.presentation.add_note.AddNoteScreen
import com.nlhd.cleanarchitectureroom.presentation.notes.NotesScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            NotesScreen(navController = navController)
        }
        composable(route = Screen.AddNoteScreen.route) {
            AddNoteScreen(navController = navController)
        }

    }


}