package Foreign.Data.DateTime.Instant

import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.time.ZonedDateTime

val createDateTime = {y: Any, m: Any, d: Any, h: Any, mi: Any, s: Any, ms: Any ->
    y as Int; m as Int; d as Int; h as Int; mi as Int; s as Int; ms as Int;
    ZonedDateTime.of(y, m, d, h, mi, s, ms, ZoneOffset.UTC)
}

val fromDateTimeImpl = {y: Any, mo: Any, d: Any, h: Any, mi: Any, s: Any, ms: Any ->
  createDateTime(y, mo, d, h, mi, s, ms).toInstant().toEpochMilli()
}

val toDateTimeImpl = { ctor: Any ->
    { instant: Any->
        instant as Int
        ctor as ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> (Any) -> Any))))))
        val dt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(instant.toLong()), ZoneOffset.UTC)
        ctor(dt.year)(dt.month+1)(dt.dayOfMonth)(dt.hour)(dt.minute)(dt.second)(0)
    }
}