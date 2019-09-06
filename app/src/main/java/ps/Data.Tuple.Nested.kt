@file:Suppress("UNCHECKED_CAST")
package PS.Data.Tuple.Nested
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val uncurry9 = { f_tick : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple) -> {
          val f_tick1 = f_tick;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          val g = v.value1.value1.value1.value1.value1.value1.value0;
          val h = v.value1.value1.value1.value1.value1.value1.value1.value0;
          val i = v
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value0;
          f_tick1.app(a).app(b).app(c).app(d).app(e).app(f).app(g).app(h)
            .app(i);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val uncurry8 = { f_tick : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple) -> {
          val f_tick1 = f_tick;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          val g = v.value1.value1.value1.value1.value1.value1.value0;
          val h = v.value1.value1.value1.value1.value1.value1.value1.value0;
          f_tick1.app(a).app(b).app(c).app(d).app(e).app(f).app(g).app(h);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val uncurry7 = { f_tick : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple) -> {
          val f_tick1 = f_tick;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          val g = v.value1.value1.value1.value1.value1.value1.value0;
          f_tick1.app(a).app(b).app(c).app(d).app(e).app(f).app(g);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val uncurry6 = { f_tick : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple) -> {
          val f_tick1 = f_tick;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          f_tick1.app(a).app(b).app(c).app(d).app(e).app(f);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val uncurry5 = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple) -> {
          val f1 = f;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          f1.app(a).app(b).app(c).app(d).app(e);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val uncurry4 = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple) -> {
          val f1 = f;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          f1.app(a).app(b).app(c).app(d);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val uncurry3 = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple) -> {
          val f1 = f;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          f1.app(a).app(b).app(c);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val uncurry2 = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple) -> {
          val f1 = f;
          val a = v.value0;
          val b = v.value1.value0;
          f1.app(a).app(b);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val uncurry10 = { f_tick : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple) -> {
          val f_tick1 = f_tick;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          val g = v.value1.value1.value1.value1.value1.value1.value0;
          val h = v.value1.value1.value1.value1.value1.value1.value1.value0;
          val i = v
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value0;
          val j = v
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value0;
          f_tick1.app(a).app(b).app(c).app(d).app(e).app(f).app(g).app(h).app(i)
            .app(j);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val uncurry1 = { f : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
          val f1 = f;
          val a = v.value0;
          f1.app(a);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val tuple9 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               { g : Any ->
                 { h : Any ->
                   { i : Any ->
                     PS.Data.Tuple.Module.Tuple.app(a)
                       .app(PS.Data.Tuple.Module.Tuple.app(b)
                              .app(PS.Data.Tuple.Module.Tuple.app(c)
                                     .app(PS.Data.Tuple.Module.Tuple.app(d)
                                            .app(PS.Data.Tuple.Module.Tuple
                                                   .app(e)
                                                   .app(
                              PS.Data.Tuple.Module.Tuple.app(f)
                                .app(PS.Data.Tuple.Module.Tuple.app(g)
                                       .app(PS.Data.Tuple.Module.Tuple.app(h)
                                              .app(PS.Data.Tuple.Module.Tuple
                                                     .app(i)
                                                     .app(
                                      PS.Data.Unit.Module.unit)))))))))
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val tuple8 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               { g : Any ->
                 { h : Any ->
                   PS.Data.Tuple.Module.Tuple.app(a)
                     .app(PS.Data.Tuple.Module.Tuple.app(b)
                            .app(PS.Data.Tuple.Module.Tuple.app(c)
                                   .app(PS.Data.Tuple.Module.Tuple.app(d)
                                          .app(PS.Data.Tuple.Module.Tuple.app(e)
                                                 .app(PS.Data.Tuple.Module.Tuple
                                                        .app(f)
                                                        .app(
                              PS.Data.Tuple.Module.Tuple.app(g)
                                .app(PS.Data.Tuple.Module.Tuple.app(h)
                                       .app(PS.Data.Unit.Module.unit))))))))
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val tuple7 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               { g : Any ->
                 PS.Data.Tuple.Module.Tuple.app(a)
                   .app(PS.Data.Tuple.Module.Tuple.app(b)
                          .app(PS.Data.Tuple.Module.Tuple.app(c)
                                 .app(PS.Data.Tuple.Module.Tuple.app(d)
                                        .app(PS.Data.Tuple.Module.Tuple.app(e)
                                               .app(PS.Data.Tuple.Module.Tuple
                                                      .app(f)
                                                      .app(
                            PS.Data.Tuple.Module.Tuple.app(g)
                              .app(PS.Data.Unit.Module.unit)))))))
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val tuple6 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               PS.Data.Tuple.Module.Tuple.app(a)
                 .app(PS.Data.Tuple.Module.Tuple.app(b)
                        .app(PS.Data.Tuple.Module.Tuple.app(c)
                               .app(PS.Data.Tuple.Module.Tuple.app(d)
                                      .app(PS.Data.Tuple.Module.Tuple.app(e)
                                             .app(PS.Data.Tuple.Module.Tuple
                                                    .app(f)
                                                    .app(
                          PS.Data.Unit.Module.unit))))))
            }
          }
        }
      }
    }
  };
  @JvmField
  val tuple5 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             PS.Data.Tuple.Module.Tuple.app(a)
               .app(PS.Data.Tuple.Module.Tuple.app(b)
                      .app(PS.Data.Tuple.Module.Tuple.app(c)
                             .app(PS.Data.Tuple.Module.Tuple.app(d)
                                    .app(PS.Data.Tuple.Module.Tuple.app(e)
                                           .app(PS.Data.Unit.Module.unit)))))
          }
        }
      }
    }
  };
  @JvmField
  val tuple4 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           PS.Data.Tuple.Module.Tuple.app(a)
             .app(PS.Data.Tuple.Module.Tuple.app(b)
                    .app(PS.Data.Tuple.Module.Tuple.app(c)
                           .app(PS.Data.Tuple.Module.Tuple.app(d)
                                  .app(PS.Data.Unit.Module.unit))))
        }
      }
    }
  };
  @JvmField
  val tuple3 = { a : Any ->
     { b : Any ->
       { c : Any ->
         PS.Data.Tuple.Module.Tuple.app(a)
           .app(PS.Data.Tuple.Module.Tuple.app(b)
                  .app(PS.Data.Tuple.Module.Tuple.app(c)
                         .app(PS.Data.Unit.Module.unit)))
      }
    }
  };
  @JvmField
  val tuple2 = { a : Any ->
     { b : Any ->
       PS.Data.Tuple.Module.Tuple.app(a)
         .app(PS.Data.Tuple.Module.Tuple.app(b).app(PS.Data.Unit.Module.unit))
    }
  };
  @JvmField
  val tuple10 = { a : Any ->
     { b : Any ->
       { c : Any ->
         { d : Any ->
           { e : Any ->
             { f : Any ->
               { g : Any ->
                 { h : Any ->
                   { i : Any ->
                     { j : Any ->
                       PS.Data.Tuple.Module.Tuple.app(a)
                         .app(PS.Data.Tuple.Module.Tuple.app(b)
                                .app(PS.Data.Tuple.Module.Tuple.app(c)
                                       .app(PS.Data.Tuple.Module.Tuple.app(d)
                                              .app(PS.Data.Tuple.Module.Tuple
                                                     .app(e)
                                                     .app(
                                PS.Data.Tuple.Module.Tuple.app(f)
                                  .app(PS.Data.Tuple.Module.Tuple.app(g)
                                         .app(PS.Data.Tuple.Module.Tuple.app(h)
                                                .app(PS.Data.Tuple.Module.Tuple
                                                       .app(i)
                                                       .app(
                                        PS.Data.Tuple.Module.Tuple.app(j)
                                          .app(PS.Data.Unit.Module.unit)))))))))
                      )
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val tuple1 = { a : Any ->
     PS.Data.Tuple.Module.Tuple.app(a).app(PS.Data.Unit.Module.unit)
  };
  @JvmField
  val over9 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          val g = v.value1.value1.value1.value1.value1.value1.value0;
          val h = v.value1.value1.value1.value1.value1.value1.value1.value0;
          val i = v
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value0;
          val z = v
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1;
          PS.Data.Tuple.Module.Tuple.app(a)
            .app(PS.Data.Tuple.Module.Tuple.app(b)
                   .app(PS.Data.Tuple.Module.Tuple.app(c)
                          .app(PS.Data.Tuple.Module.Tuple.app(d)
                                 .app(PS.Data.Tuple.Module.Tuple.app(e)
                                        .app(PS.Data.Tuple.Module.Tuple.app(f)
                                               .app(PS.Data.Tuple.Module.Tuple
                                                      .app(g)
                                                      .app(
                        PS.Data.Tuple.Module.Tuple.app(h)
                          .app(PS.Data.Tuple.Module.Tuple.app(o1.app(i)).app(z))
                      )))))));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val over8 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          val g = v.value1.value1.value1.value1.value1.value1.value0;
          val h = v.value1.value1.value1.value1.value1.value1.value1.value0;
          val z = v.value1.value1.value1.value1.value1.value1.value1.value1;
          PS.Data.Tuple.Module.Tuple.app(a)
            .app(PS.Data.Tuple.Module.Tuple.app(b)
                   .app(PS.Data.Tuple.Module.Tuple.app(c)
                          .app(PS.Data.Tuple.Module.Tuple.app(d)
                                 .app(PS.Data.Tuple.Module.Tuple.app(e)
                                        .app(PS.Data.Tuple.Module.Tuple.app(f)
                                               .app(PS.Data.Tuple.Module.Tuple
                                                      .app(g)
                                                      .app(
                        PS.Data.Tuple.Module.Tuple.app(o1.app(h)).app(z))))))));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val over7 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          val g = v.value1.value1.value1.value1.value1.value1.value0;
          val z = v.value1.value1.value1.value1.value1.value1.value1;
          PS.Data.Tuple.Module.Tuple.app(a)
            .app(PS.Data.Tuple.Module.Tuple.app(b)
                   .app(PS.Data.Tuple.Module.Tuple.app(c)
                          .app(PS.Data.Tuple.Module.Tuple.app(d)
                                 .app(PS.Data.Tuple.Module.Tuple.app(e)
                                        .app(PS.Data.Tuple.Module.Tuple.app(f)
                                               .app(PS.Data.Tuple.Module.Tuple
                                                      .app(o1.app(g))
                                                      .app(z)))))));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val over6 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          val z = v.value1.value1.value1.value1.value1.value1;
          PS.Data.Tuple.Module.Tuple.app(a)
            .app(PS.Data.Tuple.Module.Tuple.app(b)
                   .app(PS.Data.Tuple.Module.Tuple.app(c)
                          .app(PS.Data.Tuple.Module.Tuple.app(d)
                                 .app(PS.Data.Tuple.Module.Tuple.app(e)
                                        .app(PS.Data.Tuple.Module.Tuple
                                               .app(o1.app(f))
                                               .app(z))))));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val over5 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val z = v.value1.value1.value1.value1.value1;
          PS.Data.Tuple.Module.Tuple.app(a)
            .app(PS.Data.Tuple.Module.Tuple.app(b)
                   .app(PS.Data.Tuple.Module.Tuple.app(c)
                          .app(PS.Data.Tuple.Module.Tuple.app(d)
                                 .app(PS.Data.Tuple.Module.Tuple.app(o1.app(e))
                                        .app(z)))));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val over4 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val z = v.value1.value1.value1.value1;
          PS.Data.Tuple.Module.Tuple.app(a)
            .app(PS.Data.Tuple.Module.Tuple.app(b)
                   .app(PS.Data.Tuple.Module.Tuple.app(c)
                          .app(PS.Data.Tuple.Module.Tuple.app(o1.app(d)).app(z))
            ));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val over3 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val z = v.value1.value1.value1;
          PS.Data.Tuple.Module.Tuple.app(a)
            .app(PS.Data.Tuple.Module.Tuple.app(b)
                   .app(PS.Data.Tuple.Module.Tuple.app(o1.app(c)).app(z)));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val over2 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val b = v.value1.value0;
          val z = v.value1.value1;
          PS.Data.Tuple.Module.Tuple.app(a)
            .app(PS.Data.Tuple.Module.Tuple.app(o1.app(b)).app(z));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val over10 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple
                .Tuple)&& (v
                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                          .Tuple)&& (v
                                                       .value1
                                                       .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                    .Tuple)&& (v
                                                                                 .value1
                                                                                 .value1
                                                                                 .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                              .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple)&&
        (v
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1
           .value1 is PS.Data.Tuple.Module._Type_Tuple
                        .Tuple)&& (v
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1
                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                  .Tuple)&& (v
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1
                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                            .Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val b = v.value1.value0;
          val c = v.value1.value1.value0;
          val d = v.value1.value1.value1.value0;
          val e = v.value1.value1.value1.value1.value0;
          val f = v.value1.value1.value1.value1.value1.value0;
          val g = v.value1.value1.value1.value1.value1.value1.value0;
          val h = v.value1.value1.value1.value1.value1.value1.value1.value0;
          val i = v
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value0;
          val j = v
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value0;
          val z = v
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1
                    .value1;
          PS.Data.Tuple.Module.Tuple.app(a)
            .app(PS.Data.Tuple.Module.Tuple.app(b)
                   .app(PS.Data.Tuple.Module.Tuple.app(c)
                          .app(PS.Data.Tuple.Module.Tuple.app(d)
                                 .app(PS.Data.Tuple.Module.Tuple.app(e)
                                        .app(PS.Data.Tuple.Module.Tuple.app(f)
                                               .app(PS.Data.Tuple.Module.Tuple
                                                      .app(g)
                                                      .app(
                        PS.Data.Tuple.Module.Tuple.app(h)
                          .app(PS.Data.Tuple.Module.Tuple.app(i)
                                 .app(PS.Data.Tuple.Module.Tuple.app(o1.app(j))
                                        .app(z))))))))));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val over1 = { o : Any ->
     { v : Any ->
       when {
        (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
          val o1 = o;
          val a = v.value0;
          val z = v.value1;
          PS.Data.Tuple.Module.Tuple.app(o1.app(a)).app(z);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val get9 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple
              .Tuple)&& (v
                           .value1 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple)&& (v
                                                     .value1
                                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                  .Tuple)&& (v
                                                                               .value1
                                                                               .value1
                                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                            .Tuple)&&
      (v
         .value1
         .value1
         .value1
         .value1 is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (v
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                .Tuple)&& (v
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                          .Tuple)&&
      (v
         .value1
         .value1
         .value1
         .value1
         .value1
         .value1
         .value1 is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (v
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                .Tuple) -> {
        val i = v
                  .value1
                  .value1
                  .value1
                  .value1
                  .value1
                  .value1
                  .value1
                  .value1
                  .value0;
        i;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val get8 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple
              .Tuple)&& (v
                           .value1 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple)&& (v
                                                     .value1
                                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                  .Tuple)&& (v
                                                                               .value1
                                                                               .value1
                                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                            .Tuple)&&
      (v
         .value1
         .value1
         .value1
         .value1 is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (v
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                .Tuple)&& (v
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                          .Tuple)&&
      (v
         .value1
         .value1
         .value1
         .value1
         .value1
         .value1
         .value1 is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple) -> {
        val h = v.value1.value1.value1.value1.value1.value1.value1.value0;
        h;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val get7 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple
              .Tuple)&& (v
                           .value1 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple)&& (v
                                                     .value1
                                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                  .Tuple)&& (v
                                                                               .value1
                                                                               .value1
                                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                            .Tuple)&&
      (v
         .value1
         .value1
         .value1
         .value1 is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (v
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                .Tuple)&& (v
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                          .Tuple) -> {
        val g = v.value1.value1.value1.value1.value1.value1.value0;
        g;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val get6 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple
              .Tuple)&& (v
                           .value1 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple)&& (v
                                                     .value1
                                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                  .Tuple)&& (v
                                                                               .value1
                                                                               .value1
                                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                            .Tuple)&&
      (v
         .value1
         .value1
         .value1
         .value1 is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (v
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                .Tuple) -> {
        val f = v.value1.value1.value1.value1.value1.value0;
        f;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val get5 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple
              .Tuple)&& (v
                           .value1 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple)&& (v
                                                     .value1
                                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                  .Tuple)&& (v
                                                                               .value1
                                                                               .value1
                                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                            .Tuple)&&
      (v
         .value1
         .value1
         .value1
         .value1 is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple) -> {
        val e = v.value1.value1.value1.value1.value0;
        e;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val get4 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple
              .Tuple)&& (v
                           .value1 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple)&& (v
                                                     .value1
                                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                  .Tuple)&& (v
                                                                               .value1
                                                                               .value1
                                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                            .Tuple) -> {
        val d = v.value1.value1.value1.value0;
        d;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val get3 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple
              .Tuple)&& (v
                           .value1 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple)&& (v
                                                     .value1
                                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                  .Tuple) -> {
        val c = v.value1.value1.value0;
        c;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val get2 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple
              .Tuple)&& (v
                           .value1 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple) -> {
        val b = v.value1.value0;
        b;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val get10 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple
              .Tuple)&& (v
                           .value1 is PS.Data.Tuple.Module._Type_Tuple
                                        .Tuple)&& (v
                                                     .value1
                                                     .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                  .Tuple)&& (v
                                                                               .value1
                                                                               .value1
                                                                               .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                                            .Tuple)&&
      (v
         .value1
         .value1
         .value1
         .value1 is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (v
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                .Tuple)&& (v
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                          .Tuple)&&
      (v
         .value1
         .value1
         .value1
         .value1
         .value1
         .value1
         .value1 is PS.Data.Tuple.Module._Type_Tuple
                      .Tuple)&& (v
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1
                                   .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                .Tuple)&& (v
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1
                                                             .value1 is PS.Data.Tuple.Module._Type_Tuple
                                                                          .Tuple) -> {
        val j = v
                  .value1
                  .value1
                  .value1
                  .value1
                  .value1
                  .value1
                  .value1
                  .value1
                  .value1
                  .value0;
        j;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val get1 = { v : Any ->
     when {
      (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
        val a = v.value0;
        a;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val curry9 = { z : Any ->
     { f_tick : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             { d : Any ->
               { e : Any ->
                 { f : Any ->
                   { g : Any ->
                     { h : Any ->
                       { i : Any ->
                         f_tick
                           .app(PS.Data.Tuple.Module.Tuple.app(a)
                                  .app(PS.Data.Tuple.Module.Tuple.app(b)
                                         .app(PS.Data.Tuple.Module.Tuple.app(c)
                                                .app(PS.Data.Tuple.Module.Tuple
                                                       .app(d)
                                                       .app(
                                  PS.Data.Tuple.Module.Tuple.app(e)
                                    .app(PS.Data.Tuple.Module.Tuple.app(f)
                                           .app(PS.Data.Tuple.Module.Tuple
                                                  .app(g)
                                                  .app(
                                        PS.Data.Tuple.Module.Tuple.app(h)
                                          .app(PS.Data.Tuple.Module.Tuple.app(i)
                                                 .app(z))))))))))
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
  };
  @JvmField
  val curry8 = { z : Any ->
     { f_tick : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             { d : Any ->
               { e : Any ->
                 { f : Any ->
                   { g : Any ->
                     { h : Any ->
                       f_tick
                         .app(PS.Data.Tuple.Module.Tuple.app(a)
                                .app(PS.Data.Tuple.Module.Tuple.app(b)
                                       .app(PS.Data.Tuple.Module.Tuple.app(c)
                                              .app(PS.Data.Tuple.Module.Tuple
                                                     .app(d)
                                                     .app(
                                PS.Data.Tuple.Module.Tuple.app(e)
                                  .app(PS.Data.Tuple.Module.Tuple.app(f)
                                         .app(PS.Data.Tuple.Module.Tuple.app(g)
                                                .app(PS.Data.Tuple.Module.Tuple
                                                       .app(h)
                                                       .app(z)))))))))
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val curry7 = { z : Any ->
     { f_tick : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             { d : Any ->
               { e : Any ->
                 { f : Any ->
                   { g : Any ->
                     f_tick
                       .app(PS.Data.Tuple.Module.Tuple.app(a)
                              .app(PS.Data.Tuple.Module.Tuple.app(b)
                                     .app(PS.Data.Tuple.Module.Tuple.app(c)
                                            .app(PS.Data.Tuple.Module.Tuple
                                                   .app(d)
                                                   .app(
                              PS.Data.Tuple.Module.Tuple.app(e)
                                .app(PS.Data.Tuple.Module.Tuple.app(f)
                                       .app(PS.Data.Tuple.Module.Tuple.app(g)
                                              .app(z))))))))
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val curry6 = { z : Any ->
     { f_tick : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             { d : Any ->
               { e : Any ->
                 { f : Any ->
                   f_tick
                     .app(PS.Data.Tuple.Module.Tuple.app(a)
                            .app(PS.Data.Tuple.Module.Tuple.app(b)
                                   .app(PS.Data.Tuple.Module.Tuple.app(c)
                                          .app(PS.Data.Tuple.Module.Tuple.app(d)
                                                 .app(PS.Data.Tuple.Module.Tuple
                                                        .app(e)
                                                        .app(
                              PS.Data.Tuple.Module.Tuple.app(f).app(z)))))))
                }
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val curry5 = { z : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             { d : Any ->
               { e : Any ->
                 f
                   .app(PS.Data.Tuple.Module.Tuple.app(a)
                          .app(PS.Data.Tuple.Module.Tuple.app(b)
                                 .app(PS.Data.Tuple.Module.Tuple.app(c)
                                        .app(PS.Data.Tuple.Module.Tuple.app(d)
                                               .app(PS.Data.Tuple.Module.Tuple
                                                      .app(e)
                                                      .app(z))))))
              }
            }
          }
        }
      }
    }
  };
  @JvmField
  val curry4 = { z : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             { d : Any ->
               f
                 .app(PS.Data.Tuple.Module.Tuple.app(a)
                        .app(PS.Data.Tuple.Module.Tuple.app(b)
                               .app(PS.Data.Tuple.Module.Tuple.app(c)
                                      .app(PS.Data.Tuple.Module.Tuple.app(d)
                                             .app(z)))))
            }
          }
        }
      }
    }
  };
  @JvmField
  val curry3 = { z : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             f
               .app(PS.Data.Tuple.Module.Tuple.app(a)
                      .app(PS.Data.Tuple.Module.Tuple.app(b)
                             .app(PS.Data.Tuple.Module.Tuple.app(c).app(z))))
          }
        }
      }
    }
  };
  @JvmField
  val curry2 = { z : Any ->
     { f : Any ->
       { a : Any ->
         { b : Any ->
           f
             .app(PS.Data.Tuple.Module.Tuple.app(a)
                    .app(PS.Data.Tuple.Module.Tuple.app(b).app(z)))
        }
      }
    }
  };
  @JvmField
  val curry10 = { z : Any ->
     { f_tick : Any ->
       { a : Any ->
         { b : Any ->
           { c : Any ->
             { d : Any ->
               { e : Any ->
                 { f : Any ->
                   { g : Any ->
                     { h : Any ->
                       { i : Any ->
                         { j : Any ->
                           f_tick
                             .app(PS.Data.Tuple.Module.Tuple.app(a)
                                    .app(PS.Data.Tuple.Module.Tuple.app(b)
                                           .app(PS.Data.Tuple.Module.Tuple
                                                  .app(c)
                                                  .app(
                                  PS.Data.Tuple.Module.Tuple.app(d)
                                    .app(PS.Data.Tuple.Module.Tuple.app(e)
                                           .app(PS.Data.Tuple.Module.Tuple
                                                  .app(f)
                                                  .app(
                                        PS.Data.Tuple.Module.Tuple.app(g)
                                          .app(PS.Data.Tuple.Module.Tuple.app(h)
                                                 .app(PS.Data.Tuple.Module.Tuple
                                                        .app(i)
                                                        .app(
                                              PS.Data.Tuple.Module.Tuple.app(j)
                                                .app(z)))))))))))
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
  };
  @JvmField
  val curry1 = { z : Any ->
     { f : Any ->
       { a : Any ->
         f.app(PS.Data.Tuple.Module.Tuple.app(a).app(z))
      }
    }
  };
}