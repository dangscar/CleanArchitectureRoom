package com.nlhd.cleanarchitectureroom.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nlhd.cleanarchitectureroom.data.data_source.NoteDatabase
import com.nlhd.cleanarchitectureroom.data.repository.NoteRepositoryImpl
import com.nlhd.cleanarchitectureroom.domain.repository.NoteRepository
import com.nlhd.cleanarchitectureroom.domain.use_cases.AddNote
import com.nlhd.cleanarchitectureroom.domain.use_cases.DeleteNote
import com.nlhd.cleanarchitectureroom.domain.use_cases.GetNote
import com.nlhd.cleanarchitectureroom.domain.use_cases.GetNotes
import com.nlhd.cleanarchitectureroom.domain.use_cases.NoteUseCases
import com.nlhd.cleanarchitectureroom.domain.use_cases.UpdateNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase = NoteDatabase.getAudioMusicDatabase(context)

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository = NoteRepositoryImpl(
        noteDao = noteDatabase.noteDao
    )

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository) : NoteUseCases = NoteUseCases(
        addNote = AddNote(noteRepository),
        updateNote = UpdateNote(noteRepository),
        deleteNote = DeleteNote(noteRepository),
        getNotes = GetNotes(noteRepository),
        getNote = GetNote(noteRepository)

    )
}