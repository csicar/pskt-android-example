module Android.Widget where

import Effect (Effect)
import Effect.Uncurried
import Effect.Console (log, logShow)
import Global (readFloat)
import Data.Int (floor)
import Unsafe.Coerce (unsafeCoerce)
import Prelude
import Data.Tuple (Tuple(..))

foreign import data Context :: Type

foreign import _addContentView :: EffectFn2 Context View Unit
addContentView a b = runEffectFn2 _addContentView a (toView b)


--
-- 
-- View
--
--
foreign import data View :: Type

class IsView a where
    toView :: a -> View

foreign import data TextView :: Type
instance textViewView :: IsView TextView where toView = unsafeCoerce

foreign import _textView :: EffectFn2 Context String TextView
textView :: Context -> String -> Effect TextView
textView = runEffectFn2 _textView

foreign import data Button :: Type
instance buttonView :: IsView Button where toView = unsafeCoerce
foreign import _button :: EffectFn2 Context String Button
button :: Context -> String -> Effect Button
button = runEffectFn2 _button

foreign import data EditText :: Type
instance isViewEditText :: IsView EditText where toView = unsafeCoerce
foreign import _editText :: EffectFn2 Context String EditText
editText :: Context -> String -> Effect EditText
editText = runEffectFn2 _editText


foreign import _onClick :: EffectFn2 View (Effect Unit) Unit
onClick :: forall a. IsView a => a -> Effect Unit -> Effect Unit
onClick a = runEffectFn2 _onClick (toView a)

--
--
-- ViewGroup
--
--
foreign import data ViewGroup :: Type

class IsViewGroup a where
    toViewGroup :: a -> ViewGroup

foreign import _addView :: EffectFn2 ViewGroup View Unit
addView :: forall a b. IsViewGroup a => IsView b => a -> b -> Effect Unit
addView vg v = runEffectFn2 _addView (toViewGroup vg) (toView v)

foreign import data VerticalLayout :: Type

foreign import _verticalLayout :: EffectFn1 Context VerticalLayout
verticalLayout = runEffectFn1 _verticalLayout

instance viewGroupVerticalLayout :: IsViewGroup VerticalLayout where toViewGroup = unsafeCoerce
instance layoutView :: IsView VerticalLayout where toView = unsafeCoerce

foreign import data ScrollView :: Type

foreign import _scrollView :: EffectFn1 Context ScrollView
scrollView = runEffectFn1 _scrollView

instance viewGroupScrollView :: IsViewGroup ScrollView where toViewGroup = unsafeCoerce
instance viewScrollView :: IsView ScrollView where toView = unsafeCoerce

foreign import data TabLayout :: Type
instance tabLayoutView :: IsView TabLayout where toView = unsafeCoerce

foreign import _tabLayout :: EffectFn1 Context TabLayout
tabLayout = runEffectFn1 _tabLayout

foreign import _addTab :: EffectFn2 TabLayout String Unit
addTab = runEffectFn2 _addTab


--
--
-- TextView
--
--
class IsTextView a where
    toTextView :: a -> TextView

instance isTextViewButton :: IsTextView Button where toTextView = unsafeCoerce
instance isTextViewEditText :: IsTextView EditText where toTextView = unsafeCoerce
instance isTextViewTextView :: IsTextView TextView where toTextView = identity

foreign import _getText :: EffectFn1 TextView String
getText :: ∀a. IsTextView a => a -> Effect String
getText tv = runEffectFn1 _getText (toTextView tv)



--
--
-- SetText
--
--
class IsSetText a where
    setText :: a -> String -> Effect Unit

foreign import _setTextTextView :: EffectFn2 TextView String Unit
instance isSetTextTextView :: IsTextView a => IsSetText a where
    setText a = runEffectFn2 _setTextTextView (toTextView a)


--
--
-- RecyclerView
--
--
foreign import data RecyclerView :: Type -> Type

instance isViewRecyclerView :: IsView (RecyclerView a) where toView = unsafeCoerce

foreign import _recyclerView :: ∀a. EffectFn3 Context (Array a) (Context -> Effect (Tuple View (Int -> a -> Effect Unit))) (RecyclerView a)
recyclerView = runEffectFn3 _recyclerView

foreign import _updateRecyclerView :: ∀a. EffectFn2 (RecyclerView a) (Array a) Unit
updateRecyclerView :: ∀a. (RecyclerView a) -> (Array a) -> Effect Unit
updateRecyclerView = runEffectFn2 _updateRecyclerView