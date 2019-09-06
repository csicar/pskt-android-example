package Foreign.Affjax

import Foreign.PsRuntime.app

val _ajax = {
  { mkHeader : Any, options: Any ->
    { errback: Any, callback: Any ->
      //TODO create xhr

      { error: Any, cancelErrback: Any, cancelCallback: Any ->
        cancelCallback.app(Unit)
      }
    }
  }
}