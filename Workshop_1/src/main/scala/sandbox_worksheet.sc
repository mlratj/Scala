// mapping short exercise
val stolice = List("Warszawa", "Berlin", "Praga")
val kraje = List("Polska", "Niemcy", "Czechy")
val stoliceKrajow = (kraje zip stolice).toMap
val capOfCzechy = stoliceKrajow.get("Czechy")
for (capital <- capOfCzechy) println(capital)


// math short exercise
import scala.math.pow

def power(x: Double, n: Int): Double = {
  if (n > 0) {
    if (n % 2 == 0) {
      val y = power(x, n / 2)
      y * y
    }
    else x * pow(x, n - 1)
  }
  else 1 / pow(x, -n)
}

println("power 2,3 of : " + power(5,3));

// array short exercise
import scala.collection.mutable.{ArrayBuffer, Map}
val tab = Seq.fill(100)(util.Random.nextInt(200)-100).toArray
object Demo {
  def funTab1(args: Array[Int]): String = {
    var sorted_asc = args.sorted
    val string_list = sorted_asc.mkString(", ")
    return string_list
  }

  def funTab2(args: Array[Int]): String = {
    var even_nums = ArrayBuffer[Int]()
    var not_even_nums = ArrayBuffer[Int]()
    for (x <- args) {
      if (x % 2 == 0)
        even_nums += x
      if (x % 2 != 0)
        not_even_nums += x
    }
    var final_order: Array[ArrayBuffer[Int]] = Array(even_nums.sorted, not_even_nums.sorted(Ordering.Int.reverse))
    val printable_final = final_order.mkString(", ")
    return printable_final
  }


  def funTab3(args: Array[Int]): Iterable[Int]= {
    var map_numbers = Map.empty[Int, Int]
    for (x <- args) {
      val x_abs = Math.abs(x)
      map_numbers += (x -> x_abs)
    }
    val sorted_map = Map(map_numbers.toSeq.sortWith(_._2 < _._2):_*)
    val keys_only: Iterable[Int] = sorted_map.keys
    return keys_only
  }
}
val fun1:String = Demo.funTab1(tab)
println(fun1)
val fun2 = Demo.funTab2(tab)
println(fun2)
val fun3: Iterable[Int] = Demo.funTab3(tab)
println(fun3)


// using reduceLeft() instead of mkString()
// unfinished
val a = Array("Mr.","Sherlock","Holmes,","who","was",
  "usually","very","late","in","the","mornings,",
  "save","upon","those","not","infrequent","occasions","when","he","was","up",
  "all","night,","was","seated","at","the","breakfast","table.")
val b = a.reduceLeft(_+ " " +_)
println(b)
val c = a.reduceRight(_+ " " +_)
println(c)
