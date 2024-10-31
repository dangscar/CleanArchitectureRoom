package com.nlhd.cleanarchitectureroom.presentation.add_note

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nlhd.cleanarchitectureroom.R
import com.nlhd.cleanarchitectureroom.presentation.util.AddEditNoteEvent

@Composable
fun AddNoteScreen(
    navController: NavController,
    addNoteViewModel: AddNoteViewModel = hiltViewModel()
) {
    val title = addNoteViewModel.title.collectAsState()
    val content = addNoteViewModel.content.collectAsState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                //Click
                if (title.value.isBlank()) {
                    Toast.makeText(context, "Title cannot be empty", Toast.LENGTH_SHORT).show()
                    return@FloatingActionButton
                } else if (content.value.isBlank()) {
                    Toast.makeText(context, "Content cannot be empty", Toast.LENGTH_SHORT).show()
                    return@FloatingActionButton
                } else {
                    addNoteViewModel.onEvent(AddEditNoteEvent.SaveNote)
                    navController.navigateUp()
                }

            }) {
                Icon(painter = painterResource(id = R.drawable.baseline_save_24), contentDescription = null)
            }
        }
    ) { paddingValues ->  
        Column(
            modifier = Modifier.padding(paddingValues).padding(5.dp)
        ) {
            OutlinedTextField(
                value = title.value,
                onValueChange = {
                addNoteViewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                },
                label = {
                    Text(text = "Title")
                },
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodySmall
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = content.value,
                onValueChange = {
                    addNoteViewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
                },
                label = {
                    Text(text = "Content")
                },
                modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodySmall
            )
        }
    }
}