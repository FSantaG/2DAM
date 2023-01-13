package com.mjpg.basedatos.controlador
    import android.content.Context
    import android.database.Cursor
    import android.graphics.Color
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.recyclerview.widget.RecyclerView
    import com.mjpg.basedatos.R
    import com.mjpg.basedatos.bd.MyDBOpenHelper
    import com.mjpg.basedatos.dao.OperacionesDao
    import com.mjpg.basedatos.databinding.ListaPuntoBinding


class PuntosAdaptador(private var cursor: Cursor, private var context:Context) :
        RecyclerView.Adapter<PuntosAdaptador.ViewHolder>() {



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            context = parent.context
            val view = LayoutInflater.from(context)
                .inflate(
                    R.layout.lista_punto,
                    parent, false
                )
            return ViewHolder(view)
        }

        override fun
                onBindViewHolder(
            holder: ViewHolder,
            position: Int
        ) {
            cursor.moveToPosition(position)
           if ( cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROVINCIA)) == "Burgos")
                holder.binding.contenedor.setBackgroundColor(Color.CYAN)
           else
               holder.binding.contenedor.setBackgroundColor(Color.WHITE)
           with(holder) {
               val  bd= OperacionesDao(context)
               val tipo=bd.getUnTipo( cursor.getInt(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_CODTIPO)))
               binding.txtEsta.text = tipo!!.denominacion
                binding.txtDenominacion.text = cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_DENO))
                binding.txtDir.text =cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_DIRECCION))
                binding.txtPro.text = cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROVINCIA))
            }
        }

        override fun getItemCount() =cursor.count

        inner class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
            val binding = ListaPuntoBinding.bind(view)

        }


    }




