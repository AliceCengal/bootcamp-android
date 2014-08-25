package com.vandyapps.bootcamp

import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget._
import org.scaloid.common._
import com.vandyapps.bootcamp.library.ArrayAdapterBuilder

class Main extends SActivity {

  def button = find[Button](R.id.button)
  def listView = find[SListView](R.id.listView)
  def editText = find[EditText](R.id.editText)

  var names = new java.util.ArrayList[String]

  onCreate {
    setContentView(R.layout.activity_main)

    listView.setAdapter(
      ArrayAdapterBuilder
        .fromCollection(names)
        .withContext(this)
        .withResource(android.R.layout.simple_list_item_1)
        .build())
    
    listView.setOnItemClickListener(new OnItemClickListener {
      override def onItemClick(parent: AdapterView[_],
                               view: View,
                               position: Int, id: Long): Unit = {
        names.remove(position)
        listView.invalidateViews()
      }
    })

    button.onClick {
      names.add(editText.getText.toString)
      listView.invalidateViews()
    }
  }

  object LengthStringer extends ArrayAdapterBuilder.ToString[String] {
    override def apply(obj: String): String =
      s"$obj (length = ${obj.length}})"
  }

}

