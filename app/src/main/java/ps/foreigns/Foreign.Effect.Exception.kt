package Foreign.Effect.Exception


val showErrorImpl = { err: Any ->
    err as Throwable
    err.toString()
};

val error = { msg: Any ->
    msg as String
    Exception(msg);
};

val message = { e: Any ->
    e as Throwable
    e.message;
};

val name = { e: Any ->
    e as Throwable
    e::class.simpleName
};

val stackImpl = { just: Any ->
    { nothing: Any ->
        { e: Any ->
            e as Throwable; just as (Any) -> Any
            if (e.stackTrace.size == 0) {
                nothing
            } else {
                just(e.stackTrace)
            }
        };
    };
};

val throwException = { e: Any ->
    {
        e as Throwable
        throw e;
    };
};

val catchException = { c: Any ->
    { t: Any ->
        {
            c as (Any) -> (() -> Any); t as () -> Any
            try {
                t();
            } catch (e: Throwable) {
                c(e)();
            }
        }
    };
};


