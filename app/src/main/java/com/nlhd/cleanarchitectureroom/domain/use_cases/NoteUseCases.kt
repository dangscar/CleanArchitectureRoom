package com.nlhd.cleanarchitectureroom.domain.use_cases

data class NoteUseCases(
    val addNote: AddNote,
    val updateNote: UpdateNote,
    val deleteNote: DeleteNote,
    val getNotes: GetNotes,
    val getNote: GetNote
)
