package com.nlhd.cleanarchitectureroom.domain.use_cases

import com.nlhd.cleanarchitectureroom.domain.model.Note
import com.nlhd.cleanarchitectureroom.domain.repository.NoteRepository

class AddNote(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)
}