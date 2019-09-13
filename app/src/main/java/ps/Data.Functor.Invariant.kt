@file:Suppress("UNCHECKED_CAST")

package PS.Data.Functor.Invariant
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField val Invariant = { imap : Any -> mapOf(("imap" to imap))};
  @JvmField
  val invariantMultiplicative = PS.Data.Functor.Invariant.Module.Invariant
                                  .app({ f : Any ->
       { v : Any ->
         { v1 : Any ->
          val f1 = f;
            val x = v1;
            PS.Data.Monoid.Multiplicative.Module.Multiplicative.app(f1.app(x));}
      }
    });
  @JvmField
  val invariantEndo = PS.Data.Functor.Invariant.Module.Invariant
                        .app({ ab : Any ->
       { ba : Any ->
         { v : Any ->
          val ab1 = ab;
            val ba1 = ba;
            val f = v;
            PS.Data.Monoid.Endo.Module.Endo
              .app(PS.Control.Semigroupoid.Module.compose
                     .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                     .app(ab1)
                     .app(PS.Control.Semigroupoid.Module.compose
                            .app(PS.Control.Semigroupoid.Module.semigroupoidFn)
                            .app(f)
                            .app(ba1)));}
      }
    });
  @JvmField
  val invariantDual = PS.Data.Functor.Invariant.Module.Invariant
                        .app({ f : Any ->
       { v : Any ->
         { v1 : Any ->
          val f1 = f;
            val x = v1;
            PS.Data.Monoid.Dual.Module.Dual.app(f1.app(x));}
      }
    });
  @JvmField
  val invariantDisj = PS.Data.Functor.Invariant.Module.Invariant
                        .app({ f : Any ->
       { v : Any ->
         { v1 : Any ->
          val f1 = f;
            val x = v1;
            PS.Data.Monoid.Disj.Module.Disj.app(f1.app(x));}
      }
    });
  @JvmField
  val invariantConj = PS.Data.Functor.Invariant.Module.Invariant
                        .app({ f : Any ->
       { v : Any ->
         { v1 : Any ->
          val f1 = f;
            val x = v1;
            PS.Data.Monoid.Conj.Module.Conj.app(f1.app(x));}
      }
    });
  @JvmField
  val invariantAdditive = PS.Data.Functor.Invariant.Module.Invariant
                            .app({ f : Any ->
       { v : Any ->
         { v1 : Any ->
          val f1 = f;
            val x = v1;
            PS.Data.Monoid.Additive.Module.Additive.app(f1.app(x));}
      }
    });
  @JvmField
  val imapF = { dictFunctor : Any ->
     { f : Any ->
       { v : Any ->
         PS.Data.Functor.Module.map.app(dictFunctor).app(f)
      }
    }
  };
  @JvmField
  val invariantArray = PS.Data.Functor.Invariant.Module.Invariant
                         .app(PS.Data.Functor.Invariant.Module.imapF
                                .app(PS.Data.Functor.Module.functorArray));
  @JvmField
  val invariantFn = PS.Data.Functor.Invariant.Module.Invariant
                      .app(PS.Data.Functor.Invariant.Module.imapF
                             .app(PS.Data.Functor.Module.functorFn));
  @JvmField val imap = { dict : Any -> (dict as Map<String, Any>)["imap"]!!};
}