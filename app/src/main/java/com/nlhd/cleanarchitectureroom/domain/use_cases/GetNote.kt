package com.nlhd.cleanarchitectureroom.domain.use_cases

import com.nlhd.cleanarchitectureroom.domain.repository.NoteRepository

class GetNote(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(id: Int) = noteRepository.getNote(id)
}