package com.nlhd.cleanarchitectureroom.presentation.navigation

sealed class Screen(val route: String) {
    data object MainScreen: Screen("main_screen")
    data object AddNoteScreen: Screen("add_note_screen")
    data object UpdateNoteScreen: Screen("update_note_screen")
}