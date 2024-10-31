package com.nlhd.cleanarchitectureroom.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nlhd.cleanarchitectureroom.presentation.add_note.AddNoteScreen
import com.nlhd.cleanarchitectureroom.presentation.notes.NotesScreen
import com.nlhd.cleanarchitectureroom.presentation.update_note.UpdateNoteScreen

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
        composable(
            route = Screen.UpdateNoteScreen.route+"/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("id")
            UpdateNoteScreen(navController = navController, id = id!!)
        }

    }


}