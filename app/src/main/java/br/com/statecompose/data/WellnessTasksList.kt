package br.com.statecompose.data

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.statecompose.ui.water.components.WellnessTaskItem

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    tasks: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        content = {
            /**
             * Há mais uma mudança que você precisa fazer. O itemsmétodo recebe um keyparâmetro.
             * Por padrão, o estado de cada item é digitado em relação à posição do item na lista.
             * Em uma lista mutável, isso causa problemas quando o conjunto de dados é alterado,
             * pois os itens que mudam de posição perdem efetivamente qualquer estado lembrado.
             * */

            items(
                items = tasks,
                key = { task -> task.id }
            ) { task ->
                WellnessTaskItem(
                    taskName = task.label,
                    checked = task.checked,
                    onCheckedChange = { checked -> onCheckedTask(task, checked) },
                    onClose = { onCloseTask(task) },
                )
            }
        }
    )
}