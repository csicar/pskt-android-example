@file:Suppress("UNCHECKED_CAST")

package PS.Data.List.Partial
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val tail = { dictPartial : Any ->
     { v : Any ->
       when {
        (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val xs = v.value1;
          xs;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField val last = (::__rec_last)();
  fun __rec_last(): Any = { dictPartial : Any ->
     { v : Any ->
       when {
        (v is PS.Data.List.Types.Module._Type_List
                .Cons)&& (v
                            .value1 is PS.Data.List.Types.Module._Type_List
                                         .Nil) -> {
          val x = v.value0;
          x;
        }
        (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val xs = v.value1;
          PS.Data.List.Partial.Module.last.app(Unit).app(xs);
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField val _init = (::__rec__init)();
  fun __rec__init(): Any = { dictPartial : Any ->
     { v : Any ->
       when {
        (v is PS.Data.List.Types.Module._Type_List
                .Cons)&& (v
                            .value1 is PS.Data.List.Types.Module._Type_List
                                         .Nil) -> {
          val x = v.value0;
          PS.Data.List.Types.Module.Nil;
        }
        (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val x = v.value0;
          val xs = v.value1;
          PS.Data.List.Types.Module.Cons.app(x)
            .app(PS.Data.List.Partial.Module._init.app(Unit).app(xs));
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
  @JvmField
  val head = { dictPartial : Any ->
     { v : Any ->
       when {
        (v is PS.Data.List.Types.Module._Type_List.Cons) -> {
          val x = v.value0;
          x;
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    }
  };
}