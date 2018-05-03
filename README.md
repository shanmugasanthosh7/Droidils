# Droidils

Android's Simple Views and Utils in KOTLIN. 

# Download

```gradle
dependencies {
      implementation 'com.aptus:droidils:1.0.2'
}
```
Views
-----

Lets see the example,

In Xml,

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context=".MainActivity"
    tools:showIn="@layout/activity_main">

    <com.aptus.droidils.views.HtmlTextView
        android:id="@+id/htmlTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</android.support.constraint.ConstraintLayout>
```

In Activity,

```kotlin
class MainActivity : AppCompatActivity() {

          override fun onCreate(savedInstanceState: Bundle?) {
              super.onCreate(savedInstanceState)
              setContentView(R.layout.activity_main)
              setSupportActionBar(toolbar)
              val htmlTextView: HtmlTextView = findViewById(R.id.htmlTextView)
              htmlTextView.setHtmlText("<b>What</b> <i>the</i> <u>Html</u>")
          }
      }
```

- VectorDrawableButton - which supports vector drawable in left,right,top and bottom position.
- CheckbaleButton - checkable interface added.
- EndlessRecyclerScrollListener - which is used for simple pagination or load more.

Droidils utils classes fully based on Kotlin Extension function. So, we can write code concise and avoid boilerplate.

Example, 

>String to Uri

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //Here using kotlin Extension to avoid findViewById
        fab.setOnClickListener {
            val url = "http://www.example.com";
            val browserIntent = Intent(Intent.ACTION_VIEW, url.toUri()) // these convert String to Uri using kotlin extension function
            startActivity(browserIntent)
        }
    }
}
```

> Parse String to Date
```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val dateTime = "19-03-2018 09:40" // date in String
        val date = dateTime.toParseDateTime("dd-MM-yyyy hh:mm") // Convert into Date.
    }
}
```

> Format Date
```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val dateTime = "19-03-2018 09:40" // date in String
        val date = dateTime.toParseDateTime("dd-MM-yyyy hh:mm") // Convert into Date.
        val formatDate = date.toFormatDateTime("dd MMM yyyy") // Date into String by given format
    }
}
```

> Hide and Show Status Bar in simple way
```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fullScreen() // hide StatusBar

        fab.setOnClickListener {
           exitFullScreen()// Show StatusBar
        }
    }
}
```

>Json String to Object

Droidils uses [Google's GSON][GSON] library

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val jsonString = "{ name: droidils, age: 25 }" // JSON String
        val jsonObjectSerialized = jsonString.toJsonObject<User>() // Serialized as Object
    }
}
```
>Json Object to String

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val jsonObject = User("Droidils","25") // Object
        val jsonString = jsonObject.toJson() // Object to Json
    }
}
```

Added few simple views and utils classes more will add soon. Please give suggestion to improve Droidils.

Licence
-------

      Copyright 2018 Shanmugasanthosh

          Licensed under the Apache License, Version 2.0 (the "License");
          you may not use this file except in compliance with the License.
          You may obtain a copy of the License at

             http://www.apache.org/licenses/LICENSE-2.0

          Unless required by applicable law or agreed to in writing, software
          distributed under the License is distributed on an "AS IS" BASIS,
          WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
          See the License for the specific language governing permissions and
          limitations under the License.
      
      
      
      
      
      
[GSON]: https://github.com/google/gson