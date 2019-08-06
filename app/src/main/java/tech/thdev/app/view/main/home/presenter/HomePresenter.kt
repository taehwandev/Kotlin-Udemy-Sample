package tech.thdev.app.view.main.home.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.app.data.PhotoResponse
import tech.thdev.app.data.source.flickr.FlickrRepository
import tech.thdev.app.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by record-tae on 10/21/17.
 */
class HomePresenter(val view: HomeContract.View,
                    private val flickrRepository: FlickrRepository,
                    private val imageRecyclerModel: ImageRecyclerModel) : HomeContract.Presenter {

    var isLoading = false

    private val perPage = 50
    private var page = 0

    init {
        imageRecyclerModel.onClick = { position ->
            view.showBottomSheetDialog(imageRecyclerModel.getItem(position).id)
        }
    }

    override fun loadFlickrImage() {
        isLoading = true
        view.showProgress()

        flickrRepository.getSearchPhoto("Eiffel Tower", ++page, perPage)
                .enqueue(object : Callback<PhotoResponse> {
                    override fun onFailure(call: Call<PhotoResponse>?, t: Throwable?) {
                        // 실패하였을 경우 처리
                        view.hideProgress()
                        view.showLoadFail()

                        isLoading = false
                    }

                    override fun onResponse(call: Call<PhotoResponse>?, response: Response<PhotoResponse>?) {
                        // 성공하였을 경우 처리
                        if (response?.isSuccessful == true) {
                            response.body().takeIf { it?.stat == "ok" }?.let {
                                // 성공한 경우만 adapter item. 추가하도록
                                page = it.photos.page

                                it.photos.photo.forEach {
                                    imageRecyclerModel.addItem(it)
                                }
                                imageRecyclerModel.notifyDataSetChang()

                            } ?: let {
                                view.showLoadFail("Code ${response.body()?.code} message : ${response.body()?.message}")
                            }
                        } else {
                            view.showLoadFail()
                        }

                        view.hideProgress()

                        isLoading = false
                    }
                })
    }
}