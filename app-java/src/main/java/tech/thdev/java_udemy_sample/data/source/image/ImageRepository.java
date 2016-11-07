package tech.thdev.java_udemy_sample.data.source.image;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class ImageRepository implements ImageSource {

    private ImageRemoteDataSource imageRemoteDataSource;

    private static ImageRepository imageSampleRepository;

    public static ImageRepository getInstance() {
        if (imageSampleRepository == null) {
            imageSampleRepository = new ImageRepository();
        }

        return imageSampleRepository;
    }

    private ImageRepository() {
        imageRemoteDataSource = ImageRemoteDataSource.getInstance();
    }

    @Override
    public void getImageItems(int page, final LoadImageCallback loadImageCallback) {
        imageRemoteDataSource.getImageItems(page, loadImageCallback);
    }
}
