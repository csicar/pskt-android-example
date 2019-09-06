@file:Suppress("UNCHECKED_CAST")
package PS.Effect.Console
import Foreign.PsRuntime.app
object Module  {
  val log = Foreign.Effect.Console.log;
  val warn = Foreign.Effect.Console.warn;
  val error = Foreign.Effect.Console.error;
  val info = Foreign.Effect.Console.info;
  val time = Foreign.Effect.Console.time;
  val timeEnd = Foreign.Effect.Console.timeEnd;
  @JvmField
  val warnShow = { dictShow : Any ->
     { a : Any ->
       PS.Effect.Console.Module.warn
         .app(PS.Data.Show.Module.show.app(dictShow).app(a))
    }
  };
  @JvmField
  val logShow = { dictShow : Any ->
     { a : Any ->
       PS.Effect.Console.Module.log
         .app(PS.Data.Show.Module.show.app(dictShow).app(a))
    }
  };
  @JvmField
  val infoShow = { dictShow : Any ->
     { a : Any ->
       PS.Effect.Console.Module.info
         .app(PS.Data.Show.Module.show.app(dictShow).app(a))
    }
  };
  @JvmField
  val errorShow = { dictShow : Any ->
     { a : Any ->
       PS.Effect.Console.Module.error
         .app(PS.Data.Show.Module.show.app(dictShow).app(a))
    }
  };
}