package br.com.statecompose.ui.water.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.statecompose.ui.theme.StateComposeTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text(
                modifier = modifier.padding(start = 16.dp),
                text = "Total de copos de agua: $count",
            )
        }
        Button(
            onClick = {
                count++
            },
            enabled = (count < 10)
        ) {
            Text(text = "Add")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    StateComposeTheme {
        WaterCounter()
    }
}