@file:Suppress("UNCHECKED_CAST")
package PS.Data.Map.Internal
import Foreign.PsRuntime.app
object Module  {
  sealed class _Type_Map ()  {
    object Leaf : _Type_Map() {};
    data class Two (val value0 : Any,  val value1 : Any,  val value2 : Any, 
    val value3 : Any) : _Type_Map() {};
    data class Three (val value0 : Any,  val value1 : Any,  val value2 : Any, 
    val value3 : Any,  val value4 : Any,  val value5 : Any, 
    val value6 : Any) : _Type_Map() {};
  };
  val Leaf = _Type_Map.Leaf;
  val Two = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         { value3 : Any ->
           _Type_Map.Two(value0,  value1,  value2,  value3)
        }
      }
    }
  };
  val Three = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         { value3 : Any ->
           { value4 : Any ->
             { value5 : Any ->
               { value6 : Any ->
                 _Type_Map
                   .Three(value0,  value1,  value2,  value3,  value4,  value5,  
                  value6)
              }
            }
          }
        }
      }
    }
  };
  sealed class _Type_TreeContext ()  {
    data class TwoLeft (val value0 : Any,  val value1 : Any, 
    val value2 : Any) : _Type_TreeContext() {};
    data class TwoRight (val value0 : Any,  val value1 : Any, 
    val value2 : Any) : _Type_TreeContext() {};
    data class ThreeLeft (val value0 : Any,  val value1 : Any, 
    val value2 : Any,  val value3 : Any,  val value4 : Any, 
    val value5 : Any) : _Type_TreeContext() {};
    data class ThreeMiddle (val value0 : Any,  val value1 : Any, 
    val value2 : Any,  val value3 : Any,  val value4 : Any, 
    val value5 : Any) : _Type_TreeContext() {};
    data class ThreeRight (val value0 : Any,  val value1 : Any, 
    val value2 : Any,  val value3 : Any,  val value4 : Any, 
    val value5 : Any) : _Type_TreeContext() {};
  };
  val TwoLeft = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         _Type_TreeContext.TwoLeft(value0,  value1,  value2)
      }
    }
  };
  val TwoRight = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         _Type_TreeContext.TwoRight(value0,  value1,  value2)
      }
    }
  };
  val ThreeLeft = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         { value3 : Any ->
           { value4 : Any ->
             { value5 : Any ->
               _Type_TreeContext
                 .ThreeLeft(value0,  value1,  value2,  value3,  value4,  value5)
            }
          }
        }
      }
    }
  };
  val ThreeMiddle = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         { value3 : Any ->
           { value4 : Any ->
             { value5 : Any ->
               _Type_TreeContext
                 .ThreeMiddle(value0,  value1,  value2,  value3,  value4,  
                value5)
            }
          }
        }
      }
    }
  };
  val ThreeRight = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         { value3 : Any ->
           { value4 : Any ->
             { value5 : Any ->
               _Type_TreeContext
                 .ThreeRight(value0,  value1,  value2,  value3,  value4,  value5
              )
            }
          }
        }
      }
    }
  };
  sealed class _Type_KickUp ()  {
    data class KickUp (val value0 : Any,  val value1 : Any,  val value2 : Any, 
    val value3 : Any) : _Type_KickUp() {};
  };
  val KickUp = { value0 : Any ->
     { value1 : Any ->
       { value2 : Any ->
         { value3 : Any ->
           _Type_KickUp.KickUp(value0,  value1,  value2,  value3)
        }
      }
    }
  };
  @JvmField val values = (::__rec_values)();
  fun __rec_values(): Any = { v : Any ->
     when {
      (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
        PS.Data.List.Types.Module.Nil;
      }
      (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
        val left = v.value0;
        val v1 = v.value2;
        val right = v.value3;
        PS.Data.Semigroup.Module.append
          .app(PS.Data.List.Types.Module.semigroupList)
          .app(PS.Data.Map.Internal.Module.values.app(left))
          .app(PS.Data.Semigroup.Module.append
                 .app(PS.Data.List.Types.Module.semigroupList)
                 .app(PS.Control.Applicative.Module.pure
                        .app(PS.Data.List.Types.Module.applicativeList)
                        .app(v1))
                 .app(PS.Data.Map.Internal.Module.values.app(right)));
      }
      (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
        val left = v.value0;
        val v1 = v.value2;
        val mid = v.value3;
        val v2 = v.value5;
        val right = v.value6;
        PS.Data.Semigroup.Module.append
          .app(PS.Data.List.Types.Module.semigroupList)
          .app(PS.Data.Map.Internal.Module.values.app(left))
          .app(PS.Data.Semigroup.Module.append
                 .app(PS.Data.List.Types.Module.semigroupList)
                 .app(PS.Control.Applicative.Module.pure
                        .app(PS.Data.List.Types.Module.applicativeList)
                        .app(v1))
                 .app(PS.Data.Semigroup.Module.append
                        .app(PS.Data.List.Types.Module.semigroupList)
                        .app(PS.Data.Map.Internal.Module.values.app(mid))
                        .app(PS.Data.Semigroup.Module.append
                               .app(PS.Data.List.Types.Module.semigroupList)
                               .app(PS.Control.Applicative.Module.pure
                                      .app(
                                        PS.Data.List.Types.Module.applicativeList
                                      )
                                      .app(v2))
                               .app(PS.Data.Map.Internal.Module.values
                                      .app(right)))));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField val size = (::__rec_size)();
  fun __rec_size(): Any = { v : Any ->
     when {
      (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
        0;
      }
      (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
        val m1 = v.value0;
        val m2 = v.value3;
        PS.Data.Semiring.Module.add.app(PS.Data.Semiring.Module.semiringInt)
          .app(PS.Data.Semiring.Module.add
                 .app(PS.Data.Semiring.Module.semiringInt)
                 .app(1)
                 .app(PS.Data.Map.Internal.Module.size.app(m1)))
          .app(PS.Data.Map.Internal.Module.size.app(m2));
      }
      (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
        val m1 = v.value0;
        val m2 = v.value3;
        val m3 = v.value6;
        PS.Data.Semiring.Module.add.app(PS.Data.Semiring.Module.semiringInt)
          .app(PS.Data.Semiring.Module.add
                 .app(PS.Data.Semiring.Module.semiringInt)
                 .app(PS.Data.Semiring.Module.add
                        .app(PS.Data.Semiring.Module.semiringInt)
                        .app(2)
                        .app(PS.Data.Map.Internal.Module.size.app(m1)))
                 .app(PS.Data.Map.Internal.Module.size.app(m2)))
          .app(PS.Data.Map.Internal.Module.size.app(m3));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val singleton = { k : Any ->
     { v : Any ->
       PS.Data.Map.Internal.Module.Two.app(PS.Data.Map.Internal.Module.Leaf)
         .app(k)
         .app(v)
         .app(PS.Data.Map.Internal.Module.Leaf)
    }
  };
  @JvmField
  val toUnfoldable = { dictUnfoldable : Any ->
     { m : Any ->
       object   {
           val go = (::__rec_go)();
           fun __rec_go(): Any = { v : Any ->
              when {
               (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                 PS.Data.Maybe.Module.Nothing;
               }
               (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
                 val hd = v.value0;
                 val tl = v.value1;
                 when {
                   (hd is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                     __rec_go().app(tl);
                   }
                   (hd is PS.Data.Map.Internal.Module._Type_Map
                            .Two)&& (hd
                                       .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                    .Leaf)&& (hd
                                                                .value3 is PS.Data.Map.Internal.Module._Type_Map
                                                                             .Leaf) -> {
                     val k = hd.value1;
                     val v1 = hd.value2;
                     PS.Data.Function.Module.apply
                       .app(PS.Data.Maybe.Module.Just)
                       .app(PS.Data.Tuple.Module.Tuple
                              .app(PS.Data.Tuple.Module.Tuple.app(k).app(v1))
                              .app(tl));
                   }
                   (hd is PS.Data.Map.Internal.Module._Type_Map
                            .Two)&& (hd
                                       .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                    .Leaf) -> {
                     val k = hd.value1;
                     val v1 = hd.value2;
                     val right = hd.value3;
                     PS.Data.Function.Module.apply
                       .app(PS.Data.Maybe.Module.Just)
                       .app(PS.Data.Tuple.Module.Tuple
                              .app(PS.Data.Tuple.Module.Tuple.app(k).app(v1))
                              .app(PS.Data.List.Types.Module.Cons.app(right)
                                     .app(tl)));
                   }
                   (hd is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                     val left = hd.value0;
                     val k = hd.value1;
                     val v1 = hd.value2;
                     val right = hd.value3;
                     PS.Data.Function.Module.apply.app(__rec_go())
                       .app(PS.Data.List.Types.Module.Cons.app(left)
                              .app(PS.Data.List.Types.Module.Cons
                                     .app(PS.Data.Map.Internal.Module.singleton
                                            .app(k)
                                            .app(v1))
                                     .app(PS.Data.List.Types.Module.Cons
                                            .app(right)
                                            .app(tl))));
                   }
                   (hd is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                     val left = hd.value0;
                     val k1 = hd.value1;
                     val v1 = hd.value2;
                     val mid = hd.value3;
                     val k2 = hd.value4;
                     val v2 = hd.value5;
                     val right = hd.value6;
                     PS.Data.Function.Module.apply.app(__rec_go())
                       .app(PS.Data.List.Types.Module.Cons.app(left)
                              .app(PS.Data.List.Types.Module.Cons
                                     .app(PS.Data.Map.Internal.Module.singleton
                                            .app(k1)
                                            .app(v1))
                                     .app(PS.Data.List.Types.Module.Cons
                                            .app(mid)
                                            .app(PS.Data.List.Types.Module.Cons
                                                   .app(
                                                     PS.Data.Map.Internal.Module.singleton
                                                       .app(k2)
                                                       .app(v2))
                                                   .app(
                               PS.Data.List.Types.Module.Cons.app(right).app(tl)
                             )))));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 };
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val go = this.go;
          PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable).app(go)
            .app(PS.Data.List.Types.Module.Cons.app(m)
                   .app(PS.Data.List.Types.Module.Nil));
        })
    }
  };
  @JvmField
  val toAscArray = PS.Data.Map.Internal.Module.toUnfoldable
                     .app(PS.Data.Unfoldable.Module.unfoldableArray);
  @JvmField
  val toUnfoldableUnordered = { dictUnfoldable : Any ->
     { m : Any ->
       object   {
           val go = (::__rec_go)();
           fun __rec_go(): Any = { v : Any ->
              when {
               (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                 PS.Data.Maybe.Module.Nothing;
               }
               (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
                 val hd = v.value0;
                 val tl = v.value1;
                 when {
                   (hd is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                     __rec_go().app(tl);
                   }
                   (hd is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                     val left = hd.value0;
                     val k = hd.value1;
                     val v1 = hd.value2;
                     val right = hd.value3;
                     PS.Data.Function.Module.apply
                       .app(PS.Data.Maybe.Module.Just)
                       .app(PS.Data.Tuple.Module.Tuple
                              .app(PS.Data.Tuple.Module.Tuple.app(k).app(v1))
                              .app(PS.Data.List.Types.Module.Cons.app(left)
                                     .app(PS.Data.List.Types.Module.Cons
                                            .app(right)
                                            .app(tl))));
                   }
                   (hd is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                     val left = hd.value0;
                     val k1 = hd.value1;
                     val v1 = hd.value2;
                     val mid = hd.value3;
                     val k2 = hd.value4;
                     val v2 = hd.value5;
                     val right = hd.value6;
                     PS.Data.Function.Module.apply
                       .app(PS.Data.Maybe.Module.Just)
                       .app(PS.Data.Tuple.Module.Tuple
                              .app(PS.Data.Tuple.Module.Tuple.app(k1).app(v1))
                              .app(PS.Data.List.Types.Module.Cons
                                     .app(PS.Data.Map.Internal.Module.singleton
                                            .app(k2)
                                            .app(v2))
                                     .app(PS.Data.List.Types.Module.Cons
                                            .app(left)
                                            .app(PS.Data.List.Types.Module.Cons
                                                   .app(mid)
                                                   .app(
                               PS.Data.List.Types.Module.Cons.app(right).app(tl)
                             )))));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 };
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val go = this.go;
          PS.Data.Unfoldable.Module.unfoldr.app(dictUnfoldable).app(go)
            .app(PS.Data.List.Types.Module.Cons.app(m)
                   .app(PS.Data.List.Types.Module.Nil));
        })
    }
  };
  @JvmField val showTree = (::__rec_showTree)();
  fun __rec_showTree(): Any = { dictShow : Any ->
     { dictShow1 : Any ->
       { v : Any ->
         when {
          (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
            "Leaf";
          }
          (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
            val left = v.value0;
            val k = v.value1;
            val v1 = v.value2;
            val right = v.value3;
            (("Two (" as String) + (((PS.Data.Map.Internal.Module.showTree
                                        .app(dictShow)
                                        .app(dictShow1)
                                        .app(left
            ) as String) + (((") (" as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow)
                                                      .app(k
            ) as String) + (((") (" as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow1)
                                                      .app(v1
            ) as String) + (((") (" as String) + (((PS.Data.Map.Internal.Module.showTree
                                                      .app(dictShow)
                                                      .app(dictShow1)
                                                      .app(right
            ) as String) + (")" as String)) as String)) as String)) as String)) as String)) as String)) as String)) as String));
          }
          (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
            val left = v.value0;
            val k1 = v.value1;
            val v1 = v.value2;
            val mid = v.value3;
            val k2 = v.value4;
            val v2 = v.value5;
            val right = v.value6;
            (("Three (" as String) + (((PS.Data.Map.Internal.Module.showTree
                                          .app(dictShow)
                                          .app(dictShow1)
                                          .app(left
            ) as String) + (((") (" as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow)
                                                      .app(k1
            ) as String) + (((") (" as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow1)
                                                      .app(v1
            ) as String) + (((") (" as String) + (((PS.Data.Map.Internal.Module.showTree
                                                      .app(dictShow)
                                                      .app(dictShow1)
                                                      .app(mid
            ) as String) + (((") (" as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow)
                                                      .app(k2
            ) as String) + (((") (" as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow1)
                                                      .app(v2
            ) as String) + (((") (" as String) + (((PS.Data.Map.Internal.Module.showTree
                                                      .app(dictShow)
                                                      .app(dictShow1)
                                                      .app(right
            ) as String) + (")" as String)) as String)) as String)) as String)) as String)) as String)) as String)) as String)) as String)) as String)) as String)) as String)) as String)) as String));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val showMap = { dictShow : Any ->
     { dictShow1 : Any ->
       PS.Data.Show.Module.Show
         .app({ m : Any ->
           (("(fromFoldable " as String) + (((PS.Data.Show.Module.show
                                                .app(
                                                  PS.Data.Show.Module.showArray
                                                    .app(
                                                    PS.Data.Tuple.Module.showTuple
                                                      .app(dictShow)
                                                      .app(dictShow1)))
                                                .app(
            PS.Data.Map.Internal.Module.toAscArray.app(m)
          ) as String) + (")" as String)) as String))
        })
    }
  };
  @JvmField
  val lookupLE = { dictOrd : Any ->
     { k : Any ->
       object   {
           val comp = PS.Data.Ord.Module.compare.app(dictOrd);
           val go = (::__rec_go)();
           fun __rec_go(): Any = { v : Any ->
              when {
               (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                 PS.Data.Maybe.Module.Nothing;
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val right = v.value3;
                 object   {
                     val v2 = comp.app(k).app(k1);
                   }
                   .run({
                     val v2 = this.v2;
                     when {
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Maybe.Module.Just
                           .app(mapOf(("key" to k1),  ("value" to v1)));
                       }
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Maybe.Module.Just)
                           .app(PS.Data.Function.Module.apply
                                  .app(PS.Data.Maybe.Module.fromMaybe
                                         .app(mapOf(("key" to k1),  
                                        ("value" to v1))))
                                  .app(__rec_go().app(right)));
                       }
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                         __rec_go().app(left);
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   });
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val mid = v.value3;
                 val k2 = v.value4;
                 val v2 = v.value5;
                 val right = v.value6;
                 object   {
                     val v3 = comp.app(k).app(k2);
                   }
                   .run({
                     val v3 = this.v3;
                     when {
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Maybe.Module.Just
                           .app(mapOf(("key" to k2),  ("value" to v2)));
                       }
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Maybe.Module.Just)
                           .app(PS.Data.Function.Module.apply
                                  .app(PS.Data.Maybe.Module.fromMaybe
                                         .app(mapOf(("key" to k2),  
                                        ("value" to v2))))
                                  .app(__rec_go().app(right)));
                       }
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                         PS.Data.Function.Module.apply.app(__rec_go())
                           .app(PS.Data.Map.Internal.Module.Two.app(left)
                                  .app(k1)
                                  .app(v1)
                                  .app(mid));
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   });
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val comp = this.comp;
          val go = this.go;
          go;
        })
    }
  };
  @JvmField
  val lookupGE = { dictOrd : Any ->
     { k : Any ->
       object   {
           val comp = PS.Data.Ord.Module.compare.app(dictOrd);
           val go = (::__rec_go)();
           fun __rec_go(): Any = { v : Any ->
              when {
               (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                 PS.Data.Maybe.Module.Nothing;
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val right = v.value3;
                 object   {
                     val v2 = comp.app(k).app(k1);
                   }
                   .run({
                     val v2 = this.v2;
                     when {
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Maybe.Module.Just
                           .app(mapOf(("key" to k1),  ("value" to v1)));
                       }
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Maybe.Module.Just)
                           .app(PS.Data.Function.Module.apply
                                  .app(PS.Data.Maybe.Module.fromMaybe
                                         .app(mapOf(("key" to k1),  
                                        ("value" to v1))))
                                  .app(__rec_go().app(left)));
                       }
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                         __rec_go().app(right);
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   });
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val mid = v.value3;
                 val k2 = v.value4;
                 val v2 = v.value5;
                 val right = v.value6;
                 object   {
                     val v3 = comp.app(k).app(k1);
                   }
                   .run({
                     val v3 = this.v3;
                     when {
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Maybe.Module.Just
                           .app(mapOf(("key" to k1),  ("value" to v1)));
                       }
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Maybe.Module.Just)
                           .app(PS.Data.Function.Module.apply
                                  .app(PS.Data.Maybe.Module.fromMaybe
                                         .app(mapOf(("key" to k1),  
                                        ("value" to v1))))
                                  .app(__rec_go().app(left)));
                       }
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                         PS.Data.Function.Module.apply.app(__rec_go())
                           .app(PS.Data.Map.Internal.Module.Two.app(mid).app(k2)
                                  .app(v2)
                                  .app(right));
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   });
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val comp = this.comp;
          val go = this.go;
          go;
        })
    }
  };
  @JvmField
  val lookup = { dictOrd : Any ->
     { k : Any ->
       object   {
           val comp = PS.Data.Ord.Module.compare.app(dictOrd);
           val go = (::__rec_go)();
           fun __rec_go(): Any = { v : Any ->
              when {
               (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                 PS.Data.Maybe.Module.Nothing;
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val right = v.value3;
                 object   {
                     val v2 = comp.app(k).app(k1);
                   }
                   .run({
                     val v2 = this.v2;
                     when {
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Maybe.Module.Just.app(v1);
                       }
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                         __rec_go().app(left);
                       }
                       else -> {
                         __rec_go().app(right);
                       }
                     };
                   });
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val mid = v.value3;
                 val k2 = v.value4;
                 val v2 = v.value5;
                 val right = v.value6;
                 object   {
                     val v3 = comp.app(k).app(k1);
                   }
                   .run({
                     val v3 = this.v3;
                     when {
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Maybe.Module.Just.app(v1);
                       }
                       else -> {
                         val c1 = v3;
                         object   {
                             val v4 = comp.app(k).app(k2);
                             val v5 = c1;
                           }
                           .run({
                             val v4 = this.v4;
                             val v5 = this.v5;
                             when {
                               (v4 is PS.Data.Ordering.Module._Type_Ordering
                                        .EQ) -> {
                                 PS.Data.Maybe.Module.Just.app(v2);
                               }
                               (v5 is PS.Data.Ordering.Module._Type_Ordering
                                        .LT) -> {
                                 __rec_go().app(left);
                               }
                               (v4 is PS.Data.Ordering.Module._Type_Ordering
                                        .GT) -> {
                                 __rec_go().app(right);
                               }
                               else -> {
                                 __rec_go().app(mid);
                               }
                             };
                           });
                       }
                     };
                   });
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val comp = this.comp;
          val go = this.go;
          go;
        })
    }
  };
  @JvmField
  val member = { dictOrd : Any ->
     { k : Any ->
       { m : Any ->
         PS.Data.Maybe.Module.isJust
           .app(PS.Data.Map.Internal.Module.lookup.app(dictOrd).app(k).app(m))
      }
    }
  };
  @JvmField val keys = (::__rec_keys)();
  fun __rec_keys(): Any = { v : Any ->
     when {
      (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
        PS.Data.List.Types.Module.Nil;
      }
      (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
        val left = v.value0;
        val k = v.value1;
        val right = v.value3;
        PS.Data.Semigroup.Module.append
          .app(PS.Data.List.Types.Module.semigroupList)
          .app(PS.Data.Map.Internal.Module.keys.app(left))
          .app(PS.Data.Semigroup.Module.append
                 .app(PS.Data.List.Types.Module.semigroupList)
                 .app(PS.Control.Applicative.Module.pure
                        .app(PS.Data.List.Types.Module.applicativeList)
                        .app(k))
                 .app(PS.Data.Map.Internal.Module.keys.app(right)));
      }
      (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
        val left = v.value0;
        val k1 = v.value1;
        val mid = v.value3;
        val k2 = v.value4;
        val right = v.value6;
        PS.Data.Semigroup.Module.append
          .app(PS.Data.List.Types.Module.semigroupList)
          .app(PS.Data.Map.Internal.Module.keys.app(left))
          .app(PS.Data.Semigroup.Module.append
                 .app(PS.Data.List.Types.Module.semigroupList)
                 .app(PS.Control.Applicative.Module.pure
                        .app(PS.Data.List.Types.Module.applicativeList)
                        .app(k1))
                 .app(PS.Data.Semigroup.Module.append
                        .app(PS.Data.List.Types.Module.semigroupList)
                        .app(PS.Data.Map.Internal.Module.keys.app(mid))
                        .app(PS.Data.Semigroup.Module.append
                               .app(PS.Data.List.Types.Module.semigroupList)
                               .app(PS.Control.Applicative.Module.pure
                                      .app(
                                        PS.Data.List.Types.Module.applicativeList
                                      )
                                      .app(k2))
                               .app(PS.Data.Map.Internal.Module.keys.app(right))
            )));
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val isSubmap = { dictOrd : Any ->
     { dictEq : Any ->
       { m1 : Any ->
         { m2 : Any ->
           object   {
               val f = { v : Any ->
                  when {
                   (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                     val k = v.value0;
                     val v1 = v.value1;
                     PS.Data.Eq.Module.eq
                       .app(PS.Data.Maybe.Module.eqMaybe.app(dictEq))
                       .app(PS.Data.Map.Internal.Module.lookup.app(dictOrd)
                              .app(k)
                              .app(m2))
                       .app(PS.Data.Maybe.Module.Just.app(v1));
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               };
             }
             .run({
              val f = this.f;
              PS.Data.Function.Module.apply
                .app(PS.Data.Foldable.Module.all
                       .app(PS.Data.List.Lazy.Types.Module.foldableList)
                       .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                       .app(f))
                .app(PS.Data.Map.Internal.Module.toUnfoldable
                       .app(PS.Data.List.Lazy.Types.Module.unfoldableList)
                       .app(m1));
            })
        }
      }
    }
  };
  @JvmField
  val isEmpty = { v : Any ->
     when {
      (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
        true;
      }
      else -> {
        false;
      }
    }
  };
  @JvmField val functorMap = (::__rec_functorMap)();
  fun __rec_functorMap(): Any = PS.Data.Functor.Module.Functor
                                  .app({ v : Any ->
       { v1 : Any ->
         when {
          (v1 is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
            PS.Data.Map.Internal.Module.Leaf;
          }
          (v1 is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
            val f = v;
            val left = v1.value0;
            val k = v1.value1;
            val v2 = v1.value2;
            val right = v1.value3;
            PS.Data.Map.Internal.Module.Two
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Map.Internal.Module.functorMap)
                     .app(f)
                     .app(left))
              .app(k)
              .app(f.app(v2))
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Map.Internal.Module.functorMap)
                     .app(f)
                     .app(right));
          }
          (v1 is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
            val f = v;
            val left = v1.value0;
            val k1 = v1.value1;
            val v11 = v1.value2;
            val mid = v1.value3;
            val k2 = v1.value4;
            val v2 = v1.value5;
            val right = v1.value6;
            PS.Data.Map.Internal.Module.Three
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Map.Internal.Module.functorMap)
                     .app(f)
                     .app(left))
              .app(k1)
              .app(f.app(v11))
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Map.Internal.Module.functorMap)
                     .app(f)
                     .app(mid))
              .app(k2)
              .app(f.app(v2))
              .app(PS.Data.Functor.Module.map
                     .app(PS.Data.Map.Internal.Module.functorMap)
                     .app(f)
                     .app(right));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField val functorWithIndexMap = (::__rec_functorWithIndexMap)();
  fun __rec_functorWithIndexMap(): Any = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                           .app({ _ : Any ->
                                                PS.Data.Map.Internal.Module.functorMap
                                             })
                                           .app({ v : Any ->
       { v1 : Any ->
         when {
          (v1 is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
            PS.Data.Map.Internal.Module.Leaf;
          }
          (v1 is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
            val f = v;
            val left = v1.value0;
            val k = v1.value1;
            val v2 = v1.value2;
            val right = v1.value3;
            PS.Data.Map.Internal.Module.Two
              .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                     .app(PS.Data.Map.Internal.Module.functorWithIndexMap)
                     .app(f)
                     .app(left))
              .app(k)
              .app(f.app(k).app(v2))
              .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                     .app(PS.Data.Map.Internal.Module.functorWithIndexMap)
                     .app(f)
                     .app(right));
          }
          (v1 is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
            val f = v;
            val left = v1.value0;
            val k1 = v1.value1;
            val v11 = v1.value2;
            val mid = v1.value3;
            val k2 = v1.value4;
            val v2 = v1.value5;
            val right = v1.value6;
            PS.Data.Map.Internal.Module.Three
              .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                     .app(PS.Data.Map.Internal.Module.functorWithIndexMap)
                     .app(f)
                     .app(left))
              .app(k1)
              .app(f.app(k1).app(v11))
              .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                     .app(PS.Data.Map.Internal.Module.functorWithIndexMap)
                     .app(f)
                     .app(mid))
              .app(k2)
              .app(f.app(k2).app(v2))
              .app(PS.Data.FunctorWithIndex.Module.mapWithIndex
                     .app(PS.Data.Map.Internal.Module.functorWithIndexMap)
                     .app(f)
                     .app(right));
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField val fromZipper = (::__rec_fromZipper)();
  fun __rec_fromZipper(): Any = { dictOrd : Any ->
     { v : Any ->
       { tree : Any ->
         when {
          (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
            val tree1 = tree;
            tree1;
          }
          (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
            val x = v.value0;
            val ctx = v.value1;
            val tree1 = tree;
            when {
              (x is PS.Data.Map.Internal.Module._Type_TreeContext.TwoLeft) -> {
                val k1 = x.value0;
                val v1 = x.value1;
                val right = x.value2;
                PS.Data.Map.Internal.Module.fromZipper.app(dictOrd).app(ctx)
                  .app(PS.Data.Map.Internal.Module.Two.app(tree1).app(k1)
                         .app(v1)
                         .app(right));
              }
              (x is PS.Data.Map.Internal.Module._Type_TreeContext.TwoRight) -> {
                val left = x.value0;
                val k1 = x.value1;
                val v1 = x.value2;
                PS.Data.Map.Internal.Module.fromZipper.app(dictOrd).app(ctx)
                  .app(PS.Data.Map.Internal.Module.Two.app(left).app(k1).app(v1)
                         .app(tree1));
              }
              (x is PS.Data.Map.Internal.Module._Type_TreeContext
                      .ThreeLeft) -> {
                val k1 = x.value0;
                val v1 = x.value1;
                val mid = x.value2;
                val k2 = x.value3;
                val v2 = x.value4;
                val right = x.value5;
                PS.Data.Map.Internal.Module.fromZipper.app(dictOrd).app(ctx)
                  .app(PS.Data.Map.Internal.Module.Three.app(tree1).app(k1)
                         .app(v1)
                         .app(mid)
                         .app(k2)
                         .app(v2)
                         .app(right));
              }
              (x is PS.Data.Map.Internal.Module._Type_TreeContext
                      .ThreeMiddle) -> {
                val left = x.value0;
                val k1 = x.value1;
                val v1 = x.value2;
                val k2 = x.value3;
                val v2 = x.value4;
                val right = x.value5;
                PS.Data.Map.Internal.Module.fromZipper.app(dictOrd).app(ctx)
                  .app(PS.Data.Map.Internal.Module.Three.app(left).app(k1)
                         .app(v1)
                         .app(tree1)
                         .app(k2)
                         .app(v2)
                         .app(right));
              }
              (x is PS.Data.Map.Internal.Module._Type_TreeContext
                      .ThreeRight) -> {
                val left = x.value0;
                val k1 = x.value1;
                val v1 = x.value2;
                val mid = x.value3;
                val k2 = x.value4;
                val v2 = x.value5;
                PS.Data.Map.Internal.Module.fromZipper.app(dictOrd).app(ctx)
                  .app(PS.Data.Map.Internal.Module.Three.app(left).app(k1)
                         .app(v1)
                         .app(mid)
                         .app(k2)
                         .app(v2)
                         .app(tree1));
              }
              else -> (error("Error in Pattern Match") as Any)
            };
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    }
  };
  @JvmField
  val insert = { dictOrd : Any ->
     { k : Any ->
       { v : Any ->
         object   {
             val up = (::__rec_up)();
             val comp = PS.Data.Ord.Module.compare.app(dictOrd);
             val down = (::__rec_down)();
             fun __rec_up(): Any = { v1 : Any ->
                { v2 : Any ->
                  when {
                   (v1 is PS.Data.List.Types.Module._Type_List
                            .Nil)&&
                   (v2 is PS.Data.Map.Internal.Module._Type_KickUp
                            .KickUp) -> {
                     val left = v2.value0;
                     val k_tick = v2.value1;
                     val v_tick = v2.value2;
                     val right = v2.value3;
                     PS.Data.Map.Internal.Module.Two.app(left).app(k_tick)
                       .app(v_tick)
                       .app(right);
                   }
                   (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
                     val x = v1.value0;
                     val ctx = v1.value1;
                     val kup = v2;
                     when {
                       (x is PS.Data.Map.Internal.Module._Type_TreeContext
                               .TwoLeft)&&
                       (kup is PS.Data.Map.Internal.Module._Type_KickUp
                                 .KickUp) -> {
                         val k1 = x.value0;
                         val v11 = x.value1;
                         val right = x.value2;
                         val left = kup.value0;
                         val k_tick = kup.value1;
                         val v_tick = kup.value2;
                         val mid = kup.value3;
                         PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                           .app(ctx)
                           .app(PS.Data.Map.Internal.Module.Three.app(left)
                                  .app(k_tick)
                                  .app(v_tick)
                                  .app(mid)
                                  .app(k1)
                                  .app(v11)
                                  .app(right));
                       }
                       (x is PS.Data.Map.Internal.Module._Type_TreeContext
                               .TwoRight)&&
                       (kup is PS.Data.Map.Internal.Module._Type_KickUp
                                 .KickUp) -> {
                         val left = x.value0;
                         val k1 = x.value1;
                         val v11 = x.value2;
                         val mid = kup.value0;
                         val k_tick = kup.value1;
                         val v_tick = kup.value2;
                         val right = kup.value3;
                         PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                           .app(ctx)
                           .app(PS.Data.Map.Internal.Module.Three.app(left)
                                  .app(k1)
                                  .app(v11)
                                  .app(mid)
                                  .app(k_tick)
                                  .app(v_tick)
                                  .app(right));
                       }
                       (x is PS.Data.Map.Internal.Module._Type_TreeContext
                               .ThreeLeft)&&
                       (kup is PS.Data.Map.Internal.Module._Type_KickUp
                                 .KickUp) -> {
                         val k1 = x.value0;
                         val v11 = x.value1;
                         val c = x.value2;
                         val k2 = x.value3;
                         val v21 = x.value4;
                         val d = x.value5;
                         val a = kup.value0;
                         val k_tick = kup.value1;
                         val v_tick = kup.value2;
                         val b = kup.value3;
                         __rec_up().app(ctx)
                           .app(PS.Data.Map.Internal.Module.KickUp
                                  .app(PS.Data.Map.Internal.Module.Two.app(a)
                                         .app(k_tick)
                                         .app(v_tick)
                                         .app(b))
                                  .app(k1)
                                  .app(v11)
                                  .app(PS.Data.Map.Internal.Module.Two.app(c)
                                         .app(k2)
                                         .app(v21)
                                         .app(d)));
                       }
                       (x is PS.Data.Map.Internal.Module._Type_TreeContext
                               .ThreeMiddle)&&
                       (kup is PS.Data.Map.Internal.Module._Type_KickUp
                                 .KickUp) -> {
                         val a = x.value0;
                         val k1 = x.value1;
                         val v11 = x.value2;
                         val k2 = x.value3;
                         val v21 = x.value4;
                         val d = x.value5;
                         val b = kup.value0;
                         val k_tick = kup.value1;
                         val v_tick = kup.value2;
                         val c = kup.value3;
                         __rec_up().app(ctx)
                           .app(PS.Data.Map.Internal.Module.KickUp
                                  .app(PS.Data.Map.Internal.Module.Two.app(a)
                                         .app(k1)
                                         .app(v11)
                                         .app(b))
                                  .app(k_tick)
                                  .app(v_tick)
                                  .app(PS.Data.Map.Internal.Module.Two.app(c)
                                         .app(k2)
                                         .app(v21)
                                         .app(d)));
                       }
                       (x is PS.Data.Map.Internal.Module._Type_TreeContext
                               .ThreeRight)&&
                       (kup is PS.Data.Map.Internal.Module._Type_KickUp
                                 .KickUp) -> {
                         val a = x.value0;
                         val k1 = x.value1;
                         val v11 = x.value2;
                         val b = x.value3;
                         val k2 = x.value4;
                         val v21 = x.value5;
                         val c = kup.value0;
                         val k_tick = kup.value1;
                         val v_tick = kup.value2;
                         val d = kup.value3;
                         __rec_up().app(ctx)
                           .app(PS.Data.Map.Internal.Module.KickUp
                                  .app(PS.Data.Map.Internal.Module.Two.app(a)
                                         .app(k1)
                                         .app(v11)
                                         .app(b))
                                  .app(k2)
                                  .app(v21)
                                  .app(PS.Data.Map.Internal.Module.Two.app(c)
                                         .app(k_tick)
                                         .app(v_tick)
                                         .app(d)));
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               }
             };
             fun __rec_down(): Any = { ctx : Any ->
                { v1 : Any ->
                  when {
                   (v1 is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                     val ctx1 = ctx;
                     up.app(ctx1)
                       .app(PS.Data.Map.Internal.Module.KickUp
                              .app(PS.Data.Map.Internal.Module.Leaf)
                              .app(k)
                              .app(v)
                              .app(PS.Data.Map.Internal.Module.Leaf));
                   }
                   (v1 is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                     val ctx1 = ctx;
                     val left = v1.value0;
                     val k1 = v1.value1;
                     val v11 = v1.value2;
                     val right = v1.value3;
                     object   {
                         val v2 = comp.app(k).app(k1);
                       }
                       .run({
                         val v2 = this.v2;
                         when {
                           (v2 is PS.Data.Ordering.Module._Type_Ordering
                                    .EQ) -> {
                             PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                               .app(ctx1)
                               .app(PS.Data.Map.Internal.Module.Two.app(left)
                                      .app(k)
                                      .app(v)
                                      .app(right));
                           }
                           (v2 is PS.Data.Ordering.Module._Type_Ordering
                                    .LT) -> {
                             __rec_down()
                               .app(PS.Data.List.Types.Module.Cons
                                      .app(PS.Data.Map.Internal.Module.TwoLeft
                                             .app(k1)
                                             .app(v11)
                                             .app(right))
                                      .app(ctx1))
                               .app(left);
                           }
                           else -> {
                             __rec_down()
                               .app(PS.Data.List.Types.Module.Cons
                                      .app(PS.Data.Map.Internal.Module.TwoRight
                                             .app(left)
                                             .app(k1)
                                             .app(v11))
                                      .app(ctx1))
                               .app(right);
                           }
                         };
                       });
                   }
                   (v1 is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                     val ctx1 = ctx;
                     val left = v1.value0;
                     val k1 = v1.value1;
                     val v11 = v1.value2;
                     val mid = v1.value3;
                     val k2 = v1.value4;
                     val v2 = v1.value5;
                     val right = v1.value6;
                     object   {
                         val v3 = comp.app(k).app(k1);
                       }
                       .run({
                         val v3 = this.v3;
                         when {
                           (v3 is PS.Data.Ordering.Module._Type_Ordering
                                    .EQ) -> {
                             PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                               .app(ctx1)
                               .app(PS.Data.Map.Internal.Module.Three.app(left)
                                      .app(k)
                                      .app(v)
                                      .app(mid)
                                      .app(k2)
                                      .app(v2)
                                      .app(right));
                           }
                           else -> {
                             val c1 = v3;
                             object   {
                                 val v4 = comp.app(k).app(k2);
                                 val v5 = c1;
                               }
                               .run({
                                 val v4 = this.v4;
                                 val v5 = this.v5;
                                 when {
                                   (v4 is PS.Data.Ordering.Module._Type_Ordering
                                            .EQ) -> {
                                     PS.Data.Map.Internal.Module.fromZipper
                                       .app(dictOrd)
                                       .app(ctx1)
                                       .app(PS.Data.Map.Internal.Module.Three
                                              .app(left)
                                              .app(k1)
                                              .app(v11)
                                              .app(mid)
                                              .app(k)
                                              .app(v)
                                              .app(right));
                                   }
                                   (v5 is PS.Data.Ordering.Module._Type_Ordering
                                            .LT) -> {
                                     __rec_down()
                                       .app(PS.Data.List.Types.Module.Cons
                                              .app(
                                                PS.Data.Map.Internal.Module.ThreeLeft
                                                  .app(k1)
                                                  .app(v11)
                                                  .app(mid)
                                                  .app(k2)
                                                  .app(v2)
                                                  .app(right))
                                              .app(ctx1))
                                       .app(left);
                                   }
                                   (v5 is PS.Data.Ordering.Module._Type_Ordering
                                            .GT)&&
                                   (v4 is PS.Data.Ordering.Module._Type_Ordering
                                            .LT) -> {
                                     __rec_down()
                                       .app(PS.Data.List.Types.Module.Cons
                                              .app(
                                                PS.Data.Map.Internal.Module.ThreeMiddle
                                                  .app(left)
                                                  .app(k1)
                                                  .app(v11)
                                                  .app(k2)
                                                  .app(v2)
                                                  .app(right))
                                              .app(ctx1))
                                       .app(mid);
                                   }
                                   else -> {
                                     __rec_down()
                                       .app(PS.Data.List.Types.Module.Cons
                                              .app(
                                                PS.Data.Map.Internal.Module.ThreeRight
                                                  .app(left)
                                                  .app(k1)
                                                  .app(v11)
                                                  .app(mid)
                                                  .app(k2)
                                                  .app(v2))
                                              .app(ctx1))
                                       .app(right);
                                   }
                                 };
                               });
                           }
                         };
                       });
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               }
             };
           }
           .run({
            val up = this.up;
            val comp = this.comp;
            val down = this.down;
            down.app(PS.Data.List.Types.Module.Nil);
          })
      }
    }
  };
  @JvmField
  val pop = { dictOrd : Any ->
     { k : Any ->
       object   {
           val up = (::__rec_up)();
           val removeMaxNode = (::__rec_removeMaxNode)();
           val maxNode = (::__rec_maxNode)();
           val comp = PS.Data.Ord.Module.compare.app(dictOrd);
           val down = (::__rec_down)();
           fun __rec_up(): Any = PS.Partial.Unsafe.Module.unsafePartial
                                   .app({ dictPartial : Any ->
                { ctxs : Any ->
                  { tree : Any ->
                    when {
                     (ctxs is PS.Data.List.Types.Module._Type_List.Nil) -> {
                       tree;
                     }
                     (ctxs is PS.Data.List.Types.Module._Type_List.Cons) -> {
                       val x = ctxs.value0;
                       val ctx = ctxs.value1;
                       when {
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .TwoLeft)&& (x
                                                .value2 is PS.Data.Map.Internal.Module._Type_Map
                                                             .Leaf)&&
                         (tree is PS.Data.Map.Internal.Module._Type_Map
                                    .Leaf) -> {
                           val k1 = x.value0;
                           val v1 = x.value1;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Two
                                    .app(PS.Data.Map.Internal.Module.Leaf)
                                    .app(k1)
                                    .app(v1)
                                    .app(PS.Data.Map.Internal.Module.Leaf));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .TwoRight)&& (x
                                                 .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                              .Leaf)&&
                         (tree is PS.Data.Map.Internal.Module._Type_Map
                                    .Leaf) -> {
                           val k1 = x.value1;
                           val v1 = x.value2;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Two
                                    .app(PS.Data.Map.Internal.Module.Leaf)
                                    .app(k1)
                                    .app(v1)
                                    .app(PS.Data.Map.Internal.Module.Leaf));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .TwoLeft)&& (x
                                                .value2 is PS.Data.Map.Internal.Module._Type_Map
                                                             .Two) -> {
                           val k1 = x.value0;
                           val v1 = x.value1;
                           val m = x.value2.value0;
                           val k2 = x.value2.value1;
                           val v2 = x.value2.value2;
                           val r = x.value2.value3;
                           val l = tree;
                           __rec_up().app(ctx)
                             .app(PS.Data.Map.Internal.Module.Three.app(l)
                                    .app(k1)
                                    .app(v1)
                                    .app(m)
                                    .app(k2)
                                    .app(v2)
                                    .app(r));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .TwoRight)&& (x
                                                 .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                              .Two) -> {
                           val l = x.value0.value0;
                           val k1 = x.value0.value1;
                           val v1 = x.value0.value2;
                           val m = x.value0.value3;
                           val k2 = x.value1;
                           val v2 = x.value2;
                           val r = tree;
                           __rec_up().app(ctx)
                             .app(PS.Data.Map.Internal.Module.Three.app(l)
                                    .app(k1)
                                    .app(v1)
                                    .app(m)
                                    .app(k2)
                                    .app(v2)
                                    .app(r));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .TwoLeft)&& (x
                                                .value2 is PS.Data.Map.Internal.Module._Type_Map
                                                             .Three) -> {
                           val k1 = x.value0;
                           val v1 = x.value1;
                           val b = x.value2.value0;
                           val k2 = x.value2.value1;
                           val v2 = x.value2.value2;
                           val c = x.value2.value3;
                           val k3 = x.value2.value4;
                           val v3 = x.value2.value5;
                           val d = x.value2.value6;
                           val a = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Two
                                    .app(PS.Data.Map.Internal.Module.Two.app(a)
                                           .app(k1)
                                           .app(v1)
                                           .app(b))
                                    .app(k2)
                                    .app(v2)
                                    .app(PS.Data.Map.Internal.Module.Two.app(c)
                                           .app(k3)
                                           .app(v3)
                                           .app(d)));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .TwoRight)&& (x
                                                 .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                              .Three) -> {
                           val a = x.value0.value0;
                           val k1 = x.value0.value1;
                           val v1 = x.value0.value2;
                           val b = x.value0.value3;
                           val k2 = x.value0.value4;
                           val v2 = x.value0.value5;
                           val c = x.value0.value6;
                           val k3 = x.value1;
                           val v3 = x.value2;
                           val d = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Two
                                    .app(PS.Data.Map.Internal.Module.Two.app(a)
                                           .app(k1)
                                           .app(v1)
                                           .app(b))
                                    .app(k2)
                                    .app(v2)
                                    .app(PS.Data.Map.Internal.Module.Two.app(c)
                                           .app(k3)
                                           .app(v3)
                                           .app(d)));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeLeft)&& (x
                                                  .value2 is PS.Data.Map.Internal.Module._Type_Map
                                                               .Leaf)&& (x
                                                                           .value5 is PS.Data.Map.Internal.Module._Type_Map
                                                                                        .Leaf)&&
                         (tree is PS.Data.Map.Internal.Module._Type_Map
                                    .Leaf) -> {
                           val k1 = x.value0;
                           val v1 = x.value1;
                           val k2 = x.value3;
                           val v2 = x.value4;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Three
                                    .app(PS.Data.Map.Internal.Module.Leaf)
                                    .app(k1)
                                    .app(v1)
                                    .app(PS.Data.Map.Internal.Module.Leaf)
                                    .app(k2)
                                    .app(v2)
                                    .app(PS.Data.Map.Internal.Module.Leaf));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeMiddle)&& (x
                                                    .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                                 .Leaf)&& (x
                                                                             .value5 is PS.Data.Map.Internal.Module._Type_Map
                                                                                          .Leaf)&&
                         (tree is PS.Data.Map.Internal.Module._Type_Map
                                    .Leaf) -> {
                           val k1 = x.value1;
                           val v1 = x.value2;
                           val k2 = x.value3;
                           val v2 = x.value4;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Three
                                    .app(PS.Data.Map.Internal.Module.Leaf)
                                    .app(k1)
                                    .app(v1)
                                    .app(PS.Data.Map.Internal.Module.Leaf)
                                    .app(k2)
                                    .app(v2)
                                    .app(PS.Data.Map.Internal.Module.Leaf));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeRight)&& (x
                                                   .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                                .Leaf)&& (x
                                                                            .value3 is PS.Data.Map.Internal.Module._Type_Map
                                                                                         .Leaf)&&
                         (tree is PS.Data.Map.Internal.Module._Type_Map
                                    .Leaf) -> {
                           val k1 = x.value1;
                           val v1 = x.value2;
                           val k2 = x.value4;
                           val v2 = x.value5;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Three
                                    .app(PS.Data.Map.Internal.Module.Leaf)
                                    .app(k1)
                                    .app(v1)
                                    .app(PS.Data.Map.Internal.Module.Leaf)
                                    .app(k2)
                                    .app(v2)
                                    .app(PS.Data.Map.Internal.Module.Leaf));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeLeft)&& (x
                                                  .value2 is PS.Data.Map.Internal.Module._Type_Map
                                                               .Two) -> {
                           val k1 = x.value0;
                           val v1 = x.value1;
                           val b = x.value2.value0;
                           val k2 = x.value2.value1;
                           val v2 = x.value2.value2;
                           val c = x.value2.value3;
                           val k3 = x.value3;
                           val v3 = x.value4;
                           val d = x.value5;
                           val a = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Two
                                    .app(PS.Data.Map.Internal.Module.Three
                                           .app(a)
                                           .app(k1)
                                           .app(v1)
                                           .app(b)
                                           .app(k2)
                                           .app(v2)
                                           .app(c))
                                    .app(k3)
                                    .app(v3)
                                    .app(d));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeMiddle)&& (x
                                                    .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                                 .Two) -> {
                           val a = x.value0.value0;
                           val k1 = x.value0.value1;
                           val v1 = x.value0.value2;
                           val b = x.value0.value3;
                           val k2 = x.value1;
                           val v2 = x.value2;
                           val k3 = x.value3;
                           val v3 = x.value4;
                           val d = x.value5;
                           val c = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Two
                                    .app(PS.Data.Map.Internal.Module.Three
                                           .app(a)
                                           .app(k1)
                                           .app(v1)
                                           .app(b)
                                           .app(k2)
                                           .app(v2)
                                           .app(c))
                                    .app(k3)
                                    .app(v3)
                                    .app(d));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeMiddle)&& (x
                                                    .value5 is PS.Data.Map.Internal.Module._Type_Map
                                                                 .Two) -> {
                           val a = x.value0;
                           val k1 = x.value1;
                           val v1 = x.value2;
                           val k2 = x.value3;
                           val v2 = x.value4;
                           val c = x.value5.value0;
                           val k3 = x.value5.value1;
                           val v3 = x.value5.value2;
                           val d = x.value5.value3;
                           val b = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Two.app(a).app(k1)
                                    .app(v1)
                                    .app(PS.Data.Map.Internal.Module.Three
                                           .app(b)
                                           .app(k2)
                                           .app(v2)
                                           .app(c)
                                           .app(k3)
                                           .app(v3)
                                           .app(d)));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeRight)&& (x
                                                   .value3 is PS.Data.Map.Internal.Module._Type_Map
                                                                .Two) -> {
                           val a = x.value0;
                           val k1 = x.value1;
                           val v1 = x.value2;
                           val b = x.value3.value0;
                           val k2 = x.value3.value1;
                           val v2 = x.value3.value2;
                           val c = x.value3.value3;
                           val k3 = x.value4;
                           val v3 = x.value5;
                           val d = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Two.app(a).app(k1)
                                    .app(v1)
                                    .app(PS.Data.Map.Internal.Module.Three
                                           .app(b)
                                           .app(k2)
                                           .app(v2)
                                           .app(c)
                                           .app(k3)
                                           .app(v3)
                                           .app(d)));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeLeft)&& (x
                                                  .value2 is PS.Data.Map.Internal.Module._Type_Map
                                                               .Three) -> {
                           val k1 = x.value0;
                           val v1 = x.value1;
                           val b = x.value2.value0;
                           val k2 = x.value2.value1;
                           val v2 = x.value2.value2;
                           val c = x.value2.value3;
                           val k3 = x.value2.value4;
                           val v3 = x.value2.value5;
                           val d = x.value2.value6;
                           val k4 = x.value3;
                           val v4 = x.value4;
                           val e = x.value5;
                           val a = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Three
                                    .app(PS.Data.Map.Internal.Module.Two.app(a)
                                           .app(k1)
                                           .app(v1)
                                           .app(b))
                                    .app(k2)
                                    .app(v2)
                                    .app(PS.Data.Map.Internal.Module.Two.app(c)
                                           .app(k3)
                                           .app(v3)
                                           .app(d))
                                    .app(k4)
                                    .app(v4)
                                    .app(e));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeMiddle)&& (x
                                                    .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                                 .Three) -> {
                           val a = x.value0.value0;
                           val k1 = x.value0.value1;
                           val v1 = x.value0.value2;
                           val b = x.value0.value3;
                           val k2 = x.value0.value4;
                           val v2 = x.value0.value5;
                           val c = x.value0.value6;
                           val k3 = x.value1;
                           val v3 = x.value2;
                           val k4 = x.value3;
                           val v4 = x.value4;
                           val e = x.value5;
                           val d = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Three
                                    .app(PS.Data.Map.Internal.Module.Two.app(a)
                                           .app(k1)
                                           .app(v1)
                                           .app(b))
                                    .app(k2)
                                    .app(v2)
                                    .app(PS.Data.Map.Internal.Module.Two.app(c)
                                           .app(k3)
                                           .app(v3)
                                           .app(d))
                                    .app(k4)
                                    .app(v4)
                                    .app(e));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeMiddle)&& (x
                                                    .value5 is PS.Data.Map.Internal.Module._Type_Map
                                                                 .Three) -> {
                           val a = x.value0;
                           val k1 = x.value1;
                           val v1 = x.value2;
                           val k2 = x.value3;
                           val v2 = x.value4;
                           val c = x.value5.value0;
                           val k3 = x.value5.value1;
                           val v3 = x.value5.value2;
                           val d = x.value5.value3;
                           val k4 = x.value5.value4;
                           val v4 = x.value5.value5;
                           val e = x.value5.value6;
                           val b = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Three.app(a)
                                    .app(k1)
                                    .app(v1)
                                    .app(PS.Data.Map.Internal.Module.Two.app(b)
                                           .app(k2)
                                           .app(v2)
                                           .app(c))
                                    .app(k3)
                                    .app(v3)
                                    .app(PS.Data.Map.Internal.Module.Two.app(d)
                                           .app(k4)
                                           .app(v4)
                                           .app(e)));
                         }
                         (x is PS.Data.Map.Internal.Module._Type_TreeContext
                                 .ThreeRight)&& (x
                                                   .value3 is PS.Data.Map.Internal.Module._Type_Map
                                                                .Three) -> {
                           val a = x.value0;
                           val k1 = x.value1;
                           val v1 = x.value2;
                           val b = x.value3.value0;
                           val k2 = x.value3.value1;
                           val v2 = x.value3.value2;
                           val c = x.value3.value3;
                           val k3 = x.value3.value4;
                           val v3 = x.value3.value5;
                           val d = x.value3.value6;
                           val k4 = x.value4;
                           val v4 = x.value5;
                           val e = tree;
                           PS.Data.Map.Internal.Module.fromZipper.app(dictOrd)
                             .app(ctx)
                             .app(PS.Data.Map.Internal.Module.Three.app(a)
                                    .app(k1)
                                    .app(v1)
                                    .app(PS.Data.Map.Internal.Module.Two.app(b)
                                           .app(k2)
                                           .app(v2)
                                           .app(c))
                                    .app(k3)
                                    .app(v3)
                                    .app(PS.Data.Map.Internal.Module.Two.app(d)
                                           .app(k4)
                                           .app(v4)
                                           .app(e)));
                         }
                         else -> (error("Error in Pattern Match") as Any)
                       };
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               }
             });
           fun __rec_removeMaxNode(): Any = PS.Partial.Unsafe.Module.unsafePartial
                                              .app({ dictPartial : Any ->
                { ctx : Any ->
                  { m : Any ->
                    when {
                     (m is PS.Data.Map.Internal.Module._Type_Map
                             .Two)&& (m
                                        .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                     .Leaf)&& (m
                                                                 .value3 is PS.Data.Map.Internal.Module._Type_Map
                                                                              .Leaf) -> {
                       up.app(ctx).app(PS.Data.Map.Internal.Module.Leaf);
                     }
                     (m is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                       val left = m.value0;
                       val k_tick = m.value1;
                       val v = m.value2;
                       val right = m.value3;
                       __rec_removeMaxNode()
                         .app(PS.Data.List.Types.Module.Cons
                                .app(PS.Data.Map.Internal.Module.TwoRight
                                       .app(left)
                                       .app(k_tick)
                                       .app(v))
                                .app(ctx))
                         .app(right);
                     }
                     (m is PS.Data.Map.Internal.Module._Type_Map
                             .Three)&& (m
                                          .value0 is PS.Data.Map.Internal.Module._Type_Map
                                                       .Leaf)&& (m
                                                                   .value3 is PS.Data.Map.Internal.Module._Type_Map
                                                                                .Leaf)&&
                     (m
                        .value6 is PS.Data.Map.Internal.Module._Type_Map
                                     .Leaf) -> {
                       val k1 = m.value1;
                       val v1 = m.value2;
                       up
                         .app(PS.Data.List.Types.Module.Cons
                                .app(PS.Data.Map.Internal.Module.TwoRight
                                       .app(PS.Data.Map.Internal.Module.Leaf)
                                       .app(k1)
                                       .app(v1))
                                .app(ctx))
                         .app(PS.Data.Map.Internal.Module.Leaf);
                     }
                     (m is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                       val left = m.value0;
                       val k1 = m.value1;
                       val v1 = m.value2;
                       val mid = m.value3;
                       val k2 = m.value4;
                       val v2 = m.value5;
                       val right = m.value6;
                       __rec_removeMaxNode()
                         .app(PS.Data.List.Types.Module.Cons
                                .app(PS.Data.Map.Internal.Module.ThreeRight
                                       .app(left)
                                       .app(k1)
                                       .app(v1)
                                       .app(mid)
                                       .app(k2)
                                       .app(v2))
                                .app(ctx))
                         .app(right);
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               }
             });
           fun __rec_maxNode(): Any = PS.Partial.Unsafe.Module.unsafePartial
                                        .app({ dictPartial : Any ->
                { m : Any ->
                  when {
                   (m is PS.Data.Map.Internal.Module._Type_Map
                           .Two)&& (m
                                      .value3 is PS.Data.Map.Internal.Module._Type_Map
                                                   .Leaf) -> {
                     val k_tick = m.value1;
                     val v = m.value2;
                     mapOf(("key" to k_tick),  ("value" to v));
                   }
                   (m is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                     val right = m.value3;
                     __rec_maxNode().app(right);
                   }
                   (m is PS.Data.Map.Internal.Module._Type_Map
                           .Three)&& (m
                                        .value6 is PS.Data.Map.Internal.Module._Type_Map
                                                     .Leaf) -> {
                     val k_tick = m.value4;
                     val v = m.value5;
                     mapOf(("key" to k_tick),  ("value" to v));
                   }
                   (m is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                     val right = m.value6;
                     __rec_maxNode().app(right);
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               }
             });
           fun __rec_down(): Any = PS.Partial.Unsafe.Module.unsafePartial
                                     .app({ dictPartial : Any ->
                { ctx : Any ->
                  { m : Any ->
                    when {
                     (m is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                       PS.Data.Maybe.Module.Nothing;
                     }
                     (m is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                       val left = m.value0;
                       val k1 = m.value1;
                       val v1 = m.value2;
                       val right = m.value3;
                       object   {
                           val v = comp.app(k).app(k1);
                           val v2 = right;
                         }
                         .run({
                           val v = this.v;
                           val v2 = this.v2;
                           when {
                             (v2 is PS.Data.Map.Internal.Module._Type_Map
                                      .Leaf)&&
                             (v is PS.Data.Ordering.Module._Type_Ordering
                                     .EQ) -> {
                               PS.Data.Maybe.Module.Just
                                 .app(PS.Data.Tuple.Module.Tuple.app(v1)
                                        .app(up.app(ctx)
                                               .app(
                                     PS.Data.Map.Internal.Module.Leaf)));
                             }
                             (v is PS.Data.Ordering.Module._Type_Ordering
                                     .EQ) -> {
                               object   {
                                   val max = maxNode.app(left);
                                 }
                                 .run({
                                   val max = this.max;
                                   PS.Data.Maybe.Module.Just
                                     .app(PS.Data.Tuple.Module.Tuple.app(v1)
                                            .app(removeMaxNode
                                                   .app(
                                                     PS.Data.List.Types.Module.Cons
                                                       .app(
                                                         PS.Data.Map.Internal.Module.TwoLeft
                                                           .app(
                                                             (max as Map<String, Any>)["key"]!!
                                                           )
                                                           .app(
                                                             (max as Map<String, Any>)["value"]!!
                                                           )
                                                           .app(right))
                                                       .app(ctx))
                                                   .app(left)));
                                 });
                             }
                             (v is PS.Data.Ordering.Module._Type_Ordering
                                     .LT) -> {
                               __rec_down()
                                 .app(PS.Data.List.Types.Module.Cons
                                        .app(PS.Data.Map.Internal.Module.TwoLeft
                                               .app(k1)
                                               .app(v1)
                                               .app(right))
                                        .app(ctx))
                                 .app(left);
                             }
                             else -> {
                               __rec_down()
                                 .app(PS.Data.List.Types.Module.Cons
                                        .app(
                                          PS.Data.Map.Internal.Module.TwoRight
                                            .app(left)
                                            .app(k1)
                                            .app(v1))
                                        .app(ctx))
                                 .app(right);
                             }
                           };
                         });
                     }
                     (m is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                       val left = m.value0;
                       val k1 = m.value1;
                       val v1 = m.value2;
                       val mid = m.value3;
                       val k2 = m.value4;
                       val v2 = m.value5;
                       val right = m.value6;
                       object   {
                           val leaves = when {
                             (left is PS.Data.Map.Internal.Module._Type_Map
                                        .Leaf)&&
                             (mid is PS.Data.Map.Internal.Module._Type_Map
                                       .Leaf)&&
                             (right is PS.Data.Map.Internal.Module._Type_Map
                                         .Leaf) -> {
                               true;
                             }
                             else -> {
                               false;
                             }
                           };
                         }
                         .run({
                           val leaves = this.leaves;
                           object   {
                               val v = comp.app(k).app(k2);
                               val v3 = comp.app(k).app(k1);
                               val v4 = leaves;
                             }
                             .run({
                               val v = this.v;
                               val v3 = this.v3;
                               val v4 = this.v4;
                               when {
                                 (v4 == true)&&
                                 (v3 is PS.Data.Ordering.Module._Type_Ordering
                                          .EQ) -> {
                                   PS.Data.Maybe.Module.Just
                                     .app(PS.Data.Tuple.Module.Tuple.app(v1)
                                            .app(
                                       PS.Data.Map.Internal.Module.fromZipper
                                         .app(dictOrd)
                                         .app(ctx)
                                         .app(PS.Data.Map.Internal.Module.Two
                                                .app(
                                                  PS.Data.Map.Internal.Module.Leaf
                                                )
                                                .app(k2)
                                                .app(v2)
                                                .app(
                                           PS.Data.Map.Internal.Module.Leaf))));
                                 }
                                 (v4 == true)&&
                                 (v is PS.Data.Ordering.Module._Type_Ordering
                                         .EQ) -> {
                                   PS.Data.Maybe.Module.Just
                                     .app(PS.Data.Tuple.Module.Tuple.app(v2)
                                            .app(
                                       PS.Data.Map.Internal.Module.fromZipper
                                         .app(dictOrd)
                                         .app(ctx)
                                         .app(PS.Data.Map.Internal.Module.Two
                                                .app(
                                                  PS.Data.Map.Internal.Module.Leaf
                                                )
                                                .app(k1)
                                                .app(v1)
                                                .app(
                                           PS.Data.Map.Internal.Module.Leaf))));
                                 }
                                 (v3 is PS.Data.Ordering.Module._Type_Ordering
                                          .EQ) -> {
                                   object   {
                                       val max = maxNode.app(left);
                                     }
                                     .run({
                                       val max = this.max;
                                       PS.Data.Maybe.Module.Just
                                         .app(PS.Data.Tuple.Module.Tuple.app(v1)
                                                .app(removeMaxNode
                                                       .app(
                                                         PS.Data.List.Types.Module.Cons
                                                           .app(
                                                             PS.Data.Map.Internal.Module.ThreeLeft
                                                               .app(
                                                                 (max as Map<String, Any>)["key"]!!
                                                               )
                                                               .app(
                                                                 (max as Map<String, Any>)["value"]!!
                                                               )
                                                               .app(mid)
                                                               .app(k2)
                                                               .app(v2)
                                                               .app(right))
                                                           .app(ctx))
                                                       .app(left)));
                                     });
                                 }
                                 (v is PS.Data.Ordering.Module._Type_Ordering
                                         .EQ) -> {
                                   object   {
                                       val max = maxNode.app(mid);
                                     }
                                     .run({
                                       val max = this.max;
                                       PS.Data.Maybe.Module.Just
                                         .app(PS.Data.Tuple.Module.Tuple.app(v2)
                                                .app(removeMaxNode
                                                       .app(
                                                         PS.Data.List.Types.Module.Cons
                                                           .app(
                                                             PS.Data.Map.Internal.Module.ThreeMiddle
                                                               .app(left)
                                                               .app(k1)
                                                               .app(v1)
                                                               .app(
                                                                 (max as Map<String, Any>)["key"]!!
                                                               )
                                                               .app(
                                                                 (max as Map<String, Any>)["value"]!!
                                                               )
                                                               .app(right))
                                                           .app(ctx))
                                                       .app(mid)));
                                     });
                                 }
                                 (v3 is PS.Data.Ordering.Module._Type_Ordering
                                          .LT) -> {
                                   __rec_down()
                                     .app(PS.Data.List.Types.Module.Cons
                                            .app(
                                              PS.Data.Map.Internal.Module.ThreeLeft
                                                .app(k1)
                                                .app(v1)
                                                .app(mid)
                                                .app(k2)
                                                .app(v2)
                                                .app(right))
                                            .app(ctx))
                                     .app(left);
                                 }
                                 (v3 is PS.Data.Ordering.Module._Type_Ordering
                                          .GT)&&
                                 (v is PS.Data.Ordering.Module._Type_Ordering
                                         .LT) -> {
                                   __rec_down()
                                     .app(PS.Data.List.Types.Module.Cons
                                            .app(
                                              PS.Data.Map.Internal.Module.ThreeMiddle
                                                .app(left)
                                                .app(k1)
                                                .app(v1)
                                                .app(k2)
                                                .app(v2)
                                                .app(right))
                                            .app(ctx))
                                     .app(mid);
                                 }
                                 else -> {
                                   __rec_down()
                                     .app(PS.Data.List.Types.Module.Cons
                                            .app(
                                              PS.Data.Map.Internal.Module.ThreeRight
                                                .app(left)
                                                .app(k1)
                                                .app(v1)
                                                .app(mid)
                                                .app(k2)
                                                .app(v2))
                                            .app(ctx))
                                     .app(right);
                                 }
                               };
                             });
                         });
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               }
             });
         }
         .run({
          val up = this.up;
          val removeMaxNode = this.removeMaxNode;
          val maxNode = this.maxNode;
          val comp = this.comp;
          val down = this.down;
          down.app(PS.Data.List.Types.Module.Nil);
        })
    }
  };
  @JvmField
  val foldableMap = PS.Data.Foldable.Module.Foldable
                      .app({ dictMonoid : Any ->
                           { f : Any ->
                             { m : Any ->
                               PS.Data.Foldable.Module.foldMap
                                 .app(PS.Data.List.Types.Module.foldableList)
                                 .app(dictMonoid)
                                 .app(f)
                                 .app(PS.Data.Map.Internal.Module.values.app(m))
                            }
                          }
                        })
                      .app({ f : Any ->
                           { z : Any ->
                             { m : Any ->
                               PS.Data.Foldable.Module.foldl
                                 .app(PS.Data.List.Types.Module.foldableList)
                                 .app(f)
                                 .app(z)
                                 .app(PS.Data.Map.Internal.Module.values.app(m))
                            }
                          }
                        })
                      .app({ f : Any ->
       { z : Any ->
         { m : Any ->
           PS.Data.Foldable.Module.foldr
             .app(PS.Data.List.Types.Module.foldableList)
             .app(f)
             .app(z)
             .app(PS.Data.Map.Internal.Module.values.app(m))
        }
      }
    });
  @JvmField val traversableMap = (::__rec_traversableMap)();
  fun __rec_traversableMap(): Any = PS.Data.Traversable.Module.Traversable
                                      .app({ _ : Any ->
                                           PS.Data.Map.Internal.Module.foldableMap
                                        })
                                      .app({ _ : Any ->
                                           PS.Data.Map.Internal.Module.functorMap
                                        })
                                      .app({ dictApplicative : Any ->
                                           PS.Data.Traversable.Module.traverse
                                             .app(
                                               PS.Data.Map.Internal.Module.traversableMap
                                             )
                                             .app(dictApplicative)
                                             .app(
                                            PS.Control.Category.Module.identity
                                              .app(
                                              PS.Control.Category.Module.categoryFn
                                            ))
                                        })
                                      .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
              val f1 = f;
              PS.Control.Applicative.Module.pure.app(dictApplicative)
                .app(PS.Data.Map.Internal.Module.Leaf);
            }
            (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
              val f1 = f;
              val left = v.value0;
              val k = v.value1;
              val v1 = v.value2;
              val right = v.value3;
              PS.Control.Apply.Module.apply
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
                )
                .app(PS.Control.Apply.Module.apply
                       .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                              .app(Unit))
                       .app(PS.Control.Apply.Module.apply
                              .app(
                                (dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit))
                              .app(PS.Data.Functor.Module.map
                                     .app(
                                       ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                          .app(Unit
                                         ) as Map<String, Any>)["Functor0"]!!
                                         .app(Unit))
                                     .app(PS.Data.Map.Internal.Module.Two)
                                     .app(PS.Data.Traversable.Module.traverse
                                            .app(
                                              PS.Data.Map.Internal.Module.traversableMap
                                            )
                                            .app(dictApplicative)
                                            .app(f1)
                                            .app(left)))
                              .app(PS.Control.Applicative.Module.pure
                                     .app(dictApplicative)
                                     .app(k)))
                       .app(f1.app(v1)))
                .app(PS.Data.Traversable.Module.traverse
                       .app(PS.Data.Map.Internal.Module.traversableMap)
                       .app(dictApplicative)
                       .app(f1)
                       .app(right));
            }
            (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
              val f1 = f;
              val left = v.value0;
              val k1 = v.value1;
              val v1 = v.value2;
              val mid = v.value3;
              val k2 = v.value4;
              val v2 = v.value5;
              val right = v.value6;
              PS.Control.Apply.Module.apply
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
                )
                .app(PS.Control.Apply.Module.apply
                       .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                              .app(Unit))
                       .app(PS.Control.Apply.Module.apply
                              .app(
                                (dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit))
                              .app(PS.Control.Apply.Module.apply
                                     .app(
                                       (dictApplicative as Map<String, Any>)["Apply0"]!!
                                         .app(Unit))
                                     .app(PS.Control.Apply.Module.apply
                                            .app(
                                              (dictApplicative as Map<String, Any>)["Apply0"]!!
                                                .app(Unit))
                                            .app(PS.Control.Apply.Module.apply
                                                   .app(
                                                     (dictApplicative as Map<String, Any>)["Apply0"]!!
                                                       .app(Unit))
                                                   .app(
                                                     PS.Data.Functor.Module.map
                                                       .app(
                                                         ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                                            .app(Unit
                                                           ) as Map<String, Any>)["Functor0"]!!
                                                           .app(Unit))
                                                       .app(
                                                         PS.Data.Map.Internal.Module.Three
                                                       )
                                                       .app(
                                                       PS.Data.Traversable.Module.traverse
                                                         .app(
                                                           PS.Data.Map.Internal.Module.traversableMap
                                                         )
                                                         .app(dictApplicative)
                                                         .app(f1)
                                                         .app(left)))
                                                   .app(
                                                PS.Control.Applicative.Module.pure
                                                  .app(dictApplicative)
                                                  .app(k1)))
                                            .app(f1.app(v1)))
                                     .app(PS.Data.Traversable.Module.traverse
                                            .app(
                                              PS.Data.Map.Internal.Module.traversableMap
                                            )
                                            .app(dictApplicative)
                                            .app(f1)
                                            .app(mid)))
                              .app(PS.Control.Applicative.Module.pure
                                     .app(dictApplicative)
                                     .app(k2)))
                       .app(f1.app(v2)))
                .app(PS.Data.Traversable.Module.traverse
                       .app(PS.Data.Map.Internal.Module.traversableMap)
                       .app(dictApplicative)
                       .app(f1)
                       .app(right));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val foldSubmap = { dictOrd : Any ->
     { dictMonoid : Any ->
       { kmin : Any ->
         { kmax : Any ->
           { f : Any ->
             object   {
                 val tooSmall = when {
                   (kmin is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                     val kmin_tick = kmin.value0;
                     { k : Any ->
                        PS.Data.Ord.Module.lessThan.app(dictOrd).app(k)
                          .app(kmin_tick)
                     };
                   }
                   (kmin is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                     PS.Data.Function.Module._const.app(false);
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 };
                 val tooLarge = when {
                   (kmax is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                     val kmax_tick = kmax.value0;
                     { k : Any ->
                        PS.Data.Ord.Module.greaterThan.app(dictOrd).app(k)
                          .app(kmax_tick)
                     };
                   }
                   (kmax is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                     PS.Data.Function.Module._const.app(false);
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 };
                 val inBounds = when {
                   (kmin is PS.Data.Maybe.Module._Type_Maybe
                              .Just)&& (kmax is PS.Data.Maybe.Module._Type_Maybe
                                                  .Just) -> {
                     val kmin_tick = kmin.value0;
                     val kmax_tick = kmax.value0;
                     { k : Any ->
                        PS.Data.HeytingAlgebra.Module.conj
                          .app(
                            PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                          .app(PS.Data.Ord.Module.lessThanOrEq.app(dictOrd)
                                 .app(kmin_tick)
                                 .app(k))
                          .app(PS.Data.Ord.Module.lessThanOrEq.app(dictOrd)
                                 .app(k)
                                 .app(kmax_tick))
                     };
                   }
                   (kmin is PS.Data.Maybe.Module._Type_Maybe
                              .Just)&& (kmax is PS.Data.Maybe.Module._Type_Maybe
                                                  .Nothing) -> {
                     val kmin_tick = kmin.value0;
                     { k : Any ->
                        PS.Data.Ord.Module.lessThanOrEq.app(dictOrd)
                          .app(kmin_tick)
                          .app(k)
                     };
                   }
                   (kmin is PS.Data.Maybe.Module._Type_Maybe
                              .Nothing)&&
                   (kmax is PS.Data.Maybe.Module._Type_Maybe
                              .Just) -> {
                     val kmax_tick = kmax.value0;
                     { k : Any ->
                        PS.Data.Ord.Module.lessThanOrEq.app(dictOrd).app(k)
                          .app(kmax_tick)
                     };
                   }
                   (kmin is PS.Data.Maybe.Module._Type_Maybe
                              .Nothing)&&
                   (kmax is PS.Data.Maybe.Module._Type_Maybe
                              .Nothing) -> {
                     PS.Data.Function.Module._const.app(true);
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 };
                 val go = (::__rec_go)();
                 fun __rec_go(): Any = { v : Any ->
                    when {
                     (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                       PS.Data.Monoid.Module.mempty.app(dictMonoid);
                     }
                     (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                       val left = v.value0;
                       val k = v.value1;
                       val v1 = v.value2;
                       val right = v.value3;
                       PS.Data.Semigroup.Module.append
                         .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                .app(Unit))
                         .app(when {
                             (tooSmall.app(k) == true) -> {
                               PS.Data.Monoid.Module.mempty.app(dictMonoid);
                             }
                             else -> {
                               __rec_go().app(left);
                             }
                           })
                         .app(PS.Data.Semigroup.Module.append
                                .app(
                                  (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                    .app(Unit))
                                .app(when {
                                    (inBounds.app(k) == true) -> {
                                      f.app(k).app(v1);
                                    }
                                    else -> {
                                      PS.Data.Monoid.Module.mempty
                                        .app(dictMonoid);
                                    }
                                  })
                                .app(when {
                             (tooLarge.app(k) == true) -> {
                               PS.Data.Monoid.Module.mempty.app(dictMonoid);
                             }
                             else -> {
                               __rec_go().app(right);
                             }
                           }));
                     }
                     (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                       val left = v.value0;
                       val k1 = v.value1;
                       val v1 = v.value2;
                       val mid = v.value3;
                       val k2 = v.value4;
                       val v2 = v.value5;
                       val right = v.value6;
                       PS.Data.Semigroup.Module.append
                         .app((dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                .app(Unit))
                         .app(when {
                             (tooSmall.app(k1) == true) -> {
                               PS.Data.Monoid.Module.mempty.app(dictMonoid);
                             }
                             else -> {
                               __rec_go().app(left);
                             }
                           })
                         .app(PS.Data.Semigroup.Module.append
                                .app(
                                  (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                    .app(Unit))
                                .app(when {
                                    (inBounds.app(k1) == true) -> {
                                      f.app(k1).app(v1);
                                    }
                                    else -> {
                                      PS.Data.Monoid.Module.mempty
                                        .app(dictMonoid);
                                    }
                                  })
                                .app(PS.Data.Semigroup.Module.append
                                       .app(
                                         (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                           .app(Unit))
                                       .app(when {
                                           (PS.Data.HeytingAlgebra.Module.disj
                                              .app(
                                                PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean
                                              )
                                              .app(tooSmall.app(k2))
                                              .app(tooLarge.app(k1)
                                           ) == true) -> {
                                             PS.Data.Monoid.Module.mempty
                                               .app(dictMonoid);
                                           }
                                           else -> {
                                             __rec_go().app(mid);
                                           }
                                         })
                                       .app(PS.Data.Semigroup.Module.append
                                              .app(
                                                (dictMonoid as Map<String, Any>)["Semigroup0"]!!
                                                  .app(Unit))
                                              .app(when {
                                                  (inBounds
                                                     .app(k2) == true) -> {
                                                    f.app(k2).app(v2);
                                                  }
                                                  else -> {
                                                    PS.Data.Monoid.Module.mempty
                                                      .app(dictMonoid);
                                                  }
                                                })
                                              .app(when {
                                 (tooLarge.app(k2) == true) -> {
                                   PS.Data.Monoid.Module.mempty.app(dictMonoid);
                                 }
                                 else -> {
                                   __rec_go().app(right);
                                 }
                               }))));
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 };
               }
               .run({
                val tooSmall = this.tooSmall;
                val tooLarge = this.tooLarge;
                val inBounds = this.inBounds;
                val go = this.go;
                go;
              })
          }
        }
      }
    }
  };
  @JvmField
  val findMin = object   {
                    val go = (::__rec_go)();
                    fun __rec_go(): Any = { v : Any ->
                       { v1 : Any ->
                         when {
                          (v1 is PS.Data.Map.Internal.Module._Type_Map
                                   .Leaf) -> {
                            val acc = v;
                            acc;
                          }
                          (v1 is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                            val left = v1.value0;
                            val k1 = v1.value1;
                            val v11 = v1.value2;
                            __rec_go()
                              .app(PS.Data.Maybe.Module.Just
                                     .app(mapOf(("key" to k1),  ("value" to v11)
                                  )))
                              .app(left);
                          }
                          (v1 is PS.Data.Map.Internal.Module._Type_Map
                                   .Three) -> {
                            val left = v1.value0;
                            val k1 = v1.value1;
                            val v11 = v1.value2;
                            __rec_go()
                              .app(PS.Data.Maybe.Module.Just
                                     .app(mapOf(("key" to k1),  ("value" to v11)
                                  )))
                              .app(left);
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        }
                      }
                    };
                  }
                  .run({
      val go = this.go;
      go.app(PS.Data.Maybe.Module.Nothing);
    });
  @JvmField
  val lookupGT = { dictOrd : Any ->
     { k : Any ->
       object   {
           val comp = PS.Data.Ord.Module.compare.app(dictOrd);
           val go = (::__rec_go)();
           fun __rec_go(): Any = { v : Any ->
              when {
               (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                 PS.Data.Maybe.Module.Nothing;
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val right = v.value3;
                 object   {
                     val v2 = comp.app(k).app(k1);
                   }
                   .run({
                     val v2 = this.v2;
                     when {
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Map.Internal.Module.findMin.app(right);
                       }
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Maybe.Module.Just)
                           .app(PS.Data.Function.Module.apply
                                  .app(PS.Data.Maybe.Module.fromMaybe
                                         .app(mapOf(("key" to k1),  
                                        ("value" to v1))))
                                  .app(__rec_go().app(left)));
                       }
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                         __rec_go().app(right);
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   });
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val mid = v.value3;
                 val k2 = v.value4;
                 val v2 = v.value5;
                 val right = v.value6;
                 object   {
                     val v3 = comp.app(k).app(k1);
                   }
                   .run({
                     val v3 = this.v3;
                     when {
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Map.Internal.Module.findMin)
                           .app(PS.Data.Map.Internal.Module.Two.app(mid).app(k2)
                                  .app(v2)
                                  .app(right));
                       }
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Maybe.Module.Just)
                           .app(PS.Data.Function.Module.apply
                                  .app(PS.Data.Maybe.Module.fromMaybe
                                         .app(mapOf(("key" to k1),  
                                        ("value" to v1))))
                                  .app(__rec_go().app(left)));
                       }
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                         PS.Data.Function.Module.apply.app(__rec_go())
                           .app(PS.Data.Map.Internal.Module.Two.app(mid).app(k2)
                                  .app(v2)
                                  .app(right));
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   });
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val comp = this.comp;
          val go = this.go;
          go;
        })
    }
  };
  @JvmField
  val findMax = object   {
                    val go = (::__rec_go)();
                    fun __rec_go(): Any = { v : Any ->
                       { v1 : Any ->
                         when {
                          (v1 is PS.Data.Map.Internal.Module._Type_Map
                                   .Leaf) -> {
                            val acc = v;
                            acc;
                          }
                          (v1 is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                            val k1 = v1.value1;
                            val v11 = v1.value2;
                            val right = v1.value3;
                            __rec_go()
                              .app(PS.Data.Maybe.Module.Just
                                     .app(mapOf(("key" to k1),  ("value" to v11)
                                  )))
                              .app(right);
                          }
                          (v1 is PS.Data.Map.Internal.Module._Type_Map
                                   .Three) -> {
                            val k2 = v1.value4;
                            val v2 = v1.value5;
                            val right = v1.value6;
                            __rec_go()
                              .app(PS.Data.Maybe.Module.Just
                                     .app(mapOf(("key" to k2),  ("value" to v2))
                                ))
                              .app(right);
                          }
                          else -> (error("Error in Pattern Match") as Any)
                        }
                      }
                    };
                  }
                  .run({
      val go = this.go;
      go.app(PS.Data.Maybe.Module.Nothing);
    });
  @JvmField
  val lookupLT = { dictOrd : Any ->
     { k : Any ->
       object   {
           val comp = PS.Data.Ord.Module.compare.app(dictOrd);
           val go = (::__rec_go)();
           fun __rec_go(): Any = { v : Any ->
              when {
               (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
                 PS.Data.Maybe.Module.Nothing;
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val right = v.value3;
                 object   {
                     val v2 = comp.app(k).app(k1);
                   }
                   .run({
                     val v2 = this.v2;
                     when {
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Map.Internal.Module.findMax.app(left);
                       }
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Maybe.Module.Just)
                           .app(PS.Data.Function.Module.apply
                                  .app(PS.Data.Maybe.Module.fromMaybe
                                         .app(mapOf(("key" to k1),  
                                        ("value" to v1))))
                                  .app(__rec_go().app(right)));
                       }
                       (v2 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                         __rec_go().app(left);
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   });
               }
               (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
                 val left = v.value0;
                 val k1 = v.value1;
                 val v1 = v.value2;
                 val mid = v.value3;
                 val k2 = v.value4;
                 val v2 = v.value5;
                 val right = v.value6;
                 object   {
                     val v3 = comp.app(k).app(k2);
                   }
                   .run({
                     val v3 = this.v3;
                     when {
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Map.Internal.Module.findMax)
                           .app(PS.Data.Map.Internal.Module.Two.app(left)
                                  .app(k1)
                                  .app(v1)
                                  .app(mid));
                       }
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                         PS.Data.Function.Module.apply
                           .app(PS.Data.Maybe.Module.Just)
                           .app(PS.Data.Function.Module.apply
                                  .app(PS.Data.Maybe.Module.fromMaybe
                                         .app(mapOf(("key" to k2),  
                                        ("value" to v2))))
                                  .app(__rec_go().app(right)));
                       }
                       (v3 is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                         PS.Data.Function.Module.apply.app(__rec_go())
                           .app(PS.Data.Map.Internal.Module.Two.app(left)
                                  .app(k1)
                                  .app(v1)
                                  .app(mid));
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     };
                   });
               }
               else -> (error("Error in Pattern Match") as Any)
             }
           };
         }
         .run({
          val comp = this.comp;
          val go = this.go;
          go;
        })
    }
  };
  @JvmField
  val eqMap = { dictEq : Any ->
     { dictEq1 : Any ->
       PS.Data.Eq.Module.Eq
         .app({ m1 : Any ->
           { m2 : Any ->
             PS.Data.Eq.Module.eq
               .app(PS.Data.Eq.Module.eqArray
                      .app(PS.Data.Tuple.Module.eqTuple.app(dictEq).app(dictEq1)
                 ))
               .app(PS.Data.Map.Internal.Module.toAscArray.app(m1))
               .app(PS.Data.Map.Internal.Module.toAscArray.app(m2))
          }
        })
    }
  };
  @JvmField
  val ordMap = { dictOrd : Any ->
     { dictOrd1 : Any ->
       PS.Data.Ord.Module.Ord
         .app({ _ : Any ->
              PS.Data.Map.Internal.Module.eqMap
                .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
                .app((dictOrd1 as Map<String, Any>)["Eq0"]!!.app(Unit))
           })
         .app({ m1 : Any ->
           { m2 : Any ->
             PS.Data.Ord.Module.compare
               .app(PS.Data.Ord.Module.ordArray
                      .app(PS.Data.Tuple.Module.ordTuple.app(dictOrd)
                             .app(dictOrd1)))
               .app(PS.Data.Map.Internal.Module.toAscArray.app(m1))
               .app(PS.Data.Map.Internal.Module.toAscArray.app(m2))
          }
        })
    }
  };
  @JvmField
  val eq1Map = { dictEq : Any ->
     PS.Data.Eq.Module.Eq1
       .app({ dictEq1 : Any ->
         PS.Data.Eq.Module.eq
           .app(PS.Data.Map.Internal.Module.eqMap.app(dictEq).app(dictEq1))
      })
  };
  @JvmField
  val ord1Map = { dictOrd : Any ->
     PS.Data.Ord.Module.Ord1
       .app({ _ : Any ->
            PS.Data.Map.Internal.Module.eq1Map
              .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
         })
       .app({ dictOrd1 : Any ->
         PS.Data.Ord.Module.compare
           .app(PS.Data.Map.Internal.Module.ordMap.app(dictOrd).app(dictOrd1))
      })
  };
  @JvmField val empty = PS.Data.Map.Internal.Module.Leaf;
  @JvmField
  val fromFoldable = { dictOrd : Any ->
     { dictFoldable : Any ->
       PS.Data.Foldable.Module.foldl.app(dictFoldable)
         .app({ m : Any ->
              { v : Any ->
                when {
                 (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                   val k = v.value0;
                   val v1 = v.value1;
                   PS.Data.Map.Internal.Module.insert.app(dictOrd).app(k)
                     .app(v1)
                     .app(m);
                 }
                 else -> (error("Error in Pattern Match") as Any)
               }
             }
           })
         .app(PS.Data.Map.Internal.Module.empty)
    }
  };
  @JvmField
  val filterWithKey = { dictOrd : Any ->
     { predicate : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Map.Internal.Module.fromFoldable.app(dictOrd)
                .app(PS.Data.List.Lazy.Types.Module.foldableList))
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.List.Lazy.Module.filter
                       .app(PS.Data.Tuple.Module.uncurry.app(predicate)))
                .app(PS.Data.Map.Internal.Module.toUnfoldable
                       .app(PS.Data.List.Lazy.Types.Module.unfoldableList)))
    }
  };
  @JvmField
  val filter = { dictOrd : Any ->
     { predicate : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Map.Internal.Module.filterWithKey.app(dictOrd))
         .app(PS.Data.Function.Module._const.app(predicate))
    }
  };
  @JvmField
  val filterKeys = { dictOrd : Any ->
     { predicate : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Map.Internal.Module.filterWithKey.app(dictOrd))
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Function.Module._const)
                .app(predicate))
    }
  };
  @JvmField
  val fromFoldableWithIndex = { dictOrd : Any ->
     { dictFoldableWithIndex : Any ->
       PS.Data.FoldableWithIndex.Module.foldlWithIndex
         .app(dictFoldableWithIndex)
         .app({ k : Any ->
              { m : Any ->
                { v : Any ->
                  PS.Data.Map.Internal.Module.insert.app(dictOrd).app(k).app(v)
                    .app(m)
               }
             }
           })
         .app(PS.Data.Map.Internal.Module.empty)
    }
  };
  @JvmField
  val intersectionWith = { dictOrd : Any ->
     { f : Any ->
       { m1 : Any ->
         { m2 : Any ->
           object   {
               val go = (::__rec_go)();
               fun __rec_go(): Any = { v : Any ->
                  { v1 : Any ->
                    { m : Any ->
                      when {
                       (v is PS.Data.List.Types.Module._Type_List.Nil) -> {
                         val m3 = m;
                         m3;
                       }
                       (v1 is PS.Data.List.Types.Module._Type_List.Nil) -> {
                         val m3 = m;
                         m3;
                       }
                       (v is PS.Data.List.Types.Module._Type_List
                               .Cons)&& (v
                                           .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                        .Tuple)&&
                       (v1 is PS.Data.List.Types.Module._Type_List
                                .Cons)&& (v1
                                            .value0 is PS.Data.Tuple.Module._Type_Tuple
                                                         .Tuple) -> {
                         val _as = v;
                         val k1 = v.value0.value0;
                         val a = v.value0.value1;
                         val ass = v.value1;
                         val bs = v1;
                         val k2 = v1.value0.value0;
                         val b = v1.value0.value1;
                         val bss = v1.value1;
                         val m3 = m;
                         object   {
                             val v2 = PS.Data.Ord.Module.compare.app(dictOrd)
                                        .app(k1)
                                        .app(k2);
                           }
                           .run({
                             val v2 = this.v2;
                             when {
                               (v2 is PS.Data.Ordering.Module._Type_Ordering
                                        .LT) -> {
                                 __rec_go().app(ass).app(bs).app(m3);
                               }
                               (v2 is PS.Data.Ordering.Module._Type_Ordering
                                        .EQ) -> {
                                 __rec_go().app(ass).app(bss)
                                   .app(PS.Data.Map.Internal.Module.insert
                                          .app(dictOrd)
                                          .app(k1)
                                          .app(f.app(a).app(b))
                                          .app(m3));
                               }
                               (v2 is PS.Data.Ordering.Module._Type_Ordering
                                        .GT) -> {
                                 __rec_go().app(_as).app(bss).app(m3);
                               }
                               else -> (error("Error in Pattern Match") as Any)
                             };
                           });
                       }
                       else -> (error("Error in Pattern Match") as Any)
                     }
                   }
                 }
               };
             }
             .run({
              val go = this.go;
              go
                .app(PS.Data.Map.Internal.Module.toUnfoldable
                       .app(PS.Data.List.Types.Module.unfoldableList)
                       .app(m1))
                .app(PS.Data.Map.Internal.Module.toUnfoldable
                       .app(PS.Data.List.Types.Module.unfoldableList)
                       .app(m2))
                .app(PS.Data.Map.Internal.Module.empty);
            })
        }
      }
    }
  };
  @JvmField
  val intersection = { dictOrd : Any ->
     PS.Data.Map.Internal.Module.intersectionWith.app(dictOrd)
       .app(PS.Data.Function.Module._const)
  };
  @JvmField
  val delete = { dictOrd : Any ->
     { k : Any ->
       { m : Any ->
         PS.Data.Maybe.Module.maybe.app(m).app(PS.Data.Tuple.Module.snd)
           .app(PS.Data.Map.Internal.Module.pop.app(dictOrd).app(k).app(m))
      }
    }
  };
  @JvmField
  val difference = { dictOrd : Any ->
     { m1 : Any ->
       { m2 : Any ->
         PS.Data.Foldable.Module.foldl
           .app(PS.Data.List.Types.Module.foldableList)
           .app(PS.Data.Function.Module.flip
                  .app(PS.Data.Map.Internal.Module.delete.app(dictOrd)))
           .app(m1)
           .app(PS.Data.Map.Internal.Module.keys.app(m2))
      }
    }
  };
  @JvmField
  val checkValid = { tree : Any ->
     object   {
         val allHeights = (::__rec_allHeights)();
         fun __rec_allHeights(): Any = { v : Any ->
            when {
             (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
               PS.Control.Applicative.Module.pure
                 .app(PS.Data.List.Types.Module.applicativeList)
                 .app(PS.Data.Semiring.Module.zero
                        .app(PS.Data.Semiring.Module.semiringInt));
             }
             (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
               val left = v.value0;
               val right = v.value3;
               PS.Data.Functor.Module.map
                 .app(PS.Data.List.Types.Module.functorList)
                 .app({ n : Any ->
                      PS.Data.Semiring.Module.add
                        .app(PS.Data.Semiring.Module.semiringInt)
                        .app(n)
                        .app(PS.Data.Semiring.Module.one
                               .app(PS.Data.Semiring.Module.semiringInt))
                   })
                 .app(PS.Data.Semigroup.Module.append
                        .app(PS.Data.List.Types.Module.semigroupList)
                        .app(__rec_allHeights().app(left))
                        .app(__rec_allHeights().app(right)));
             }
             (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
               val left = v.value0;
               val mid = v.value3;
               val right = v.value6;
               PS.Data.Functor.Module.map
                 .app(PS.Data.List.Types.Module.functorList)
                 .app({ n : Any ->
                      PS.Data.Semiring.Module.add
                        .app(PS.Data.Semiring.Module.semiringInt)
                        .app(n)
                        .app(PS.Data.Semiring.Module.one
                               .app(PS.Data.Semiring.Module.semiringInt))
                   })
                 .app(PS.Data.Semigroup.Module.append
                        .app(PS.Data.List.Types.Module.semigroupList)
                        .app(__rec_allHeights().app(left))
                        .app(PS.Data.Semigroup.Module.append
                               .app(PS.Data.List.Types.Module.semigroupList)
                               .app(__rec_allHeights().app(mid))
                               .app(__rec_allHeights().app(right))));
             }
             else -> (error("Error in Pattern Match") as Any)
           }
         };
       }
       .run({
        val allHeights = this.allHeights;
        PS.Data.Eq.Module.eq.app(PS.Data.Eq.Module.eqInt)
          .app(PS.Data.List.Module.length
                 .app(PS.Data.List.Module.nub.app(PS.Data.Eq.Module.eqInt)
                        .app(allHeights.app(tree))))
          .app(PS.Data.Semiring.Module.one
                 .app(PS.Data.Semiring.Module.semiringInt));
      })
  };
  @JvmField
  val asList = PS.Control.Category.Module.identity
                 .app(PS.Control.Category.Module.categoryFn);
  @JvmField
  val foldableWithIndexMap = PS.Data.FoldableWithIndex.Module.FoldableWithIndex
                               .app({ _ : Any ->
                                    PS.Data.Map.Internal.Module.foldableMap
                                 })
                               .app({ dictMonoid : Any ->
                                    { f : Any ->
                                      { m : Any ->
                                        PS.Data.Function.Module.apply
                                          .app(PS.Data.Foldable.Module.foldMap
                                                 .app(
                                                   PS.Data.List.Types.Module.foldableList
                                                 )
                                                 .app(dictMonoid)
                                                 .app(
                                              PS.Data.Tuple.Module.uncurry
                                                .app(f)))
                                          .app(PS.Data.Function.Module.apply
                                                 .app(
                                                   PS.Data.Map.Internal.Module.asList
                                                 )
                                                 .app(
                                           PS.Data.Map.Internal.Module.toUnfoldable
                                             .app(
                                               PS.Data.List.Types.Module.unfoldableList
                                             )
                                             .app(m)))
                                     }
                                   }
                                 })
                               .app({ f : Any ->
                                    { z : Any ->
                                      { m : Any ->
                                        PS.Data.Function.Module.apply
                                          .app(PS.Data.Foldable.Module.foldl
                                                 .app(
                                                   PS.Data.List.Types.Module.foldableList
                                                 )
                                                 .app(
                                                   PS.Control.Semigroupoid.Module.compose
                                                     .app(
                                                       PS.Control.Semigroupoid.Module.semigroupoidFn
                                                     )
                                                     .app(
                                                       PS.Data.Tuple.Module.uncurry
                                                     )
                                                     .app(
                                                     PS.Data.Function.Module.flip
                                                       .app(f)))
                                                 .app(z))
                                          .app(PS.Data.Function.Module.apply
                                                 .app(
                                                   PS.Data.Map.Internal.Module.asList
                                                 )
                                                 .app(
                                           PS.Data.Map.Internal.Module.toUnfoldable
                                             .app(
                                               PS.Data.List.Types.Module.unfoldableList
                                             )
                                             .app(m)))
                                     }
                                   }
                                 })
                               .app({ f : Any ->
       { z : Any ->
         { m : Any ->
           PS.Data.Function.Module.apply
             .app(PS.Data.Foldable.Module.foldr
                    .app(PS.Data.List.Types.Module.foldableList)
                    .app(PS.Data.Tuple.Module.uncurry.app(f))
                    .app(z))
             .app(PS.Data.Function.Module.apply
                    .app(PS.Data.Map.Internal.Module.asList)
                    .app(PS.Data.Map.Internal.Module.toUnfoldable
                           .app(PS.Data.List.Types.Module.unfoldableList)
                           .app(m)))
        }
      }
    });
  @JvmField
  val mapMaybeWithKey = { dictOrd : Any ->
     { f : Any ->
       PS.Data.FoldableWithIndex.Module.foldrWithIndex
         .app(PS.Data.Map.Internal.Module.foldableWithIndexMap)
         .app({ k : Any ->
              { a : Any ->
                { acc : Any ->
                  PS.Data.Maybe.Module.maybe.app(acc)
                    .app({ b : Any ->
                         PS.Data.Map.Internal.Module.insert.app(dictOrd).app(k)
                           .app(b)
                           .app(acc)
                      })
                    .app(f.app(k).app(a))
               }
             }
           })
         .app(PS.Data.Map.Internal.Module.empty)
    }
  };
  @JvmField
  val mapMaybe = { dictOrd : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.Map.Internal.Module.mapMaybeWithKey.app(dictOrd))
       .app(PS.Data.Function.Module._const)
  };
  @JvmField val traversableWithIndexMap = (::__rec_traversableWithIndexMap)();
  fun __rec_traversableWithIndexMap(): Any = PS.Data.TraversableWithIndex.Module.TraversableWithIndex
                                               .app({ _ : Any ->
                                                    PS.Data.Map.Internal.Module.foldableWithIndexMap
                                                 })
                                               .app({ _ : Any ->
                                                    PS.Data.Map.Internal.Module.functorWithIndexMap
                                                 })
                                               .app({ _ : Any ->
                                                    PS.Data.Map.Internal.Module.traversableMap
                                                 })
                                               .app({ dictApplicative : Any ->
       { f : Any ->
         { v : Any ->
           when {
            (v is PS.Data.Map.Internal.Module._Type_Map.Leaf) -> {
              val f1 = f;
              PS.Control.Applicative.Module.pure.app(dictApplicative)
                .app(PS.Data.Map.Internal.Module.Leaf);
            }
            (v is PS.Data.Map.Internal.Module._Type_Map.Two) -> {
              val f1 = f;
              val left = v.value0;
              val k = v.value1;
              val v1 = v.value2;
              val right = v.value3;
              PS.Control.Apply.Module.apply
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
                )
                .app(PS.Control.Apply.Module.apply
                       .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                              .app(Unit))
                       .app(PS.Control.Apply.Module.apply
                              .app(
                                (dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit))
                              .app(PS.Data.Functor.Module.map
                                     .app(
                                       ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                          .app(Unit
                                         ) as Map<String, Any>)["Functor0"]!!
                                         .app(Unit))
                                     .app(PS.Data.Map.Internal.Module.Two)
                                     .app(
                                  PS.Data.TraversableWithIndex.Module.traverseWithIndex
                                    .app(
                                      PS.Data.Map.Internal.Module.traversableWithIndexMap
                                    )
                                    .app(dictApplicative)
                                    .app(f1)
                                    .app(left)))
                              .app(PS.Control.Applicative.Module.pure
                                     .app(dictApplicative)
                                     .app(k)))
                       .app(f1.app(k).app(v1)))
                .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                       .app(PS.Data.Map.Internal.Module.traversableWithIndexMap)
                       .app(dictApplicative)
                       .app(f1)
                       .app(right));
            }
            (v is PS.Data.Map.Internal.Module._Type_Map.Three) -> {
              val f1 = f;
              val left = v.value0;
              val k1 = v.value1;
              val v1 = v.value2;
              val mid = v.value3;
              val k2 = v.value4;
              val v2 = v.value5;
              val right = v.value6;
              PS.Control.Apply.Module.apply
                .app((dictApplicative as Map<String, Any>)["Apply0"]!!.app(Unit)
                )
                .app(PS.Control.Apply.Module.apply
                       .app((dictApplicative as Map<String, Any>)["Apply0"]!!
                              .app(Unit))
                       .app(PS.Control.Apply.Module.apply
                              .app(
                                (dictApplicative as Map<String, Any>)["Apply0"]!!
                                  .app(Unit))
                              .app(PS.Control.Apply.Module.apply
                                     .app(
                                       (dictApplicative as Map<String, Any>)["Apply0"]!!
                                         .app(Unit))
                                     .app(PS.Control.Apply.Module.apply
                                            .app(
                                              (dictApplicative as Map<String, Any>)["Apply0"]!!
                                                .app(Unit))
                                            .app(PS.Control.Apply.Module.apply
                                                   .app(
                                                     (dictApplicative as Map<String, Any>)["Apply0"]!!
                                                       .app(Unit))
                                                   .app(
                                                     PS.Data.Functor.Module.map
                                                       .app(
                                                         ((dictApplicative as Map<String, Any>)["Apply0"]!!
                                                            .app(Unit
                                                           ) as Map<String, Any>)["Functor0"]!!
                                                           .app(Unit))
                                                       .app(
                                                         PS.Data.Map.Internal.Module.Three
                                                       )
                                                       .app(
                                                       PS.Data.TraversableWithIndex.Module.traverseWithIndex
                                                         .app(
                                                           PS.Data.Map.Internal.Module.traversableWithIndexMap
                                                         )
                                                         .app(dictApplicative)
                                                         .app(f1)
                                                         .app(left)))
                                                   .app(
                                                PS.Control.Applicative.Module.pure
                                                  .app(dictApplicative)
                                                  .app(k1)))
                                            .app(f1.app(k1).app(v1)))
                                     .app(
                                  PS.Data.TraversableWithIndex.Module.traverseWithIndex
                                    .app(
                                      PS.Data.Map.Internal.Module.traversableWithIndexMap
                                    )
                                    .app(dictApplicative)
                                    .app(f1)
                                    .app(mid)))
                              .app(PS.Control.Applicative.Module.pure
                                     .app(dictApplicative)
                                     .app(k2)))
                       .app(f1.app(k2).app(v2)))
                .app(PS.Data.TraversableWithIndex.Module.traverseWithIndex
                       .app(PS.Data.Map.Internal.Module.traversableWithIndexMap)
                       .app(dictApplicative)
                       .app(f1)
                       .app(right));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        }
      }
    });
  @JvmField
  val alter = { dictOrd : Any ->
     { f : Any ->
       { k : Any ->
         { m : Any ->
           object   {
               val v = f
                         .app(PS.Data.Map.Internal.Module.lookup.app(dictOrd)
                                .app(k)
                                .app(m));
             }
             .run({
              val v = this.v;
              when {
                (v is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                  PS.Data.Map.Internal.Module.delete.app(dictOrd).app(k).app(m);
                }
                (v is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                  val v1 = v.value0;
                  PS.Data.Map.Internal.Module.insert.app(dictOrd).app(k).app(v1)
                    .app(m);
                }
                else -> (error("Error in Pattern Match") as Any)
              };
            })
        }
      }
    }
  };
  @JvmField
  val fromFoldableWith = { dictOrd : Any ->
     { dictFoldable : Any ->
       { f : Any ->
         object   {
             val combine = { v : Any ->
                { v1 : Any ->
                  when {
                   (v1 is PS.Data.Maybe.Module._Type_Maybe.Just) -> {
                     val v2 = v;
                     val v_tick = v1.value0;
                     PS.Data.Function.Module.apply
                       .app(PS.Data.Maybe.Module.Just)
                       .app(f.app(v2).app(v_tick));
                   }
                   (v1 is PS.Data.Maybe.Module._Type_Maybe.Nothing) -> {
                     val v2 = v;
                     PS.Data.Maybe.Module.Just.app(v2);
                   }
                   else -> (error("Error in Pattern Match") as Any)
                 }
               }
             };
           }
           .run({
            val combine = this.combine;
            PS.Data.Foldable.Module.foldl.app(dictFoldable)
              .app({ m : Any ->
                   { v : Any ->
                     when {
                      (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                        val k = v.value0;
                        val v1 = v.value1;
                        PS.Data.Map.Internal.Module.alter.app(dictOrd)
                          .app(combine.app(v1))
                          .app(k)
                          .app(m);
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    }
                  }
                })
              .app(PS.Data.Map.Internal.Module.empty);
          })
      }
    }
  };
  @JvmField
  val insertWith = { dictOrd : Any ->
     { f : Any ->
       { k : Any ->
         { v : Any ->
           PS.Data.Map.Internal.Module.alter.app(dictOrd)
             .app(PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Maybe.Module.Just)
                    .app(PS.Data.Maybe.Module.maybe.app(v)
                           .app(PS.Data.Function.Module.flip.app(f).app(v))))
             .app(k)
        }
      }
    }
  };
  @JvmField
  val unionWith = { dictOrd : Any ->
     { f : Any ->
       { m1 : Any ->
         { m2 : Any ->
           object   {
               val go = { m : Any ->
                  { v : Any ->
                    when {
                     (v is PS.Data.Tuple.Module._Type_Tuple.Tuple) -> {
                       val m3 = m;
                       val k = v.value0;
                       val v1 = v.value1;
                       PS.Data.Map.Internal.Module.alter.app(dictOrd)
                         .app(PS.Control.Semigroupoid.Module.compose
                                .app(
                                  PS.Control.Semigroupoid.Module.semigroupoidFn)
                                .app(PS.Data.Maybe.Module.Just)
                                .app(PS.Data.Maybe.Module.maybe.app(v1)
                                       .app(f.app(v1))))
                         .app(k)
                         .app(m3);
                     }
                     else -> (error("Error in Pattern Match") as Any)
                   }
                 }
               };
             }
             .run({
              val go = this.go;
              PS.Data.Foldable.Module.foldl
                .app(PS.Data.List.Types.Module.foldableList)
                .app(go)
                .app(m2)
                .app(PS.Data.Map.Internal.Module.toUnfoldable
                       .app(PS.Data.List.Types.Module.unfoldableList)
                       .app(m1));
            })
        }
      }
    }
  };
  @JvmField
  val union = { dictOrd : Any ->
     PS.Data.Map.Internal.Module.unionWith.app(dictOrd)
       .app(PS.Data.Function.Module._const)
  };
  @JvmField
  val semigroupMap = { dictOrd : Any ->
     PS.Data.Semigroup.Module.Semigroup
       .app(PS.Data.Map.Internal.Module.union.app(dictOrd))
  };
  @JvmField
  val monoidMap = { dictOrd : Any ->
     PS.Data.Monoid.Module.Monoid
       .app({ _ : Any ->
            PS.Data.Map.Internal.Module.semigroupMap.app(dictOrd)
         })
       .app(PS.Data.Map.Internal.Module.empty)
  };
  @JvmField
  val submap = { dictOrd : Any ->
     { kmin : Any ->
       { kmax : Any ->
         PS.Data.Map.Internal.Module.foldSubmap.app(dictOrd)
           .app(PS.Data.Map.Internal.Module.monoidMap.app(dictOrd))
           .app(kmin)
           .app(kmax)
           .app(PS.Data.Map.Internal.Module.singleton)
      }
    }
  };
  @JvmField
  val unions = { dictOrd : Any ->
     { dictFoldable : Any ->
       PS.Data.Foldable.Module.foldl.app(dictFoldable)
         .app(PS.Data.Map.Internal.Module.union.app(dictOrd))
         .app(PS.Data.Map.Internal.Module.empty)
    }
  };
  @JvmField
  val update = { dictOrd : Any ->
     { f : Any ->
       { k : Any ->
         { m : Any ->
           PS.Data.Map.Internal.Module.alter.app(dictOrd)
             .app(PS.Data.Maybe.Module.maybe.app(PS.Data.Maybe.Module.Nothing)
                    .app(f))
             .app(k)
             .app(m)
        }
      }
    }
  };
}