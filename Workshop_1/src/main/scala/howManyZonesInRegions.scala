import java.util.TimeZone

object howManyZonesInRegions extends App{
  val time_zones:Array[String] = TimeZone.getAvailableIDs //.filter(_.startsWith(validIds)).map(_.stripPrefix(validIds)).sorted;
  val time_zones_valid = time_zones.filter(id => id.contains("/"))
  val spitted_time_zones = time_zones_valid.map(x => x.split("/"))
  var cnt_zones = spitted_time_zones.toList.groupBy(zone => zone(0)).mapValues(_.size).toMap
  for (x <- cnt_zones) {
    println(x)
  }
}
