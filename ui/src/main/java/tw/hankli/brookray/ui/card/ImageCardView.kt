package tw.hankli.brookray.ui.card

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.withStyledAttributes
import tw.hankli.brookray.ui.R

class ImageCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    val image: ImageView = ImageView(context, attrs, defStyleAttr)

    init {
        context.withStyledAttributes(attrs, R.styleable.ImageCardView) {
            val drawable = getDrawable(R.styleable.ImageCardView_android_src)
            if (drawable != null) image.setImageDrawable(drawable)

            val adjust = getBoolean(R.styleable.ImageCardView_android_adjustViewBounds, false)
            image.adjustViewBounds = adjust

            val index = getInt(R.styleable.ImageCardView_android_scaleType, -1)
            if (index >= 0) image.scaleType = ImageView.ScaleType.values()[index]
        }
    }
}