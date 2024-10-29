package com.nlhd.cleanarchitectureroom.domain.repository

import com.nlhd.cleanarchitectureroom.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    //Get notes
    fun getNotes() : Flow<List<Note>>

    //Add notes
    suspend fun addNote(note: Note)

    //Update notes
    suspend fun updateNote(note: Note)

    //Delete notes
    suspend fun deleteNote(note: Note)

    //Get note by id
    suspend fun getNote(id: Int): Note?
}