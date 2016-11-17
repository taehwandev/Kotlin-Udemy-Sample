package tech.thdev.java_udemy_sample.data.source.photo_detail;


/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoDetailRepository implements PhotoDetailSource {

    private PhotoDetailRemoteDataSource photoDetailRemoteDataSource;

    private static PhotoDetailRepository imageSampleRepository;

    public static PhotoDetailRepository getInstance() {
        if (imageSampleRepository == null) {
            imageSampleRepository = new PhotoDetailRepository();
        }

        return imageSampleRepository;
    }

    private PhotoDetailRepository() {
        photoDetailRemoteDataSource = PhotoDetailRemoteDataSource.getInstance();
    }

    @Override
    public void getImageItems(String photoId, final LoadImageCallback loadImageCallback) {
        photoDetailRemoteDataSource.getImageItems(photoId, loadImageCallback);
    }
}
