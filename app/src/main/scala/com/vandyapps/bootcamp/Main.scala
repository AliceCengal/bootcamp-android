package com.vandyapps.bootcamp

import android.widget._
import org.scaloid.common._

class Main extends SActivity {

  def button = find[Button](R.id.button)
  def text = find[TextView](R.id.textView)

  onCreate {
    setContentView(R.layout.activity_main)
    text.setText("Right")
    button.onClick(switch())
  }

  def switch() {
    if (text.getText == "Right") text.setText("Left")
    else text.setText("Right")
  }
  
}

