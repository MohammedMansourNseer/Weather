package com.app.weather.main

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector

@Stable
data class BottomMenuContentModel(val title:String,val icon:ImageVector,val route:String)
