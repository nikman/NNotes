package com.niku.nnotes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.niku.nnotes.data.Nnotes
import com.niku.nnotes.ui.theme.NNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun LazyColumnScrollableComponent(notesList: List<Nnotes>) {
    LazyColumn(

        items()
        = notesList, modifier = Modifier.fillMaxHeight()) { note ->
        val context = ContextAmbient.current
        Card(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillParentMaxWidth().padding(16.dp).clickable(onClick = {
                Toast.makeText(context, "Author: ${blog.author}", Toast.LENGTH_SHORT).show()
            }),
            backgroundColor = Color(0xFFFFA867.toInt())
        ) {
            Text(
                blog.name, style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                ), modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NNotesTheme {
        Greeting("Android")
    }
}