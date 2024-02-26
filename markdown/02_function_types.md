```
//1
fun fetchText(
    onSuccess: (String) -> Unit,
    onFailure: (Throwable) -> Boolean
) {
    // ...
    onSuccess.invoke("Some text") // returns Unit
    // or
    val handled: Boolean =
        onFailure.invoke(Error("Some error"))
}
```


```
//2
fun fetchText(
    onSuccess: (String) -> Unit,
    onFailure: (Throwable) -> Boolean
) {
    // ...
    onSuccess("Some text") // returns Unit
    // or
    val handled: Boolean = onFailure(Error("Some error"))
}
```


```
//3
fun someOperations(
    onStart: (() -> Unit)? = null,
    onCompletion: (() -> Unit)? = null,
) {
    onStart?.invoke()
    // ...
    onCompletion?.invoke()
}
```


```
class Button(val text: String, val onClick: () -> Unit)

var listeners: List<(Action) -> Unit> = emptyList()

fun setListener(listener: (Action) -> Unit) {
    listeners = listeners + listener
}
```


```
fun setListItemListener(
    listener: (Int, Int, View, View) -> Unit
) {
    listeners = listeners + listener
}
```


```
fun setListItemListener(
    listener: (
        position: Int,
        id: Int,
        child: View,
        parent: View
    ) -> Unit
) {
    listeners = listeners + listener
}
```


```
private var listeners =
    emptyList<(Int, Int, View, View) -> Unit>()

fun setListItemListener(
    listener: (
        position: Int, id: Int,
        View, parent: View
    ) -> Unit
) {
    listeners = listeners + listener
}

fun removeListItemListener(
    listener: (Int, Int, View, View) -> Unit
) {
    listeners = listeners - listener
}
```


```
typealias Users = List<User>

fun updateUsers(users: Users) {}
// during compilation becomes
// fun updateUsers(users: List<User>) {}

fun main() {
    val users: Users = emptyList()
    // during compilation becomes
    // val users: List<User> = emptyList()

    val newUsers: List<User> = emptyList()
    updateUsers(newUsers) // acceptable
}
```


```
import thirdparty.Name

class Foo {
    val name1: Name
    val name2: my.Name
}
```


```
import my.Name

typealias ThirdPartyName = thirdparty.Name

class Foo {
    val name1: ThirdPartyName
    val name2: Name
}
```


```
//4
// DON'T DO THAT! Misleading and false type safety
typealias Minutes = Int
typealias Seconds = Int

fun decideAboutTime(): Minutes = 10
fun setupTimer(time: Seconds) { 
    /*...*/
}

fun main() {
    val time = decideAboutTime()
    setupTimer(time)
}
```


```
//5
class OnClick : (Int) -> Unit {
    override fun invoke(viewId: Int) {
        // ...
    }
}

fun setListener(l: (Int) -> Unit) { 
    /*...*/
}

fun main() {
    val onClick = OnClick()
    setListener(onClick)
}
```