@file:Suppress("UNCHECKED_CAST")

package PS.Global
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val nan = Foreign.Global.nan;
  val isNaN = Foreign.Global.isNaN;
  val infinity = Foreign.Global.infinity;
  val isFinite = Foreign.Global.isFinite;
  val readInt = Foreign.Global.readInt;
  val readFloat = Foreign.Global.readFloat;
  val __toFixed = Foreign.Global.__toFixed;
  val __toExponential = Foreign.Global.__toExponential;
  val __toPrecision = Foreign.Global.__toPrecision;
  val __decodeURI = Foreign.Global.__decodeURI;
  val __encodeURI = Foreign.Global.__encodeURI;
  val __decodeURIComponent = Foreign.Global.__decodeURIComponent;
  val __encodeURIComponent = Foreign.Global.__encodeURIComponent;
  @JvmField
  val toPrecision = { digits : Any ->
     { n : Any ->
       PS.Data.Function.Uncurried.Module.runFn4
         .app(PS.Global.Module.__toPrecision)
         .app(PS.Data.Function.Module._const.app(PS.Data.Maybe.Module.Nothing))
         .app(PS.Data.Maybe.Module.Just)
         .app(digits)
         .app(n)
    }
  };
  @JvmField
  val toFixed = { digits : Any ->
     { n : Any ->
       PS.Data.Function.Uncurried.Module.runFn4.app(PS.Global.Module.__toFixed)
         .app(PS.Data.Function.Module._const.app(PS.Data.Maybe.Module.Nothing))
         .app(PS.Data.Maybe.Module.Just)
         .app(digits)
         .app(n)
    }
  };
  @JvmField
  val toExponential = { digits : Any ->
     { n : Any ->
       PS.Data.Function.Uncurried.Module.runFn4
         .app(PS.Global.Module.__toExponential)
         .app(PS.Data.Function.Module._const.app(PS.Data.Maybe.Module.Nothing))
         .app(PS.Data.Maybe.Module.Just)
         .app(digits)
         .app(n)
    }
  };
  @JvmField
  val encodeURIComponent = { s : Any ->
     PS.Data.Function.Uncurried.Module.runFn3
       .app(PS.Global.Module.__encodeURIComponent)
       .app(PS.Data.Function.Module._const.app(PS.Data.Maybe.Module.Nothing))
       .app(PS.Data.Maybe.Module.Just)
       .app(s)
  };
  @JvmField
  val encodeURI = { s : Any ->
     PS.Data.Function.Uncurried.Module.runFn3.app(PS.Global.Module.__encodeURI)
       .app(PS.Data.Function.Module._const.app(PS.Data.Maybe.Module.Nothing))
       .app(PS.Data.Maybe.Module.Just)
       .app(s)
  };
  @JvmField
  val decodeURIComponent = { s : Any ->
     PS.Data.Function.Uncurried.Module.runFn3
       .app(PS.Global.Module.__decodeURIComponent)
       .app(PS.Data.Function.Module._const.app(PS.Data.Maybe.Module.Nothing))
       .app(PS.Data.Maybe.Module.Just)
       .app(s)
  };
  @JvmField
  val decodeURI = { s : Any ->
     PS.Data.Function.Uncurried.Module.runFn3.app(PS.Global.Module.__decodeURI)
       .app(PS.Data.Function.Module._const.app(PS.Data.Maybe.Module.Nothing))
       .app(PS.Data.Maybe.Module.Just)
       .app(s)
  };
}