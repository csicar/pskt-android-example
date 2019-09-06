package Foreign.Data.DateTime

import java.time.DateTimeException
import java.time.Instant
import java.time.ZoneOffset
import java.time.ZonedDateTime

val createUTC = { rec: Any ->
    rec as Map<String, Any>
    val y = rec["y"]!! as Int
    val mo = rec["mo"]!! as Int;
    val d = rec["d"]!! as Int;
    val h = rec["h"]!! as Int;
    val m = rec["m"]!! as Int;
    val s = rec["s"]!! as Int;
    val ms = rec["ms"]!! as Int;
    ZonedDateTime.of(y, mo, d, h, m, s, ms, ZoneOffset.UTC).toInstant().toEpochMilli()
}

val calcDiff = { rec1: Any, rec2: Any ->
    val ms1 = createUTC(rec1)
    val ms2 = createUTC(rec2)
    ms1 - ms2
}

val adjustImpl = { just: Any ->
    { nothing: Any ->
        { offset: Any ->
            { rec: Any ->
                offset as Int; just as (Any) -> Any
                try {
                    val ms = createUTC(rec)
                    val dt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(ms + offset), ZoneOffset.UTC)
                    just(mapOf(
                        "year" to dt.year,
                        "month" to dt.month,
                        "day" to dt.dayOfMonth,
                        "hour" to dt.hour,
                        "minute" to dt.minute,
                        "second" to dt.second,
                        "millisecond" to 0
                    ))
                } catch (e: DateTimeException) {
                    nothing
                }

            }
        }
    }
}