package tech.thdev.app.view.main.detail.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.app.data.PhotoInfo
import tech.thdev.app.data.source.flickr.FlickrRepository
import tech.thdev.app.util.decimalFormat
import tech.thdev.app.util.getDate

/**
 * Created by taehwankwon on 12/11/2017.
 */
class DetailImagePresenter(val view: DetailImageContract.View,
                           private val repository: FlickrRepository) : DetailImageContract.Presenter {

    override fun loadDetailInfo(photoId: String) {
        repository.getPhotoDetail(photoId)
                .enqueue(object : Callback<PhotoInfo> {

                    override fun onResponse(call: Call<PhotoInfo>?, response: Response<PhotoInfo>?) {
                        if (response?.isSuccessful == true) {
                            response.body()?.takeIf { it.stat == "ok" }?.let {
                                // 처리
                                it.photo.let {
                                    view.updateItem(
                                            it.getImageUrl(),
                                            it.title._content,
                                            it.description._content,
                                            it.dates.lastupdate.getDate("MM-dd-yyyy hh:mm:ss"),
                                            it.views.toString().decimalFormat(),
                                            it.comments._content.toString().decimalFormat())

                                    view.updateToolbarItem(
                                            it.owner.getBuddyIcons(),
                                            it.owner.username)
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<PhotoInfo>?, t: Throwable?) {

                    }
                })
    }
}