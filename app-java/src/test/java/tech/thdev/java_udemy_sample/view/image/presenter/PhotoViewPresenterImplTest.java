package tech.thdev.java_udemy_sample.view.image.presenter;

import org.awaitility.core.ThrowingRunnable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import tech.thdev.java_udemy_sample.data.PhotoItem;
import tech.thdev.java_udemy_sample.data.source.image.ImageRepository;
import tech.thdev.java_udemy_sample.view.image.adapter.model.PhotoViewAdapterContract;

import static org.awaitility.Awaitility.await;
import static com.jayway.awaitility.Awaitility.await;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by tae-hwan on 11/13/16.
 */
public class PhotoViewPresenterImplTest {

    // Adapter
    private PhotoViewAdapterContract.Model adapterModel;
    private PhotoViewAdapterContract.View adapterView;

    private PhotoViewPresenter.View view;
    private PhotoViewPresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        adapterModel = mock(PhotoViewAdapterContract.Model.class);
        adapterView = mock(PhotoViewAdapterContract.View.class);

        view = mock(PhotoViewPresenter.View.class);
        presenter = new PhotoViewPresenterImpl(view, ImageRepository.getInstance());
        presenter.setAdapterModel(adapterModel);
        presenter.setAdapterView(adapterView);
    }

    @Test
    public void testLoadSuccess() throws Exception {
        final boolean[] finish = {false};
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                finish[0] = true;
                System.out.println("----finish " + finish[0]);
                return invocationOnMock;
            }
        }).when(view).showLoaded();

        presenter.recentPhotoData();
        await().untilAsserted(new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                while (!finish[0]) {
                    verify(adapterModel, atLeastOnce()).addItem((PhotoItem) any());
                    // ...
                    System.out.println();
                }
            }
        });

        verify(view).showLoaded();
    }

    @Test
    public void testAdapterNotify() throws Exception {
        final boolean[] finish = {false};
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                finish[0] = true;
                return invocationOnMock;
            }
        }).when(adapterView).onReload();

        presenter.recentPhotoData();
        await().until(new Runnable() {
            @Override
            public void run() {
                while (!finish[0]) {
                    verify(adapterModel, atLeastOnce()).addItem((PhotoItem) any());
                }
            }
        });

        verify(adapterView).onReload();
    }
}