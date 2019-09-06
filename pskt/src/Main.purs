module Main where

import Prelude

import Effect (Effect)
import Effect.Uncurried
import Effect.Console (log, logShow)
import Global (readFloat)
import Data.Int (floor)
import Unsafe.Coerce (unsafeCoerce)

main :: Context -> Effect Unit
main ctx = do
  log "in main"
  void $ verticalLayout ctx $ \vm -> do
        log "in vertical layout"
        a <- editText vm "1st Field"
        b <- editText vm "2nd Field"
        res <- textView vm "result ="
        btn <- button vm "click"
        onClick btn $ \_ -> do
            aVal <- getText a
            bVal <- getText b
            setText res $ "result = " <> aVal <> bVal
            log "btn clicked!"

class IsView a where
    toView :: a -> View


instance textViewView :: IsView TextView where toView = unsafeCoerce
instance buttonView :: IsView Button where toView = unsafeCoerce

class SetText a where
    setText :: a -> String -> Effect Unit
instance setTextTextView :: SetText TextView where
    setText = runEffectFn2 _setTextViewText

class GetText a where
    getText :: a -> Effect String
instance getTextEditText :: GetText EditText where
    getText = runEffectFn1 _getTextEditText

foreign import data TextView :: Type
foreign import data Button :: Type
foreign import data EditText :: Type

foreign import data VerticalLayout :: Type

foreign import data View :: Type

foreign import data ViewManager :: Type
foreign import data Context :: Type

foreign import _textView :: EffectFn2 ViewManager String TextView
textView :: ViewManager -> String -> Effect TextView
textView = runEffectFn2 _textView

foreign import _button :: EffectFn2 ViewManager String Button
button = runEffectFn2 _button

foreign import _editText :: EffectFn2 ViewManager String EditText
editText = runEffectFn2 _editText

foreign import _verticalLayout :: EffectFn2 Context (ViewManager -> Effect Unit) VerticalLayout
verticalLayout = runEffectFn2 _verticalLayout

foreign import _onClick :: EffectFn2 View (View -> Effect Unit) Unit
onClick v = runEffectFn2 _onClick (toView v)

foreign import _setTextViewText :: EffectFn2 TextView String Unit

foreign import _getTextEditText :: EffectFn1 EditText String