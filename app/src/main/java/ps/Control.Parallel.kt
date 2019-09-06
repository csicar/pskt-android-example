@file:Suppress("UNCHECKED_CAST")
package PS.Control.Parallel
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val parTraverse_ = { dictParallel : Any ->
     { dictFoldable : Any ->
       { f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Control.Parallel.Class.Module.sequential.app(dictParallel))
           .app(PS.Data.Foldable.Module.traverse_
                  .app((dictParallel as Map<String, Any>)["Applicative1"]!!
                         .app(Unit))
                  .app(dictFoldable)
                  .app(PS.Control.Semigroupoid.Module.compose
                         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                         .app(PS.Control.Parallel.Class.Module.parallel
                                .app(dictParallel))
                         .app(f)))
      }
    }
  };
  @JvmField
  val parTraverse = { dictParallel : Any ->
     { dictTraversable : Any ->
       { f : Any ->
         PS.Control.Semigroupoid.Module.compose
           .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
           .app(PS.Control.Parallel.Class.Module.sequential.app(dictParallel))
           .app(PS.Data.Traversable.Module.traverse.app(dictTraversable)
                  .app((dictParallel as Map<String, Any>)["Applicative1"]!!
                         .app(Unit))
                  .app(PS.Control.Semigroupoid.Module.compose
                         .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                         .app(PS.Control.Parallel.Class.Module.parallel
                                .app(dictParallel))
                         .app(f)))
      }
    }
  };
  @JvmField
  val parSequence_ = { dictParallel : Any ->
     { dictFoldable : Any ->
       PS.Control.Parallel.Module.parTraverse_.app(dictParallel)
         .app(dictFoldable)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val parSequence = { dictParallel : Any ->
     { dictTraversable : Any ->
       PS.Control.Parallel.Module.parTraverse.app(dictParallel)
         .app(dictTraversable)
         .app(PS.Control.Category.Module.identity
                .app(PS.Control.Category.Module.categoryFn))
    }
  };
  @JvmField
  val parOneOfMap = { dictParallel : Any ->
     { dictAlternative : Any ->
       { dictFoldable : Any ->
         { dictFunctor : Any ->
           { f : Any ->
             PS.Control.Semigroupoid.Module.compose
               .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
               .app(PS.Control.Parallel.Class.Module.sequential
                      .app(dictParallel))
               .app(PS.Data.Foldable.Module.oneOfMap.app(dictFoldable)
                      .app((dictAlternative as Map<String, Any>)["Plus1"]!!
                             .app(Unit))
                      .app(PS.Control.Semigroupoid.Module.compose
                             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                             .app(PS.Control.Parallel.Class.Module.parallel
                                    .app(dictParallel))
                             .app(f)))
          }
        }
      }
    }
  };
  @JvmField
  val parOneOf = { dictParallel : Any ->
     { dictAlternative : Any ->
       { dictFoldable : Any ->
         { dictFunctor : Any ->
           PS.Control.Semigroupoid.Module.compose
             .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
             .app(PS.Control.Parallel.Class.Module.sequential.app(dictParallel))
             .app(PS.Data.Foldable.Module.oneOfMap.app(dictFoldable)
                    .app((dictAlternative as Map<String, Any>)["Plus1"]!!
                           .app(Unit))
                    .app(PS.Control.Parallel.Class.Module.parallel
                           .app(dictParallel)))
        }
      }
    }
  };
  @JvmField
  val parApply = { dictParallel : Any ->
     { mf : Any ->
       { ma : Any ->
         PS.Control.Parallel.Class.Module.sequential.app(dictParallel)
           .app(PS.Control.Apply.Module.apply
                  .app(((dictParallel as Map<String, Any>)["Applicative1"]!!
                          .app(Unit) as Map<String, Any>)["Apply0"]!!
                         .app(Unit))
                  .app(PS.Control.Parallel.Class.Module.parallel
                         .app(dictParallel)
                         .app(mf))
                  .app(PS.Control.Parallel.Class.Module.parallel
                         .app(dictParallel)
                         .app(ma)))
      }
    }
  };
}