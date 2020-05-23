import java.util.TimeZone;

object AustraliaZones extends App{
  val validIds:String = "Australia/"
  val time_zones:Array[String] = TimeZone.getAvailableIDs.filter(_.startsWith(validIds)).map(_.stripPrefix(validIds)).sorted;
  println("A full list of areas in Australia available in java.util.TimeZone:")
  println(time_zones.mkString(", "));
  for (zone <- time_zones) {
    val time_zone = TimeZone.getTimeZone(validIds + zone)
    println(zone + " is in " + time_zone.getDisplayName)
  }
}
