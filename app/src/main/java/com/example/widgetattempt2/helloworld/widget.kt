package com.example.glancevideo.helloworld

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.background
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxHeight
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.layout.width
import androidx.glance.text.FontStyle
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.google.android.gms.location.LocationServices
import java.util.Locale

class WidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = HelloWorldWidget()
}

class HelloWorldWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            NJTransitWidgetContent(context)
        }
    }
}

@Composable
fun NJTransitWidgetContent(context: Context) {
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header with one background color
        Column(
            modifier = GlanceModifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = GlanceModifier.height(7.5.dp))
            Text(
            text = "Princeton",
            style = TextStyle(
                color = ColorProvider(Color.White),
                fontSize = 20.sp,
                fontWeight = androidx.glance.text.FontWeight.Bold
            ))
            //Spacer(modifier = GlanceModifier.height(7.5.dp))
        }

        Spacer(modifier = GlanceModifier.height(5.dp))
        // Body with another background color
        Column(
            modifier = GlanceModifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .background(Color.White)
        ) {
            SubBox(station = "New York", time = "10 mins", trainNum = "# 3834", c = Color.Black)
            Spacer(modifier = GlanceModifier.height(2.5.dp))
            SubBox(station = "Trenton", time = "5 mins", trainNum = "# 3831", c = Color(0xFFF7515F))
            Spacer(modifier = GlanceModifier.height(2.5.dp))
            SubBox(station = "Trenton", time = "5 mins", trainNum = "# 3831", c = Color(0xFFF7515F))
            //Spacer(modifier = GlanceModifier.height(7.5.dp))
        }
    }
}
//OLD CODE
//    Column(
//        modifier = GlanceModifier
//            .fillMaxSize()
//            .cornerRadius(16.dp)
//            .padding(horizontal = 8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Column (modifier = GlanceModifier
//            .fillMaxWidth()
//            .background(Color.Black))
//        {
//            Text(
//            text = "Princeton",
//            style = TextStyle(
//                color = ColorProvider(Color.White),
//                fontSize = 20.sp,
//                fontWeight = androidx.glance.text.FontWeight.Bold
//            )
//        )
//        }
//        Spacer(modifier = GlanceModifier.height(7.5.dp))
//        Text(
//            text = "Princeton",
//            style = TextStyle(
//                color = ColorProvider(Color.Black),
//                fontSize = 20.sp,
//                fontWeight = androidx.glance.text.FontWeight.Bold
//            )
//        )
//        Spacer(modifier = GlanceModifier.height(7.5.dp))

        // Subboxes in a column
//        Column (
//            modifier = GlanceModifier.background(ColorProvider(Color.White))
//                .fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ){
//            SubBox(station = "New York", time = "10 mins", trainNum = "# 3834", c = Color.Black)
//            Spacer(modifier = GlanceModifier.height(2.5.dp))
//            SubBox(station = "Trenton", time = "5 mins", trainNum = "# 3831", c = Color(0xFFF7515F))
//            Spacer(modifier = GlanceModifier.height(2.5.dp))
//            SubBox(station = "Trenton", time = "5 mins", trainNum = "# 3831", c = Color(0xFFF7515F))
//            Spacer(modifier = GlanceModifier.height(7.5.dp))
//        }
//    }
//}

@Composable
fun SubBox(station: String, time: String, trainNum: String, c : Color) {
    Spacer(modifier = GlanceModifier.width(15.dp))
    Row(
        modifier = GlanceModifier
            .fillMaxWidth()
            .background(ColorProvider(c))
            .cornerRadius(20.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = GlanceModifier.width(6.dp))
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = station,
                style = TextStyle(
                    color = ColorProvider(Color.White),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = trainNum,
                style = TextStyle(
                    color = ColorProvider(Color.White),
                    fontSize = 12.06.sp
                )
            )
        }
        Spacer(modifier = GlanceModifier.defaultWeight())
        Text(
            text = time,
            style = TextStyle(
                color = ColorProvider(Color.White),
                fontSize = 14.sp
            )
        )
        Spacer(modifier = GlanceModifier.width(8.dp))
    }
}