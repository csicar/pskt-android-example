package Foreign.Android.Widget

import PS.Data.Tuple.Module
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import org.jetbrains.anko.sdk27.coroutines.onClick

val __rId = {ctx: Any, id: Any ->
    ctx as Activity; id as String
    val ressourceId = ctx.resources.getIdentifier(id, "id", ctx.packageName)
    ctx.findViewById<View>(ressourceId)
}

val __verticalLayout = { ctx: Any ->
    ctx as Context

    LinearLayout(ctx).also { it.orientation = LinearLayout.VERTICAL }
}

val __scrollView = { ctx: Any ->
    ctx as Context
    ScrollView(ctx)
}

val __button = { ctx: Any, str: Any ->
    ctx as Context; str as String
    val btn = Button(ctx)
    btn.text = str
    btn
}

val __textView = { ctx: Any, str: Any ->
    ctx as Context; str as String
    val tv = TextView(ctx)
    tv.text = str
    tv
}

val __editText = { ctx: Any, str: Any ->
    ctx as Context; str as String
    val et = EditText(ctx)
    et.setText(str)
    et
}


val __addView = { viewGroup: Any, view: Any ->
    viewGroup as ViewGroup; view as View
    viewGroup.addView(view)
}

val __addContentView = { ctx: Any, view: Any ->

    ctx as Activity; view as View
    ctx.addContentView(
        view,
        ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    )
}

val __onClick = { view: Any, f: Any ->
    view as View; f as () -> Unit
    view.onClick { f() }
}

val __setTextTextView = { button: Any, str: Any ->
    button as TextView; str as String
    button.text = str
}

val __getText = {textView: Any ->
    textView as TextView
    textView.text.toString()
}

val __tabLayout  = {ctx: Any ->
    ctx as Context;
    TabLayout(ctx)
}

val __addTab = {tabLayout: Any, tabName: Any ->
    tabLayout as TabLayout; tabName as String
    tabLayout.addTab(tabLayout.newTab().setText(tabName))
}

class PsRecyclerViewAdapter(var myDataset: List<Any>, private val createViewHolder: (Context) -> (() -> Any)) :
    RecyclerView.Adapter<PsRecyclerViewAdapter.PsBinderViewHolder>() {

    class PsBinderViewHolder(val view: View, val binder: ((Int) -> ((Any) -> (() -> Unit)))): RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PsRecyclerViewAdapter.PsBinderViewHolder {
        val (vh, binder) = createViewHolder(parent.context)() as Module._Type_Tuple.Tuple
        return PsBinderViewHolder(vh as View, binder as ((Int) -> ((Any) -> (() -> Unit))))
    }

    override fun onBindViewHolder(holder: PsBinderViewHolder, position: Int) {
        holder.binder(position)(myDataset[position])()
    }

    override fun getItemCount() = myDataset.size
}


val __recyclerView = {ctx: Any, dataset: Any, createViewHolder: Any ->
    ctx as Context; createViewHolder as ((Context) -> (() -> Any)); dataset as List<Any>



    RecyclerView(ctx).apply {
        layoutManager = LinearLayoutManager(ctx)
        adapter = PsRecyclerViewAdapter(dataset, createViewHolder)
    }
}

val __updateRecyclerView = {view: Any, newVal: Any ->
    view as RecyclerView; newVal as List<Any>
    val adapter = view.adapter as PsRecyclerViewAdapter
    adapter.myDataset = newVal
    adapter.notifyDataSetChanged()
}