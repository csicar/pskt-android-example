package Foreign.PsRuntime;

fun Any.app(arg: Any): Any {
return (this as (Any) -> Any)(arg)
}

fun Any.appRun() = (this as () -> Any)()
