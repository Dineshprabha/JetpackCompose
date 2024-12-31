package com.dinesh.jetpackcompose.nested_list_with_checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dinesh.jetpackcompose.R

@Composable
fun ParentCheckBox() {

    val isChecked = remember {
        mutableStateOf(false)
    }

    val departmentList = mutableListOf<Departments>()

    val department1 = Departments(
        departmentName = "Company",
        sectionName = listOf("Accounts", "Payroll", "Sales", "Marketing", "Software")
    )
    val department2 = Departments(
        departmentName = "University",
        sectionName = listOf("Mathematics", "Medical", "Arts")
    )
    val department3 = Departments(
        departmentName = "Hospital",
        sectionName = listOf("General Physician")
    )
    departmentList.add(department1)
    departmentList.add(department2)
    departmentList.add(department3)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Gray)
            .clickable { },
    ) {
        Column {
            Surface() {
                LazyColumn(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(top = 8.dp)
                        .background(Color.Gray)
                ) {
                    item {
                        for (item in departmentList) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(8.dp)
                                    .background(Color.Gray)
                            ) {
                                SingleCheckBox(onChecked = isChecked, item.departmentName)
                                if (item.sectionName.isNotEmpty()) {
                                    for (subItem in item.sectionName) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight()
                                                .background(colorResource(id = R.color.teal_700))
                                        ) {
                                            SingleCheckBox(onChecked = isChecked, subItem)
                                            Divider()
                                        }

                                    }

                                }
                                //Sublist

                                Divider()
                            }
                        }
                    }
                }
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

