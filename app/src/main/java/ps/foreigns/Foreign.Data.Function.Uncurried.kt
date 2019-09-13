package Foreign.Data.Function.Uncurried


val mkFn0 = { fn: Any ->
    {
        fn as (Any) -> Any
        fn(Unit);
    }
}

val mkFn2 = { fn: Any ->
    { a: Any, b: Any ->
        fn as (Any) -> ((Any) -> Any)
        fn(a)(b);
    }
}

val mkFn3 = { fn: Any ->
    { a: Any, b: Any, c: Any ->
        fn as (Any) -> ((Any) -> ((Any) -> Any))
        fn(a)(b)(c);
    }
}

val mkFn4 = { fn: Any ->
    { a: Any, b: Any, c: Any, d: Any ->
        fn as (Any) -> ((Any) -> ((Any) -> ((Any) -> Any)))
        fn(a)(b)(c)(d);
    }
}

val mkFn5 = { fn: Any ->
    { a: Any, b: Any, c: Any, d: Any, e: Any ->
        fn as (Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> Any))))
        fn(a)(b)(c)(d)(e);
    }
}

val mkFn6 = { fn: Any ->
    { a: Any, b: Any, c: Any, d: Any, e: Any, f: Any ->
        fn as (Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> Any)))))
        fn(a)(b)(c)(d)(e)(f);
    }
}

val mkFn7 = { fn: Any ->
    { a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any ->
        fn as (Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> Any))))))
        fn(a)(b)(c)(d)(e)(f)(g);
    }
}

val mkFn8 = { fn: Any ->
    { a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any ->
        fn as (Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> Any)))))))
        fn(a)(b)(c)(d)(e)(f)(g)(h);
    }
}

val mkFn9 = { fn: Any ->
    { a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any ->
        fn as (Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> Any))))))))
        fn(a)(b)(c)(d)(e)(f)(g)(h)(i);
    }
}

val mkFn10 = { fn: Any ->
    { a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any ->
        fn as (Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> ((Any) -> Any)))))))))
        fn(a)(b)(c)(d)(e)(f)(g)(h)(i)(j);
    }
}

val runFn0 = { fn: Any ->
    fn as (Any) -> Any
    fn(Unit)
}

val runFn2 = { fn: Any ->
    { a: Any ->
        { b: Any ->

            fn as (Any, Any) -> Any
            fn(a, b)

        }
    }
}

val runFn3 = { fn: Any ->
    { a: Any ->
        { b: Any ->
            { c: Any ->

                fn as (Any, Any, Any) -> Any
                fn(a, b, c)

            }
        }
    }
}

val runFn4 = { fn: Any ->
    { a: Any ->
        { b: Any ->
            { c: Any ->
                { d: Any ->

                    fn as (Any, Any, Any, Any) -> Any
                    fn(a, b, c, d)

                }
            }
        }
    }
}

val runFn5 = { fn: Any ->
    { a: Any ->
        { b: Any ->
            { c: Any ->
                { d: Any ->
                    { e: Any ->

                        fn as (Any, Any, Any, Any, Any) -> Any
                        fn(a, b, c, d, e)

                    }
                }
            }
        }
    }
}

val runFn6 = { fn: Any ->
    { a: Any ->
        { b: Any ->
            { c: Any ->
                { d: Any ->
                    { e: Any ->
                        { f: Any ->

                            fn as (Any, Any, Any, Any, Any, Any) -> Any
                            fn(a, b, c, d, e, f)

                        }
                    }
                }
            }
        }
    }
}

val runFn7 = { fn: Any ->
    { a: Any ->
        { b: Any ->
            { c: Any ->
                { d: Any ->
                    { e: Any ->
                        { f: Any ->
                            { g: Any ->

                                fn as (Any, Any, Any, Any, Any, Any, Any) -> Any
                                fn(a, b, c, d, e, f, g)

                            }
                        }
                    }
                }
            }
        }
    }
}

val runFn8 = { fn: Any ->
    { a: Any ->
        { b: Any ->
            { c: Any ->
                { d: Any ->
                    { e: Any ->
                        { f: Any ->
                            { g: Any ->
                                { h: Any ->

                                    fn as (Any, Any, Any, Any, Any, Any, Any, Any) -> Any
                                    fn(a, b, c, d, e, f, g, h)

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

val runFn9 = { fn: Any ->
    { a: Any ->
        { b: Any ->
            { c: Any ->
                { d: Any ->
                    { e: Any ->
                        { f: Any ->
                            { g: Any ->
                                { h: Any ->
                                    { i: Any ->

                                        fn as (Any, Any, Any, Any, Any, Any, Any, Any, Any) -> Any
                                        fn(a, b, c, d, e, f, g, h, i)

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

val runFn10 = { fn: Any ->
    { a: Any ->
        { b: Any ->
            { c: Any ->
                { d: Any ->
                    { e: Any ->
                        { f: Any ->
                            { g: Any ->
                                { h: Any ->
                                    { i: Any ->
                                        { j: Any ->

                                            fn as (Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) -> Any
                                            fn(a, b, c, d, e, f, g, h, i, j)

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}