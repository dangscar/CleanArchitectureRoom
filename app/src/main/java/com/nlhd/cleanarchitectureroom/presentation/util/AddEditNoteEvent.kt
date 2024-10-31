package com.nlhd.cleanarchitectureroom.presentation.util

sealed class AddEditNoteEvent {

    data class EnteredTitle(val title: String): AddEditNoteEvent()
    data class EnteredContent(val content: String): AddEditNoteEvent()
    data object SaveNote: AddEditNoteEvent()
}