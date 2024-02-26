```
//1
data class Complex(val real: Double, val imaginary: Double) {
    fun doubled(): Complex =
        Complex(this.real * 2, this.imaginary * 2)
    fun times(num: Int) =
        Complex(real * num, imaginary * num)
}

fun zeroComplex(): Complex = Complex(0.0, 0.0)

fun makeComplex(
    real: Double = 0.0,
    imaginary: Double = 0.0
) = Complex(real, imaginary)

fun Complex.plus(other: Complex): Complex =
    Complex(real + other.real, imaginary + other.imaginary)
fun Int.toComplex() = Complex(this.toDouble(), 0.0)
```


```
//2
fun add(a: Int, b: Int) = a + b

fun main() {
   val f = ::add // function reference
   println(f.isOpen) // false
   println(f.visibility) // PUBLIC
   // The above statements require `kotlin-reflect`
   // dependency
}
```


```
//3
fun add(a: Int, b: Int) = a + b

fun main() {
   val f: (Int, Int) -> Int = ::add
   // an alternative to:
   // val f: (Int, Int) -> Int = { a, b -> add(a, b) }
   println(f(10, 20)) // 30
}
```


```
//4
fun zeroComplex(): Complex = Complex(0.0, 0.0)

fun makeComplex(
   real: Double = 0.0,
   imaginary: Double = 0.0
) = Complex(real, imaginary)

data class Complex(val real: Double, val imaginary: Double)

fun main() {
   val f1: () -> Complex = ::zeroComplex
   println(f1()) // Complex(real=0.0, imaginary=0.0)

   val f2: (Double, Double) -> Complex = ::makeComplex
   println(f2(1.0, 2.0)) // Complex(real=1.0, imaginary=2.0)
}
```


```
fun produceComplex1(producer: ()->Complex) {}
produceComplex1(::makeComplex)  
fun produceComplex2(producer: (Double)->Complex) {}
produceComplex2(::makeComplex)
```


```
//5
data class Number(val num: Int) {
   fun toFloat(): Float = num.toFloat()
   fun times(n: Int): Number = Number(num * n)
}

fun main() {
   val numberObject = Number(10)
   // member function reference
   val float: (Number) -> Float = Number::toFloat
   // `toFloat` has no parameters, but its function type
   // needs a receiver of type `Number`
   println(float(numberObject)) // 10.0
   val multiply: (Number, Int) -> Number = Number::times
   println(multiply(numberObject, 4)) // Number(num = 40.0)
   // `times` has one parameter of type `Int`, but its
   // function type also needs a receiver of type `Number`
}
```


```
//6
fun sum(a: Int, b: Int) =
   (a..b).fold(0, Int::plus)

fun product(a: Int, b: Int) =
   (a..b).fold(1, Int::times)
```


```
//7
data class Complex(val real: Double, val imaginary: Double) {
   fun doubled(): Complex =
       Complex(this.real * 2, this.imaginary * 2)
   fun times(num: Int) =
       Complex(real * num, imaginary * num)
}

fun main() {
   val c1 = Complex(1.0, 2.0)

   val f1: (Complex) -> Complex = Complex::doubled
   println(f1(c1)) // Complex(real=2.0, imaginary=4.0)

   val f2: (Complex, Int) -> Complex = Complex::times
   println(f2(c1, 4)) // Complex(real=4.0, imaginary=8.0)
}
```


```
data class Number(val num: Int)

fun Number.toFloat(): Float = num.toFloat()
fun Number.times(n: Int): Number = Number(num * n)

fun main() {
   val num = Number(10)
   // extension function reference
   val float: (Number) -> Float = Number::toFloat
   println(float(num)) // 10.0
   val multiply: (Number, Int) -> Number = Number::times
   println(multiply(num, 4)) // Number(num = 40.0)
}
```


```
data class Complex(val real: Double, val imaginary: Double)

fun Complex.plus(other: Complex): Complex =
   Complex(real + other.real, imaginary + other.imaginary)

fun Int.toComplex() = Complex(this.toDouble(), 0.0)

fun main() {
   val c1 = Complex(1.0, 2.0)
   val c2 = Complex(4.0, 5.0)

   // extension function reference
   val f1: (Complex, Complex) -> Complex = Complex::plus
   println(f1(c1, c2)) // Complex(real=5.0, imaginary=7.0)

   val f2: (Complex, Int) -> Complex = Complex::times
   println(f2(c1, 4)) // Complex(real=4.0, imaginary=8.0)
}
```


```
//8
class TeamPoints(val points: List<Int>) {
   fun <T> calculatePoints(operation: (List<Int>) -> T): T =
       operation(points)
}

fun main() {
   val teamPoints = TeamPoints(listOf(1, 3, 5))

   val sum = teamPoints
       .calculatePoints(List<Int>::sum)
   println(sum) // 9

   val avg = teamPoints
       .calculatePoints(List<Int>::average)
   println(avg) // 3.0

   val invalid = String?::isNullOrBlank
   println(invalid(null)) // true
   println(invalid("  ")) // true
   println(invalid("AAA")) // false
}
```


