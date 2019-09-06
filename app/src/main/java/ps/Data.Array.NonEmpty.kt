@file:Suppress("UNCHECKED_CAST")
package PS.Data.Array.NonEmpty
import Foreign.PsRuntime.app
object Module  {
  @JvmField val unsafeFromArrayF = PS.Unsafe.Coerce.Module.unsafeCoerce;
  @JvmField val unsafeFromArray = PS.Unsafe.Coerce.Module.unsafeCoerce;
  @JvmField val toArray = PS.Unsafe.Coerce.Module.unsafeCoerce;
  @JvmField
  val unionBy_tick = { eq : Any ->
     { xs : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
         .app(PS.Data.Array.Module.unionBy.app(eq)
                .app(PS.Data.Array.NonEmpty.Module.toArray.app(xs)))
    }
  };
  @JvmField
  val union_tick = { dictEq : Any ->
     PS.Data.Array.NonEmpty.Module.unionBy_tick
       .app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val unionBy = { eq : Any ->
     { xs : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Array.NonEmpty.Module.unionBy_tick.app(eq).app(xs))
         .app(PS.Data.Array.NonEmpty.Module.toArray)
    }
  };
  @JvmField
  val union = { dictEq : Any ->
     PS.Data.Array.NonEmpty.Module.unionBy.app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val unzip = PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Bifunctor.Module.bimap
                       .app(PS.Data.Tuple.Module.bifunctorTuple)
                       .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
                       .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray))
                .app(PS.Control.Semigroupoid.Module.compose
                       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                       .app(PS.Data.Array.Module.unzip)
                       .app(PS.Data.Array.NonEmpty.Module.toArray));
  @JvmField
  val updateAt = { i : Any ->
     { x : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArrayF)
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Array.Module.updateAt.app(i).app(x))
                .app(PS.Data.Array.NonEmpty.Module.toArray))
    }
  };
  @JvmField
  val zip = { xs : Any ->
     { ys : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
         .app(PS.Data.Array.Module.zip
                .app(PS.Data.Array.NonEmpty.Module.toArray.app(xs))
                .app(PS.Data.Array.NonEmpty.Module.toArray.app(ys)))
    }
  };
  @JvmField
  val zipWith = { f : Any ->
     { xs : Any ->
       { ys : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
           .app(PS.Data.Array.Module.zipWith.app(f)
                  .app(PS.Data.Array.NonEmpty.Module.toArray.app(xs))
                  .app(PS.Data.Array.NonEmpty.Module.toArray.app(ys)))
      }
    }
  };
  @JvmField
  val zipWithA = { dictApplicative : Any ->
     { f : Any ->
       { xs : Any ->
         { ys : Any ->
           PS.Data.Function.Module.apply
             .app(PS.Data.Array.NonEmpty.Module.unsafeFromArrayF)
             .app(PS.Data.Array.Module.zipWithA.app(dictApplicative).app(f)
                    .app(PS.Data.Array.NonEmpty.Module.toArray.app(xs))
                    .app(PS.Data.Array.NonEmpty.Module.toArray.app(ys)))
        }
      }
    }
  };
  @JvmField
  val some = { dictAlternative : Any ->
     { dictLazy : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArrayF)
         .app(PS.Data.Array.Module.some.app(dictAlternative).app(dictLazy))
    }
  };
  @JvmField
  val snoc_tick = { xs : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
         .app(PS.Data.Array.Module.snoc.app(xs).app(x))
    }
  };
  @JvmField
  val snoc = { xs : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
         .app(PS.Data.Array.Module.snoc
                .app(PS.Data.Array.NonEmpty.Module.toArray.app(xs))
                .app(x))
    }
  };
  @JvmField
  val singleton = PS.Control.Semigroupoid.Module.compose
                    .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                    .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
                    .app(PS.Data.Array.Module.singleton);
  @JvmField
  val replicate = { i : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
         .app(PS.Data.Array.Module.replicate
                .app(PS.Data.Ord.Module.max.app(PS.Data.Ord.Module.ordInt)
                       .app(1)
                       .app(i))
                .app(x))
    }
  };
  @JvmField
  val range = { x : Any ->
     { y : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
         .app(PS.Data.Array.Module.range.app(x).app(y))
    }
  };
  @JvmField
  val modifyAt = { i : Any ->
     { f : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArrayF)
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Array.Module.modifyAt.app(i).app(f))
                .app(PS.Data.Array.NonEmpty.Module.toArray))
    }
  };
  @JvmField
  val intersectBy_tick = { eq : Any ->
     { xs : Any ->
       PS.Data.Array.Module.intersectBy.app(eq)
         .app(PS.Data.Array.NonEmpty.Module.toArray.app(xs))
    }
  };
  @JvmField
  val intersectBy = { eq : Any ->
     { xs : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Array.NonEmpty.Module.intersectBy_tick.app(eq).app(xs))
         .app(PS.Data.Array.NonEmpty.Module.toArray)
    }
  };
  @JvmField
  val intersect_tick = { dictEq : Any ->
     PS.Data.Array.NonEmpty.Module.intersectBy_tick
       .app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val intersect = { dictEq : Any ->
     PS.Data.Array.NonEmpty.Module.intersectBy
       .app(PS.Data.Eq.Module.eq.app(dictEq))
  };
  @JvmField
  val insertAt = { i : Any ->
     { x : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArrayF)
         .app(PS.Control.Semigroupoid.Module.compose
                .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                .app(PS.Data.Array.Module.insertAt.app(i).app(x))
                .app(PS.Data.Array.NonEmpty.Module.toArray))
    }
  };
  @JvmField
  val fromFoldable1 = { dictFoldable1 : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
       .app(PS.Data.Array.Module.fromFoldable
              .app((dictFoldable1 as Map<String, Any>)["Foldable0"]!!.app(Unit))
    )
  };
  @JvmField
  val fromArray = { xs : Any ->
     when {
      (PS.Data.Ord.Module.greaterThan.app(PS.Data.Ord.Module.ordInt)
         .app(PS.Data.Array.Module.length.app(xs))
         .app(0) as Boolean) -> {
        val xs1 = xs;
        PS.Data.Maybe.Module.Just
          .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray.app(xs1));
      }
      (PS.Data.Boolean.Module.otherwise as Boolean) -> {
        val xs1 = xs;
        PS.Data.Maybe.Module.Nothing;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val fromFoldable = { dictFoldable : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.Array.NonEmpty.Module.fromArray)
       .app(PS.Data.Array.Module.fromFoldable.app(dictFoldable))
  };
  @JvmField
  val difference_tick = { dictEq : Any ->
     { xs : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.Module.difference.app(dictEq))
         .app(PS.Data.Array.NonEmpty.Module.toArray.app(xs))
    }
  };
  @JvmField
  val cons_tick = { x : Any ->
     { xs : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
         .app(PS.Data.Array.Module.cons.app(x).app(xs))
    }
  };
  @JvmField
  val fromNonEmpty = { v : Any ->
     when {
      (v is PS.Data.NonEmpty.Module._Type_NonEmpty.NonEmpty) -> {
        val x = v.value0;
        val xs = v.value1;
        PS.Data.Array.NonEmpty.Module.cons_tick.app(x).app(xs);
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val concatMap = PS.Data.Function.Module.flip
                    .app(PS.Control.Bind.Module.bind
                           .app(
      PS.Data.Array.NonEmpty.Internal.Module.bindNonEmptyArray));
  @JvmField
  val concat = PS.Control.Semigroupoid.Module.compose
                 .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                 .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
                 .app(PS.Control.Semigroupoid.Module.compose
                        .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                        .app(PS.Data.Array.Module.concat)
                        .app(PS.Control.Semigroupoid.Module.compose
                               .app(
                                 PS.Control.Semigroupoid.Module.semigroupoidFn)
                               .app(PS.Data.Array.NonEmpty.Module.toArray)
                               .app(PS.Data.Functor.Module.map
                                      .app(
                                        PS.Data.Array.NonEmpty.Internal.Module.functorNonEmptyArray
                                      )
                                      .app(PS.Data.Array.NonEmpty.Module.toArray
        ))));
  @JvmField
  val appendArray = { xs : Any ->
     { ys : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
         .app(((PS.Data.Array.NonEmpty.Module.toArray
                  .app(xs) as List<Any>) + (ys as List<Any>)))
    }
  };
  @JvmField
  val alterAt = { i : Any ->
     { f : Any ->
       PS.Control.Semigroupoid.Module.compose
         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
         .app(PS.Data.Array.Module.alterAt.app(i).app(f))
         .app(PS.Data.Array.NonEmpty.Module.toArray)
    }
  };
  @JvmField
  val adaptMaybe = { f : Any ->
     PS.Data.Function.Module.apply.app(PS.Partial.Unsafe.Module.unsafePartial)
       .app({ dictPartial : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Data.Maybe.Module.fromJust.app(Unit))
           .app(PS.Control.Semigroupoid.Module.compose
                  .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                  .app(f)
                  .app(PS.Data.Array.NonEmpty.Module.toArray))
      })
  };
  @JvmField
  val head = PS.Data.Array.NonEmpty.Module.adaptMaybe
               .app(PS.Data.Array.Module.head);
  @JvmField
  val _init = PS.Data.Array.NonEmpty.Module.adaptMaybe
                .app(PS.Data.Array.Module._init);
  @JvmField
  val last = PS.Data.Array.NonEmpty.Module.adaptMaybe
               .app(PS.Data.Array.Module.last);
  @JvmField
  val tail = PS.Data.Array.NonEmpty.Module.adaptMaybe
               .app(PS.Data.Array.Module.tail);
  @JvmField
  val uncons = PS.Data.Array.NonEmpty.Module.adaptMaybe
                 .app(PS.Data.Array.Module.uncons);
  @JvmField
  val toNonEmpty = PS.Control.Semigroupoid.Module.composeFlipped
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(PS.Data.Array.NonEmpty.Module.uncons)
                     .app({ v : Any ->
       when {
        ((v as Map<String, Any>).size == 2) -> {
          val x = v["head"]!!;
          val xs = v["tail"]!!;
          PS.Data.NonEmpty.Module.NonEmpty.app(x).app(xs);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val unsnoc = PS.Data.Array.NonEmpty.Module.adaptMaybe
                 .app(PS.Data.Array.Module.unsnoc);
  @JvmField
  val adaptAny = { f : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(f)
       .app(PS.Data.Array.NonEmpty.Module.toArray)
  };
  @JvmField
  val catMaybes = PS.Data.Array.NonEmpty.Module.adaptAny
                    .app(PS.Data.Array.Module.catMaybes);
  @JvmField
  val delete = { dictEq : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
         .app(PS.Data.Array.Module.delete.app(dictEq).app(x))
    }
  };
  @JvmField
  val deleteAt = { i : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.deleteAt.app(i))
  };
  @JvmField
  val deleteBy = { f : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
         .app(PS.Data.Array.Module.deleteBy.app(f).app(x))
    }
  };
  @JvmField
  val difference = { dictEq : Any ->
     { xs : Any ->
       PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
         .app(PS.Data.Array.NonEmpty.Module.difference_tick.app(dictEq).app(xs))
    }
  };
  @JvmField
  val drop = { i : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.drop.app(i))
  };
  @JvmField
  val dropEnd = { i : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.dropEnd.app(i))
  };
  @JvmField
  val dropWhile = { f : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.dropWhile.app(f))
  };
  @JvmField
  val elemIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
         .app(PS.Data.Array.Module.elemIndex.app(dictEq).app(x))
    }
  };
  @JvmField
  val elemLastIndex = { dictEq : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
         .app(PS.Data.Array.Module.elemLastIndex.app(dictEq).app(x))
    }
  };
  @JvmField
  val filter = { f : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.filter.app(f))
  };
  @JvmField
  val filterA = { dictApplicative : Any ->
     { f : Any ->
       PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
         .app(PS.Data.Array.Module.filterA.app(dictApplicative).app(f))
    }
  };
  @JvmField
  val findIndex = { x : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.findIndex.app(x))
  };
  @JvmField
  val findLastIndex = { x : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.findLastIndex.app(x))
  };
  @JvmField
  val foldM = { dictMonad : Any ->
     { f : Any ->
       { acc : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Array.NonEmpty.Module.adaptAny)
           .app(PS.Data.Array.Module.foldM.app(dictMonad).app(f).app(acc))
      }
    }
  };
  @JvmField
  val foldRecM = { dictMonadRec : Any ->
     { f : Any ->
       { acc : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Array.NonEmpty.Module.adaptAny)
           .app(PS.Data.Array.Module.foldRecM.app(dictMonadRec).app(f).app(acc))
      }
    }
  };
  @JvmField
  val index = PS.Data.Array.NonEmpty.Module.adaptAny
                .app(PS.Data.Array.Module.index);
  @JvmField
  val length = PS.Data.Array.NonEmpty.Module.adaptAny
                 .app(PS.Data.Array.Module.length);
  @JvmField
  val mapMaybe = { f : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.mapMaybe.app(f))
  };
  @JvmField
  val partition = { f : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.partition.app(f))
  };
  @JvmField
  val slice = { start : Any ->
     { end : Any ->
       PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
         .app(PS.Data.Array.Module.slice.app(start).app(end))
    }
  };
  @JvmField
  val span = { f : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.span.app(f))
  };
  @JvmField
  val take = { i : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.take.app(i))
  };
  @JvmField
  val takeEnd = { i : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.takeEnd.app(i))
  };
  @JvmField
  val takeWhile = { f : Any ->
     PS.Data.Function.Module.apply.app(PS.Data.Array.NonEmpty.Module.adaptAny)
       .app(PS.Data.Array.Module.takeWhile.app(f))
  };
  @JvmField
  val toUnfoldable = { dictUnfoldable : Any ->
     PS.Data.Array.NonEmpty.Module.adaptAny
       .app(PS.Data.Array.Module.toUnfoldable.app(dictUnfoldable))
  };
  @JvmField
  val unsafeAdapt = { f : Any ->
     PS.Control.Semigroupoid.Module.compose
       .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
       .app(PS.Data.Array.NonEmpty.Module.unsafeFromArray)
       .app(PS.Data.Array.NonEmpty.Module.adaptAny.app(f))
  };
  @JvmField
  val cons = { x : Any ->
     PS.Data.Function.Module.apply
       .app(PS.Data.Array.NonEmpty.Module.unsafeAdapt)
       .app(PS.Data.Array.Module.cons.app(x))
  };
  @JvmField
  val insert = { dictOrd : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeAdapt)
         .app(PS.Data.Array.Module.insert.app(dictOrd).app(x))
    }
  };
  @JvmField
  val insertBy = { f : Any ->
     { x : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeAdapt)
         .app(PS.Data.Array.Module.insertBy.app(f).app(x))
    }
  };
  @JvmField
  val modifyAtIndices = { dictFoldable : Any ->
     { _is : Any ->
       { f : Any ->
         PS.Data.Function.Module.apply
           .app(PS.Data.Array.NonEmpty.Module.unsafeAdapt)
           .app(PS.Data.Array.Module.modifyAtIndices.app(dictFoldable).app(_is)
                  .app(f))
      }
    }
  };
  @JvmField
  val nub = { dictOrd : Any ->
     PS.Data.Array.NonEmpty.Module.unsafeAdapt
       .app(PS.Data.Array.Module.nub.app(dictOrd))
  };
  @JvmField
  val nubBy = { f : Any ->
     PS.Data.Function.Module.apply
       .app(PS.Data.Array.NonEmpty.Module.unsafeAdapt)
       .app(PS.Data.Array.Module.nubBy.app(f))
  };
  @JvmField
  val nubByEq = { f : Any ->
     PS.Data.Function.Module.apply
       .app(PS.Data.Array.NonEmpty.Module.unsafeAdapt)
       .app(PS.Data.Array.Module.nubByEq.app(f))
  };
  @JvmField
  val nubEq = { dictEq : Any ->
     PS.Data.Array.NonEmpty.Module.unsafeAdapt
       .app(PS.Data.Array.Module.nubEq.app(dictEq))
  };
  @JvmField
  val reverse = PS.Data.Array.NonEmpty.Module.unsafeAdapt
                  .app(PS.Data.Array.Module.reverse);
  @JvmField
  val sort = { dictOrd : Any ->
     PS.Data.Array.NonEmpty.Module.unsafeAdapt
       .app(PS.Data.Array.Module.sort.app(dictOrd))
  };
  @JvmField
  val sortBy = { f : Any ->
     PS.Data.Function.Module.apply
       .app(PS.Data.Array.NonEmpty.Module.unsafeAdapt)
       .app(PS.Data.Array.Module.sortBy.app(f))
  };
  @JvmField
  val sortWith = { dictOrd : Any ->
     { f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeAdapt)
         .app(PS.Data.Array.Module.sortWith.app(dictOrd).app(f))
    }
  };
  @JvmField
  val updateAtIndices = { dictFoldable : Any ->
     { pairs : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Array.NonEmpty.Module.unsafeAdapt)
         .app(PS.Data.Array.Module.updateAtIndices.app(dictFoldable).app(pairs))
    }
  };
  @JvmField
  val unsafeIndex = { dictPartial : Any ->
     PS.Data.Array.NonEmpty.Module.adaptAny
       .app(PS.Data.Array.Module.unsafeIndex.app(Unit))
  };
  @JvmField
  val toUnfoldable1 = { dictUnfoldable1 : Any ->
     { xs : Any ->
       object   {
           val len = PS.Data.Array.NonEmpty.Module.length.app(xs);
           val f = { i : Any ->
              PS.Data.Function.Module.apply
                .app(PS.Data.Tuple.Module.Tuple
                       .app(PS.Partial.Unsafe.Module.unsafePartial
                              .app({ dictPartial : Any ->
                                   PS.Data.Array.NonEmpty.Module.unsafeIndex
                                     .app(Unit)
                                })
                              .app(xs)
                              .app(i)))
                .app(when {
                 (PS.Data.Ord.Module.lessThan.app(PS.Data.Ord.Module.ordInt)
                    .app(i)
                    .app(PS.Data.Ring.Module.sub
                           .app(PS.Data.Ring.Module.ringInt)
                           .app(len)
                           .app(1)) == true) -> {
                   PS.Data.Maybe.Module.Just
                     .app(PS.Data.Semiring.Module.add
                            .app(PS.Data.Semiring.Module.semiringInt)
                            .app(i)
                            .app(1));
                 }
                 else -> {
                   PS.Data.Maybe.Module.Nothing;
                 }
               })
           };
         }
         .run({
          val len = this.len;
          val f = this.f;
          PS.Data.Unfoldable1.Module.unfoldr1.app(dictUnfoldable1).app(f)
            .app(0);
        })
    }
  };
}