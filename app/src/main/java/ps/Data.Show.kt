@file:Suppress("UNCHECKED_CAST")

package PS.Data.Show
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  val showIntImpl = Foreign.Data.Show.showIntImpl;
  val showNumberImpl = Foreign.Data.Show.showNumberImpl;
  val showCharImpl = Foreign.Data.Show.showCharImpl;
  val showStringImpl = Foreign.Data.Show.showStringImpl;
  val showArrayImpl = Foreign.Data.Show.showArrayImpl;
  val cons = Foreign.Data.Show.cons;
  val join = Foreign.Data.Show.join;
  @JvmField
  val ShowRecordFields = { showRecordFields : Any ->
     mapOf(("showRecordFields" to showRecordFields))
  };
  @JvmField val Show = { show : Any -> mapOf(("show" to show))};
  @JvmField
  val showString = PS.Data.Show.Module.Show
                     .app(PS.Data.Show.Module.showStringImpl);
  @JvmField
  val showRecordFieldsNil = PS.Data.Show.Module.ShowRecordFields
                              .app({ v : Any ->
       { v1 : Any ->
         emptyList<Any>()
      }
    });
  @JvmField
  val showRecordFields = { dict : Any ->
     (dict as Map<String, Any>)["showRecordFields"]!!
  };
  @JvmField
  val showRecord = { dictRowToList : Any ->
     { dictShowRecordFields : Any ->
       PS.Data.Show.Module.Show
         .app({ record : Any ->
           object   {
               val v = PS.Data.Show.Module.showRecordFields
                         .app(dictShowRecordFields)
                         .app(PS.Type.Data.RowList.Module.RLProxy)
                         .app(record);
             }
             .run({
              val v = this.v;
              when {
                ((v as List<Any>).size == 0) -> {
                  "{}";
                }
                else -> {
                  val fields = v;
                  PS.Data.Show.Module.join.app(" ")
                    .app(listOf("{",  PS.Data.Show.Module.join.app(", ")
                                        .app(fields),  "}"));
                }
              };
            })
        })
    }
  };
  @JvmField
  val showNumber = PS.Data.Show.Module.Show
                     .app(PS.Data.Show.Module.showNumberImpl);
  @JvmField
  val showInt = PS.Data.Show.Module.Show.app(PS.Data.Show.Module.showIntImpl);
  @JvmField
  val showChar = PS.Data.Show.Module.Show.app(PS.Data.Show.Module.showCharImpl);
  @JvmField
  val showBoolean = PS.Data.Show.Module.Show
                      .app({ v : Any ->
       when {
        (v == true) -> {
          "true";
        }
        (v == false) -> {
          "false";
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField val show = { dict : Any -> (dict as Map<String, Any>)["show"]!!};
  @JvmField
  val showArray = { dictShow : Any ->
     PS.Data.Show.Module.Show
       .app(PS.Data.Show.Module.showArrayImpl
              .app(PS.Data.Show.Module.show.app(dictShow)))
  };
  @JvmField
  val showRecordFieldsCons = { dictIsSymbol : Any ->
     { dictShowRecordFields : Any ->
       { dictShow : Any ->
         PS.Data.Show.Module.ShowRecordFields
           .app({ v : Any ->
             { record : Any ->
               object   {
                   val tail = PS.Data.Show.Module.showRecordFields
                                .app(dictShowRecordFields)
                                .app(PS.Type.Data.RowList.Module.RLProxy)
                                .app(record);
                   val key = PS.Data.Symbol.Module.reflectSymbol
                               .app(dictIsSymbol)
                               .app(PS.Data.Symbol.Module.SProxy);
                   val focus = PS.Record.Unsafe.Module.unsafeGet.app(key)
                                 .app(record);
                 }
                 .run({
                  val tail = this.tail;
                  val key = this.key;
                  val focus = this.focus;
                  PS.Data.Show.Module.cons
                    .app(PS.Data.Show.Module.join.app(": ")
                           .app(listOf(key,  PS.Data.Show.Module.show
                                               .app(dictShow)
                                               .app(focus))))
                    .app(tail);
                })
            }
          })
      }
    }
  };
}