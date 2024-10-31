package com.nlhd.cleanarchitectureroom.presentation.update_note

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nlhd.cleanarchitectureroom.domain.model.Note
import com.nlhd.cleanarchitectureroom.domain.use_cases.NoteUseCases
import com.nlhd.cleanarchitectureroom.presentation.util.AddEditNoteEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel() {

    private var _title: MutableStateFlow<String> = MutableStateFlow("")
    val title: StateFlow<String> = _title

    private var _content: MutableStateFlow<String> = MutableStateFlow("")
    val content: StateFlow<String> = _content

    private var _idNote: MutableStateFlow<Int> = MutableStateFlow(-1)
    val idNote: StateFlow<Int> = _idNote

    fun getNote(id: Int) = viewModelScope.launch {
        noteUseCases.getNote(id = id)?.let { note ->
            _title.value = note.title
            _content.value = note.content
            _idNote.value = note.id
        }
    }

    fun onEvent(event: AddEditNoteEvent) {
        when(event) {
            is AddEditNoteEvent.EnteredTitle -> {
                _title.value = event.title
            }
            is AddEditNoteEvent.EnteredContent -> {
                _content.value = event.content
            }
            AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    noteUseCases.updateNote(
                        Note(
                            title = title.value,
                            content = content.value,
                            timestamp = System.currentTimeMillis()
                        ).apply {
                            id = idNote.value
                        }
                    )
                }
            }
        }
    }
}