```
//9
class Box<T>(private val value: T) {
   fun unbox(): T = value
}

fun main() {
   val unbox = Box<String>::unbox
   val box = Box("AAA")
   println(unbox(box)) // AAA
}
```


```
//10
data class Number(val num: Int) {
   fun toFloat(): Float = num.toFloat()
   fun times(n: Int): Number = Number(num * n)
}

fun main() {
   val num = Number(10)
   // bounded function reference
   val getNumAsFloat: () -> Float = num::toFloat
   // There is no need for receiver type in function type,
   // because reference is already bound to an object
   println(getNumAsFloat()) // 10.0
   val multiplyNum: (Int) -> Number = num::times
   println(multiplyNum(4)) // Number(num = 40.0)
}
```


```
data class Complex(val real: Double, val imaginary: Double) {
   fun doubled(): Complex =
       Complex(this.real * 2, this.imaginary * 2)
   fun times(num: Int) =
       Complex(real * num, imaginary * num)
}

fun Complex.plus(other: Complex): Complex =
   Complex(real + other.real, imaginary + other.imaginary)
fun Int.toComplex() = Complex(this.toDouble(), 0.0)

fun main() {
   val c1 = Complex(1.0, 2.0)

   val f1: () -> Complex = c1::doubled
   println(f1()) // Complex(real=2.0, imaginary=4.0)

   val f2: (Int) -> Complex = c1::times
   println(f2(17)) // Complex(real=17.0, imaginary=34.0)

   val f3: (Complex) -> Complex = c1::plus
   println(f3(Complex(12.0, 13.0)))
   // Complex(real=13.0, imaginary=15.0)

   val f4: () -> Complex = 42::toComplex
   println(f4()) // Complex(real=42.0, imaginary=0.0)
}
```


```
//11
object SuperUser {
   fun getId() = 0
}

fun main() {
   val myId = SuperUser::getId
   println(myId()) // 0

   val obj = object {
       fun cheer() {
           println("Hello")
       }
   }
   val f = obj::cheer
   f() // Hello
}
```


```
class MainPresenter(
   private val view: MainView,
   private val repository: MarvelRepository
) : BasePresenter() {

   fun onViewCreated() {
       subscriptions += repository.getAllCharacters()
           .applySchedulers()
           .subscribeBy(
               onSuccess = this::show,
               onError = view::showError
           )
   }

   fun show(items: List<MarvelCharacter>) {
       // ...
       view.show(items)
   }
}
```


```
//12
data class Complex(val real: Double, val imaginary: Double)

fun main() {
  // constructor reference
  val produce: (Double, Double) -> Complex = ::Complex
  println(produce(1.0, 2.0))
  // Complex(real=1.0, imaginary=2.0)
}
```


```
//13
class StudentId(val value: Int)
class UserId(val value: Int) {
   constructor(studentId: StudentId) : this(studentId.value)
}

fun main() {
   val ints: List<Int> = listOf(1, 1, 2, 3, 5, 8)
   val studentIds: List<StudentId> = ints.map(::StudentId)
   val userIds: List<UserId> = studentIds.map(::UserId)
}
```


```
//14
object Robot {
   fun moveForward() { 
       /*...*/
   }
   fun moveBackward() { 
       /*...*/
   }
}

fun main() {
   Robot.moveForward()
   Robot.moveBackward()

   val action1: () -> Unit = Robot::moveForward
   val action2: () -> Unit = Robot::moveBackward
}
```


```
//15
class Drone {
   fun setOff() {}
   fun land() {}

   companion object {
       fun makeDrone(): Drone = Drone()
   }
}

fun main() {
   val maker: () -> Drone = Drone.Companion::makeDrone
}
```


```
//16
fun foo(i: Int) = 1
fun foo(str: String) = "AAA"

fun main() {
  println(foo(123)) // 1
  println(foo("")) // AAA
}
```


```
//17
fun foo(i: Int) = 1
fun foo(str: String) = "AAA"

fun main() {
  val fooInt: (Int) -> Int = ::foo
  println(fooInt(123)) // 1
  val fooStr: (String) -> String = ::foo
  println(fooStr("")) // AAA
}
```


```
//18
class StudentId(val value: Int)
data class UserId(val value: Int) {
   constructor(studentId: StudentId) : this(studentId.value)
}

fun main() {
   val intToUserId: (Int) -> UserId = ::UserId
   println(intToUserId(1)) // UserId(value=1)

   val studentId = StudentId(2)
   val studentIdToUserId: (StudentId) -> UserId = ::UserId
   println(studentIdToUserId(studentId)) // UserId(value=2)
}
```


```
//19
data class Complex(val real: Double, val imaginary: Double)

fun main() {
   val c1 = Complex(1.0, 2.0)
   val c2 = Complex(3.0, 4.0)

   // property reference
   val getter: (Complex) -> Double = Complex::real

   println(getter(c1)) // 1.0
   println(getter(c2)) // 3.0

   // bounded property reference
   val c1ImgGetter: () -> Double = c1::imaginary
   println(c1ImgGetter()) // 2.0
}
```