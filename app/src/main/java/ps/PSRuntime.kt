package Foreign.PsRuntime;

fun Any.app(arg: Any): Any {
return (this as (Any) -> Any)(arg)
}
