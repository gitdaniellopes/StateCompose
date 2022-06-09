package br.com.statecompose.ui.water.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

//Possui estado e vão controlar ele para o StatelessCounter
//içamos o count de StatelessCounter para StatefulCounter.
// isso é bom por que ele pode ser reutilizado, posso passar copos de suco por exemplo e torna o composeable mais dinamico.
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}