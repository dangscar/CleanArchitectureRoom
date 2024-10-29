package com.nlhd.cleanarchitectureroom.data.repository

import com.nlhd.cleanarchitectureroom.data.data_source.NoteDao
import com.nlhd.cleanarchitectureroom.domain.model.Note
import com.nlhd.cleanarchitectureroom.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository{
    override fun getNotes(): Flow<List<Note>> = noteDao.getNotes()

    override suspend fun addNote(note: Note) =  noteDao.addNote(note)

    override suspend fun updateNote(note: Note) = noteDao.updateNote(note)

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
}