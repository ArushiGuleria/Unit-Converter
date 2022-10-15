package com.example.unit_converter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unit_converter.ui.theme.Unit_ConverterTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit_ConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConverterScreen()
                }
            }
        }
    }
}

@Composable
fun ConverterScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        //Image(
        //    painter = painterResource(R.drawable.cupcake),
        //    contentDescription = null,
        //    modifier = Modifier.width(300.dp)
        //)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Currency Conversion", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(8.dp))

        var varinput by remember { mutableStateOf("")}
        var ans by remember { mutableStateOf("")}
        SelectUnit1Button()
        SelectUnit2Button()
        SelectUnit3Button()
    }
}


@Composable
fun SelectUnit1Button() {
    Column() {
        Text(text= "Currency Converter", textAlign = TextAlign.Center, fontSize = 20.sp)

        OutlinedTextField(
            value= varinput, onValueChange = {userInput= it},
            placeHolder={Text(text= "Currency to convert", fontSize = 15.sp)}
        )
        Button(
            onClick = { ans = CurrencyC(1, varinput) },
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text("Currency:INR to USD")
        }
        Button(
            onClick = { ans = CurrencyC(2, varinput) },
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text("Currency:USD to INR")
        }
        Text(text= ans, fontSize = 22.sp )
    }
}

@Composable
fun SelectUnit2Button() {
    Column() {
        Text(text= "Time Converter", textAlign = TextAlign.Center, fontSize = 20.sp)

        OutlinedTextField(
            value= varinput, onValueChange = {userInput= it},
            placeHolder={Text(text= "Time to convert", fontSize = 15.sp)}
        )
        Button(
            onClick = { ans = TimeC(1, varinput) },
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text("Hrs to Mins")
        }
        Button(
            onClick = { ans = TimeC(2, varinput) },
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text("Currency:Mins to Hrs")
        }
        Text(text= ans, fontSize = 22.sp )
    }
}

@Composable
fun SelectUnit3Button() {
    Column() {
        Text(text= "Distance Converter", textAlign = TextAlign.Center, fontSize = 20.sp)

        OutlinedTextField(
            value= varinput, onValueChange = {userInput= it},
            placeHolder={Text(text= "Distance to convert", fontSize = 15.sp)}
        )
        Button(
            onClick = { ans = DistanceC(1, varinput) },
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text("kilometre to metre")
        }
        Button(
            onClick = { ans = DistanceC(2, varinput) },
            modifier = modifier.widthIn(min = 250.dp)
        ) {
            Text("metre to kilometre")
        }
        Text(text= ans, fontSize = 22.sp )
    }
}



@Composable
fun CurrencyC(ch1: Int, var1: String): String {
    var1= if(ch1==1) (var1.Float()/82).toString() else (var1.Float()*82).toString()
    return(var1)
    }

@Composable
fun TimeC(ch1: Int, var1: String): String {
    var1= if(ch1==1) (var1.Float()*60).toString() else (var1.Float()/60).toString()
    return(var1)
}

@Composable
fun DistanceC(ch1: Int, var1: String): String {
    var1= if(ch1==1) (var1.Float()*1000).toString() else (var1.Float()/1000).toString()
    return(var1)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Unit_ConverterTheme {
        ConverterScreen()
    }
}