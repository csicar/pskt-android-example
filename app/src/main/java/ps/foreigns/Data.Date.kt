package Foreign.Data.Date

import java.time.Duration
import java.time.ZoneOffset
import java.time.ZonedDateTime

val createDate = { y: Int, m: Int, d: Int ->
    ZonedDateTime.of(y, m, d, 0, 0, 0, 0, ZoneOffset.UTC)
}

val canonicalDateImpl = { ctor: Any, y: Any, m: Any, d: Any ->
    ctor as ((Any) -> ((Any) -> ((Any) -> Any))); y as Int; m as Int; d as Int
    val date = createDate(y, m - 1, d)
    ctor(date.year)(date.month + 1)(date.dayOfMonth)
}

val calcWeekday = { y: Any, m: Any, d: Any ->
    y as Int; m as Int; d as Int
    createDate(y, m - 1, d).dayOfMonth
}

val calcDiff = { y1: Any, m1: Any, d1: Any, y2: Any, m2: Any, d2: Any ->
  y1 as Int; m1 as Int; d1 as Int; y2 as Int; m2 as Int; d2 as Int
  val dt1 = createDate(y1 as Int, m1 - 1, d1)
  val dt2 = createDate(y2 as Int, m2 - 1, d2)
  Duration.between(dt1, dt2).toMillis()
}