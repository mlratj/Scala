def power_tail_recursive {
  val rand = new util.Random(100)
  val tab = Seq.fill(10000)(rand.nextInt(200)).toArray

  def timeOf[A](f: => A) = {
    val s = System.nanoTime
    val r = f
    println("time: " + (System.nanoTime - s) / 1e9 + " sec.")
  }

  timeOf(tab.map((x) => power_tail_recursive));
}