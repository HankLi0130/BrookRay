package tw.hankli.library.ext

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

/** 顯示列表 Dialog */
fun Context.getListDialog(titleId: Int, itemsId: Int, listener: DialogInterface.OnClickListener): AlertDialog {
    return AlertDialog.Builder(this)
        .setTitle(titleId)
        .setItems(itemsId, listener)
        .create()
}