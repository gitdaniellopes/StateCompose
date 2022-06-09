package br.com.statecompose.ui.water

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.statecompose.data.WellnessTasksList
import br.com.statecompose.ui.water.components.StatefulCounter

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel(),
) {
    Column(modifier = modifier) {
        StatefulCounter(modifier = modifier)

        WellnessTasksList(
            modifier = modifier,
            tasks = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}