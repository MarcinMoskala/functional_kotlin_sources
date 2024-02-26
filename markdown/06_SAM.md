```
interface OnClick {
   fun onClick(view: View)
}
```


```
fun setOnClickListener(listener: OnClick) {
   //...
}

setOnClickListener(object : OnClick {
   override fun onClick(view: View) {
       // ...
   }
})
```


```
fun interface OnClick {
    fun onClick(view: View)
}
```


```
interface ElementListener<T> {
    fun invoke(element: T)
}

fun interface OnClick : ElementListener<View> {
    fun onClick(view: View)

    fun invoke(element: View) {
        onClick(element)
    }
}
```