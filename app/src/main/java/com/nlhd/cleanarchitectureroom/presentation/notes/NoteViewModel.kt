package com.nlhd.cleanarchitectureroom.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nlhd.cleanarchitectureroom.domain.model.Note
import com.nlhd.cleanarchitectureroom.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel() {

    private var _noteState: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val noteState: StateFlow<List<Note>> = _noteState

    init {
        getNotes()
    }

    private var deleteNote: Note? = null
    fun getNotes() = viewModelScope.launch {
        noteUseCases.getNotes().onEach {
            _noteState.value = it
        }.launchIn(viewModelScope)
    }


    fun onEvent(event: NoteEvent) {
        if (event is NoteEvent.DeleteNote) {
            viewModelScope.launch {
                noteUseCases.deleteNote(event.note)
            }
            deleteNote = event.note
        } else {
            viewModelScope.launch {
                noteUseCases.addNote(deleteNote!!)
            }
        }
    }
}