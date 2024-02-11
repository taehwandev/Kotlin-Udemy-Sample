package tech.thdev.kotlin_udemy_sample.util

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur

/**
 * Create blur image - half size
 */
fun Bitmap?.createBlurImage(context: Context, radius: Float = 25.0f): Bitmap? {
    return this?.let {
        createBlurImage(context, it.width / 2, it.height / 2, radius)
    }
}

/**
 * Create blur image
 */
fun Bitmap?.createBlurImage(
    context: Context,
    dstWidth: Int,
    dstHeight: Int,
    radius: Float = 25.0f
): Bitmap? {
    return this?.let {
        val temp = getRadius(radius)

        val bitmap: Bitmap = Bitmap.createScaledBitmap(this, dstWidth, dstHeight, false)

        val renderScript: RenderScript = RenderScript.create(context)

        val blurInput: Allocation = Allocation.createFromBitmap(
            renderScript,
            bitmap,
            Allocation.MipmapControl.MIPMAP_NONE,
            Allocation.USAGE_SCRIPT
        )
        val blurOutput: Allocation = Allocation.createTyped(renderScript, blurInput.type)

        val blur: ScriptIntrinsicBlur =
            ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))

        // Set the radius of the Blur. Supported range 0 < radius <= 25
        blur.setRadius(temp)
        blur.setInput(blurInput)
        blur.forEach(blurOutput)

        blurOutput.copyTo(bitmap)
        renderScript.destroy()

        return bitmap
    }
}

private fun getRadius(radius: Float): Float {
    if (radius < 0) {
        return 0f

    } else if (radius > 25.0f) {
        return 25.0f
    }

    return radius
}