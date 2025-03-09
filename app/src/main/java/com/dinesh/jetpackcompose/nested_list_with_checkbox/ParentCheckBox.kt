package com.dinesh.jetpackcompose.nested_list_with_checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dinesh.jetpackcompose.R

@Composable
fun ParentCheckBox() {

    var parentChecked by remember { mutableStateOf(false) }
    val children = remember { mutableStateListOf(false, false, false) }

    // Parent Checkbox
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = parentChecked,
                onCheckedChange = { isChecked ->
                    parentChecked = isChecked
                    // Set all child checkboxes to the parent's state
                    children.indices.forEach { index ->
                        children[index] = isChecked
                    }
                }
            )
            Text(text = "Parent Checkbox", modifier = Modifier.padding(start = 8.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Child Checkboxes
        children.forEachIndexed { index, isChecked ->
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 24.dp)) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { checked ->
                        children[index] = checked
                        // Update parent checkbox: checked if all children are checked
                        parentChecked = children.all { it }
                    }
                )
                Text(text = "Child ${index + 1}", modifier = Modifier.padding(start = 8.dp))
            }
        }
    }

}

@Composable
fun SingleCheckBox(onChecked: MutableState<Boolean>, subItem: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = subItem,
            color = colorResource(R.color.white),
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Start,
        )

        Checkbox(
            checked = onChecked.value,
            onCheckedChange = {
                onChecked.value = it
            },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Red,
                checkmarkColor = Color.White
            ),
            interactionSource = remember {
                MutableInteractionSource()
            }
        )

    }
}

