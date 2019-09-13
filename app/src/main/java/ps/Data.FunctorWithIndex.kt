@file:Suppress("UNCHECKED_CAST")

package PS.Data.FunctorWithIndex
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val mapWithIndexArray = Foreign.Data.FunctorWithIndex.mapWithIndexArray;
  @JvmField
  val FunctorWithIndex = { Functor0 : Any ->
     { mapWithIndex : Any ->
       mapOf(("Functor0" to Functor0),  ("mapWithIndex" to mapWithIndex))
    }
  };
  @JvmField
  val mapWithIndex = { dict : Any ->
     (dict as Map<String, Any>)["mapWithIndex"]!!
  };
  @JvmField
  val mapDefault = { dictFunctorWithIndex : Any ->
     { f : Any ->
       PS.Data.FunctorWithIndex.Module.mapWithIndex.app(dictFunctorWithIndex)
         .app(PS.Data.Function.Module._const.app(f))
    }
  };
  @JvmField
  val functorWithIndexMultiplicative = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                         .app({ _ : Any ->
                                              PS.Data.Monoid.Multiplicative.Module.functorMultiplicative
                                           })
                                         .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map
                .app(PS.Data.Monoid.Multiplicative.Module.functorMultiplicative)
         )
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val functorWithIndexMaybe = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Maybe.Module.functorMaybe
                                  })
                                .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map.app(PS.Data.Maybe.Module.functorMaybe))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val functorWithIndexLast = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                               .app({ _ : Any ->
                                    PS.Data.Maybe.Last.Module.functorLast
                                 })
                               .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map
                .app(PS.Data.Maybe.Last.Module.functorLast))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val functorWithIndexFirst = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Maybe.First.Module.functorFirst
                                  })
                                .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map
                .app(PS.Data.Maybe.First.Module.functorFirst))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val functorWithIndexDual = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                               .app({ _ : Any ->
                                    PS.Data.Monoid.Dual.Module.functorDual
                                 })
                               .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map
                .app(PS.Data.Monoid.Dual.Module.functorDual))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val functorWithIndexDisj = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                               .app({ _ : Any ->
                                    PS.Data.Monoid.Disj.Module.functorDisj
                                 })
                               .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map
                .app(PS.Data.Monoid.Disj.Module.functorDisj))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val functorWithIndexConj = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                               .app({ _ : Any ->
                                    PS.Data.Monoid.Conj.Module.functorConj
                                 })
                               .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map
                .app(PS.Data.Monoid.Conj.Module.functorConj))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
  @JvmField
  val functorWithIndexArray = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                .app({ _ : Any ->
                                     PS.Data.Functor.Module.functorArray
                                  })
                                .app(
    PS.Data.FunctorWithIndex.Module.mapWithIndexArray);
  @JvmField
  val functorWithIndexAdditive = PS.Data.FunctorWithIndex.Module.FunctorWithIndex
                                   .app({ _ : Any ->
                                        PS.Data.Monoid.Additive.Module.functorAdditive
                                     })
                                   .app({ f : Any ->
       PS.Data.Function.Module.apply
         .app(PS.Data.Functor.Module.map
                .app(PS.Data.Monoid.Additive.Module.functorAdditive))
         .app(f.app(PS.Data.Unit.Module.unit))
    });
}