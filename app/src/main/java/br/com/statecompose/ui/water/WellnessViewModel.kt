package br.com.statecompose.ui.water

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import br.com.statecompose.data.WellnessTask

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(task: WellnessTask) {
        _tasks.remove(task)
    }

    fun changeTaskChecked(task: WellnessTask, checked: Boolean) {
        tasks.find { it.id == task.id }?.let { item ->
            item.checked = checked
        }
    }
}

private fun getWellnessTasks() = List(30) {
    WellnessTask(
        id = it,
        label = "Tarefa # $it"
    )
}