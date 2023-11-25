package com.github.marcelobenedito.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.marcelobenedito.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskComplete(
                        image = R.drawable.ic_task_completed,
                        title = stringResource(R.string.all_tasks_completed),
                        subtitle = stringResource(R.string.nice_work)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskComplete(
    image: Int,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    // 1. Center align all of the content vertically and horizontally on the screen.
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = image), contentDescription = null)
        // 2. Set the first Text composable to a Bold font weight, 24dp padding top, and 8dp padding bottom.
        Text(
            text = title,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        // 3. Set the second Text composable to a 16sp font size.
        Text(
            text = subtitle,
            fontSize = 16.sp
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskComplete(
            image = R.drawable.ic_task_completed,
            title = stringResource(R.string.all_tasks_completed),
            subtitle = stringResource(R.string.nice_work)
        )
    }
}