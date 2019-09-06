@file:Suppress("UNCHECKED_CAST")
package PS.Data.Array.NonEmpty.Internal
import Foreign.PsRuntime.app
object Module  {
  val fold1Impl = Foreign.Data.Array.NonEmpty.Internal.fold1Impl;
  val traverse1Impl = Foreign.Data.Array.NonEmpty.Internal.traverse1Impl;
  @JvmField val NonEmptyArray = { x : Any -> x};
  @JvmField
  val unfoldable1NonEmptyArray = PS.Data.Unfoldable1.Module.unfoldable1Array;
  @JvmField
  val traversableWithIndexNonEmptyArray = PS.Data.TraversableWithIndex.Module.traversableWithIndexArray;
  @JvmField
  val traversableNonEmptyArray = PS.Data.Traversable.Module.traversableArray;
  @JvmField
  val showNonEmptyArray = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app({ v : Any ->
         when {
          else -> {
            val xs = v;
            (("(NonEmptyArray " as String) + (((PS.Data.Show.Module.show
                                                  .app(
                                                    PS.Data.Show.Module.showArray
                                                      .app(dictShow))
                                                  .app(xs
            ) as String) + (")" as String)) as String));
          }
        }
      })
  };
  @JvmField
  val semigroupNonEmptyArray = PS.Data.Semigroup.Module.semigroupArray;
  @JvmField
  val ordNonEmptyArray = { dictOrd : Any ->
     PS.Data.Ord.Module.ordArray.app(dictOrd)
  };
  @JvmField val ord1NonEmptyArray = PS.Data.Ord.Module.ord1Array;
  @JvmField val monadNonEmptyArray = PS.Control.Monad.Module.monadArray;
  @JvmField
  val functorWithIndexNonEmptyArray = PS.Data.FunctorWithIndex.Module.functorWithIndexArray;
  @JvmField val functorNonEmptyArray = PS.Data.Functor.Module.functorArray;
  @JvmField
  val foldableWithIndexNonEmptyArray = PS.Data.FoldableWithIndex.Module.foldableWithIndexArray;
  @JvmField val foldableNonEmptyArray = PS.Data.Foldable.Module.foldableArray;
  @JvmField val foldable1NonEmptyArray = (::__rec_foldable1NonEmptyArray)();
  fun __rec_foldable1NonEmptyArray(): Any = PS.Data.Semigroup.Foldable.Module.Foldable1
                                              .app({ _ : Any ->
                                                   PS.Data.Array.NonEmpty.Internal.Module.foldableNonEmptyArray
                                                })
                                              .app({ dictSemigroup : Any ->
                                                   PS.Data.Array.NonEmpty.Internal.Module.fold1Impl
                                                     .app(
                                                    PS.Data.Semigroup.Module.append
                                                      .app(dictSemigroup))
                                                })
                                              .app({ dictSemigroup : Any ->
       PS.Data.Semigroup.Foldable.Module.foldMap1Default
         .app(PS.Data.Array.NonEmpty.Internal.Module.foldable1NonEmptyArray)
         .app(PS.Data.Array.NonEmpty.Internal.Module.functorNonEmptyArray)
         .app(dictSemigroup)
    });
  @JvmField
  val traversable1NonEmptyArray = (::__rec_traversable1NonEmptyArray)();
  fun __rec_traversable1NonEmptyArray(): Any = PS.Data.Semigroup.Traversable.Module.Traversable1
                                                 .app({ _ : Any ->
                                                      PS.Data.Array.NonEmpty.Internal.Module.foldable1NonEmptyArray
                                                   })
                                                 .app({ _ : Any ->
                                                      PS.Data.Array.NonEmpty.Internal.Module.traversableNonEmptyArray
                                                   })
                                                 .app({ dictApply : Any ->
                                                      PS.Data.Semigroup.Traversable.Module.sequence1Default
                                                        .app(
                                                          PS.Data.Array.NonEmpty.Internal.Module.traversable1NonEmptyArray
                                                        )
                                                        .app(dictApply)
                                                   })
                                                 .app({ dictApply : Any ->
       PS.Data.Array.NonEmpty.Internal.Module.traverse1Impl
         .app(PS.Control.Apply.Module.apply.app(dictApply))
         .app(PS.Data.Functor.Module.map
                .app((dictApply as Map<String, Any>)["Functor0"]!!.app(Unit)))
    });
  @JvmField
  val eqNonEmptyArray = { dictEq : Any ->
     PS.Data.Eq.Module.eqArray.app(dictEq)
  };
  @JvmField val eq1NonEmptyArray = PS.Data.Eq.Module.eq1Array;
  @JvmField val bindNonEmptyArray = PS.Control.Bind.Module.bindArray;
  @JvmField val applyNonEmptyArray = PS.Control.Apply.Module.applyArray;
  @JvmField
  val applicativeNonEmptyArray = PS.Control.Applicative.Module.applicativeArray;
  @JvmField val altNonEmptyArray = PS.Control.Alt.Module.altArray;
}