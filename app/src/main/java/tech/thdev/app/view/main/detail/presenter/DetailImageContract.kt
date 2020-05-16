package tech.thdev.app.view.main.detail.presenter

/**
 * Created by taehwankwon on 12/11/2017.
 */
interface DetailImageContract {

    interface View {

        fun updateToolbarItem(buddyIcon: String, buddyName: String)

        fun updateItem(
            imageUrl: String,
            title: String,
            content: String,
            date: String,
            viewCount: String,
            commentCount: String
        )

        fun showFlickrWebPage(url: String)
    }

    interface Presenter {

        fun loadDetailInfo(photoId: String)

        /**
         * Flickr WebPage 주소를 가져와 Show 한다
         */
        fun loadFlickrWebPage()
    }
}