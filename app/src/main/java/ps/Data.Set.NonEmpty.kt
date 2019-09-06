@file:Suppress("UNCHECKED_CAST")
package PS.Data.Set.NonEmpty
import Foreign.PsRuntime.app
object Module  {
  @JvmField val NonEmptySet = { x : Any -> x};
  @JvmField
  val unionSet = { dictOrd : Any ->
     { s1 : Any ->
       { v : Any ->
         when {
          else -> {
            val s11 = s1;
            val s2 = v;
            PS.Data.Set.NonEmpty.Module.NonEmptySet
              .app(PS.Data.Semigroup.Module.append
                     .app(PS.Data.Set.Module.semigroupSet.app(dictOrd))
                     .app(s11)
                     .app(s2));
          }
        }
      }
    }
  };
  @JvmField
  val toUnfoldable1 = { dictUnfoldable1 : Any ->
     { v : Any ->
       when {
        else -> {
          val s = v;
          object   {
              val go = PS.Partial.Unsafe.Module.unsafePartial
                         .app({ dictPartial : Any ->
                   { v1 : Any ->
                     when {
                      (v1 is PS.Data.List.Types.Module._Type_List
                               .Cons)&& (v1
                                           .value1 is PS.Data.List.Types.Module._Type_List
                                                        .Nil) -> {
                        val x = v1.value0;
                        PS.Data.Tuple.Module.Tuple.app(x)
                          .app(PS.Data.Maybe.Module.Nothing);
                      }
                      (v1 is PS.Data.List.Types.Module._Type_List.Cons) -> {
                        val x = v1.value0;
                        val tail = v1.value1;
                        PS.Data.Tuple.Module.Tuple.app(x)
                          .app(PS.Data.Maybe.Module.Just.app(tail));
                      }
                      else -> (error("Error in Pattern Match") as Any)
                    }
                  }
                });
            }
            .run({
              val go = this.go;
              PS.Data.Unfoldable1.Module.unfoldr1.app(dictUnfoldable1).app(go)
                .app(PS.Data.Set.Module.toUnfoldable
                       .app(PS.Data.List.Types.Module.unfoldableList)
                       .app(s));
            });
        }
      }
    }
  };
  @JvmField
  val toUnfoldable = { dictUnfoldable : Any ->
     { v : Any ->
       when {
        else -> {
          val s = v;
          PS.Data.Set.Module.toUnfoldable.app(dictUnfoldable).app(s);
        }
      }
    }
  };
  @JvmField val toSet = { v : Any -> when { else -> { val s = v; s; } }};
  @JvmField
  val subset = { dictOrd : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val s1 = v;
            val s2 = v1;
            PS.Data.Set.Module.subset.app(dictOrd).app(s1).app(s2);
          }
        }
      }
    }
  };
  @JvmField
  val size = { v : Any ->
     when {
      else -> {
        val s = v;
        PS.Data.Set.Module.size.app(s);
      }
    }
  };
  @JvmField
  val singleton = { a : Any ->
     PS.Data.Set.NonEmpty.Module.NonEmptySet
       .app(PS.Data.Set.Module.singleton.app(a))
  };
  @JvmField
  val showNonEmptySet = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ s : Any ->
         (("(fromFoldable1 " as String) + (((PS.Data.Show.Module.show
                                               .app(
                                                 PS.Data.List.Types.Module.showNonEmptyList
                                                   .app(dictShow))
                                               .app(
          PS.Data.Set.NonEmpty.Module.toUnfoldable1
            .app(PS.Data.List.Types.Module.unfoldable1NonEmptyList)
            .app(s)) as String) + (")" as String)) as String))
      })
  };
  @JvmField
  val semigroupNonEmptySet = { dictOrd : Any ->
     PS.Data.Set.Module.semigroupSet.app(dictOrd)
  };
  @JvmField
  val properSubset = { dictOrd : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val s1 = v;
            val s2 = v1;
            PS.Data.Set.Module.properSubset.app(dictOrd).app(s1).app(s2);
          }
        }
      }
    }
  };
  @JvmField
  val ordNonEmptySet = { dictOrd : Any ->
     PS.Data.Set.Module.ordSet.app(dictOrd)
  };
  @JvmField val ord1NonEmptySet = PS.Data.Set.Module.ord1Set;
  @JvmField
  val min = { v : Any ->
     when {
      else -> {
        val s = v;
        PS.Partial.Unsafe.Module.unsafePartial
          .app({ dictPartial : Any ->
             PS.Data.Maybe.Module.fromJust.app(Unit)
               .app(PS.Data.Set.Module.findMin.app(s))
          });
      }
    }
  };
  @JvmField
  val member = { dictOrd : Any ->
     { a : Any ->
       { v : Any ->
         when {
          else -> {
            val a1 = a;
            val m = v;
            PS.Data.Set.Module.member.app(dictOrd).app(a1).app(m);
          }
        }
      }
    }
  };
  @JvmField
  val max = { v : Any ->
     when {
      else -> {
        val s = v;
        PS.Partial.Unsafe.Module.unsafePartial
          .app({ dictPartial : Any ->
             PS.Data.Maybe.Module.fromJust.app(Unit)
               .app(PS.Data.Set.Module.findMax.app(s))
          });
      }
    }
  };
  @JvmField
  val mapMaybe = { dictOrd : Any ->
     { f : Any ->
       { v : Any ->
         when {
          else -> {
            val f1 = f;
            val s = v;
            PS.Data.Set.Module.mapMaybe.app(dictOrd).app(f1).app(s);
          }
        }
      }
    }
  };
  @JvmField
  val map = { dictOrd : Any ->
     { f : Any ->
       { v : Any ->
         when {
          else -> {
            val f1 = f;
            val s = v;
            PS.Data.Set.NonEmpty.Module.NonEmptySet
              .app(PS.Data.Set.Module.map.app(dictOrd).app(f1).app(s));
          }
        }
      }
    }
  };
  @JvmField
  val insert = { dictOrd : Any ->
     { a : Any ->
       { v : Any ->
         when {
          else -> {
            val a1 = a;
            val s = v;
            PS.Data.Set.NonEmpty.Module.NonEmptySet
              .app(PS.Data.Set.Module.insert.app(dictOrd).app(a1).app(s));
          }
        }
      }
    }
  };
  @JvmField
  val fromSet = { s : Any ->
     when {
      (PS.Data.Set.Module.isEmpty.app(s) == true) -> {
        PS.Data.Maybe.Module.Nothing;
      }
      else -> {
        PS.Data.Maybe.Module.Just
          .app(PS.Data.Set.NonEmpty.Module.NonEmptySet.app(s));
      }
    }
  };
  @JvmField
  val intersection = { dictOrd : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val s1 = v;
            val s2 = v1;
            PS.Data.Set.NonEmpty.Module.fromSet
              .app(PS.Data.Set.Module.intersection.app(dictOrd).app(s1).app(s2)
            );
          }
        }
      }
    }
  };
  @JvmField
  val fromFoldable1 = { dictFoldable1 : Any ->
     { dictOrd : Any ->
       PS.Data.Semigroup.Foldable.Module.foldMap1.app(dictFoldable1)
         .app(PS.Data.Set.NonEmpty.Module.semigroupNonEmptySet.app(dictOrd))
         .app(PS.Data.Set.NonEmpty.Module.singleton)
    }
  };
  @JvmField
  val fromFoldable = { dictFoldable : Any ->
     { dictOrd : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Set.NonEmpty.Module.fromSet)
         .app(PS.Data.Set.Module.fromFoldable.app(dictFoldable).app(dictOrd))
    }
  };
  @JvmField val foldableNonEmptySet = PS.Data.Set.Module.foldableSet;
  @JvmField val foldable1NonEmptySet = (::__rec_foldable1NonEmptySet)();
  fun __rec_foldable1NonEmptySet(): Any = PS.Data.Semigroup.Foldable.Module.Foldable1
                                            .app({ _ : Any ->
                                                 PS.Data.Set.NonEmpty.Module.foldableNonEmptySet
                                              })
                                            .app({ dictSemigroup : Any ->
                                                 PS.Data.Semigroup.Foldable.Module.foldMap1
                                                   .app(
                                                     PS.Data.Set.NonEmpty.Module.foldable1NonEmptySet
                                                   )
                                                   .app(dictSemigroup)
                                                   .app(
                                                  PS.Control.Category.Module.identity
                                                    .app(
                                                    PS.Control.Category.Module.categoryFn
                                                  ))
                                              })
                                            .app({ dictSemigroup : Any ->
       { f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Semigroup.Foldable.Module.foldMap1
                  .app(PS.Data.List.Types.Module.foldable1NonEmptyList)
                  .app(dictSemigroup)
                  .app(f))
           .app(PS.Data.Set.NonEmpty.Module.toUnfoldable1
                  .app(PS.Data.List.Types.Module.unfoldable1NonEmptyList))
      }
    });
  @JvmField
  val filter = { dictOrd : Any ->
     { f : Any ->
       { v : Any ->
         when {
          else -> {
            val f1 = f;
            val s = v;
            PS.Data.Set.Module.filter.app(dictOrd).app(f1).app(s);
          }
        }
      }
    }
  };
  @JvmField
  val eqNonEmptySet = { dictEq : Any ->
     PS.Data.Set.Module.eqSet.app(dictEq)
  };
  @JvmField val eq1NonEmptySet = PS.Data.Set.Module.eq1Set;
  @JvmField
  val difference = { dictOrd : Any ->
     { v : Any ->
       { v1 : Any ->
         when {
          else -> {
            val s1 = v;
            val s2 = v1;
            PS.Data.Set.NonEmpty.Module.fromSet
              .app(PS.Data.Set.Module.difference.app(dictOrd).app(s1).app(s2));
          }
        }
      }
    }
  };
  @JvmField
  val delete = { dictOrd : Any ->
     { a : Any ->
       { v : Any ->
         when {
          else -> {
            val a1 = a;
            val s = v;
            PS.Data.Set.NonEmpty.Module.fromSet
              .app(PS.Data.Set.Module.delete.app(dictOrd).app(a1).app(s));
          }
        }
      }
    }
  };
  @JvmField
  val cons = { dictOrd : Any ->
     { a : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Set.NonEmpty.Module.NonEmptySet)
         .app(PS.Data.Set.Module.insert.app(dictOrd).app(a))
    }
  };
}