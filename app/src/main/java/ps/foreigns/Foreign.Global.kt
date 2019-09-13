package Foreign.Global;

import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*

val nan = Double.NaN

val isNaN = { x: Any -> x as Double; x.isNaN() }

val infinity = Double.POSITIVE_INFINITY

val isFinite = { x: Any -> x as Double; x.isFinite() }

val readInt = { radix: Any -> { n: Any -> radix as Int; n as String; n.toInt(radix) } }

val readFloat = { x:Any -> x as String; x.toDouble()}

val __toFixed = { digits: Any ->
    { fail: Any, succ: Any, digits: Any, n: Any ->
        fail as (Any) -> Any; succ as (Any) -> Any; digits as Int; n as Double
        try {

            succ("%.${digits}f".format(n))
        } catch(e: IllegalFormatException) {
            fail(e.message?:"")
        }
    };
};

val __toExponential = { digits: Any ->
    { fail: Any, succ: Any, digits: Any, n: Any ->
        fail as (Any) -> Any; succ as (Any) -> Any; digits as Int; n as Double
        TODO("implement")
    };
};

val __toPrecision = { digits: Any ->
    { fail: Any, succ: Any, digits: Any, n: Any ->
        fail as (Any) -> Any; succ as (Any) -> Any; digits as Int; n as Double
        try {

            succ("%.${digits}f".format(n))
        } catch(e: IllegalFormatException) {
            fail(e.message?:"")
        }
    };
};

val __decodeURI = { fail: Any, succ: Any, s: Any ->
    fail as (Any) -> Any; succ as (Any) -> Any; s as String;
    try {

        succ(URLDecoder.decode(s, StandardCharsets.UTF_8.name()))
    } catch (e: UnsupportedEncodingException) {
        fail(e.message ?: "")
    }
}
val __encodeURI ={ fail: Any, succ: Any, s: Any ->
    fail as (Any) -> Any; succ as (Any) -> Any; s as String;
    try {

        succ(URLEncoder.encode(s, StandardCharsets.UTF_8.name()))
    } catch (e: UnsupportedEncodingException) {
        fail(e.message ?: "")
    }
}


val __decodeURIComponent = __decodeURI//TODO: check is interchangeable
val __encodeURIComponent = __encodeURI