package com.nlhd.cleanarchitectureroom.domain.use_cases

import com.nlhd.cleanarchitectureroom.domain.repository.NoteRepository

class GetNotes(
    private val noteRepository: NoteRepository
) {

    operator fun invoke() = noteRepository.getNotes()
}