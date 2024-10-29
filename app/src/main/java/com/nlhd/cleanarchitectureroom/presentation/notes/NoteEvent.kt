package com.nlhd.cleanarchitectureroom.presentation.notes

import com.nlhd.cleanarchitectureroom.domain.model.Note

sealed class NoteEvent {
    data class DeleteNote(val note: Note): NoteEvent()
    data object RestoreNote: NoteEvent()
}